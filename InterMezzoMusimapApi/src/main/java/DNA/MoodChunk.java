	package DNA;

	/**
	 * This class is an implemenatation of Chunk for mood types, 
	 * there are 6 moods in every DNA and they repesent the type of mood that is suitable for this music
	 * 
	 * @author Tuval
	 *
	 */
public class MoodChunk extends  AbstractChunk {


	/**
	 * This is the constructor for the mood type, It uses the abstruct contsractur as is
	 * In the future, can be added other features.
	 * It tell what moods represent the music
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an String
	 */
	public MoodChunk(String name, String UID, String score) {
		super(name, UID, score);
		this.chunkNumber = 6;//6;
	}
	

	/**
	 * This is the constructor for the mood type, It uses the abstruct contsractur as is
	 * In the future, can be added other features.
	 * It tell what moods represent the music
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	public MoodChunk(String name, String UID, int score) {
		super(name, UID, score);
		this.chunkNumber = 6;//6;
	}
	

	
	
}
