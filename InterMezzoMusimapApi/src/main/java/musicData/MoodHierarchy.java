package musicData;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import musicData.Mood.Category;

public class MoodHierarchy {

	Mood root = new Mood("Base","0000-00000", null);
	Map<String, Mood> allMoods;
	Date d;
	Random rand;
	
	public MoodHierarchy() {
		allMoods = new HashMap<String, Mood>();
		d = new Date();
		rand = new Random(d.getTime());
	}
	public Mood getRoot() {
		return root;
	}

	public String getRootName() {
		return root.getName();
	}

	public String getParentName(String curpar) {
		return allMoods.get(curpar).getParentName();
	}
	
	public void addMood(String name,String UID, String parentName) {
		//Mood MoodParent = allMoods.get(parentName);
		Mood MoodToAdd = new Mood(name, UID, allMoods.get(parentName));
		allMoods.put(name, MoodToAdd);
	}
	
	public Map<String, Mood> getMap(){
		return allMoods;
	}
	
	public Mood getDifferentMood(String MoodName) {
		List<Mood> allOtherMoods = getOtherMoodsOfCategory(MoodName);
		int pickedMood = rand.nextInt(allOtherMoods.size());
		return allOtherMoods.get(pickedMood);
	}
	
	public Mood getMoodByName(String name) {
		return this.allMoods.get(name);
	}
	
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
