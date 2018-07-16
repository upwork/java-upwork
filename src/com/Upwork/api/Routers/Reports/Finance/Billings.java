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

package com.Upwork.api.Routers.Reports.Finance;

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
public final class Billings {
	
	final static String ENTRY_POINT = "gds";
	
	private OAuthClient oClient = null;

	public Billings(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
    /**
     * Generate Billing Reports for a Specific Freelancer
     *
     * @param   freelancerReference Freelancer's reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getByFreelancer(String freelancerReference, HashMap<String, String> params) throws JSONException {
        return oClient.get("/finreports/v2/providers/" + freelancerReference + "/billings", params);
    }

    /**
     * Generate Billing Reports for a Specific Buyer's Team
     *
     * @param   buyerTeamReference Buyer team reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getByBuyersTeam(String buyerTeamReference, HashMap<String, String> params) throws JSONException {
        return oClient.get("/finreports/v2/buyer_teams/" + buyerTeamReference + "/billings", params);
    }
    
    /**
     * Generate Billing Reports for a Specific Buyer's Company
     *
     * @param   buyerCompanyReference Buyer company reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
     * @return	{@link JSONObject}
     */
    public JSONObject getByBuyersCompany(String buyerCompanyReference, HashMap<String, String> params) throws JSONException {
        return oClient.get("/finreports/v2/buyer_companies/" + buyerCompanyReference + "/billings", params);
    }

}
