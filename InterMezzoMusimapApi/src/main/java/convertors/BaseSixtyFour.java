package convertors;
import java.util.Base64;

/**
 * This interface is a wrapper for base64 object,
 * we get a string from the API and we use it in the project as an object that has a name and a UID from MUSIMAP API
 * everyUID has a name in MUSIMAP
 * 
 * @author Tuval
 *
 */
public interface BaseSixtyFour {
	
	/**
	 * this method retuns the name of the uid
	 * @return the name of the object
	 */
	public String getName();
	/**
	 * this method returns the uid of the object
	 * @return the uid of the object
	 */
	public Base64 getUID();
	/**
	 * this method sets the name of the object
	 * @param name the name to assign
	 */
	public void setName(String name);
	/**
	 *  this method sets the uid of the object
	 * @param UID the uid to assign
	 */
	public void setUID(Base64 UID);

}
