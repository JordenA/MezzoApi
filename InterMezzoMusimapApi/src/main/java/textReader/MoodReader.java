package textReader;

import java.util.HashMap;
import java.util.Map;

import DNA.Chunk;
import DNA.MoodChunk;

public class MoodReader extends AbstractReader {

	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[100];
		String mood;
		mood = strToRead.substring(strToRead.indexOf("\"moods\":") + "\"moods\":".length());
		for(int i = 0; i < 100 ; i++) {
			if(mood.length() < 9) {
				break;
			}
			mood = mood.substring(mood.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = mood.substring(0, mood.indexOf("\",\""));
			mood = mood.substring(mood.indexOf("\"name\":\"")+ "\"name\":\"".length());
			//creating new empty mood
			String moodToAssign = mood.substring(0, mood.indexOf("\""));
			//removing the mood we used
			mood = mood.substring(mood.indexOf("\"importance\":") + "\"importance\":".length());
			
			String moodImportance = mood.substring(0, mood.indexOf("}"));
			System.out.println(moodToAssign);
			System.out.println(UID);
			System.out.println(moodImportance);
			toReturn[i] = new MoodChunk(moodToAssign,UID,  moodImportance);
		}
		// TODO Auto-generated method stub
		return toReturn;
	}
	
	

}
