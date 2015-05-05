package com.Upwork.api.Routers;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Auth;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Auth.class
})
public class AuthTest extends Helper {
	@Test public void getUserInfo() throws Exception {
		Auth auth = new Auth(client);
    	JSONObject json = auth.getUserInfo();
        
        assertTrue(json instanceof JSONObject);
	}
}