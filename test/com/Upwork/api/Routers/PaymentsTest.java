package com.Upwork.api.Routers;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Payments;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Payments.class
})
public class PaymentsTest extends Helper {
	@Test public void submitBonus() throws Exception {
		Payments payments = new Payments(client);
    	JSONObject json = payments.submitBonus("1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
}
