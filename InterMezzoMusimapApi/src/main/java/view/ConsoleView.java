package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import musicData.Song;
import presenter.Presenter;

public class ConsoleView implements View {

	Scanner sc;
	static int numOfChosen;
	static int numOfSongs;
	//
	Presenter p;
	
	public ConsoleView() {
		sc = new Scanner(System.in); 
		numOfChosen = 0;
		numOfSongs = 0;
	}
	
	public String[] getPickedArtists() {
		String[] arr1 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		String[] arr2= {"maroon 5", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};
		String[] toReturn = new String[20];
		System.out.println("Choose your favorite artist:"); 
		for(int i = 0; i < arr1.length; i ++) {
			System.out.println("1 for " + arr1[i] + " or 2 for " + arr2[i]);
			//int chosen = sc.nextInt();
			int chosen = 1;
			if(chosen == 1) {
				toReturn[i] = arr1[i];
			}else {
				toReturn[i] = arr2[i];
			}
		}
		
		return toReturn;
	}
	
	public List<Song> playSongs(Song[] toPlay) {
		List<Song> toReturn = new LinkedList<>();
		System.out.println("do you like the next song? 1 for yes, 2 for no");
		
		for(int i = 0; i < toPlay.length; i ++) {
			numOfSongs++;
			System.out.println(toPlay[i].getSongName() +" by " + toPlay[i].getArtistName());
			int chosen = sc.nextInt();
			if(chosen == 1) {
				numOfChosen++;
				toReturn.add(toPlay[i]);
			}
		}
		
		return toReturn;
	}
	
	public static int getFitness() {
		if(numOfSongs == 0) {
			return 0;
		}
		
		return (numOfChosen*100)/numOfSongs;
	}

	@Override
	public void setSongs(Song[] toAssign) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPresenter(Presenter p) {
		this.p = p;
	}
	
	
	
	
	
}
