package musicData;

/**
 * This class represents the Mood type as it is in the Musimap API
 * we build them as a hireracy in the way that they have parents and catagories
 * 
 * @author Tuval
 *
 */
public class Mood {
	private Category cat; 
	private String name;
	private String UID;
	private Mood parent;
	
	/**
	 * The constractor of the class, it initializes all the parameters
	 * it will initialize the category according to the parent
	 * @param moodName the name of the mood from the MUSIMAP API
	 * @param UID The UID from the MUSIMAP API
	 * @param moodParent an object that is the parent of the mood according to MUSIMAP API
	*/
	public Mood(String moodName,String UID, Mood moodParent) {
		this.UID = UID;
		this.name= moodName;
		this.parent = moodParent;	
		if(this.getParentName().equals("nullParent")) {
			this.cat = this.getNewCategory(this.name);
		}	
		if(moodParent != null) {			
			if(moodParent.getCategory() == null) {
				this.cat = this.getCategory(moodParent.getName());
			}
			else {
				this.cat = moodParent.getCategory();
			}
		}
	}

	/**
	 * set a new parent to the mood
	 * @param parentMood the parent mood to assign
	 */
	public void setParent(Mood parentMood) {
		this.parent = parentMood;
	}
	
	/**
	 * removes the parent of the mood
	 * @param parentMood the parent mood to remove
	 */
	public void removeParent(Mood parentMood) {
		this.parent = null;
	}
	
	/**
	 * This method returns the category of the mood
	 * @return Category name for the requested mood
	 */
	public Category getCategory() {
		return this.cat;
	}
	
	/**
	 * This method returns the name of the mood
	 * @return name for the requested mood
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the parent of the mood
	 * @return parent mood object for the requested mood
	 */
	public String getParentName() {
		if(parent == null) {
			return "nullParent";
		}
		
		return parent.getName();
	}
	
	/**
	 * This method is being used while creatinf the new mood to ercieve the parent mood
	 * it is used for mood that were not assigned yet- the top moods
	 * @param parentName The name of the parent of the mood
	 * @return the category of the mood
	 */
	private Category getCategory(String parentName) {
		if(parentName.equals("Up (Air)")) {
			return Category.UP;
		}else if(parentName.equals("On (Ground)")) {
			return Category.ON;
		}else if(parentName.equals("Out (Wood)")) {
			return Category.OUT;
		}else if(parentName.equals("Above (Fire)")) {
			return Category.ABOVE;
		}else if(parentName.equals("Down (Metal)")) {
			return Category.DOWN;
		}else if(parentName.equals("In\\/within (Water)")) {
			return Category.IN;
		}else {
			return null;
		}
			
	}
	
	/**
	 * This method is being used while creatinf the new mood to ercieve the mood
	 * it is used for mood that were not assigned yet- the top moods
	 * @param parentName The name of the parent of the mood
	 * @return the category of the mood
	 */
	private Category getNewCategory(String name) {
		if(name.equals("Up (Air)")) {
			return Category.UP;
		}else if(name.equals("On (Ground)")) {
			return Category.ON;
		}else if(name.equals("Out (Wood)")) {
			return Category.OUT;
		}else if(name.equals("Above (Fire)")) {
			return Category.ABOVE;
		}else if(name.equals("Down (Metal)")) {
			return Category.DOWN;
		}else if(name.equals("In\\/within (Water)")) {
			return Category.IN;
		}else {
			return null;
		}
			
	}
	
	/**
	 * this method returens the mood UID from the MUSIMAP API
	 * @return The UID of the mood
	 */
	public String getUID() {
		return this.UID;
	}
	
	/**
	 * This ios an enum that is equivelent to the same in the MUSIMAP API category
	 * 
	 * @author Tuval
	 *
	 */
	public enum Category{
		ABOVE, DOWN, IN, ON, OUT, UP
	}
}
