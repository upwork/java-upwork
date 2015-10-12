package com.Upwork.test_api;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.Upwork.api.OAuthClient;
import com.Upwork.api.Routers.Organization.Users;

/**
 * Hello world! Test Upwork API
 *
 */
public class App 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
    	//assign access token-secret pair if they are already known
		//this process is up to application how to save and store
		//in secure token's data 
		//String aToken = "xxxxxxxxxxxxxxxxxxxxxxxxx";
		//String aSecret = "xxxxxxxxxxx";
		
		//by default token and secret are unknown
		//and application must follow authorization process
		String aToken = null;
		String aSecret = null;
		
		OAuthClient client = new OAuthClient(null);
		
		// authorize application and get access token
		if (aToken == null && aSecret == null) {
			Scanner scanner = new Scanner(System.in);
			String authzUrl = client.getAuthorizationUrl();
			System.out.println(authzUrl);
			
			System.out.println("1. Copy paste the following url in your browser : ");
	        System.out.println(authzUrl);
	        System.out.println("2. Grant access ");
	        System.out.println("3. Copy paste the oauth_verifier parameter here :");
	        
	        String oauth_verifier = scanner.nextLine();
	        
	        String verifier = null;
	        try {
	            verifier = URLDecoder.decode(oauth_verifier,"UTF-8");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        HashMap<String, String> token = client.getAccessTokenSet(verifier);
	        
	        scanner.close();
	        System.out.println(token);
		} else {
			// set known access token-secret pair
			client.setTokenWithSecret(aToken, aSecret);
		}
        
        JSONObject json1 = null;
        try {
        	// Get info of authenticated user
        	Users users = new Users(client);
        	json1 = users.getMyInfo();
        	
        	// get my uid
        	String myId = null;
        	try {
            	JSONObject user = json1.getJSONObject("user");
            	myId = user.getString("id");
            	System.out.println(myId);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }        	
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
