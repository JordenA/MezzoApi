package textReader;
import java.util.Map;

import DNA.Chunk;

public interface Reader {
	
	public Chunk[] readChunk(String strToRead);
	
	public String readUID(String strToRead);

}
