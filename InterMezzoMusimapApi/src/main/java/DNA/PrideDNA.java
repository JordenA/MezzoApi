package DNA;

import java.util.LinkedList;
import java.util.List;
/**
 * This is the implementation of the DNA as Pride DNA that has this format:
 * 6 mood
 * 3 influcedby
 * 3 influencing
 * 5 keywords
 * 7 propreties
 * 
 * @author Tuval
 *
 */
public class PrideDNA implements DNA {

	//the data structure for the DNA
	List<Chunk> myDNA;
	
	/**
	 * constarctor for the Pride DNA, its initalizes an empty DNA and will be assigned after
	 */
	public PrideDNA(){
		myDNA = new LinkedList<>();
	}
	
	/**
	 * constarctor for the Pride DNA, its initalizes a DNA ftom what the user picked
	 * @param userPick string that represents the DNA from what the user picked
	 */
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
