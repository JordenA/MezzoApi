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
		System.out.println("\n**************STARTING FIRST POOL*********\n");
		System.out.println("\n**************ENTERING READ CHUNKS*********\n");
		Individual[] firstPool = RR.ReadGenerationChunks(firstUserInput);
		System.out.println("this is the first generation");
		int j = 0;
		for(Individual i:firstPool) {
			
			System.out.println("this is the inidividual number " + j + " " + i.getPrideDNA().getDNA().toString());
			j++;
		}	
		System.out.println("\n**************EXITING READ CHUNKS*********\n");
		System.out.println("\n**************ENTERING GENERATION CREATION*********\n");
		currentGeneration = new PrideGeneration(firstPool, MH);	
		System.out.println("\n**************EXITING GENERATION CREATION*********\n");
		System.out.println("\n**************ENTERING REPREDUCTION*********\n");
		currentGeneration.reproduce(firstPool);
		System.out.println("\n**************EXITING REPREDUCTION*********\n");
		System.out.println("\n**************ENDING FIRST POOL*********\n");
	}
	
	public void repreduce() {
		System.out.println("\n**************STARTING REPREDUCTION*********\n");
		currentGeneration.reproduce(nextGeneration);
		System.out.println("\n**************ENDING REPREDUCTION*********\n");
	}
	
	public void addToNextGeneration(Individual toAdd) {
		//adding picked song
		nextGeneration.add(toAdd);
		//checking if generation is full
		if(nextGeneration.size() == 10) {
			if(ConsoleView.getFitness() >= 90) {
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
		System.out.println("\n**************STARTING FIRST GENERATION*********\n");
		try {
			//checkinmg where the error is
			System.out.println("API request started");
			String[][] helper = myApi.initFirstDNA(pickedArtists);
			System.out.println("API request ended");
			System.out.println("create first pool started");
			this.createFirstPool(helper);
			System.out.println("create first pool ended");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**************ENDING FIRST GENERATION*********\n");
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
		System.out.println("model recieved " + toAdd.size() + " songs");
		for(int i = 0; i < toAdd.size(); i ++) {
			try {
				System.out.println("model is reqyesting song info on song " + toAdd.get(i).getsongUID());
				String[] data = myApi.getSongInfoBySongUid(toAdd.get(i).getsongUID());
				System.out.println("we recieved the following information for this song: ");
				int j = 0;
				for(String str:data) {
					System.out.println("this is the " + j + " element of the song " + str);
				}		
				Individual temp = RR.readIndividualChunks(data);
				System.out.println("this is the temp individual " + temp.getPrideDNA().getDNA() + "  we recieved for the song " + toAdd.get(i).getsongUID()  );
				this.addToNextGeneration(temp);
			}catch(Exception e) {
				System.out.println("is there a problem??????");
				System.out.println(e.getMessage() + " i is now " + i + " and size is " + toAdd.size());
			}
		}
	}
	
	
	

}