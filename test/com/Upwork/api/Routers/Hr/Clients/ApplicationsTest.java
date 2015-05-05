package com.Upwork.api.Routers.Hr.Clients;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Clients.Applications;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Applications.class
})
public class ApplicationsTest extends Helper {
	@Test public void getList() throws Exception {
		Applications applications = new Applications(client);
    	JSONObject json = applications.getList(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Applications applications = new Applications(client);
    	JSONObject json = applications.getSpecific("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}
