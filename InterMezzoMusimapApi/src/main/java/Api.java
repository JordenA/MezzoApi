
import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

import javax.net.ssl.HttpsURLConnection;

public class Api {

	private final String USER_AGENT = "Musimap PHP Sample";
	
	private String getToken() throws Exception {
		String url = "https://api.musimap.net/oauth/access_token";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		Map<String,Object> params = new LinkedHashMap<>();
		params.put("grant_type", "client_credentials");
		params.put("client_id", "1r3mhw9nfhuv7tok");
		params.put("client_secret", "l1nzfrajtvxrjorhsts1pf7e9td8jge9");
      
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> param : params.entrySet()) {
			if (postData.length() != 0) postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

		// Send post request
		con.setDoOutput(true);
		con.getOutputStream().write(postDataBytes);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		//wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			//System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			//System.out.println(response.toString());
			JSONObject json = new JSONObject(response.toString());
			String token = json.getString("access_token");
			return token;
		}	
	}

	String getArtistInfluancedTo(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str = new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?limit=3&name="+str+"&influences[0][type]=artist&influences[0][direction]=to&influences[0][uid]=3B970FE1-83BB-4291-4F3E-226FBADEE365&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	}
	
	String getArtistUID(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str= new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?name="+str+"&output=details";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			
			JSONObject json = new JSONObject(response.toString());
			String uid = json.getJSONArray("results").getJSONObject(0).getString("uid");
			System.out.println(uid);
			return uid;
		}		
	}

String getArtistInfluancedFrom(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&influences[0][direction]=from&influences[0][uid]=3B970FE1-83BB-4291-4F3E-226FBADEE365&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
}
	String getArtistScore() throws Exception {

		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/artists/search?score_expertise";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		

	}
	String getArtistGenre(String s) throws Exception { // recieved albums names - not finish

		String token = getToken();
		if (token == null) {
			return null;
		}
		String str= new String();
		str = s;
		String uid= this.getArtistUID(str);
		String url = "https://api.musimap.net/albums/search?owner="+uid;
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		

	
	}
	String getArtistProperties(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str= new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?name="+str+"&output=properties";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	}
String getArtistTags(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str= new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?name="+str+"&output=tags";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	}
String getArtistKeywords(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&output=keywords";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
 }
String getArtistMemberships(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&output=memberships";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
}
String getArtistReferences(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&output=references";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
}
String getArtistMoods(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&limit=5&output=moods";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
}
String getMoodsHierarchy() throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String url = "https://api.musimap.net/moods";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		
}
String getTrackAudioAnalysis(String str) throws Exception {

	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String track= new String();
	track= str;
	String url = "https://api.musimap.net/tracks/search?name="+str+"&output=audioanalysis";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-length", "0");
	con.setRequestProperty("Content-type", "application/json");
	byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
	con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	} else {
		BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		//print result
		System.out.println(response.toString());
		return response.toString();
	}		

		
   }
	String[][] initFirstDNA(String[] artists) throws Exception { // String[] artists recieved from GUI code
		String[][] toReturn= new String[20][6];
		for(int i=0; i<20; i++) {
			toReturn[i][0]=getArtistMoods(artists[i]);
			toReturn[i][1]=getArtistInfluancedFrom(artists[i]);
			toReturn[i][2]=getArtistInfluancedFrom(artists[i]);
			toReturn[i][3]=getArtistKeywords(artists[i]);
			toReturn[i][4]=getArtistProperties(artists[i]);
			toReturn[i][5]=getArtistTags(artists[i]);

		}
		for(int i=0; i<20; i++) {
			for (int j=0; j<6; j++) {
				System.out.println(toReturn[i][j]);
			}
		}
		return toReturn;
	}
	

	
	String getSongMoodsBySongUid(String songUid) throws Exception {
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&output=moods";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}	
		
	}
		
	String getSongKeywordsBySongUid(String songUid) throws Exception{

		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&output=keywords";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	}
	/*String getSongTagsBySongUid(String songUid) throws Exception{


		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&output=tags";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	
		
	}*/
	String getSongPropertiesBySongUid(String songUid) throws Exception{
        String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&output=properties";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}			
	}
	String getSongInfluancedTo(String songUid) throws Exception{
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&influences[0][type]=artist&influences[0][direction]=to&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}		
	
		
	}
	String getSongInfluancedFrom(String songUid) throws Exception{
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&influences[0][direction]=from&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}			
	}
	String[] getSongInfoBySongUid(String songUid) throws Exception{ //sets info on one song
		String[] res= new String[5];
		res[0]=getSongMoodsBySongUid(songUid);
		res[1]=getSongInfluancedFrom(songUid);
		res[2]=getSongInfluancedTo(songUid);
		res[3]=getSongKeywordsBySongUid(songUid);
		res[4]=getSongPropertiesBySongUid(songUid);
		//res[5]=getSongTagsBySongUid(songUid);
		return res;	
	}
	
	String[][] getSongsInfo(String[] songUID) throws Exception { // recieve an array of uid's of songs that got like
		int size= songUID.length;
		String[][] toReturn= new String[size][5];
		for(int i=0; i<size; i++) {
			toReturn[i][0]=getSongMoodsBySongUid(songUID[i]);
			toReturn[i][1]=getSongInfluancedFrom(songUID[i]);
			toReturn[i][2]=getSongInfluancedTo(songUID[i]);
			toReturn[i][3]=getSongKeywordsBySongUid(songUID[i]);
			toReturn[i][4]=getSongPropertiesBySongUid(songUID[i]);
			//toReturn[i][5]=getSongTagsBySongUid(songUID[i]);

		}
		for(int i=0; i<size; i++) { // print the answer - not necessary
			for (int j=0; j<5; j++) {
				System.out.println(toReturn[i][j]);
			}
		}
		return toReturn;
	}
	
	String getSongByDNA(Chunk[] dna) throws Exception {
		String token = getToken();
		if (token == null) {
			return null;
		}
		Date d= new Date();
		Random rand= new Random(d.getTime());
		int moodRand, keywordRand, influenceToRand,influenceFromRand ,propRand; 
		moodRand=rand.nextInt(6);
		influenceFromRand=rand.nextInt(3)+6;
		influenceToRand= rand.nextInt(3)+9;
		keywordRand= rand.nextInt(6)+12;
		propRand=rand.nextInt(7)+18;
		String url = "https://api.musimap.net/tracks/search?moods["+ moodRand +"][uid]="+ dna[moodRand].getUID() +"moods["+ moodRand +"][importance]=70:100|keywords["+ keywordRand+ "][uid]="+ dna[keywordRand].getUID() +"&keywords["+ keywordRand+ "][importance]=70:100|properties["+ propRand +"][uid]="+ dna[propRand].getUID() +"&properties[" +propRand+ "][importance]=70:100|influences[" +influenceFromRand +"][type]=tracks&influences[" +influenceFromRand+ "][direction]=from&influences[" + influenceFromRand + "][importance]=70:100|influences[" + influenceToRand +"][type]=artist&influences[" +influenceToRand+ "][direction]=to&influences[" +influenceToRand+ "][importance]=70:100&output=owners";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-length", "0");
		con.setRequestProperty("Content-type", "application/json");
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
		con.setRequestProperty("Authorization", "Bearer ".concat(new String(encodedBytes)));

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return null;
		} else {
			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
			//print result
			System.out.println(response.toString());
			return response.toString();
		}
		
		
	}
	
}
