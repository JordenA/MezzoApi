package view;

import java.util.List;

import musicData.Song;

public interface View {
	
	public String[] getPickedArtists();
	
	public List<Song> playSongs(Song[] toPlay);
	
	public void setSongs(Song[] toAssign);
}
