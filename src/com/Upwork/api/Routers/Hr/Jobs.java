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

package com.Upwork.api.Routers.Hr;

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
public final class Jobs {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Jobs(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Get list of jobs
     *
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getList(HashMap<String, String> params) throws JSONException {
        return oClient.get("/hr/v2/jobs", params);
    }

    /**
     * Get specific job by key
     *
     * @param   key Job key
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSpecific(String key) throws JSONException {
        return oClient.get("/hr/v2/jobs/" + key);
    }
    
    /**
     * Post a new job
     *
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject postJob(HashMap<String, String> params) throws JSONException {
        return oClient.post("/hr/v2/jobs", params);
    }

    /**
     * Edit existent job
     *
     * @param   key Job key
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject editJob(String key, HashMap<String, String> params) throws JSONException {
        return oClient.put("/hr/v2/jobs/" + key, params);
    }
    
    /**
     * Delete existent job
     *
     * @param   key Job key
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject deleteJob(String key, HashMap<String, String> params) throws JSONException {
        return oClient.delete("/hr/v2/jobs/" + key, params);
    }

}
