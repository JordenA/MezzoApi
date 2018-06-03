package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import DNA.Chunk;
import DNA.DNA;
import api.Api;
import musicData.MoodHierarchy;
import musicData.Song;
import textReader.MoodHierarchyReader;
import textReader.ReaderWrapper;
import textReader.SongReader;
import variables.Generation;
import variables.GenerationEvaluator;
import variables.Individual;
import variables.PrideGeneration;
import variables.PrideIndividual;
import view.ConsoleView;

public class Model {
	
	GenerationEvaluator GE;
	ReaderWrapper RR = new ReaderWrapper();
	Generation currentGeneration;
	MoodHierarchyReader MHR;
	MoodHierarchy MH;
	List<Individual> nextGeneration;
	Api myApi;
	SongReader SR;
	

	public Model(){
		RR = new ReaderWrapper();
		nextGeneration = new LinkedList<>();
		MHR = new MoodHierarchyReader();
		MH = MHR.readMoodHierarchy("hhh");
		currentGeneration = new PrideGeneration(MH);
		myApi = new Api();
		SR = new SongReader();
		
	}
	
	public void createFirstPool(String[][] firstUserInput) {
		Individual[] firstPool = RR.ReadGenerationChunks(firstUserInput);	
		currentGeneration = new PrideGeneration(firstPool, MH);	
	}
	
	public void repreduce() {
		currentGeneration.reproduce(nextGeneration);
	}
	
	public void addToNextGeneration(Individual toAdd) {
		//adding picked song
		nextGeneration.add(toAdd);
		//checking if generation is full
		if(nextGeneration.size() == 10) {
			if(ConsoleView.getFitness() >= 70) {
				System.out.println("we did it!");
				System.exit(0);
			}
			GE = new GenerationEvaluator(nextGeneration);
			nextGeneration = GE.setIndividualRoll();
			repreduce();
			nextGeneration.clear();
			//fitness
		}
	}
	
	public Individual getIndividualFromAPI(String[] individualData) {
		Individual toReturn = RR.readIndividualChunks(individualData);;
		return toReturn;
	}
	
	public Generation getGeneration() {
		return this.currentGeneration;
	}
	
	public void setFirstGeneration(String[] pickedArtists) {
		try {
			this.createFirstPool(myApi.initFirstDNA(pickedArtists));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public Song[] getSongByDNA() {
		Date d = new Date();
		Random rand = new Random(d.getTime());
		int randInt = rand.nextInt(20);
		Individual[] temp = currentGeneration.getGeneration();
		try {
			String helper = myApi.getSongByDNA(temp[randInt].getPrideDNA());
			return SR.createSongArr(helper);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public void addToNextGeneration(List<Song> toAdd) {
		
		for(int i = 0; i < toAdd.size(); i ++) {
			try {
				Individual temp = RR.readIndividualChunks(myApi.getSongInfoBySongUid(toAdd.get(i).getsongUID()));
				this.addToNextGeneration(temp);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	

}