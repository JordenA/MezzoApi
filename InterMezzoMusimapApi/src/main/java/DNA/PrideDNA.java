package DNA;

import java.util.LinkedList;
import java.util.List;

public class PrideDNA implements DNA {

	List<Chunk> myDNA;
	
	
	public PrideDNA(){
		myDNA = new LinkedList<>();
	}
	
	public PrideDNA(String userPick){
		myDNA = new LinkedList<>();
		
	}
	
	@Override
	public void initDNA() {
		myDNA = new LinkedList<>();

	}

	@Override
	public List<Chunk> getDNA() {
		return myDNA;
	}

	@Override
	public void initDNA(List<Chunk> arr) {
		this.myDNA.addAll(arr);
		
	}
	
	@Override
	public void buildDNA(Chunk chunkToAdd) {
		myDNA.add(chunkToAdd);
	}

}
