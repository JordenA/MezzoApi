package variables;

import java.util.List;

import algorithm.Algorithm;
import algorithm.alphaAlgo;
import musicData.MoodHierarchy;

/**
 * This class implements the generation interfface in a way that is like a pride of lions in nature
 * 
 * @author Tuval
 *
 */
public class PrideGeneration implements Generation {
	
	int fitness;
	Algorithm algo;
	Individual[] pool;
	
	/**
	 * this constarctor initializes the class with a modd hirerachy object to use 
	 * @param MH the mood hirerachy pobject as defiened in its class
	 */
	public PrideGeneration(MoodHierarchy MH){ 
		//change from null
		algo= new alphaAlgo(MH);
		//pool = this.algo.createFirstPool(null);
	}
	
	/**
	 * this constarctor initializes the class with a modd hirerachy object to use 
	 * @param firstPool the first generation of all the generations
	 * @param MH the mood hirerachy pobject as defiened in its class
	 */
	public PrideGeneration(Individual[] firstPool, MoodHierarchy MH){ 
		//change from null
		algo= new alphaAlgo(MH);
		//pool = firstPool;
	}

	@Override
	public Individual[] getGeneration() {
		return pool;
	}

	@Override
	public void reproduce(Individual[] pickedSongs) {
		System.out.println("the songs are: ");
		for(Individual i: pickedSongs) {
			System.out.println(i.getPrideDNA().getDNA().toString());
		}
		pool = algo.reproduce(pickedSongs);
	}

	@Override
	public void reproduce(List<Individual> pickedSongs) {
		Individual[] helper = new PrideIndividual[20];
		pickedSongs.toArray(helper);
		//System.out.println("worked?");
		this.reproduce(helper);
	}






	
	
	
}
