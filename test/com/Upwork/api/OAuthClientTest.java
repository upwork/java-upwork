package com.Upwork.api;

import static org.junit.Assert.*;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.*;

import static org.mockito.Mockito.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import com.Upwork.api.Config;
import com.Upwork.api.OAuthClient;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Config.class,
    OAuthClient.class
})
public class OAuthClientTest {
	@Spy private final Properties properties = new Properties();
	
	private HashMap<String, String> expectedToken;
	private final CommonsHttpOAuthConsumer CommonsHttpOAuthConsumerMock = PowerMockito.mock(CommonsHttpOAuthConsumer.class);
	private final CommonsHttpOAuthProvider CommonsHttpOAuthProviderMock = PowerMockito.mock(CommonsHttpOAuthProvider.class);
	
	@Before
	public void setUp() {
		expectedToken = new HashMap<String, String>();
		expectedToken.put("token", "atoken");
        expectedToken.put("secret", "asecret");
	}
	
	private OAuthClient getMockedClient() throws Exception {
		when(properties.getProperty("consumerKey")).thenReturn("key");
		when(properties.getProperty("consumerSecret")).thenReturn("secret");
		
		final FileInputStream fileInputStreamMock = PowerMockito.mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withArguments(Matchers.anyString())
                            .thenReturn(fileInputStreamMock);
		
		PowerMockito.whenNew(CommonsHttpOAuthConsumer.class).withArguments(Matchers.anyString(), Matchers.anyString())
                            .thenReturn(CommonsHttpOAuthConsumerMock);
        
        PowerMockito.whenNew(CommonsHttpOAuthProvider.class).withArguments(Matchers.anyString(), Matchers.anyString(), Matchers.anyString())
        					.thenReturn(CommonsHttpOAuthProviderMock);
        
        Config config = new Config(properties);
		
		OAuthClient client = new OAuthClient(config);
		
		return client;
	}
	
	@Ignore("weird behavior in Travis") @Test public void getAuthorizationUrl() throws Exception {
		when(CommonsHttpOAuthProviderMock.retrieveRequestToken(CommonsHttpOAuthConsumerMock, "")).thenReturn("url");
		
		OAuthClient client = getMockedClient();
		String authzUrl = client.getAuthorizationUrl();
		
		assertEquals("get authorization url", "url", authzUrl);
	}
	
	@Test public void getAccessTokenSet() throws Exception {
		when(CommonsHttpOAuthConsumerMock.getToken()).thenReturn("atoken");
        when(CommonsHttpOAuthConsumerMock.getTokenSecret()).thenReturn("asecret");
		
        OAuthClient client = getMockedClient();
		HashMap<String, String> token = client.getAccessTokenSet("verifier");
		
		assertEquals(expectedToken, token);
	}
	
	@Test public void setTokenWithSecret() throws Exception {
		OAuthClient client = getMockedClient();
		HashMap<String, String> token = client.setTokenWithSecret("atoken", "asecret");
		
		assertEquals(expectedToken, token);
	}
}