package com.Upwork.api.Routers;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
		author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
		date = "6/6/2014",
		currentRevision = 1,
		lastModified = "6/6/2014",
		lastModifiedBy = "Maksym Novozhylov",
		reviewers = {"Yiota Tsakiri"}
	)
public final class Messages {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Messages(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/** 
     * Retrive rooms information
     *
     * @param   company Company ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getRooms(String company) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms");
    }

    /**
     * Get a specific room information
     *
     * @param   company Company ID
     * @param   roomId  Room ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getRoomDetails(String company, String roomId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/" + roomId, params);
    }

    /**
     * Get a specific room by offer ID
     *
     * @param   company Company ID
     * @param   offerId Offer ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getRoomByOffer(String company, String offerId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/offers/" + offerId, params);
    }

    /**
     * Get a specific room by application ID
     *
     * @param   company Company ID
     * @param   applicationId Application ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getRoomByApplication(String company, String applicationId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/appications/" + applicationId, params);
    }

    /**
     * Get a specific room by contract ID
     *
     * @param   company Company ID
     * @param   contractId Contract ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getRoomByContract(String company, String contractId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/contracts/" + contractId, params);
    }

    /**
     * Create a new room
     *
     * @param   company Company ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject createRoom(String company, HashMap<String, String> params) throws JSONException {
        return oClient.post("/messages/v3/" + company + "/rooms", params);
    }

    /**
     * Send a message to a room
     *
     * @param   company Company ID
     * @param   roomId Room ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject sendMessageToRoom(String company, String roomId, HashMap<String, String> params) throws JSONException {
        return oClient.post("/messages/v3/" + company + "/rooms/" + roomId + "/stories", params);
    }

    /**
     * Update a room settings
     *
     * @param   company Company ID
     * @param   roomId Room ID
     * @param   username User ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject updateRoomSettings(String company, String roomId, String username, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/" + roomId + "/users/" + username, params);
    }

    /**
     * Update the metadata of a room
     *
     * @param   company Company ID
     * @param   roomId Room ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject updateRoomMetadata(String company, String roomId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/messages/v3/" + company + "/rooms/" + roomId, params);
    }

}
