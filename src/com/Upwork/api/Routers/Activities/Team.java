/**
 * Copyright 2014 Upwork
 *
 * Licensed under the Upwork's API Terms of Use;
 * you may not use this file except in compliance with the Terms.
 * You may obtain a copy of the Terms at
 * 
 *    https://developers.upwork.com/api-tos.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Upwork.api.Routers.Activities;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "6/4/2014",
	currentRevision = 1,
	lastModified = "6/4/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Team {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Team(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Get by type
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   code (Optional) Code(s)
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    private JSONObject _getByType(String company, String team, String code) throws JSONException {
        String url = "";
        if (code != null) {
            url = "/" + code;
        }

        return oClient.get("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/tasks" + url);
    }

    /**
     * List all oTask/Activity records within a team
     *
     * @param   company Company ID
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getList(String company, String team) throws JSONException {
        return _getByType(company, team, null);
    }
    
    /**
     * List all oTask/Activity records within a team by specified code(s)
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   code Specific code(s)
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSpecificList(String company, String team, String code) throws JSONException {
        return _getByType(company, team, code);
    }
    
    /**
     * Create an oTask/Activity record within a team
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject addActivity(String company, String team, HashMap<String, String> params) throws JSONException {
        return oClient.post("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/tasks", params);
    }

    /**
     * Update specific oTask/Activity record within a team
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   code Specific code
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject updateActivity(String company, String team, String code, HashMap<String, String> params) throws JSONException {
        return oClient.put("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/tasks/" + code, params);
    }
    
    /**
     * Archive specific oTask/Activity record within a team
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   code Specific code(s)
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject archiveActivity(String company, String team, String code) throws JSONException {
        return oClient.put("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/archive/" + code);
    }
    
    /**
     * Unarchive specific oTask/Activity record within a team
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   code Specific code(s)
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject unarchiveActivity(String company, String team, String code) throws JSONException {
        return oClient.put("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/unarchive/" + code);
    }

    /**
     * Update a group of oTask/Activity records
     *
     * @param   company Company ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject updateBatch(String company, HashMap<String, String> params) throws JSONException {
        return oClient.put("/otask/v1/tasks/companies/" + company + "/tasks/batch", params);
    }

}
