package view;

public class Song { // when the user listens to a song - build this struct
	String songName;
	String artistName;
	String songUID;
	boolean like; // true - liked, false - dislike
	boolean end=false; //end of Song arr
	
	
	
	public boolean isEnd() {
		return end;
	}
	
	public void setEnd(boolean bool) {
		this.end=bool;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	public void setsongUID(String songUID) {
		this.songUID=songUID;
	}
	public String getsongUID() {
		return songUID;
	}

	
	public Song(String songName, String artistName, String songUID, boolean like, boolean end) {
		//super();
		this.songName = songName;
		this.songUID=songUID;
		this.artistName = artistName;
		this.like = like;
		this.end=end;
		
	}
	
	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	public Song(Song s) {
		this.songName=s.getSongName();
		this.artistName=s.getArtistName();
		this.songUID=s.getsongUID();
		this.like=s.isLike();
		this.end=s.isEnd();
	}
	
	
	

	
	
	
	
	
	

}
