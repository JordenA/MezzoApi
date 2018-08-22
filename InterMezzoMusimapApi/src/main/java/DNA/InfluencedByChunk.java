package DNA;
/**
 * This class is an implemenatation of Chunk for influeced by types, 
 * there are 3 ingluenced by in every DNA and they repesent who influences the type of music
 * 
 * @author Tuval
 *
 */
public class InfluencedByChunk extends AbstractChunk{

	/**
	 * This is the constructor for the influenced by type, It uses the abstruct contsractur as is
	 * In the future, can be added other features.
	 * It tell who are they influencing(type of music)
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	public InfluencedByChunk(String name, String UID, String score) {
		super(name, UID, score);
		this.chunkNumber = 3;
	}

}
