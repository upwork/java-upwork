package com.Upwork.api.Routers;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
		author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
		date = "6/3/2014",
		currentRevision = 1,
		lastModified = "6/3/2014",
		lastModifiedBy = "Maksym Novozhylov",
		reviewers = {"Yiota Tsakiri"}
	)
public final class Mc {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Mc(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/** 
     * Get trays
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getTrays() throws JSONException {   
        return oClient.get("/mc/v1/trays");
    }   

    /** 
     * Get tray by type
     *
     * @param   username Username
     * @param   type Tray type/name
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getTrayByType(String username, String type) throws JSONException {   
        return oClient.get("/mc/v1/trays/" + username + "/" + type);
    }

    /** 
     * Get tray by type
     *
     * @param   username Username
     * @param   type Tray type/name
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getTrayByType(String username, String type, HashMap<String, String> params) throws JSONException {   
        return oClient.get("/mc/v1/trays/" + username + "/" + type, params);
    }
    
    /**
     * List thread details based on thread id
     *
     * @param   username Username
     * @param   threadId Thread ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getThreadDetails(String username, String threadId) throws JSONException {
        return oClient.get("/mc/v1/threads/" + username + "/" + threadId);
    }
    
    /**
     * Get a specific thread by "Interview" context
     *
     * @param   username Username
     * @param	jobKey Job key
     * @param   applicationId Application ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getThreadByContext(String username, String jobKey, String applicationId) throws JSONException {
        return oClient.get("/mc/v1/contexts/" + username + "/Interviews:" + jobKey + ":" + applicationId);
    }
    
    /**
     * Get a specific thread by context
     *
     * @param   username Username
     * @param	jobKey Job key
     * @param   applicationId Application ID
     * @param	context Context
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getThreadByContext(String username, String jobKey, String applicationId, String context) throws JSONException {
        return oClient.get("/mc/v1/contexts/" + username + "/" + context + ":" + jobKey + ":" + applicationId);
    }
    
    /**
     * Get a specific thread by context (last message content)
     *
     * @param   username Username
     * @param	jobKey Job key
     * @param   applicationId Application ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getThreadByContextLastPosts(String username, String jobKey, String applicationId) throws JSONException {
        return oClient.get("/mc/v1/contexts/" + username + "/Interviews:" + jobKey + ":" + applicationId + "/last_posts");
    }
    
    /**
     * Get a specific thread by context (last message content)
     *
     * @param   username Username
     * @param	jobKey Job key
     * @param   applicationId Application ID
     * @param	context Context
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getThreadByContextLastPosts(String username, String jobKey, String applicationId, String context) throws JSONException {
        return oClient.get("/mc/v1/contexts/" + username + "/" + context + ":" + jobKey + ":" + applicationId + "/last_posts");
    }
    
    /**
     * Send new message
     *
     * @param   username User ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
	public JSONObject startNewThread(String username, HashMap<String, String> params) throws JSONException {
		return oClient.post("/mc/v1/threads/" + username, params);
	}
	
	/**
     * Reply to existent thread
     *
     * @param   username User ID
     * @param   threadId Thread ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject replyToThread(String username, String threadId, HashMap<String, String> params) throws JSONException {
        return oClient.post("/mc/v1/threads/" + username + "/" + threadId, params);
    }
	
	/** 
     * Update threads based on user actions
     *
     * @param   username Username
     * @param   threadId Thread ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject markThread(String username, String threadId, HashMap<String, String> params) throws JSONException {   
        return oClient.put("/mc/v1/threads/" + username + "/" + threadId, params);
    }

}
