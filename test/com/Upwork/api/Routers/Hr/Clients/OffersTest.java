package com.Upwork.api.Routers.Hr.Clients;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Clients.Offers;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Offers.class
})
public class OffersTest extends Helper {
	@Test public void getList() throws Exception {
		Offers offers = new Offers(client);
    	JSONObject json = offers.getList(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Offers offers = new Offers(client);
    	JSONObject json = offers.getSpecific("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void makeOffer() throws Exception {
		Offers offers = new Offers(client);
    	JSONObject json = offers.makeOffer(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}
