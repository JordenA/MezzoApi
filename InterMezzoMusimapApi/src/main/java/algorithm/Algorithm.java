package algorithm;

import DNA.Chunk;
import variables.Individual;

/**
 * This Interface is the Algorithm behind all the project, it is the brain of the Genetic algorithm and in case of change,
 * it can easily be replaced or extended differently. 
 * 
 * @author Tuval
 *
 */
public interface Algorithm {

	/**
	 * This is the method that evaluates the current generation, and can be implemented in many different ways
	 */
	void fitness();
	/**
	 * This method generates a generic individual by a generic Chunk of DNA data in an array
	 * @param allQualities the array of Chunks that is the DNA of the Individual to be created
	 * @return a new individual with the DNA as given in the allQualities parameter
	 */
	public Individual generateIndividual(Chunk[] allQualities);
	/**
	 * This method created the first pool of Individuals according to a given list of Chunks of DNA.
	 * This method would only be used once while initializing the first pool using the user input of preferred artists.
	 * @param userPicks an Array of Arrays of Chunks of DNA that is received from an adapter that build this format from the API quest
	 * @return an Array of individuals that will be the first generation
	 */
	public Individual[] createFirstPool(Chunk[][] userPicks);
	/**
	 * This is the method that is in charge of the way that the individual of the generation choose to reproduce
	 * @param pickedSongs the list of Individuals that will be having dependents in the next generation
	 * @return a new generation of Individuals that was reproduced from the input
	 */
	public Individual[] reproduce(Individual[] pickedSongs);
	/**
	 * This method is responsible for the way that mutations are generated in the algorithem
	 * @param indi the Individual to use to create the new mutation
	 * @return a new Individual that is a mutation
	 */
	public Individual createMutation(Individual indi);
	
}
