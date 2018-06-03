package DNA;
import java.util.List;

public interface DNA {
	
	
	void initDNA();
	void initDNA(List<Chunk> arr);
	List<Chunk> getDNA();
	void buildDNA(Chunk chunkToAdd);
}
