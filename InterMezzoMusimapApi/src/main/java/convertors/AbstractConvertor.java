package convertors;

import java.util.HashMap;
import java.util.Map;

public class AbstractConvertor implements Convertor {
	
	Map<String, BaseSixtyFour> myMap;
	
	AbstractConvertor(){
		BaseSixtyFour zeroMood = new Mood("zero", null, 1);
		BaseSixtyFour AboveMood = new Mood("Above", zeroMood, 2);
		BaseSixtyFour selfControlMood = new Mood("self-control", AboveMood, 3);
		BaseSixtyFour absoluteMood = new Mood("absolute", selfControlMood, 4);
		BaseSixtyFour verticalMood = new Mood("vertical", selfControlMood, 5);
		BaseSixtyFour flawlessMood = new Mood("flawless", selfControlMood, 6);
		BaseSixtyFour seekingMood = new Mood("seeking", selfControlMood, 7);
		BaseSixtyFour inspiredMood = new Mood("inspired", selfControlMood, 8);

		
		myMap = new HashMap<>();
		myMap.put("zero", zeroMood);
		myMap.put("Above", AboveMood);
		myMap.put("self-control", selfControlMood);
		myMap.put("absolute", absoluteMood);
		myMap.put("vertical", verticalMood);
		myMap.put("flawless", flawlessMood);
		myMap.put("seeking", seekingMood);	
		myMap.put("inspired", inspiredMood);
		
	}
	public BaseSixtyFour getUID(String name) {
		
		if(myMap.containsKey(name)){
			return myMap.get(name);
		}
		
		return null;
	}

}
