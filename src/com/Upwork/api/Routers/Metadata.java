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
	lastModified = "6/4/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Metadata {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Metadata(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/** 
     * Get Categories
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getCategories() throws JSONException {   
        return oClient.get("/profiles/v1/metadata/categories");
    }
    
    /** 
     * Get Categories (v2)
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getCategoriesV2() throws JSONException {   
        return oClient.get("/profiles/v2/metadata/categories");
    }

    /** 
     * Get Skills
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSkills() throws JSONException {   
        return oClient.get("/profiles/v1/metadata/skills");
    }

    /**
     * Get Skills V2
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSkillsV2() throws JSONException {
        return oClient.get("/profiles/v2/metadata/skills");
    }

    /**
     * Get Specialties
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSpecialties() throws JSONException {
        return oClient.get("/profiles/v1/metadata/specialties");
    }
    
    /** 
     * Get regions
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getRegions() throws JSONException {   
        return oClient.get("/profiles/v1/metadata/regions");
    }

    /**
     * Get tests
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getTests() throws JSONException {
        return oClient.get("/profiles/v1/metadata/tests");
    }
    
    /**
     * Get reasons
     *
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getReasons(HashMap<String, String> params) throws JSONException {
        return oClient.get("/profiles/v1/metadata/reasons", params);
    }

}
