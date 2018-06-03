package algorithm;

import java.util.Map;

import DNA.Chunk;
import DNA.DNA;
import variables.Generation;
import variables.Individual;

public interface Algorithm {

	void fitness();
	public Individual generateIndividual(Chunk[] allQualities);
	public Individual[] createFirstPool(Chunk[][] userPicks);
	public Individual[] reproduce(Individual[] pickedSongs); 
	public Individual createMutation(Individual indi);
	public Generation createFirstGeneration(String[][] userInput);
	
}
