package variables;
import DNA.Chunk;
import DNA.DNA;

/**
 * This interface is an individual of a generation. every individual has DNA that tell his character
 * individuals have rolls in the generation and they can reproduce and disapear in the next generation
 * 
 * @author Tuval
 *
 */
public interface Individual {
	
	/**
	 * this method adds a chunk of dna to the individual dna
	 * @param chunkToAdd a chunk of dna to add to the individual
	 */
	public void addChunk(Chunk chunkToAdd);
	/**
	 * this method adds chunks of dna to the individual dna
	 * @param chunksToAdd chunks of dna to add to the individual
	 */
	public void addChunks(Chunk[] chunksToAdd);
	/**
	 * this method returns the DNA of the individual
	 * @return the DNA of the individual, will be used in the API
	 */
	DNA getPrideDNA();
	/**
	 *  this method sets the DNA of the individual
	 * @param prideDNA the new DNA of the individual
	 */
	void setPrideDNA(DNA prideDNA);
	/**
	 * this method determines that the individual will be alpha if it got picked
	 */
	public void setAlphaMale();
	/**
	 * this method determines that the individual will be ellite female if it got picked
	 */
	public void setElliteFemale();
	/**
	 * this method determines that the individual will be male if it got picked
	 */
	public void setMale();
	/**
	 * this method determines that the individual will not be ellite female if it got picked
	 */
	public void setNotElliteFemale();
	/**
	 * this method determines that the individual will be mutation male if it got picked 
	 */
	public void setMaleMutation();
	/**
	 * this method determines that the individual will be mutatation female if it got picked 
	 */
	public void setFemaleMutation();
	
}
