package variables;

import java.util.List;

import algorithm.Algorithm;
import algorithm.alphaAlgo;
import musicData.MoodHierarchy;

public class PrideGeneration implements Generation {
	
	int fitness;
	Algorithm algo;
	Individual[] pool;
	
	public PrideGeneration(MoodHierarchy MH){ 
		System.out.println("\n**************STARTING INITIALIZING  GENERATION*********\n");
		//change from null
		algo= new alphaAlgo(MH);
		//pool = this.algo.createFirstPool(null);
		System.out.println("\n**************END INITIALIZING  GENERATION*********\n");
	}
	
	public PrideGeneration(Individual[] firstPool, MoodHierarchy MH){ 
		//change from null
		algo= new alphaAlgo(MH);
		//pool = this.algo.createFirstPool();
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
		System.out.println("worked?");
		this.reproduce(helper);
	}






	
	
	
}
