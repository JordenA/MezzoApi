package DNA;
/**
 * This class is an implemenatation of Chunk for key words types, 
 * there are 5 key words in every DNA and they repesent the type of mood that is suitable for this music
 * 
 * @author Tuval
 *
 */
public class KeyWordChunk extends AbstractChunk {

	/**
	 * This is the constructor for the Keyword type, It uses the abstruct contsractur as is
	 * In the future, can be added other features.
	 * It tell what are the keywords for the type of music
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	KeyWordChunk(String name, String UID, String score) {
		super(name, UID, score);
		this.chunkNumber = 5;
	}

}
