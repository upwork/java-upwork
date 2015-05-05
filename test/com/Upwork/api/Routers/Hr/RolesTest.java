package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Roles;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Roles.class
})
public class RolesTest extends Helper {
	@Test public void getAll() throws Exception {
		Roles roles = new Roles(client);
    	JSONObject json = roles.getAll();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getBySpecificUser() throws Exception {
		Roles roles = new Roles(client);
    	JSONObject json = roles.getBySpecificUser("1234");
        
        assertTrue(json instanceof JSONObject);
	}
}