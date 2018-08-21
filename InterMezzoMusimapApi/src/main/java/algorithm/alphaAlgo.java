package algorithm;

import java.util.Date;
import java.util.Random;
import DNA.Chunk;
import DNA.MoodChunk;
import convertors.Convertor;
import musicData.Mood;
import musicData.MoodHierarchy;
import variables.Individual;
import variables.PrideIndividual;
import view.ConsoleView;

/**
 * This class is an implementation of the Algorithm class, it implements it in the lions pride -Alpha manner.
 * It means that unlike the common genetic algorithem that uses couples, 
 * this one will use an alphja individual that is the strongest one in the pride,
 *  and they will repreduce more than other individuals
 *  
 * @author Tuval
 *
 */
public class alphaAlgo implements Algorithm {


	Convertor moodConvrtr;
	MoodHierarchy  MH;
	Date d;
	Random rand;
	
	/**
	 * the constructor of the class, will assign the class objects and initialize the others
	 * @param MH the mood hierarchy that showws how the hierarchy is designed into families
	 */
	public alphaAlgo(MoodHierarchy MH){
		this.MH = MH;
		d = new Date();
		rand = new Random(d.getTime());
		
	}
	
	/**
	 * We choose to determine the score of the generation according to how many times the user swiped yes.
	 * If the user loved more than X % of what had been offered, that means he loved our suggestion, and that the itereations can be stopped.
	 */
	@Override
	public void fitness() {
		ConsoleView.getFitness(); 
	}
	
	@Override
	public Individual generateIndividual(Chunk[] allQualities) {
		//creates new PrideIndividual
		Individual toReturn = new PrideIndividual();
		//going over all the Chunk and adding them to the new individual
		for(Chunk c:allQualities) {
			toReturn.addChunk(c);
		}
		
		//returns the new individual
		return toReturn;
	}

	@Override
	public Individual[] reproduce(Individual[] pickedSongs) {
		Individual[] toReturn = new PrideIndividual[20];
		//reprudocing the whole generation by reproducing couples in same ways
		//the place of the individual in the array determines their status in the group
		//notice 0 -alpha male
		if(pickedSongs != null) {
			toReturn[0] = makeChild(pickedSongs[0],pickedSongs[1]);
			toReturn[1] = makeChild(pickedSongs[0],pickedSongs[2]);
			toReturn[2] = makeChild(pickedSongs[0],pickedSongs[2]);
			toReturn[3] = makeChild(pickedSongs[0],pickedSongs[3]);
			toReturn[4] = makeChild(pickedSongs[0],pickedSongs[3]);
			toReturn[5] = makeChild(pickedSongs[0],pickedSongs[4]);
			toReturn[6] = makeChild(pickedSongs[0],pickedSongs[7]);
			toReturn[7] = makeChild(pickedSongs[0],pickedSongs[7]);
			toReturn[8] = makeChild(pickedSongs[0],pickedSongs[6]);
			toReturn[9] = makeChild(pickedSongs[0],pickedSongs[9]);
			toReturn[10] = makeChild(pickedSongs[5],pickedSongs[2]);
			toReturn[11] = makeChild(pickedSongs[5],pickedSongs[9]);
			toReturn[12] = makeChild(pickedSongs[1],pickedSongs[8]);
			toReturn[13] = makeChild(pickedSongs[9],pickedSongs[8]);
			toReturn[14] = makeChild(pickedSongs[6],pickedSongs[8]);
			toReturn[15] = makeChild(pickedSongs[3],pickedSongs[7]);
			toReturn[16] = makeChild(pickedSongs[3],pickedSongs[2]);
			toReturn[17] = makeChild(pickedSongs[7],pickedSongs[4]);
			//places 18 and 19 are the mutations
			toReturn[18] = makeChild(pickedSongs[6],pickedSongs[4]);
			toReturn[19] = makeChild(pickedSongs[3],pickedSongs[4]);
			//creating the mutation
			toReturn[18] = createMutation(toReturn[18]);
			toReturn[19] = createMutation(toReturn[19]);
		}
		
		//return the group of individuals
		return toReturn;	
		
	}
	
	@Override
	public Individual[] createFirstPool(Chunk[][] userPicks) {
		Individual[] firstPool = new PrideIndividual[20];
		for(int i = 0; i < userPicks.length ;i++) {
			firstPool[i] = this.generateIndividual(userPicks[i]);
		}
		
		return firstPool;
	}
	
	@Override
	public Individual createMutation(Individual indi) {
		//number of moods in DNA
		Individual toReturn = indi;
		int ChunkNumber = rand.nextInt(6);
		Mood newMood = MH.getDifferentMood(indi.getPrideDNA().getDNA().get(ChunkNumber).getName());
		toReturn.getPrideDNA().getDNA().add(ChunkNumber, 
				new MoodChunk(newMood.getName(), newMood.getUID(),
						Integer.toString(rand.nextInt(100))));
		
		//returning the new Individual
		return toReturn;
	}
	
	/**
	 * this is the way that two individuals make a child!
	 * we implement it in a random way, when in every chunk of DNA is picked according to random number
	 * like in nature, some features are like our faher and some are like our mother
	 * @param parentA The first parent that will be used to reproduced
	 * @param parentB The first parent that will be used to reproduced
	 * @return A new baby child of the two happy parents :)
	 */
	private Individual makeChild(Individual parentA, Individual parentB) {		
		Individual toReturn = new PrideIndividual();
		int iterationNumberA = parentA.getPrideDNA().getDNA().size();
		int iterationNumberB = parentB.getPrideDNA().getDNA().size();
		int iterationNumber = Math.max(iterationNumberA, iterationNumberB);
		for(int i = 0; i < iterationNumber; i++) {
			Chunk toAdd;
			int randNum = rand.nextInt(2);
			if(randNum == 0) {
				toAdd = parentA.getPrideDNA().getDNA().get(i);
			}else {
				toAdd = parentB.getPrideDNA().getDNA().get(i);
			}
			toReturn.addChunk(toAdd);
		}
		System.out.println("this is the child "+ toReturn.getPrideDNA().getDNA());
		return toReturn;
	}
	


	
	
	

	
	

}
