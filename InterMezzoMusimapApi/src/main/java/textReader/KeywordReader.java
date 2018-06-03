package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;

public class KeywordReader extends AbstractReader {

	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[6];
		String helper;
		helper = strToRead.substring(strToRead.indexOf("\"keywords\":[{") + "\"keywords\":[{".length());
		for(int i = 0; i < toReturn.length ; i++) {
			helper = helper.substring(helper.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = helper.substring(0, helper.indexOf("\",\""));
			helper = helper.substring(helper.indexOf("name\":\"")+ "name\":\"".length());
			//creating new empty mood
			String keywordName = helper.substring(0, helper.indexOf("\""));
			//removing the mood we used
			helper = helper.substring(helper.indexOf("importance\":") + "importance\":".length());
			String keywordImportance = helper.substring(0, helper.indexOf("}"));
			System.out.println(keywordName);
			System.out.println(keywordImportance);
			toReturn[i] = new InfluencingChunk(keywordName, UID, keywordImportance);
		}
		
		return toReturn;
	}

}
