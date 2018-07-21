package algorithm;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import DNA.Chunk;
import DNA.DNA;
import DNA.MoodChunk;
import DNA.PrideDNA;
import convertors.Convertor;
import convertors.MoodConvertor;
import musicData.Mood;
import musicData.MoodHierarchy;
import textReader.MoodHierarchyReader;
import variables.Generation;
import variables.Individual;
import variables.PrideGeneration;
import variables.PrideIndividual;
import view.ConsoleView;

public class alphaAlgo implements Algorithm {


	Convertor moodConvrtr;
	MoodHierarchy  MH;
	Date d;
	Random rand;
	
	public alphaAlgo(MoodHierarchy MH){
		moodConvrtr = new MoodConvertor();
		this.MH = MH;
		d = new Date();
		rand = new Random(d.getTime());
		
	}
	@Override
	public void fitness() {
		ConsoleView.getFitness(); 

	}
	
	//for now only for first indivdual in first generation
	@Override
	public Individual generateIndividual(Chunk[] allQualities) {
		Individual toReturn = new PrideIndividual();
		for(Chunk c:allQualities) {
			toReturn.addChunk(c);
		}
		return toReturn;
	}

	@Override
	public Individual[] reproduce(Individual[] pickedSongs) {
		Individual[] toReturn = new PrideIndividual[20];
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
			toReturn[18] = makeChild(pickedSongs[6],pickedSongs[4]);
			toReturn[19] = makeChild(pickedSongs[3],pickedSongs[4]);
			//creating the mutation
			toReturn[18] = createMutation(toReturn[18]);
			toReturn[19] = createMutation(toReturn[19]);
		}
		
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
	
	public String getDataFromInput(String input) {
		/**
		Map<String, String> ToReturn = new HashMap<String, String>();
		String[] partsMood = input.split("\\[moods\\]");
		String afterMoods = partsMood[1];
		for(int i = 0; i < 10 ; i ++) {
			ToReturn.put(getSpeficDataFromInput, value)getSpeficDataFromInput
		}
		return moodName;
		
		**/
		
		return null;
	}
	
	private Individual makeChild(Individual parentA, Individual parentB) {
		//making sure no null
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
		
		return toReturn;
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
	@Override
	public Generation createFirstGeneration(String[][] userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

	
	

}
