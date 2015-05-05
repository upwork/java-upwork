package com.Upwork.api.Routers;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.*;

import static org.mockito.Mockito.*;

import com.Upwork.api.OAuthClient;

@RunWith(PowerMockRunner.class)
public class Helper {
	@Mock
	protected OAuthClient client;
	
	@Before
	public void setUp() throws JSONException {
		MockitoAnnotations.initMocks(this);
        when(client.get(Matchers.anyString())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.get(Matchers.anyString(), (HashMap<String, String>) Matchers.anyObject())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.post(Matchers.anyString(), (HashMap<String, String>) Matchers.anyObject())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.put(Matchers.anyString())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.put(Matchers.anyString(), (HashMap<String, String>) Matchers.anyObject())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.delete(Matchers.anyString())).thenReturn(new JSONObject("{'key': 'value'}"));
        when(client.delete(Matchers.anyString(), (HashMap<String, String>) Matchers.anyObject())).thenReturn(new JSONObject("{'key': 'value'}"));
	}
}