package convertors;

public interface Convertor {
	
	/**
	 * This method converts from aname to the UID of the object
	 * @param name The name of the object
	 * @return the object value in UID
	 */
	public BaseSixtyFour getUID(String name);
}
