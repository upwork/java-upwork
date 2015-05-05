package com.Upwork.api.Routers.Reports.Finance;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Reports.Finance.Accounts;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Accounts.class
})
public class AccountsTest extends Helper {
	@Test public void getOwned() throws Exception {
		Accounts accounts = new Accounts(client);
    	JSONObject json = accounts.getOwned("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Accounts accounts = new Accounts(client);
    	JSONObject json = accounts.getSpecific("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}