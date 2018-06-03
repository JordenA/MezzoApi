package view;

import java.util.ArrayList;
import java.util.List;

import musicData.Song;

public class Fitness {
	
	static List<Song> songList = new ArrayList<Song>();
	static int countLikes = 0;

	public static void addSongToFitness(Song s) {
		songList.add(s);
		
	}
	
	public void printFitness() {
		System.out.print(songList);
	}
	
	public static void fitness() {
		
		for(int i=0;i<songList.size();i++)
		{
			if(songList.get(i).isLike()==true)
				countLikes++;
		}
		System.out.print("you liked "+countLikes+" songs out of "+songList.size()+" songs");
		
	
		
		
	}
	
	public static String getFitnessAnswer() {
		String str=("you liked "+countLikes+" songs out of "+songList.size()+" songs");
		
		return str;
	}
	
	
	

}
