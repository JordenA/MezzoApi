package musicData;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import musicData.Mood.Category;

/**
 * This class is a wrapper class for a Map for all the moods when there is a root which is a dummy
 * mood and all the others are build accordiung to the mood class, and saved in a HashMap
 * 
 * @author Tuval
 *
 */
public class MoodHierarchy {

	Mood root = new Mood("Base","0000-00000", null);
	Map<String, Mood> allMoods;
	Date d;
	Random rand;
	
	/**
	 * the constractor of the class initailizes all the parametrs  of the class according to input
	 */
	public MoodHierarchy() {
		allMoods = new HashMap<String, Mood>();
		d = new Date();
		rand = new Random(d.getTime());
	}
	/**
	 * This method return the root mood of the class
	 * for us it is a dummy mood
	 * @return The root mood of this class
	 */
	public Mood getRoot() {
		return root;
	}

	/**
	 * This method returns the name of the root and not as an oobject
	 * @return the name of the root
	 */
	public String getRootName() {
		return root.getName();
	}

	/**
	 * this method returns the name of the parent of the mood
	 * @param curpar the current mood that we want its parent
	 * (par stands for parent while trying to go up the hirerachy
	 * @return the name of the parent of the mood
	 */
	public String getParentName(String curpar) {
		return allMoods.get(curpar).getParentName();
	}
	
	/**
	 * This method adds a new mood to the Map of this class
	 * @param name the name of the new mood
	 * @param UID the UID  of the new mood according to MUSIMAP API
	 * @param parentName the name of the parent of the mood
	 */
	public void addMood(String name,String UID, String parentName) {
		//Mood MoodParent = allMoods.get(parentName);
		Mood MoodToAdd = new Mood(name, UID, allMoods.get(parentName));
		allMoods.put(name, MoodToAdd);
	}
	
	/**
	 * This method returns the entire map of the class
	 * @return the class of the map
	 */
	public Map<String, Mood> getMap(){
		return allMoods;
	}
	
	/**
	 * This method returns a new mood of the same category as the one requested, 
	 * it will be used for mutation
	 * @param MoodName the name of the mood we want to get another like for category
	 * @return a new mood that is not the one in the input but has the same catagory
	 */
	public Mood getDifferentMood(String MoodName) {
		List<Mood> allOtherMoods = getOtherMoodsOfCategory(MoodName);
		int pickedMood = rand.nextInt(allOtherMoods.size());
		return allOtherMoods.get(pickedMood);
	}
	/**
	 * This method returns the mood object by the name,
	 * if doesnt exist returns null(as map does)
	 * @param name the name of the requested mood
	 * @return a mood object that is that name
	 */
	public Mood getMoodByName(String name) {
		return this.allMoods.get(name);
	}
	
	/**
	 * This method returns a list of all the other moods of the same catagory
	 * @param MoodName the name of the mood that we want to recieve the list of catagory that thye are in
	 * @return a list of mood og moodname catagory
	 */
	private List<Mood> getOtherMoodsOfCategory(String MoodName){
		List<Mood> toReturn = new LinkedList<>();
		Mood userMood = this.getMoodByName(MoodName);
		for(Mood md:allMoods.values()) {
			//checks that is the same mood
			if(md.getCategory().equals(userMood.getCategory()) && 
					//not the same mood
					!md.getName().equals(userMood.getName())) {
				toReturn.add(md);
			}
		}
		
		return toReturn;
	}

}
