package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;

/**
 * not active
 * 
 * @author Tuval
 *
 */
public class UIDReader extends AbstractReader{

	
	/**
	 * not active
	 */
	public String readUID(String strToRead) {
		String toReturn;
		String UID;
		UID = strToRead.substring(strToRead.indexOf("\"results") + 13);
		UID = UID.substring(UID.indexOf("\"uid\":\":")+ 8);
		//creating new empty mood
		toReturn = UID.substring(0, UID.indexOf("\""));
		return toReturn;		
	}

	@Override
	public Chunk[] readChunk(String strToRead) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * never used
	 */
	@Override
	public Chunk[] readChunk() {
		// TODO Auto-generated method stub
		return null;
	}

}
