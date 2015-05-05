/**
 * Copyright 2014 Upwork
 *
 * Licensed under the Upwork's API Terms of Use;
 * you may not use this file except in compliance with the Terms.
 * You may obtain a copy of the Terms at
 * 
 *    http://developers.upwork.com/API-Terms-of-Use
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Upwork.api.Routers.Hr;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "11/17/2014",
	currentRevision = 1,
	lastModified = "11/17/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Milestones {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Milestones(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Get active Milestone for the Contract
     *
     * @param	contractId Contract reference
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getActiveMilestone(String contractId) throws JSONException {
        return oClient.get("/hr/v3/fp/milestones/statuses/active/contracts/" + contractId);
    }
    
    /**
     * Get all submissions for the active Milestone
     *
     * @param	milestoneId Milestone ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSubmissions(String milestoneId) throws JSONException {
        return oClient.get("/hr/v3/fp/milestones/" + milestoneId + "/submissions");
    }
	
	/**
     * Create a new Milestone
     *
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject create(HashMap<String, String> params) throws JSONException {
        return oClient.post("/hr/v3/fp/milestones", params);
    }
    
    /**
     * Edit an existing Milestone
     *
     * @param	milestoneId Milestone ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject edit(String milestoneId, HashMap<String, String> params) throws JSONException {
        return oClient.put("/hr/v3/fp/milestones/" + milestoneId, params);
    }
    
    /**
     * Activate an existing Milestone
     *
     * @param	milestoneId Milestone ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject activate(String milestoneId, HashMap<String, String> params) throws JSONException {
        return oClient.put("/hr/v3/fp/milestones/" + milestoneId + "/activate", params);
    }
    
    /**
     * Approve an existing Milestone
     *
     * @param	milestoneId Milestone ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject approve(String milestoneId, HashMap<String, String> params) throws JSONException {
        return oClient.put("/hr/v3/fp/milestones/" + milestoneId + "/approve", params);
    }
    
    /**
     * Delete an existing Milestone
     *
     * @param	milestoneId Milestone ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject delete(String milestoneId) throws JSONException {
        return oClient.delete("/hr/v3/fp/milestones/" + milestoneId);
    }

}