package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Jobs;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Jobs.class
})
public class JobsTest extends Helper {
	@Test public void getList() throws Exception {
		Jobs jobs = new Jobs(client);
    	JSONObject json = jobs.getList(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Jobs jobs = new Jobs(client);
    	JSONObject json = jobs.getSpecific("key");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void postJob() throws Exception {
		Jobs jobs = new Jobs(client);
    	JSONObject json = jobs.postJob(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void editJob() throws Exception {
		Jobs jobs = new Jobs(client);
    	JSONObject json = jobs.editJob("key", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void deleteJob() throws Exception {
		Jobs jobs = new Jobs(client);
    	JSONObject json = jobs.deleteJob("key", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}