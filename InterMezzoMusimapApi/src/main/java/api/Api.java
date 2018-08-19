package api;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

import DNA.*;
import view.MyGui;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author Yarden
 * API class 
 *this class is responsable for connecting to musimap API.
 *collects information about artist and songs in order to build to the user playlist by his DNA of music taste
 */
public class Api {

	private final String USER_AGENT = "Musimap PHP Sample";
	private final int NUMBER_TRY = 3;
	private static String Token = null;
	private static int ForbiddenErrorTry = 0;
	/**
	 * 
	 * @return String - token for user
	 * @throws Exception
	 */
	
	private String getToken() throws Exception {
		if (Api.Token != null) {
			return Api.Token;
		}
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
		////System.out.println("\nSending 'POST' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

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
			////System.out.println(response.toString());
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
			JSONObject json = new JSONObject(response.toString());
			String token = json.getString("access_token");
			Api.Token = token;
			Api.ForbiddenErrorTry = 0;
			return token;
		}	
	}
	/**
	 * 
	 * @param s - artist name
	 * @return String of Influanced to 
	 * @throws Exception
	 */

	String getArtistInfluancedTo(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str = new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?limit=1&name="+str+"&influences[0][type]=artist&influences[0][direction]=to&influences[0][uid]=3B970FE1-83BB-4291-4F3E-226FBADEE365&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistInfluancedTo(s);
			}
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
			return response.toString();
		}		
	}
	/**
	 * 
	 * @param s artist
	 * @return String of the artist UID
	 * @throws Exception
	 */
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistUID(s);
			}
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
			
			JSONObject json = new JSONObject(response.toString());
			String uid = json.getJSONArray("results").getJSONObject(0).getString("uid");
			System.out.println(uid);
			return uid;
		}		
	}
		/**
		 * 
		 * @param s artist
		 * @return String of the artist influanced from
		 * @throws Exception
		 */
String getArtistInfluancedFrom(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&limit=1&influences[0][direction]=from&influences[0][uid]=3B970FE1-83BB-4291-4F3E-226FBADEE365&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getArtistInfluancedFrom(s);
		}
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		////System.out.println(response.toString());
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
		return response.toString();
	}		
}
/**
 * 
 * @return String - the score of top artists
 * @throws Exception
 */
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistScore();
			}
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
			return response.toString();
		}		

	}
	/**
	 * 
	 * @param s - the artist
	 * @return String of the artist genres
	 * @throws Exception
	 */
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistGenre(s);
			}
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
			return response.toString();
		}		

	
	}
	/**
	 * 
	 * @param s - artist
	 * @return string of artist properties
	 * @throws Exception
	 */
	String getArtistProperties(String s) throws Exception {
		
		String token = getToken();
		if (token == null) {
			return null;
		}
		String str= new String();
		str= s;
		String url = "https://api.musimap.net/artists/search?name="+str+"&limit=1&output=properties";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistProperties(s);
			}
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
			return response.toString();
		}		
	}
	/**
	 * 
	 * @param s- artist
	 * @return String of artist tags
	 * @throws Exception
	 */
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getArtistTags(s);
			}
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
			return response.toString();
		}		
	}
/**
 
 * @param s- artist name
 * @return string of the artist keywords
 * @throws Exception
 */
String getArtistKeywords(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&limit=1&output=keywords";
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getArtistKeywords(s);
		}
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
		return response.toString();
	}		
 }
/**
 * @param s - artists name
 * @return String of the artist memberships
 * @throws Exception
 */
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getArtistMemberships(s);
		}
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
		return response.toString();
	}		
}
/**
 * 
 * @param s artist name
 * @return String of artist refrences
 * @throws Exception
 */
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getArtistReferences(s);
		}
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
		return response.toString();
	}		
}
/**
 * 
 * @param s artist name
 * @return string of artist moods
 * @throws Exception
 */
String getArtistMoods(String s) throws Exception {
	
	String token = getToken();
	if (token == null) {
		return null;
	}
	String str= new String();
	str= s;
	String url = "https://api.musimap.net/artists/search?name="+str+"&limit=1&output=moods";
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getArtistMoods(s);
		}
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
		return response.toString();
	}		
}
/**
 * 
 * @return the hierarchy of moods by musimap
 * @throws Exception
 */
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getMoodsHierarchy();
		}
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
		return response.toString();
	}		
}
/**
 * 
 * @param str song name
 * @return String of song audio analysis
 * @throws Exception
 */
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
	////System.out.println("\nSending 'GET' request to URL : " + url);
	////System.out.println("Response Code : " + responseCode);

	if (responseCode > 200) {
		if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
			Api.Token = null;
			Api.ForbiddenErrorTry++;
			this.getTrackAudioAnalysis(str);
		}
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
		return response.toString();
	}		
/**
 * @param array of artists names
 * @return the first DNA to the algorithm
 */
		
   }
	public String[][] initFirstDNA(String[] artists) throws Exception { // String[] artists recieved from GUI code
		Date d = new Date();
		String[][] toReturn= new String[20][5];
		for(int i=0; i<20; i++) {
			System.out.println("time started getArtists on itereation " + i + " is " + d.getTime() );
			toReturn[i][0]=getArtistMoods(artists[i]);
			System.out.println("time finished getArtists on itereation " + i + " is " + d.getTime() );
			System.out.println("time started getArtistInfluancedTo on itereation " + i + " is " + d.getTime() );
			toReturn[i][1]=getArtistInfluancedTo(artists[i]);
			System.out.println("time finished getArtistInfluancedTo on itereation " + i + " is " + d.getTime() );
			System.out.println("time started getArtistInfluancedFrom on itereation " + i + " is " + d.getTime() );		
			toReturn[i][2]=getArtistInfluancedFrom(artists[i]);
			System.out.println("time finished getArtistInfluancedFrom on itereation " + i + " is " + d.getTime() );
			System.out.println("time started getArtistKeywords on itereation " + i + " is " + d.getTime() );
			toReturn[i][3]=getArtistKeywords(artists[i]);
			System.out.println("time finished getArtistKeywords on itereation " + i + " is " + d.getTime() );
			System.out.println("time started getArtistProperties on itereation " + i + " is " + d.getTime() );
			toReturn[i][4]=getArtistProperties(artists[i]);
			System.out.println("time started getArtistProperties on itereation " + i + " is " + d.getTime() );
			//toReturn[i][5]=getArtistTags(artists[i]);

		}
		for(int i=0; i<20; i++) {
			for (int j=0; j<5; j++) {
				//System.out.println(toReturn[i][j]);
			}
		}
		return toReturn;
	}
	

	/**
	 * 
	 * @param songUid - UID of a song 
	 * @return String of song's moods
	 * @throws Exception
	 */
	String getSongMoodsBySongUid(String songUid) throws Exception {
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&limit=1&output=moods";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongMoodsBySongUid(songUid);
			}
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
			return response.toString();
		}	
		
	}
	/**
	 * 	
	 * @param songUid - UID of a song
	 * @return String of the song's keywords
	 * @throws Exception
	 */
	String getSongKeywordsBySongUid(String songUid) throws Exception{

		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&limit=1&output=keywords";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongKeywordsBySongUid(songUid);
			}
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

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
			return response.toString();
		}		
	
		
	}*/
	/**
	 * 
	 * @param songUid - UID of a song
	 * @return String of the song's properties
	 * @throws Exception
	 */
	String getSongPropertiesBySongUid(String songUid) throws Exception{
        String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&limit=1&output=properties";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongPropertiesBySongUid(songUid);
			}
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
			return response.toString();
		}			
	}
	/**
	 * 
	 * @param songUid - UID of a song
	 * @return String of the song's influanced to
	 * @throws Exception  
	 */
	String getSongInfluancedTo(String songUid) throws Exception{
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&limit=1&influences[0][type]=artist&influences[0][direction]=to&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongInfluancedTo(songUid);
			}
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
			return response.toString();
		}		
	
		
	}
	/**
	 * 
	 * @param songUid - UID of a song
	 * @return String of the song's influanced from
	 * @throws Exception
	 */
	String getSongInfluancedFrom(String songUid) throws Exception{
		String mySongUid= new String();
		mySongUid= songUid;
		String token = getToken();
		if (token == null) {
			return null;
		}
		String url = "https://api.musimap.net/tracks/search?name="+mySongUid+"&limit=1&influences[0][direction]=from&influences[0][importance]=10&reference_provider=qobuz&output=details,references";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongInfluancedFrom(songUid);
			}
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
			return response.toString();
		}			
	}
	/**
	 * 
	 * @param songUid- UID of a song
	 * @return array of strings - each index contains specific info about the song -moods, influance and more
	 * @throws Exception
	 */
	public String[] getSongInfoBySongUid(String songUid) throws Exception{ //sets info on one song
		String[] res= new String[5];
		res[0]=getSongMoodsBySongUid(songUid);
		res[1]=getSongInfluancedFrom(songUid);
		res[2]=getSongInfluancedTo(songUid);
		res[3]=getSongKeywordsBySongUid(songUid);
		res[4]=getSongPropertiesBySongUid(songUid);
		//res[5]=getSongTagsBySongUid(songUid);
		return res;	
	}
	
	int getArraySize(String[] str) {
		int size=0;
		for (int i=0;i<str.length;i++) {
			if(str[i]=="-1") {
				break;
			}
			size++;
		}
		return size;
	}
	/**
	 * 
	 * @param songUID -array of  UIDs of a songs that the user like
	 * @return information about each song. 
	 * @throws Exception
	 */
	String[][] getSongsInfo(String[] songUID) throws Exception { // recieve an array of uid's of songs that got like
		int size= getArraySize(songUID);
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
				//System.out.println(toReturn[i][j]);
			}
		}
		return toReturn;
	}
	/**
	 * 
	 * @param userdna - DNA from the algorithm
	 * @return song that match the DNA
	 * @throws Exception
	 */
	public String getSongByDNA(DNA userdna) throws Exception {
		Chunk[] dna = new Chunk[25];
		dna = userdna.getDNA().toArray(dna);
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
		//String url = "https://api.musimap.net/tracks/search?moods["+ moodRand +"][uid]="+ dna[moodRand].getUID() +"moods["+ moodRand +"][importance]=70:100|keywords["+ keywordRand+ "][uid]="+ dna[keywordRand].getUID() +"&keywords["+ keywordRand+ "][importance]=70:100|properties["+ propRand +"][uid]="+ dna[propRand].getUID() +"&properties[" +propRand+ "][importance]=70:100|influences[" +influenceFromRand +"][type]=tracks&influences[" +influenceFromRand+ "][direction]=from&influences[" + influenceFromRand + "][importance]=70:100|influences[" + influenceToRand +"][type]=artist&influences[" +influenceToRand+ "][direction]=to&influences[" +influenceToRand+ "][importance]=70:100&output=owners";
		String url="https://api.musimap.net/tracks/search?moods[0][uid]="+ dna[moodRand].getUID()+"&output=owners";
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
		////System.out.println("\nSending 'GET' request to URL : " + url);
		////System.out.println("Response Code : " + responseCode);

		if (responseCode > 200) {
			if (responseCode == 403 && Api.ForbiddenErrorTry < NUMBER_TRY) {
				Api.Token = null;
				Api.ForbiddenErrorTry++;
				this.getSongByDNA(userdna);
			}
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
			return response.toString();
		}
		
		
	}
	
}
