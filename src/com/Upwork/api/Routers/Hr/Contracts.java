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
	lastModified = "19/9/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Contracts {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Contracts(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/** 
     * Suspend Contract
     *
     * @param   reference Contract reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject suspendContract(String reference, HashMap<String, String> params) throws JSONException {   
        return oClient.put("/hr/v2/contracts/" + reference + "/suspend", params);
    }
    
    /** 
     * Restart Contract
     *
     * @param   reference Contract reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject restartContract(String reference, HashMap<String, String> params) throws JSONException {   
        return oClient.put("/hr/v2/contracts/" + reference + "/restart", params);
    }
	
	/** 
     * End Contract
     *
     * @param   reference Contract reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject endContract(String reference, HashMap<String, String> params) throws JSONException {   
        return oClient.delete("/hr/v2/contracts/" + reference, params);
    }

}
