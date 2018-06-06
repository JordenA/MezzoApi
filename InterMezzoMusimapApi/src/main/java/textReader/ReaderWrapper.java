package textReader;

import DNA.Chunk;
import DNA.DNA;
import DNA.MoodChunk;
import DNA.PrideDNA;
import Randomizer.ChunkRandom;
import musicData.MoodHierarchy;
import variables.Individual;
import variables.PrideIndividual;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReaderWrapper extends AbstractReader {

	MoodHierarchyReader MHR;
	MoodHierarchy MH;
	ChunkRandom CR;
	Reader moodReader;
	Reader InfuencedByReader;
	Reader InfluencingReader;
	Reader keywordReader;
	Reader propertiesReader;
	
	
	public ReaderWrapper(){
		moodReader = new MoodReader();
		InfuencedByReader = new InfluencedByReader();
		InfluencingReader = new InfluencingReader();
		keywordReader = new KeywordReader();
		propertiesReader = new PropertiesReader();
		MHR = new MoodHierarchyReader();
		//just for now
		MH = MHR.readMoodHierarchy("nuldld");
		CR = new ChunkRandom(MH);
	}
	@Override
	public Chunk[] readChunk(String strToRead) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Individual readIndividualChunks(String[] strToRead){
		Individual toReturn;
		//Chunk[] helper;
		Chunk[] mds = CR.randomChunks(moodReader.readChunk(strToRead[0]));
		Chunk[] infBy = CR.randomChunks(InfuencedByReader.readChunk(strToRead[1]));
		Chunk[] infing = CR.randomChunks(InfluencingReader.readChunk(strToRead[2]));
		Chunk[] kywrds = CR.randomChunks(keywordReader.readChunk(strToRead[3]));
		Chunk[] prprts = CR.randomChunks(propertiesReader.readChunk(strToRead[4]));
		//the new user DNA
		List<Chunk> newDNA = new LinkedList<Chunk>();
		//ading all chunks after randomizing and changing them to lists
		newDNA.addAll(Arrays.asList(mds));
		newDNA.addAll(Arrays.asList(infBy));
		newDNA.addAll(Arrays.asList(infing));
		newDNA.addAll(Arrays.asList(kywrds));		
		newDNA.addAll(Arrays.asList(prprts));
		DNA toAssign = new PrideDNA();
		toAssign.initDNA(newDNA);
		toReturn = new PrideIndividual(toAssign);
		
		return toReturn;
	}
	
	public Individual[] ReadGenerationChunks(String[][] strToRead){
		Individual[] toReturn  = new PrideIndividual[20];
		for(int i = 0; i < strToRead.length ; i++) {
			Chunk[] mds = /*CR.randomChunks(*/moodReader.readChunk(strToRead[i][0])/*)*/;
			Chunk[] infBy = InfuencedByReader.readChunk(strToRead[i][1]);
			Chunk[] infing = InfluencingReader.readChunk(strToRead[i][2]);
			Chunk[] kywrds = keywordReader.readChunk(strToRead[i][3]);
			Chunk[] prprts = propertiesReader.readChunk(strToRead[i][4]);
			//the new user DNA
			List<Chunk> newDNA = new LinkedList<Chunk>();
			//ading all chunks after randomizing and changing them to lists
			newDNA.addAll(Arrays.asList(mds));
			newDNA.addAll(Arrays.asList(infBy));
			newDNA.addAll(Arrays.asList(infing));
			newDNA.addAll(Arrays.asList(kywrds));		
			newDNA.addAll(Arrays.asList(prprts));
			DNA toAssign = new PrideDNA();
			toAssign.initDNA(newDNA);
			toReturn[i] = new PrideIndividual(toAssign);
			
		}
		System.out.println(toReturn.toString());
		return toReturn;
	}
	
	private Chunk[] chopChunks(Chunk[] toChop, int numberForOutput) {
		Chunk[] toReturn;
		switch(toChop.getClass().getName()) {
			case "MoodReader":
				toReturn = new MoodChunk[6];
		}
		//Chunk[] toReturn = new 
		
		return null;
	}
	

}
