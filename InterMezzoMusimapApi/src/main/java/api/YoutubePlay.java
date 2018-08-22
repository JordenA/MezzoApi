package api;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.json.JSONObject;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
/**
*this class responsable to open youtube window on google chrome in order to play songs
 * @author Yarden
 
 */
public class YoutubePlay {
	/**
	 * 
	 * @param songNameGUI - string for the name of the song
	 * @param artistNameGUI - string for the artist name
	 * @throws IOException
	 */
	public static void playYoutube(String songNameGUI,String artistNameGUI) throws IOException {
		String artist= new String();
		String track= new String();
		String uid= new String();
//		artist= "coldplay";
//		track= "clocks";
//		uid= "37BF6FEF-4685-EF3D-0BAA-3256FD0BF933"; // uid of a song
//		String[] arr = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		Api api = new Api();
		String songArtist= new String();
		String songName= new String();
		songArtist= songNameGUI;
		songName= artistNameGUI;
		
		
        YouTube youtube = YoutubeApi.getYouTubeService();
        try {
            HashMap<String, String> parameters = new HashMap<>(); //hashmap of parametrs to the youtube song
            parameters.put("part", "snippet");
            parameters.put("maxResults", "1"); // return only 1 res
            parameters.put("q", songArtist +" "+ songName); // the song we want to hear
            parameters.put("type", "video");

            YouTube.Search.List searchListByKeywordRequest = youtube.search().list(parameters.get("part").toString());
            if (parameters.containsKey("maxResults")) {
                searchListByKeywordRequest.setMaxResults(Long.parseLong(parameters.get("maxResults").toString()));
            }

            if (parameters.containsKey("q") && parameters.get("q") != "") {
                searchListByKeywordRequest.setQ(parameters.get("q").toString());
            }

            if (parameters.containsKey("type") && parameters.get("type") != "") {
                searchListByKeywordRequest.setType(parameters.get("type").toString());
            }

            SearchListResponse response = searchListByKeywordRequest.execute();
            System.out.println(response);
            JSONObject json = new JSONObject(response.toString()); // getting json in the response
			String videoId = json.getJSONArray("items").getJSONObject(0).getJSONObject("id").getString("videoId"); // taking the first song - its id and videoid
		
			URI uri = new URI("http://www.youtube.com/watch?v=" + videoId); // creating uri 
            if (Desktop.isDesktopSupported()) 
            {
              try 
              {
                Desktop.getDesktop().browse(uri); // open browser
              }
              catch (IOException e) 
              { /* TODO: error handling */ }
            }
			
            // error
        } catch (GoogleJsonResponseException e) {
            e.printStackTrace();
            System.err.println("There was a service error: " +
                e.getDetails().getCode() + " : " + e.getDetails().getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

}
