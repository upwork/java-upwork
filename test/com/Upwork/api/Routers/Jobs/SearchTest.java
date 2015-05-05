package com.Upwork.api.Routers.Jobs;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Jobs.Search;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Search.class
})
public class SearchTest extends Helper {
	@Test public void find() throws Exception {
		Search search = new Search(client);
    	JSONObject json = search.find(new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}