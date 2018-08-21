package DNA;

/**
 * This class is an extention of the Abstract class AbstructChunk, for a Genre type of Chunk
 * The Genre type is defined in the Musimap API
 * @author Tuval
 *
 */
public class GenreChunk extends AbstractChunk {

	/**
	 * This is the constructor for the Genre type, It uses the abstruct contractur as is
	 * In the future, can be added other features.
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	GenreChunk(String name, String UID,  String score) {
		super(name, UID, score);
	}


}
