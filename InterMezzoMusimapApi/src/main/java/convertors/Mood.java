package convertors;

public class Mood extends BaseSixtyFourAbstract{
	
	private String name;
	private boolean isLeaf;
	private BaseSixtyFour parent;
	private int number;
	
	public Mood(String moodName, BaseSixtyFour moodParent, int moodNumber) {
		
		name= moodName;
		this.parent = moodParent;
		this.number = moodNumber;
	}

	
	public void setParent(Mood parentMood) {
		this.parent = parentMood;
	}
	
	public void removeParent(Mood parentMood) {
		this.parent = null;
	}
	
	
	

}
