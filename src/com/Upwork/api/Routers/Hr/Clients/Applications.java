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

package com.Upwork.api.Routers.Hr.Clients;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "6/4/2014",
	currentRevision = 1,
	lastModified = "2/15/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Applications {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Applications(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Get list of applications
     *
     * @param   params Parameters
     * @return  object
     */
    public JSONObject getList(HashMap<String, String> params) throws JSONException {
        return oClient.get("/hr/v4/clients/applications", params);
    }

    /**
     * Get specific application
     *
     * @param   reference Application reference
     * @param   params Parameters
     * @return  object
     */
    public JSONObject getSpecific(String reference, HashMap<String, String> params) throws JSONException {
        return oClient.get("/hr/v4/clients/applications/" + reference, params);
    }

}
