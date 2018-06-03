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
		model.setFirstGeneration(artists);
		while(true) {
			Song[] songs = model.getSongByDNA();
			List<Song> pickedSongs = view.playSongs(songs);
			model.addToNextGeneration(pickedSongs);		
		}
	}

}
