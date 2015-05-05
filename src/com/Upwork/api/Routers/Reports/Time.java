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

package com.Upwork.api.Routers.Reports;

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
public final class Time {
	
	final static String ENTRY_POINT = "gds";
	
	private OAuthClient oClient = null;

	public Time(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * Generate Time Reports for a Specific Team/Comapny/Agency
     *
     * @param   company Company ID
     * @param   team (Optional) Team ID
     * @param   agency (Optional) Agency ID
     * @param   params (Optional) Parameters
     * @param   hideFinDetails (Optional) Hides all financial details
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    private JSONObject _getByType(String company, String team, String agency, HashMap<String, String> params, Boolean hideFinDetails) throws JSONException {
        String url = "";
        if (team != null) {
            url = "/teams/" + team;
            if (hideFinDetails) {
                url = url + "/hours";
            }
        } else if (agency != null) {
            url = "/agencies/" + agency;
        }

        return oClient.get("/timereports/v1/companies/" + company + url, params);
    }
    
    /**
     * Generate Time Reports for a Specific Team (with financial info)
     *
     * @param   company Company ID
     * @param   team Team ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByTeamFull(String company, String team, HashMap<String, String> params) throws JSONException {
        return _getByType(company, team, null, params, false);
    }

    /**
     * Generate Time Reports for a Specific Team (hide financial info)
     *
     * @param   company Company ID
     * @param   team Team ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByTeamLimited(String company, String team, HashMap<String, String> params) throws JSONException {
        return _getByType(company, team, null, params, true);
    }
    
    /**
     * Generating Agency Specific Reports
     *
     * @param   company Company ID
     * @param   agency Agency ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByAgency(String company, String agency, HashMap<String, String> params) throws JSONException {
        return _getByType(company, null, agency, params, false);
    }

    /**
     * Generating Company Wide Reports
     *
     * @param   company Company ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByCompany(String company, HashMap<String, String> params) throws JSONException {
        return _getByType(company, null, null, params, false);
    }
    
    /**
     * Generating Freelancer's Specific Reports (hide financial info)
     *
     * @param   freelancerId Freelancer's ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByFreelancerLimited(String freelancerId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/timereports/v1/providers/" + freelancerId + "/hours", params);
    }

    /**
     * Generating Freelancer's Specific Reports (with financial info)
     *
     * @param   freelancerId Freelancer's ID
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getByFreelancerFull(String freelancerId, HashMap<String, String> params) throws JSONException {
        return oClient.get("/timereports/v1/providers/" + freelancerId, params);
    }

}
