package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Milestones;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Milestones.class
})
public class MilestonesTest extends Helper {
	@Test public void getActiveMilestone() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.getActiveMilestone("1234");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSubmissions() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.getSubmissions("1234");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void create() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.create(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void edit() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.edit("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void activate() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.activate("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void approve() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.approve("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void delete() throws Exception {
		Milestones milestones = new Milestones(client);
    	JSONObject json = milestones.delete("1234");
        
        assertTrue(json instanceof JSONObject);
	}
}