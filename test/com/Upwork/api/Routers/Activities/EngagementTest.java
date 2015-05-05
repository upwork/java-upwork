package com.Upwork.api.Routers.Activities;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Activities.Engagement;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Engagement.class
})
public class EngagementTest extends Helper {
	@Test public void getSpecific() throws Exception {
		Engagement activities = new Engagement(client);
    	JSONObject json = activities.getSpecific("1234");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void assign() throws Exception {
		Engagement activities = new Engagement(client);
    	JSONObject json = activities.assign("company", "team", "1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}