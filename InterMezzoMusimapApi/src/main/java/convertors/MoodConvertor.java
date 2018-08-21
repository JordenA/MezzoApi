package convertors;
import java.util.Base64;

/**
 * This class 
 * @author Tuval
 *
 */
public class MoodConvertor extends AbstractConvertor {

	public Base64 getBase64(String name) {
		BaseSixtyFour toReturn = super.getUID(name);
		if(toReturn != null) {
			return toReturn.getUID();
		}
		
		return null;
	}
}
