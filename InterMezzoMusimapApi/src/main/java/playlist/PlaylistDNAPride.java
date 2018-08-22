package playlist;

import java.util.LinkedList;
import java.util.List;
import DNA.DNA;
import variables.Generation;
import variables.Individual;
/**
 * This class implements the playlist interface 
 * the playlist can continue to grow for ever
 * @author Tuval
 *
 */
public class PlaylistDNAPride implements playlistDNA {
	
	List<DNA> playlist;
	
	/**
	 * the constractor of the playlist, initialized once
	 */
	public PlaylistDNAPride() {
		playlist = new LinkedList<>();
	}
	@Override
	public List<DNA> getPlaylist(){
		return this.playlist;
	}
	
	@Override
	public void setPlaylist(Generation toAssign) {
		List<DNA> temp = new LinkedList<DNA>();
		for(Individual i: toAssign.getGeneration()) {
			temp.add(i.getPrideDNA());
		}
		
		playlist.addAll(temp);
	}
	
}
