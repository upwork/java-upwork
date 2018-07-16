package com.Upwork.api.Routers.Reports.Finance;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Reports.Finance.Earnings;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Earnings.class
})
public class EarningsTest extends Helper {
	@Test public void getByFreelancer() throws Exception {
		Earnings earnings = new Earnings(client);
    	JSONObject json = earnings.getByFreelancer("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByBuyersTeam() throws Exception {
		Earnings earnings = new Earnings(client);
    	JSONObject json = earnings.getByBuyersTeam("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByBuyersCompany() throws Exception {
		Earnings earnings = new Earnings(client);
    	JSONObject json = earnings.getByBuyersCompany("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}
