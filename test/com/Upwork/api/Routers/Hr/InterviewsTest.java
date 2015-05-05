package com.Upwork.api.Routers.Hr;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Hr.Interviews;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
	Interviews.class
})
public class InterviewsTest extends Helper {
	@Test public void invite() throws Exception {
		Interviews interviews = new Interviews(client);
    	JSONObject json = interviews.invite("key", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}