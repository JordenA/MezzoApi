package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;
import DNA.PropertiesChunk;

public class PropertiesReader extends AbstractReader {
	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[10];
		String results;
		results = strToRead.substring(strToRead.indexOf("\"properties\":") + 13);
		for(int i = 0; i < toReturn.length ; i++) {
			results = results.substring(results.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = results.substring(0, results.indexOf("\",\""));
			results = results.substring(results.indexOf("\"name\":\"")+ 8);
			//creating new empty mood
			String propertyName = results.substring(0, results.indexOf("\""));
			//removing the mood we used
			results = results.substring(results.indexOf("\"category\":\"") + 12);
			String propertyCategory = results.substring(0, results.indexOf("\""));
			//getting importance
			results = results.substring(results.indexOf("\"importance\":") + 13);
			String propertyScore = results.substring(0, results.indexOf("}"));
			System.out.println(propertyName);
			System.out.println(propertyCategory);
			System.out.println( propertyScore);
			toReturn[i] = new PropertiesChunk(propertyName, propertyCategory, UID, propertyScore);
		}
		
		return toReturn;
	}

}
