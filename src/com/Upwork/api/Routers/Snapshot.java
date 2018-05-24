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

package com.Upwork.api.Routers;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "6/4/2014",
	currentRevision = 1,
	lastModified = "24/5/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Snapshot {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Snapshot(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
    /**
     * Get snapshot info by specific contract
     *
     * @param   contractId Contract ID
     * @param   ts Timestamp
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getByContract(String contractId, String ts) throws JSONException {   
        return oClient.get("/team/v3/snapshots/contracts/" + contractId + "/" + ts);
    }   

    /** 
     * Update snapshot by specific contract
     *
     * @param   contractId Contract ID
     * @param   ts Timestamp
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject updateByContract(String contractId, String ts, HashMap<String, String> params) throws JSONException {   
        return oClient.put("/team/v3/snapshots/contracts/" + contractId + "/" + ts, params);
    }
    
    /**
     * Delete snapshot by specific contract
     *
     * @param   contractId Contract ID
     * @param   ts Timestamp
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject deleteByContract(String contractId, String ts) throws JSONException {
        return oClient.delete("/team/v3/snapshots/contracts/" + contractId + "/" + ts);
    }

}
