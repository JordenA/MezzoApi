package DNA;

/**
 * This class is an implemenatation of Chunk for propreties, 
 * there are 7 properties in every DNA and they repesent properties of the music
 * 
 * @author Tuval
 *
 */
public class PropertiesChunk extends AbstractChunk {
	
	//there are few catagories for properties
	String catagory;
	
	/**
	 * This is the constructor for the properties type, It uses the abstruct contsractur as is
	 * and adds the category type.
	 * @param name the name of the Chunk, according to API
	 * @param catagory the category of the property
	 * @param UID the UID of the Chunk, according to API
	 * @param score is the score of the chunk from 1-100, recieved as an int
	 */
	
	public PropertiesChunk(String name,String catagory,String UID, String score) {
		super(name, UID, score);
		this.catagory = catagory;
		this.chunkNumber = 7;
	}

}
