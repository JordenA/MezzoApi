package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import musicData.Song;

public interface View {


	public String[] getPickedArtists();
	
	public List<Song> playSongs(Song[] toPlay);

}
