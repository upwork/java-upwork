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
	date = "6/3/2014",
	currentRevision = 1,
	lastModified = "24/5/2018",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Workdiary {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Workdiary(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Get Workdiary
     *
     * @param   company Company ID
     * @param   date Date
     * @param   params (Optional) Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject get(String company, String date, HashMap<String, String> params) throws JSONException {
        return oClient.get("/team/v3/workdiaries/companies/" + company + "/" + date, params);
    }
    
    /**
     * Get Work Diary by Contract
     *
     * @param   contract Contract ID
     * @param   date Date
     * @param   params (Optional) Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByContract(String contract, String date, HashMap<String, String> params) throws JSONException {
        return oClient.get("/team/v3/workdiaries/contracts/" + contract + "/" + date, params);
    }

}
