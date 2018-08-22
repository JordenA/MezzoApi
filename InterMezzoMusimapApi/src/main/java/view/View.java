package view;

import java.util.List;

import musicData.Song;
import presenter.Presenter;

/**
 * this is the generic View for this project
 * it allows to recieve a list of songs from the user, or send list of songs to play to the user
 * @author Tuval
 *
 */
public interface View {
	
	public String[] getPickedArtists();
	
	public List<Song> playSongs(Song[] toPlay);
	
	public void setSongs(Song[] toAssign);
	
	public void setPresenter(Presenter p);
}
