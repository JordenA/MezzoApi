package Randomizer;

import java.util.Date;
import java.util.Random;

import DNA.Chunk;
import DNA.MoodChunk;
import musicData.Mood;
import musicData.MoodHierarchy;

/**
 * This is a class that makes randomazation in the mood chunk part of the DNA
 * it uses the mood hirarechy and the categories of the mood
 * 
 * @author Tuval
 *
 */
public class ChunkRandom {

	MoodHierarchy MH;
	Date d;
	Random rand;

	/**
	 * the contractor of the chunk random that recieves the mood hirerchy to use
	 * @param MH mood hirerchy to use later suring the work
	 */
	public ChunkRandom(MoodHierarchy MH) {
		d = new Date();
		rand = new Random(d.getTime());
		this.MH = MH;
	}

	/**
	 * This is the heart of the class, while recieving the list of chunk, 
	 * it will return a smaller list with 6 moods of 6 different categories
	 * 
	 * @param toChop the array of moods to cut 
	 * @return a new array of 6 places with different catagories for moods
	 */
	public Chunk[] randomChunks(Chunk[] toChop) {
		int arraySize = toChop.length;
		int numToReturn = toChop[0].getChunkNumber();
		int counter = numToReturn;
		Chunk[] toReturn = new Chunk[numToReturn];
		if(toChop[0] == null) {
		}else {
			if(toChop[0].getClass() == MoodChunk.class) {
				int randomInt;
				while(counter > 1) {
					randomInt = this.rand.nextInt(arraySize);
					Chunk temp= toChop[randomInt];
					//adding above mood at place 0
					if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.ABOVE
							&& toReturn[0] == null) {
						toReturn[0] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
					//adding down mood at place 1
					else if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.DOWN
							&& toReturn[1] == null) {
						toReturn[1] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
					//adding in mood at place 2
					else if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.IN
							&& toReturn[2] == null) {
						toReturn[2] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
					// adding on mood at place 3
					else if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.ON
							&& toReturn[3] == null) {
						toReturn[3] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
					//adding out mood at place 4
					else if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.OUT
							&& toReturn[4] == null) {
						toReturn[4] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
					//adding up mood at place 5
					else if(MH.getMoodByName(temp.getName()).getCategory() == Mood.Category.UP
							&& toReturn[5] == null) {
						toReturn[5] = new MoodChunk(temp.getName(), temp.getUID(), temp.getScore());
						//flag that we are done 
						counter--;
					}
				}
			}
			else{
				int randomInt = this.rand.nextInt(arraySize);
				for(int i = 0; i < numToReturn; i ++) {
					Chunk temp = toChop[randomInt];
					if(temp != null) {
						toReturn[i] = temp;
					}
					//making sure getting three
					else {
						i--;
					}
				}
				
			}
		}
		
		return toReturn;
	}
}
