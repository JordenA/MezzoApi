package DNA;

/**
 * This Interface represents a chunk of the DNA of an Individual
 * It is designed as close for changes, open for extentaions 
 * @author Tuval
 *
 */
public interface Chunk {
	
	/**
	 * This method returns the name(type) of the Chunk
	 * @return The name of the Chunk
	 */
	public String getName();
	/**
	 * This method sets the name(type) of the Chunk
	 * @param name the name to assign to the Chunk
	 */
	public void setName(String name);
	/**
	 * This method returns the UID of a Chunk
	 * @return the Chunk UID
	 */
	public String getUID();
	/**
	 * This method returns the number of the Chunks in the DNA
	 * @return the Chunk number
	 */
	public int getChunkNumber();
	/**
	 * This method returns the score(how high it is) of the chunk according to the API
	 * @return the score of the chunk - how high it is from 1 to 100
	 */
	public int getScore();
}
