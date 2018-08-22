package variables;

import DNA.Chunk;
import DNA.DNA;
import DNA.PrideDNA;

/**
 * This class implements individual as apride individual, and goes hand in hand with the pride generation
 * it is an individual of a pride of lions in nature
 * @author Tuval
 *
 */
public class PrideIndividual implements Individual{
	private DNA pDNA;
	private boolean isAlphaMale = false;
	private boolean isElliteFemale = false;
	private boolean isNotEliteFemale = false;
	private boolean isMale = false;
	private boolean isMaleMutation = false;
	private boolean isFemaleMutation = false;
	
	/**
	 * Constractor for a new pride individual
	 * the dna will be empty and build later
	 */
	public PrideIndividual() {
		pDNA = new PrideDNA();
	}
	
	/**
	 * Constractor for a new pride individual
	 * the dna will be assigned immidietly
	 * @param indiDNA a DNA objedt to be the individual DNA
	 */
	public PrideIndividual(DNA indiDNA){
		pDNA= indiDNA;
	}
	/**
	 * Constractor for a new pride individual
	 * the dna will be assigned as chunks to a dna object
	 * @param DNAinChuncks array of chunks that contain the DNA for the new individual
	 */
	public PrideIndividual(Chunk[] DNAinChuncks){
		pDNA = new PrideDNA();
		for(Chunk c: DNAinChuncks) {
			pDNA.buildDNA(c);
		}
	}
	@Override
	public void setAlphaMale() {
		isAlphaMale = true;
	}
	@Override
	public void setElliteFemale() {
		isElliteFemale = true;
	}
	@Override
	public void setMale() {
		isMale = true;
	}
	@Override
	public void setNotElliteFemale() {
		isNotEliteFemale = true;
	}
	@Override
	public void setMaleMutation() {
		isMaleMutation = true;
	}
	@Override
	public void setFemaleMutation() {
		isFemaleMutation = true;
	}
	@Override
	public DNA getPrideDNA() {
		return pDNA;
	}
	@Override
	public void setPrideDNA(DNA prideDNA) {
		this.pDNA = prideDNA;
	}

	@Override
	public void addChunk(Chunk chunkToAdd) {
		pDNA.buildDNA(chunkToAdd);
		
	}

	@Override
	public void addChunks(Chunk[] chunksToAdd) {
		for(int i =0; i < chunksToAdd.length;i++) {
			pDNA.buildDNA(chunksToAdd[i]);
		}
		
	}
	
	
}
