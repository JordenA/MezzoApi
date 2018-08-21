package api;
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

import musicData.Song;

//FOR THE GUI
import java.util.ArrayList;
import java.util.List;
import textReader.SongReader;
import view.Fitness;
import view.MyGui;
//
/**
 * Main created to check the Api class
 * @author Yarden
 */

public class Main {
	/**
	static int songCounter=0;
	static Song[] songArr=new Song [10];
	static boolean check=false;

	 
	

	public static void main(String[] args) throws Exception { 
		
		//Song STR example for the gui
		String str = "{\"total\":11,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"8B2BE602-A55E-19D8-F8DC-74039B34BF39\",\"name\":\"Message To Michael\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"FE65179C-7698-3CB3-9C1C-E1020A1DCD96\",\"name\":\"Let\\u0027s Get High\",\"owners\":[{\"uid\":\"569959D7-7E25-B47B-0FEF-EFF3F1D8DB80\",\"nickname\":\"Lenny Kravitz\"}],\"score\":100},{\"uid\":\"1EC25CEE-48CD-105C-99DA-B5D44A4B02C3\",\"name\":\"Lonely Rainbows\",\"owners\":[{\"uid\":\"B55E75D3-D55D-7033-4227-4924D25E9D44\",\"nickname\":\"Vanessa Paradis\"}],\"score\":100},{\"uid\":\"DA46FB60-74E6-1BF1-3FFB-E45996A9CCDA\",\"name\":\"Mood Indigo\",\"owners\":[{\"uid\":\"E366801D-1E61-1995-3732-F3842217132F\",\"nickname\":\"Louis Armstrong\"}],\"score\":100},{\"uid\":\"4BCCCF6D-126C-F723-9444-058C759BCF36\",\"name\":\"(They Long To Be) Close To You\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"B0DD138B-7B65-86F7-0EA4-BF97E842FFD1\",\"name\":\"J\\u0027t\\u0027emm\\u00e8ne au vent\",\"owners\":[{\"uid\":\"81EB577E-4F36-4610-8B91-B7EB607E59FF\",\"nickname\":\"Louise Attaque\"}],\"score\":100},{\"uid\":\"C09F3D29-980E-B1BA-4B16-3323526ED180\",\"name\":\"The Look Of Love\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"85D4EE26-3815-714B-94AD-08471FFE621E\",\"name\":\"In The Stone\",\"owners\":[{\"uid\":\"B36EC115-6071-6FA7-55BD-797461759250\",\"nickname\":\"Earth, Wind \\u0026 Fire\"}],\"score\":100},{\"uid\":\"EE3ABEE3-6AD4-172B-A535-BF15548E8E58\",\"name\":\"The Windows Of The World\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"C5A560B7-DA61-9A4E-EC28-632A9F3C127B\",\"name\":\"Lisa\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100}]}"; 
		songArr=SongReader.createSongArr(str);
		MyGui frame = new MyGui();

		
		// TODO Auto-generated method stub

        
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

	
	public Song[] getSongArr() {
		return songArr;
	}
	
	public static Song getSong() { // send song to gui
		
			if(songCounter > 9) {
				songCounter = 9;
			}
			Song s= songArr[songCounter];
			return s;	
		
	}
	
	public static void updatelike(boolean isLiked) { // send song to gui
	
		MyGui.countChoices++;
		songArr[songCounter].setLike(isLiked);//set like or dislike - depends on user input from gui
		Fitness.addSongToFitness(songArr[songCounter]);
		
		if (isLiked==true)
		{
			MyGui.likeCount++; // counts how many likes per generation
			MyGui.likedSongsUID[MyGui.LikedSongsUIDcounter]=songArr[songCounter].getsongUID();
			System.out.println(MyGui.likedSongsUID[MyGui.LikedSongsUIDcounter]);
			MyGui.LikedSongsUIDcounter++; // counts how many likes per 10 songs 
			
		}
		
		if (songCounter<=9) //// WAS <=9
		{
			songCounter++; // dont move to the next sont until you update the like/dislike	
		}
		
		if (songCounter==10) { // WAS ==10
			check=true;	
			Fitness.fitness();
		}
		
		
}
**/


}


	

