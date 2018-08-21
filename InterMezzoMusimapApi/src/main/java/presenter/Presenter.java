package presenter;

import java.util.List;

import model.Model;
import musicData.Song;
import view.View;

public class Presenter {
	private View view;
	private Model model;
	
	public Presenter(View view, Model model) {
	this.view = view;
	this.model = model;
	
	}
	
	public void run() {
		String[] artists = view.getPickedArtists();	
		//System.out.println("the artist is " + artists[0]);
		model.setFirstGeneration(artists);
		//System.out.println("the artist is " + artists[0]);
		while(true) {
			Song[] songs = model.getSongByDNA();
			System.out.println("the song is " + songs[0]);
			view.setSongs(songs);
			List<Song> pickedSongs = view.playSongs(songs);
			System.out.println("sending " + pickedSongs.size() + " songs to the model");
			model.addToNextGeneration(pickedSongs);		
		}
	}

}
