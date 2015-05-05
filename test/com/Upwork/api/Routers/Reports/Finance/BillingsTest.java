package com.Upwork.api.Routers.Reports.Finance;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Reports.Finance.Billings;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Billings.class
})
public class BillingsTest extends Helper {
	@Test public void getByFreelancer() throws Exception {
		Billings billings = new Billings(client);
    	JSONObject json = billings.getByFreelancer("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByFreelancersTeam() throws Exception {
		Billings billings = new Billings(client);
    	JSONObject json = billings.getByFreelancersTeam("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByFreelancersCompany() throws Exception {
		Billings billings = new Billings(client);
    	JSONObject json = billings.getByFreelancersCompany("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByBuyersTeam() throws Exception {
		Billings billings = new Billings(client);
    	JSONObject json = billings.getByBuyersTeam("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByBuyersCompany() throws Exception {
		Billings billings = new Billings(client);
    	JSONObject json = billings.getByBuyersCompany("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}