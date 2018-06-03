package variables;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import DNA.Chunk;

/**
 * This class evalutes and scores the top 10 song that were picked by the user
 * @author Tuval
 *
 */
public class GenerationEvaluator{
	
	private List<Individual> toEvaluate;
	private Individual PastAlpha;
	Comparator indiComparator;
	
	
	public GenerationEvaluator(List<Individual> toEvaluate) {
		this.toEvaluate = toEvaluate;
		//for(Individual ind:toEvaluate) {
		//	this.toEvaluate.add(ind);
		//}
		Date d = new Date();
		Random rand = new Random(d.getTime());
		int randomInt = rand.nextInt(toEvaluate.size());
		PastAlpha = toEvaluate.get(randomInt);
		indiComparator = new IndividualComparator();
	}
	
	public Individual getAlpha() {
		Individual toReturn;
		//first generation
		if (PastAlpha == null) {
			//random one out of all
			Date d = new Date();
			Random rand = new Random(d.getTime());
			//finding a random one 
			int randomIndi = rand.nextInt(toEvaluate.size());
			toReturn = toEvaluate.get(randomIndi);
		}
		else {
			toReturn = evaluateGeneration();
		}
		
		return toReturn;
	}

	private Individual evaluateGeneration() {
		Individual toReturn = new PrideIndividual();
		int maxSimileraty = -1;
		for(int i = 0; i < toEvaluate.size(); i++) {
			Individual temp = toEvaluate.get(i);
			int currSimileraty = evaluateIndividual(temp);
			if(currSimileraty > maxSimileraty) {
				toReturn = temp;
				maxSimileraty = currSimileraty;
			}
		}		
		return toReturn;
	}
	
	private int evaluateIndividual(Individual toEvaluate) {
		int i = 0;
		for(Chunk c: PastAlpha.getPrideDNA().getDNA()) {
			if(PastAlpha.getPrideDNA().getDNA().contains(c)) {
				i++;
			}
		}
		
		return i;
	}
	/**
	 * This method returns an ordered array of Individuals by this order
	 * 1.Alpha Individual
	 * 2. Ellitte female
	 * @return
	 */
	public List<Individual> setIndividualRoll() {
		toEvaluate.sort(indiComparator);
		//alpha
		toEvaluate.get(0).setAlphaMale();
		//three elite females
		toEvaluate.get(1).setElliteFemale();
		toEvaluate.get(2).setElliteFemale();
		toEvaluate.get(3).setElliteFemale();
		//two males
		toEvaluate.get(4).setMale();
		toEvaluate.get(5).setMale();
		//two not elite females
		toEvaluate.get(6).setNotElliteFemale();
		toEvaluate.get(7).setNotElliteFemale();
		//and the two mutations
		toEvaluate.get(8).setMaleMutation();
		toEvaluate.get(9).setFemaleMutation();
		
		return toEvaluate;
	}


	
	class IndividualComparator implements  Comparator<Individual>{

		@Override
		public int compare(Individual o1, Individual o2) {
			int firstEvaluation =  evaluateIndividual(o1);
			int secondEvaluation = evaluateIndividual(o2);
			return firstEvaluation - secondEvaluation;
		}
		
	}
	
	

}
