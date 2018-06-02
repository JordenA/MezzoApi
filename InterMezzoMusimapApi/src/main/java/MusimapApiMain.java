import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.json.JSONObject;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.SearchListResponse;

public class MusimapApiMain {

	public static void main(String[] args) throws Exception { 
		// TODO Auto-generated method stub
		String artist= new String();
		String track= new String();
		String uid= new String();
		artist= "coldplay";
		track= "clocks";
		uid= "37BF6FEF-4685-EF3D-0BAA-3256FD0BF933"; // uid of a song
		String[] arr = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		Api api = new Api();
		String songArtist= new String();
		String songName= new String();
		songArtist= "coldplay";
		songName= "clocks";
		
        YouTube youtube = YoutubeApi.getYouTubeService();
        try {
            HashMap<String, String> parameters = new HashMap<>();
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
            JSONObject json = new JSONObject(response.toString());
			String videoId = json.getJSONArray("items").getJSONObject(0).getJSONObject("id").getString("videoId");
			URI uri = new URI("http://www.youtube.com/watch?v=" + videoId); // change uri to gui ??
            if (Desktop.isDesktopSupported()) 
            {
              try 
              {
                Desktop.getDesktop().browse(uri);
              }
              catch (IOException e) 
              { /* TODO: error handling */ }
            }

        } catch (GoogleJsonResponseException e) {
            e.printStackTrace();
            System.err.println("There was a service error: " +
                e.getDetails().getCode() + " : " + e.getDetails().getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
		try {
		//api.getArtistInfluancedTo(artist);
		//api.getArtistInfluancedFrom(artist);
		//api.getArtistProperties(artist);
		//api.getArtistTags(artist);
		//api.getArtistKeywords(artist);
		//api.getArtistMemberships(artist);
		//api.getArtistReferences(artist);
		//api.getArtistMoods(artist);
		//api.getTrackAudioAnalysis(track);
		//api.initFirstDNA(arr);
		//api.getMoodsHierarchy();
		//api.getTrackByDNA();
		//api.getTrackInfluancedFrom(track);
		//api.getArtistUID(artist);
		//api.getSongMoodsBySongUid(uid);
		//api.getSongKeywordsBySongUid(uid);
		//api.getSongTagsBySongUid(uid);
		//api.getSongPropertiesBySongUid(uid);
		//api.getSongInfluancedTo(uid);
		//api.getSongInfluancedFrom(uid);
		//api.getSongInfoBySongUid(uid);
		//api.getSongByDNA();
		} catch (Exception e) {
			System.err.println("exception: " + e.getMessage());
		}
		

		
		 
	   }
	

}