package com.Upwork.api.Routers;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Metadata;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Metadata.class
})
public class MetadataTest extends Helper {
	@Test public void getCategories() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getCategories();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getCategoriesV2() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getCategoriesV2();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSkills() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getSkills();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getSkillsV2() throws Exception {
		Metadata metadata = new Metadata(client);
	JSONObject json = metadata.getSkillsV2();

        assertTrue(json instanceof JSONObject);
	}

	@Test public void getSpecialties() throws Exception {
		Metadata metadata = new Metadata(client);
	JSONObject json = metadata.getSpecialties();

        assertTrue(json instanceof JSONObject);
	}

	@Test public void getRegions() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getRegions();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getTests() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getTests();
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void getReasons() throws Exception {
		Metadata metadata = new Metadata(client);
    	JSONObject json = metadata.getReasons(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}
