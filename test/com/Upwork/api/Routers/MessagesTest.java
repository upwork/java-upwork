package com.Upwork.api.Routers;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Upwork.api.Routers.Helper;
import com.Upwork.api.Routers.Messages;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Messages.class
})
public class MessagesTest extends Helper {
	@Test public void getRooms() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json = messages.getRooms("company");
        
        assertTrue(json instanceof JSONObject);
    	
	JSONObject json2 = messages.getRooms("company", new HashMap<String, String>());
        
        assertTrue(json2 instanceof JSONObject);
	}
	
	@Test public void getRoomDetails() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json1 = messages.getRoomDetails("company", "room-id", new HashMap<String, String>());

        assertTrue(json1 instanceof JSONObject);
	}

	@Test public void getRoomByOffer() throws Exception {
		Messages messages = new Messages(client);
		JSONObject json = messages.getRoomByOffer("company", "1234", new HashMap<String, String>());

		assertTrue(json instanceof JSONObject);
	}

	@Test public void getRoomByApplication() throws Exception {
		Messages messages = new Messages(client);
		JSONObject json = messages.getRoomByApplication("company", "1234", new HashMap<String, String>());

		assertTrue(json instanceof JSONObject);
	}

	@Test public void getRoomByContract() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json = messages.getRoomByContract("company", "1234", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void createRoom() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json = messages.createRoom("company", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void sendMessageToRoom() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json = messages.sendMessageToRoom("company", "room-id", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}
	
	@Test public void updateRoomSettings() throws Exception {
		Messages messages = new Messages(client);
    	JSONObject json = messages.updateRoomSettings("company", "room-id", "username", new HashMap<String, String>());
        
        assertTrue(json instanceof JSONObject);
	}

	@Test public void updateRoomMetadata() throws Exception {
		Messages messages = new Messages(client);
		JSONObject json = messages.updateRoomMetadata("company", "room-id", new HashMap<String, String>());

		assertTrue(json instanceof JSONObject);
	}
}
