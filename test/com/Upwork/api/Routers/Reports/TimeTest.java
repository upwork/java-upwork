package com.Upwork.api.Routers.Reports;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Reports.Time;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Time.class
})
public class TimeTest extends Helper {
	@Test public void getByTeamFull() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByTeamFull("company", "team", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByTeamLimited() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByTeamLimited("company", "team", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByAgency() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByAgency("company", "agency", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByCompany() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByCompany("company", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByFreelancerLimited() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByFreelancerLimited("freelancer_id", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByFreelancerFull() throws Exception {
		Time time = new Time(client);
    	JSONObject json = time.getByFreelancerFull("freelancer_id", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}