package musicData;

/**
 * This class is a representation of a song, it has the charistristics of a song
 * It is used to show the song to the user 
 * 
 * @author Itamar
 *
 */
public class Song { // when the user listens to a song - build this struct
	
	String songName;
	String artistName;
	String songUID;
	boolean like; // true - liked, false - dislike
	boolean end=false; //end of Song arr
	
	/**
	 *  A constractor for a song that is built from the parametrs of the song
	 * @param songName The name of the song
	 * @param artistName the name oif the artist of the song
	 * @param songUID the UID of the song as defiened in the MUSIMAP API
	 * @param like is the song liked or not
	 * @param end is the song in the end of the array
	 */
	public Song(String songName, String artistName, String songUID, boolean like, boolean end) {
		//super();
		this.songName = songName;
		this.songUID=songUID;
		this.artistName = artistName;
		this.like = like;
		this.end=end;
		
	}
	/**
	 *  A constractor for a song that is built from the parametrs of the song - as a copy constarctor
	 * @param s a song to copy
	 */
	public Song(Song s) {
		this.songName=s.getSongName();
		this.artistName=s.getArtistName();
		this.songUID=s.getsongUID();
		this.like=s.isLike();
		this.end=s.isEnd();
	}
	
	/**
	 * this method tells if the song is the last song of the array
	 * @return boolean statement for the question
	 */
	public boolean isEnd() {
		return end;
	}
	
	/**
	 * this method sets the song to be at the end of an array as a oarameter in its charisteristics
	 * @param bool if it is or not
	 */
	public void setEnd(boolean bool) {
		this.end=bool;
	}
	/**
	 * retuirns the name of the song
	 * @return The name of the song
	 */
	public String getSongName() {
		return songName;
	}
	/**
	 *  This method sets the song name
	 * @param songName the name of the song to assign
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}
	/**
	 * this method returns the artist name
	 * @return the name of the artist of the song
	 */
	public String getArtistName() {
		return artistName;
	}
	/**
	 * this method sets the artist name
	 * @param artistName the name of the artist to assign
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	/**
	 * this method tell if the user like the song or not
	 * @return the answer about liking or not for this song
	 */
	public boolean isLike() {
		return like;
	}
	/**
	 * this method sets the like parameter for the song, if user likes it or not
	 * @param like true if user liked it else false
	 */
	public void setLike(boolean like) {
		this.like = like;
	}
	/**
	 * this method sets the user UID acording to UID in MUSIMAP API
	 * @param songUID the UID of the song from the API
	 */
	public void setsongUID(String songUID) {
		this.songUID=songUID;
	}
	/**
	 * this method returns the user UID acording to UID in MUSIMAP API
	 * @return the UID of the song from the API
	 */
	public String getsongUID() {
		return songUID;
	}





}
