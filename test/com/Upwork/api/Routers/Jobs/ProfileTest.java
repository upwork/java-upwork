package com.Upwork.api.Routers.Jobs;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Jobs.Profile;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Profile.class
})
public class ProfileTest extends Helper {
	@Test public void getSpecific() throws Exception {
		Profile profile = new Profile(client);
    	JSONObject json = profile.getSpecific("key");
        
        assertTrue(json instanceof JSONObject);
	}
}