package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Submissions;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Submissions.class
})
public class SubmissionsTest extends Helper {
	@Test public void requestApproval() throws Exception {
		Submissions submissions = new Submissions(client);
    	JSONObject json = submissions.requestApproval(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void approve() throws Exception {
		Submissions submissions = new Submissions(client);
    	JSONObject json = submissions.approve("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void reject() throws Exception {
		Submissions submissions = new Submissions(client);
    	JSONObject json = submissions.reject("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}