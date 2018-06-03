package variables;

import DNA.Chunk;
import DNA.DNA;
import DNA.PrideDNA;

public class PrideIndividual implements Individual{
	private DNA pDNA;
	private boolean isAlphaMale = false;
	private boolean isElliteFemale = false;
	private boolean isNotEliteFemale = false;
	private boolean isMale = false;
	private boolean isMaleMutation = false;
	private boolean isFemaleMutation = false;
	
	
	public PrideIndividual() {
		pDNA = new PrideDNA();
	}
	
	public PrideIndividual(DNA indiDNA){
		pDNA= indiDNA;
	}
	
	public PrideIndividual(Chunk[] DNAinChuncks){
		pDNA = new PrideDNA();
		for(Chunk c: DNAinChuncks) {
			pDNA.buildDNA(c);
		}
	}
	
	public void setAlphaMale() {
		isAlphaMale = true;
	}
	
	public void setElliteFemale() {
		isElliteFemale = true;
	}
	
	public void setMale() {
		isMale = true;
	}
	public void setNotElliteFemale() {
		isNotEliteFemale = true;
	}
	
	public void setMaleMutation() {
		isMaleMutation = true;
	}
	
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
