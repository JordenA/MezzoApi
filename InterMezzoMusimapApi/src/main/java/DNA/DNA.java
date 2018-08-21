package DNA;
import java.util.List;

/**
 * This Interface is the core of the Individual, because every individdual needs a DNA.
 * It can be addpapted to many forms
 * 
 * @author Tuval
 *
 */
public interface DNA {
	
	/**
	 * This method initialize the DNA in a case that it is a generic one with no input
	 * I will save it in a type according to the way implemented
	 */
	void initDNA();
	/**
	 * This method initialize the DNA when is given an array of Chunks to save
	 * @param arr An array of Chunks to save as the DNA
	 */
	void initDNA(List<Chunk> arr);
	/**
	 * This method returns the DNA as a generic list type
	 * @return the DNA Chunks as a list
	 */
	List<Chunk> getDNA();
	/**
	 * This mthod bulild the DNA by adding a new Chunk to it, 
	 * ususally when something happens or in first initalization 
	 * @param chunkToAdd a Chunk object to add to the DNA type that saves all the Chunks
	 */
	void buildDNA(Chunk chunkToAdd);
}
