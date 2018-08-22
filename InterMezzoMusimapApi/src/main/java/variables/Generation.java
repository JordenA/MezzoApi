package variables;

import java.util.List;

/**
 * This clas is a generation as described in a genetic algoritem 
 * every generation is containg a group of individuals, aas well as the way they reprodoce and create a new individual
 * 
 * @author Tuval
 *
 */
public interface Generation {
	
	/**
	 * on object of the class with all the individuals
	 */
	public Individual[] indi= new Individual[20];
	/**
	 * this method returns the array of individuals in a given generation
	 * @return an array of the individulas of the generation
	 */
	public Individual[] getGeneration();
	
	/**
	 * the method creates a new generartion from the picked songs of the user 
	 * that represent the stronger individuals of this generation
	 * 
	 * @param pickedSongs the songs that the user picked that he likes as an array
	 */
	public void reproduce(Individual[] pickedSongs);
	
	/**
	 * the method creates a new generartion from the picked songs of the user 
	 * that represent the stronger individuals of this generation
	 * 
	 * @param pickedSongs the songs that the user picked that he likes as a list
	 */
	public void reproduce(List<Individual> pickedSongs);
}
