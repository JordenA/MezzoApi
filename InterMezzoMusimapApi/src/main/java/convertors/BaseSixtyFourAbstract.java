package convertors;

import java.util.Base64;

public class BaseSixtyFourAbstract implements BaseSixtyFour {
	
	String name;
	Base64 UID;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Base64 getUID() {
		return UID;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setUID(Base64 UID) {
		this.UID = UID;

	}

}
