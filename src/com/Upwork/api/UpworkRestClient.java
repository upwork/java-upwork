/**
 * Copyright 2009 Upwork
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import com.Upwork.ClassPreamble;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "5/31/2014",
	currentRevision = 2,
	lastModified = "6/3/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public class UpworkRestClient {
    final static int METHOD_GET     = 1;
    final static int METHOD_POST    = 2;
    final static int METHOD_PUT     = 3;
    final static int METHOD_DELETE  = 4;
    
    final static int HTTP_RESPONSE_503 = 503;
    
    /**
     * Get JSON response for GET
     * 
     * @param   request Request object for GET
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(HttpGet request) throws JSONException {
        return UpworkRestClient.getJSONObject(request, METHOD_GET, new HashMap<String, String>());
    }
    
    /**
     * Get JSON response for GET
     * 
     * @param   request Request object for GET
     * @param   method HTTP Method
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(HttpGet request, Integer method) throws JSONException {
        return UpworkRestClient.getJSONObject(request, method, new HashMap<String, String>());
    }
    
    /**
     * Get JSON response for GET
     * 
     * @param   request Request object for GET
     * @param   method HTTP method
     * @param   params POST parameters
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(HttpGet request, Integer method, HashMap<String, String> params) throws JSONException {
        switch (method) {
        case METHOD_GET:
            return doGetRequest(request);
        default:
            throw new RuntimeException("Wrong http method requested");
        }
    }
    
    /**
     * Get JSON response for POST
     * 
     * @param   request Request object for POST
     * @param   method HTTP method
     * @param   params POST parameters
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(HttpPost request, Integer method, HashMap<String, String> params) throws JSONException {
        switch (method) {
        case METHOD_PUT:
        case METHOD_DELETE:
        case METHOD_POST:
            return doPostRequest(request, params);
        default:
            throw new RuntimeException("Wrong http method requested");
        }
    }
    
    /**
     * Execute POST request
     * 
     * @param   url Request object for POST
     * @param   method HTTP method
     * @param   params POST parameters
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
   	private static JSONObject doPostRequest(HttpPost httpPost, HashMap<String, String> params) throws JSONException {
    	JSONObject json = null;
        HttpClient postClient = HttpClientBuilder.create().build();
        HttpResponse response;
        
        try {
            response = postClient.execute(httpPost);
            
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                
                if (entity != null) {
                    InputStream instream = entity.getContent();  
                    String result = convertStreamToString(instream);
                    instream.close();
                    
                    json = new JSONObject(result);
                }
            } else {
            	json = UpworkRestClient.genError(response);
            }
        } catch (ClientProtocolException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpPost.abort();
        }
        
        return json;
    }
    
   	/**
     * Execute GET request
     * 
     * @param   url Request object for GET
     * @param   method HTTP method
     * @param   params POST parameters
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    private static JSONObject doGetRequest(HttpGet httpGet) throws JSONException {
        JSONObject json = null;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        
        try {
        	response = httpClient.execute(httpGet);
            
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = convertStreamToString(instream);
                    instream.close();
                    
                    json = new JSONObject(result);
                }
            } else {
            	json = UpworkRestClient.genError(response);
            }
        } catch (ClientProtocolException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpGet.abort();
        }
        
        return json;
    }
    
    /**
     * Convert stream to string
     * 
     * @param	is Input stream
     * @return	Converted string
     * */
    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
  
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Generate error as JSONObject
     * 
     * @param   code Error code
     * @param   message Error message
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    private static JSONObject genError(Integer code, String message) throws JSONException {
        // TODO: HTTP-Status (404, etc), for now return status line
        return new JSONObject("{error: {code: \"" + code.toString() + "\", message: \"" + message + "\"}}");
    }
    
    /**
     * Generate error as JSONObject
     * 
     * @param   code Error code
     * @param   message Error message
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    private static JSONObject genError(HttpResponse response) throws JSONException {
    	String code		= response.getFirstHeader("X-Upwork-Error-Code").getValue();
    	String message	= response.getFirstHeader("X-Upwork-Error-Message").getValue();
    	
    	if (code == null) {
    		code = Integer.toString(response.getStatusLine().getStatusCode());
    	}
    	
    	if (message == null) {
    		message = response.getStatusLine().toString();
    	}

    	return new JSONObject("{error: {code: \"" + code + "\", message: \"" + message + "\"}}");
    }
}
