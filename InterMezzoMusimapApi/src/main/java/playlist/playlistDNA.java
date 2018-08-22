package playlist;

import java.util.LinkedList;
import java.util.List;

import DNA.DNA;
import variables.Generation;
import variables.Individual;

/**
 * This interface is the DNA of all the generation that was liked by the user
 * @author Tuval
 *
 */
public interface playlistDNA {


	/**
	 * returns the playlist if the user want s to hear it
	 * @return the DNA of the music that the user liked
	 */
	public List<DNA> getPlaylist();
	/**
	 * this method adds a new generation to the playlist
	 * @param toAssign the generation that passed the fitness function
	 */
	public void setPlaylist(Generation toAssign);

}
