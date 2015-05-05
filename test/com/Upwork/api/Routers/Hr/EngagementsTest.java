package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Engagements;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Engagements.class
})
public class EngagementsTest extends Helper {
	@Test public void getList() throws Exception {
		Engagements engagements = new Engagements(client);
    	JSONObject json = engagements.getList(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Engagements engagements = new Engagements(client);
    	JSONObject json = engagements.getSpecific("1234");
        
        assertTrue(json instanceof JSONObject);
	}
}