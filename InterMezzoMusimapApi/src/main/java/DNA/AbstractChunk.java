package DNA;

/**
 * this is an abstract implemetation of the Chunk of the DNA
 * @author Tuval
 *
 */
public abstract class AbstractChunk implements Chunk {

	int chunkNumber;
	String name;
	String UID;
	int score;
	
	/**
	 * The constractor of the Chunk, defines what needed to be defined for all the Chunks
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as a String and would be changed to int
	 */
	AbstractChunk(String name,String UID, String score){
		this.name = name;
		this.UID = UID;
		score = score.replace("\"", "");
		Double tempDouble = Double.parseDouble(score.trim());
		this.score = tempDouble.intValue();
	}
	
	/**
	 * The constractor of the Chunk, defines what needed to be defined for all the Chunks
	 * @param name the name of the Chunk, according to API
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	AbstractChunk(String name,String UID, int score){
		this.name = name;
		this.UID = UID;
		this.score = score;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;	
	}
	
	@Override
	public String getUID() {
		return UID;
	}
	
	@Override
	public int getChunkNumber() {
		return chunkNumber;
	}
	
	@Override
	public int getScore() {
		return score;
	}

}
