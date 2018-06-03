package variables;
import DNA.Chunk;
import DNA.DNA;

public interface Individual {
	
	public void addChunk(Chunk chunkToAdd);
	
	public void addChunks(Chunk[] chunksToAdd);

	DNA getPrideDNA();

	void setPrideDNA(DNA prideDNA);

	public void setAlphaMale();
	
	public void setElliteFemale();
	
	public void setMale();
	
	public void setNotElliteFemale();
	
	public void setMaleMutation();
	
	public void setFemaleMutation();
	
}
