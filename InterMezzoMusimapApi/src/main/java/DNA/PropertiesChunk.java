package DNA;

public class PropertiesChunk extends AbstractChunk {
	
	String catagory;
	
	public PropertiesChunk(String name,String catagory,String UID, String score) {
		super(name, UID, score);
		this.catagory = catagory;
		this.chunkNumber = 7;
	}

}
