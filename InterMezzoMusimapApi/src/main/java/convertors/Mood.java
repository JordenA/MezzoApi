package convertors;

/**
 * this class is the mood clas, everymood has UID and name
 * @author Tuval
 *
 */
public class Mood extends BaseSixtyFourAbstract{
	
	private String name;
	private boolean isLeaf;
	private BaseSixtyFour parent;
	private int number;
	
	/**
	 * this is the mood ad defined in the MUSIMAP API
	 * This constractor initializes the parameetrs for the object
	 * @param moodName the name of the mood
	 * @param moodParent the parent of the mood by the api
	 * @param moodNumber the number of the mood - currently not used
	 */
	public Mood(String moodName, BaseSixtyFour moodParent, int moodNumber) {
		name= moodName;
		this.parent = moodParent;
		this.number = moodNumber;
	}

	/**
	 * not used
	 * @param parentMood
	 */
	public void setParent(Mood parentMood) {
		this.parent = parentMood;
	}
	/**
	 * not used
	 * @param parentMood
	 */
	public void removeParent(Mood parentMood) {
		this.parent = null;
	}
	
	
	

}
