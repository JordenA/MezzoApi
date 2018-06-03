package variables;

import java.util.List;

public interface Generation {
	public Individual[] indi= new Individual[20];
	public Individual[] getGeneration();
	public void reproduce(Individual[] pickedSongs);	
	public void reproduce(List<Individual> pickedSongs);
}
