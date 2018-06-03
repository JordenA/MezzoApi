package DNA;

public abstract class AbstractChunk implements Chunk {

	int chunkNumber;
	String name;
	String UID;
	int score;
	
	AbstractChunk(String name,String UID, String score){
		this.name = name;
		this.UID = UID;
		score = score.replace("\"", "");
		Double tempDouble = Double.parseDouble(score.trim());
		this.score = tempDouble.intValue();
	}
	
	AbstractChunk(String name,String UID, int score){
		this.name = name;
		this.UID = UID;
		this.score = score;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;	
	}
	
	@Override
	public String getUID() {
		return UID;
	}
	
	@Override
	public int getChunkNumber() {
		return chunkNumber;
	}
	
	@Override
	public int getScore() {
		return score;
	}

}
