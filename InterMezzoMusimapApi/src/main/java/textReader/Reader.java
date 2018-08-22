package textReader;
import java.util.Map;

import DNA.Chunk;

/**
 * This is an interface that is reading the output of an API to make it into an object of the project(Chunk)
 * Any output is read differnetly according to the API
 * 
 * @author Tuval
 *
 */
public interface Reader {
	
	/**
	 * This method is generating an array of chunks from the output of the API
	 * The number of cells is determined in the implementation
	 * 
	 * @param strToRead The output of the API that needs to be read to our object
	 * @return an array of chunks that wrapp the data 
	 */
	public Chunk[] readChunk(String strToRead);
	
	/**
	 * this method returns a UID from the output of the API
	 * @param strToRead the string that we recieve"(usually very messy)
	 * @return a clean struing of just the UID
	 */
	public String readUID(String strToRead);

}
