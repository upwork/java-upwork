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
 * 
 * @author: Maksym Novozhylov <mnovozhilov@upwork.com>
 */

package com.Upwork.api;

import com.Upwork.ClassPreamble;
import com.Upwork.api.Config;
import com.Upwork.api.UpworkRestClient;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthException;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "5/31/2014",
	currentRevision = 1,
	lastModified = "9/30/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public class OAuthClient {
	
	private static Log logger = LogFactory.getLog(OAuthClient.class);
	
	private static final int METHOD_GET     = 1;
    private static final int METHOD_POST    = 2;
    private static final int METHOD_PUT     = 3;
    private static final int METHOD_DELETE  = 4;
    
    private static final String OVERLOAD_PARAM = "http_method";
    private static final String DATA_FORMAT = "json";
    private static final String UPWORK_BASE_URL = "https://www.upwork.com/";
    
	private static final String OAUTH_REQUEST_TOKEN_ENDPOINT = 
			UPWORK_BASE_URL + "api/auth/v1/oauth/token/request";
    private static final String OAUTH_ACCESS_TOKEN_ENDPOINT = 
    		UPWORK_BASE_URL + "api/auth/v1/oauth/token/access";
    private static final String OAUTH_AUTHORIZATION_ENDPOINT = 
    		UPWORK_BASE_URL + "services/api/auth";
    
    private static OAuthConsumer mOAuthConsumer = null;
    private static OAuthProvider mOAuthProvider = new CommonsHttpOAuthProvider(
            OAUTH_REQUEST_TOKEN_ENDPOINT,
            OAUTH_ACCESS_TOKEN_ENDPOINT,
            OAUTH_AUTHORIZATION_ENDPOINT);
    
	private static String consumerKey		= null;
	private static String consumerSecret	= null;
	private static String accessToken		= null;
	private static String accessSecret		= null;
	private static String entryPoint		= "api";

	/**
	 * Constructor
	 * 
	 * @param	properties Config properties
	 * */
	public OAuthClient(Config properties) {
		
		logger.info("Initialised OAuthClient.");
		
		if (properties == null) {
			properties = new Config(null);  
		}
		
		consumerKey = properties.getProperty("consumerKey");
		consumerSecret = properties.getProperty("consumerSecret");

		mOAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
	}
	
	/**
	 * Get authorization URL, and use provided callback
	 * 
     * @param   oauthCallback URL, i.e. oauth_callback used in mobile applications
	 * @return	URL for authorizing application
	 * */
	public String getAuthorizationUrl(String oauthCallback) {
        return _getAuthorizationUrl(oauthCallback);
    }

	/**
	 * Get authorization URL
	 * 
	 * @return	URL for authorizing application
	 * */
	public String getAuthorizationUrl() {
        return _getAuthorizationUrl("");
	}
	
	/**
	 * Get access token-secret pair
	 * 
	 * @param	verifier OAuth verifier, which was got after authorization 
	 * @return	Access token-secret pair
	 * */
	public HashMap<String, String> getAccessTokenSet(String verifier) {
		try {
            mOAuthProvider.retrieveAccessToken(mOAuthConsumer, verifier);
        }
        catch (OAuthException e) {
            e.printStackTrace();
        }
		
		return setTokenWithSecret(mOAuthConsumer.getToken(), mOAuthConsumer.getTokenSecret()); 
	}
	
	/**
	 * Setup access token and secret for OAuth client
	 * 
	 * @param	aToken Access token
	 * @param	aSecret Access secret
	 * @return	Token-secret pair
	 * */
	public final HashMap<String, String> setTokenWithSecret(String aToken, String aSecret) {
		HashMap<String, String> token = new HashMap<String, String>();
		
		accessToken	= aToken;
		accessSecret = aSecret;
		
        mOAuthConsumer.setTokenWithSecret(accessToken, accessSecret);
        
        token.put("token", accessToken);
        token.put("secret", accessSecret);
		
		return token;
	}
	
	/**
	 * Setup entry point for the request(s)
	 * 
	 * @param	ep Entry point
	 * */
	public final void setEntryPoint(String ep) {
		entryPoint = ep;
	}
	
	/**
	 * Send signed OAuth GET request without parameters
	 * 
	 * @param	url Relative URL
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject get(String url) throws JSONException {
		return sendGetRequest(url, METHOD_GET, null);
	}
	
	/**
	 * Send signed OAuth GET request
	 * 
	 * @param	url Relative URL
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject get(String url, HashMap<String, String> params) throws JSONException {
		return sendGetRequest(url, METHOD_GET, params);
	}

	/**
	 * Send signed OAuth POST request
	 * 
	 * @param	url Relative URL
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject post(String url, HashMap<String, String> params) throws JSONException {
		return sendPostRequest(url, METHOD_POST, params);
	}

	/**
	 * Send signed OAuth PUT request
	 * 
	 * @param	url Relative URL
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject put(String url) throws JSONException {
		return sendPostRequest(url, METHOD_PUT, new HashMap<String, String>());
	}
	
	/**
	 * Send signed OAuth PUT request
	 * 
	 * @param	url Relative URL
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject put(String url, HashMap<String, String> params) throws JSONException {
		return sendPostRequest(url, METHOD_PUT, params);
	}

	/**
	 * Send signed OAuth DELETE request without parameters
	 * 
	 * @param	url Relative URL
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject delete(String url) throws JSONException {
		return sendPostRequest(url, METHOD_DELETE, null);
	}
	
	/**
	 * Send signed OAuth DELETE request
	 * 
	 * @param	url Relative URL
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	public JSONObject delete(String url, HashMap<String, String> params) throws JSONException {
		return sendPostRequest(url, METHOD_DELETE, params);
	}
	
	/**
	 * Get authorization URL, use provided callback URL
	 * 
     * @param   oauthCallback URL, i.e. oauth_callback
	 * @return	URL for authorizing application
	 * */
	private String _getAuthorizationUrl(String oauthCallback) {
		String url = null;
        
		try {
            url = mOAuthProvider.retrieveRequestToken(mOAuthConsumer, oauthCallback);
        }
        catch (OAuthException e) {
            e.printStackTrace();
        }
		
		return url;
	}
	
	/**
	 * Send signed GET OAuth request
	 * 
	 * @param	url Relative URL
	 * @param	type Type of HTTP request (HTTP method)
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	private JSONObject sendGetRequest(String url, Integer type, HashMap<String, String> params) throws JSONException {
		
		String fullUrl = getFullUrl(url);
		HttpGet request = new HttpGet(fullUrl);
		
		if (params != null) {
			URI uri;
			String query = "";
			try {
				URIBuilder uriBuilder = new URIBuilder(request.getURI());
				
				logger.info("Opening URL: "+ fullUrl);

				// encode values and add them to the request
				for (Map.Entry<String, String> entry : params.entrySet()) {
	                String key = entry.getKey();
	                String value = entry.getValue();
	                logger.info("Parameter: "+ key +"="+ value);
	                // to prevent double encoding, we need to create query string ourself
	                // uriBuilder.addParameter(key, URLEncoder.encode(value).replace("%3B", ";"));
	                query = query + key + "=" + value.replace("&", "&amp;") + "&";
	                // what the hell is going on in java - no adequate way to encode query string
	                // lets temporary replace "&" in the value, to encode it manually later
	            }
				
				// this routine will encode query string
				uriBuilder.setCustomQuery(query);
				uri = uriBuilder.build();
				
				// re-create request to have validly encoded ampersand
				request = new HttpGet(fullUrl + "?" + uri.getRawQuery().replace("&amp;", "%26"));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			mOAuthConsumer.sign(request);
		}
		catch (OAuthException e) {
            e.printStackTrace();
        }
		
        return UpworkRestClient.getJSONObject(request, type);
    }
	
	/**
	 * Send signed POST OAuth request
	 * 
	 * @param	url Relative URL
	 * @param	type Type of HTTP request (HTTP method)
	 * @param	params Hash of parameters
	 * @throws	JSONException If JSON object is invalid or request was abnormal
	 * @return	{@link JSONObject} JSON Object that contains data from response
	 * */
	private JSONObject sendPostRequest(String url, Integer type, HashMap<String, String> params) throws JSONException {
		String fullUrl = getFullUrl(url);
		HttpPost request = new HttpPost(fullUrl);
		
		switch(type) {
		case METHOD_PUT:
		case METHOD_DELETE:
			// assign overload value
        	String oValue;
        	if (type == METHOD_PUT) {
        		oValue = "put";
        	} else {
        		oValue = "delete";
        	}
        	params.put(OVERLOAD_PARAM, oValue);
		case METHOD_POST:
			break;
		default:
            throw new RuntimeException("Wrong http method requested");
		}
		
		// doing post request using json to avoid issue with urlencoded symbols
		JSONObject json = new JSONObject();
		
        for (Map.Entry<String, String> entry : params.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
		
		request.setHeader("Content-Type", "application/json");
		try {
			request.setEntity(new StringEntity(json.toString()));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        // sign request
		try {
			mOAuthConsumer.sign(request);
		}
		catch (OAuthException e) {
            e.printStackTrace();
        }
		
        return UpworkRestClient.getJSONObject(request, type, params);
    }
	
	/**
	 * Build absolute URL
	 * 
	 * @param	url Relative URL
	 * @return	Absolute URL
	 * */
	private final String getFullUrl(String url) {
		return UPWORK_BASE_URL + entryPoint + url + 
			((entryPoint == "api") ? ("." + DATA_FORMAT) : "");
	}
}
