package textReader;

import DNA.Chunk;
import DNA.PropertiesChunk;
import DNA.TagChunk;

/**
 * not active
 * @author Tuval
 *
 */
public class TagReader extends AbstractReader {

	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[20];
		String results;
		results = strToRead.substring(strToRead.indexOf("\"tags\":[\"") + 9);
		for(int i = 0; i < toReturn.length ; i++) {
			String tagName = results.substring(0, results.indexOf("\""));
			//removing the mood we used
			results = results.substring(results.indexOf("\",\"") + 3);
			toReturn[i] = new TagChunk(tagName,"this-is-tag-no-UID", "100");
		}
		
		return toReturn;
	}

}
