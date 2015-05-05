package com.Upwork.api.Routers.Organization;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Organization.Companies;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Companies.class
})
public class CompaniesTest extends Helper {
	@Test public void getList() throws Exception {
		Companies companies = new Companies(client);
    	JSONObject json = companies.getList();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSpecific() throws Exception {
		Companies companies = new Companies(client);
    	JSONObject json = companies.getSpecific("1234");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getTeams() throws Exception {
		Companies companies = new Companies(client);
    	JSONObject json = companies.getTeams("1234");
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getUsers() throws Exception {
		Companies companies = new Companies(client);
    	JSONObject json = companies.getUsers("1234");
        
        assertTrue(json instanceof JSONObject);
	}
}