package com.Upwork.api.Routers;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Workdays;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Workdiary.class
})
public class WorkdaysTest extends Helper {
	@Test public void getByCompany() throws Exception {
		Workdays workdays = new Workdays(client);
    	JSONObject json = workdays.getByCompany("company", "20140101", "20140131", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getByContract() throws Exception {
		Workdays workdays = new Workdays(client);
    	JSONObject json = workdays.getByContract("company", "20140101", "20140131", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}