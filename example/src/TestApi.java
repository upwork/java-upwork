import com.Upwork.api.*;
import com.Upwork.api.Routers.Organization.Users;
import com.Upwork.api.Routers.Reports.Time;

import java.util.HashMap;
import java.util.Scanner;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class TestApi {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//assign access token-secret pair if they are already known
		//this process is up to application how to save and store
		//in secure token's data 
		//String aToken = "xxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		//String aSecret = "xxxxxxxxxxxxxx";
		
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
        JSONObject json2 = null;
        JSONObject json3 = null;
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
        	
        	// Get test report
        	//Build the list of parameters
            HashMap<String, String> params2 = new HashMap<String, String>();
        	params2.put("tqx", "out:json");
        	params2.put("tq", "select task where worked_on >= '2014-06-01' AND worked_on <= '2014-06-03' order by worked_on");
        	Time report = new Time(client);
        	json2 = report.getByFreelancerLimited(myId, params2);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        
        System.out.println(json1);
        System.out.println(json2);
	}
}
