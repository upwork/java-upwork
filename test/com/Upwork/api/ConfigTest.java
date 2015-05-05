package com.Upwork.api;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.*;

import static org.mockito.Mockito.*;

import java.io.FileInputStream;
import java.util.Properties;

import com.Upwork.api.Config;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Config.class
})
public class ConfigTest {
	@Spy private final Properties properties = new Properties();
	
	@Test public void getProperty() throws Exception  {
		when(properties.getProperty("key")).thenReturn("value");
		
		final FileInputStream fileInputStreamMock = PowerMockito.mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withArguments(Matchers.anyString())
                            .thenReturn(fileInputStreamMock);
		
		Config config = new Config(properties);
		String test = config.getProperty("key");
		
		assertEquals("get config property", "value", test);
	}
}