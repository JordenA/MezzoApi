package musicData;

import convertors.BaseSixtyFour;

public class Mood {
	private Category cat; 
	private String name;
	private String UID;
	private Mood parent;
	
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

	
	public void setParent(Mood parentMood) {
		this.parent = parentMood;
	}
	
	public void removeParent(Mood parentMood) {
		this.parent = null;
	}
	
	public Category getCategory() {
		return this.cat;
	}
	
	public String getName() {
		return name;
	}
	
	public String getParentName() {
		if(parent == null) {
			//System.out.println("the mood " + name + " has null parent");
			return "nullParent";
		}
		
		return parent.getName();
	}
	
	public enum Category{
		ABOVE, DOWN, IN, ON, OUT, UP
	}
	
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
	
	public String getUID() {
		return this.UID;
	}
	
}
