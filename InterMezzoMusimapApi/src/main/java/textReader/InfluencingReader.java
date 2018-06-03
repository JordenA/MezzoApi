package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;
import DNA.MoodChunk;

public class InfluencingReader extends AbstractReader {

	String influencingStr = "Array ( [total] => 58 [limit] => 3 [offset] => 0 [results] => Array ( [0] => Array ( [uid] => 4D9B6DA8-751A-6B0E-539C-BD3C216B7B13 [nickname] => Goldrush [realname] => Matt Brooks [gender] => [website] => [date_of_birth] => [place_of_birth] => [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => Spotify [values] => Array ( [0] => 4hvUds7bICxtDRJydorhpg ) ) [1] => Array ( [source] => Qobuz [values] => Array ( [0] => 60908 ) ) [2] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0001514546 [1] => mn0000949579 ) ) [3] => Array ( [source] => Echonest [values] => Array ( [0] => ARKE1NS1187FB3DACA ) ) [4] => Array ( [source] => Discogs [values] => Array ( [0] => 51843 ) ) [5] => Array ( [source] => Deezer [values] => Array ( [0] => 243992 ) ) ) [score] => 100 ) [1] => Array ( [uid] => 9FE89B27-7E84-3396-BCD0-7606BB0C0E8F [nickname] => Sway Clarke II [realname] => [gender] => male [website] => http://www.swayclarke.com/ [date_of_birth] => [place_of_birth] => Toronto [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => iTunes [values] => Array ( [0] => 695625843 [1] => 595993254 ) ) [1] => Array ( [source] => BandPage [values] => Array ( [0] => 228959289711022080 ) ) [2] => Array ( [source] => Wikipedia [values] => Array ( [0] => https://en.wikipedia.org/wiki/Sway_Clarke_II ) ) [3] => Array ( [source] => Echonest [values] => Array ( [0] => ARPARSY1443BB5C340 ) ) [4] => Array ( [source] => Discogs [values] => Array ( [0] => 3543725 ) ) [5] => Array ( [source] => Deezer [values] => Array ( [0] => 5152198 ) ) [6] => Array ( [source] => Qobuz [values] => Array ( [0] => 1317178 [1] => 1475067 ) ) [7] => Array ( [source] => Spotify [values] => Array ( [0] => 1chXzMmrrsZU1vnIMMepTr ) ) [8] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0003174987 ) ) ) [score] => 64.29 ) [2] => Array ( [uid] => FCFA14A4-615B-6567-9956-8BF3071EAF2A [nickname] => Olly Murs [realname] => Oliver Stanley Murs [gender] => male [website] => http://www.ollymurs.com/ [date_of_birth] => 14/05/1984 [place_of_birth] => United Kingdom [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => Wikipedia [values] => Array ( [0] => https://en.wikipedia.org/wiki/Olly_Murs [1] => https://fr.wikipedia.org/wiki/Olly_Murs ) ) [1] => Array ( [source] => Qobuz [values] => Array ( [0] => 2071462 [1] => 409440 [2] => 945441 [3] => 1306530 [4] => 620087 ) ) [2] => Array ( [source] => Last.FM [values] => Array ( [0] => http://www.last.fm/music/Olly+Murs ) ) [3] => Array ( [source] => Twitter [values] => Array ( [0] => ollyofficial ) ) [4] => Array ( [source] => Facebook [values] => Array ( [0] => ollymurs ) ) [5] => Array ( [source] => MusicBrainz [values] => Array ( [0] => 0b108024-ccb5-468f-b2e9-77ed4f5615c6 ) ) [6] => Array ( [source] => iTunes [values] => Array ( [0] => 382815022 ) ) [7] => Array ( [source] => BandPageTour [values] => Array ( [0] => 12334259553701888 ) ) [8] => Array ( [source] => BandPage [values] => Array ( [0] => 12334259553701888 ) ) [9] => Array ( [source] => Spotify [values] => Array ( [0] => 3whuHq0yGx60atvA2RCVRW ) ) [10] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0002517606 ) ) [11] => Array ( [source] => Deezer [values] => Array ( [0] => 399881 ) ) [12] => Array ( [source] => Echonest [values] => Array ( [0] => ARGLFXO12592CDB6B4 ) ) [13] => Array ( [source] => Discogs [values] => Array ( [0] => 1928902 ) ) ) [score] => 64.29 ) ) )\r\n";
	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[3];
		String influencing;
		influencing = strToRead.substring(strToRead.lastIndexOf(" \\\"results\\\": ") + 1);
		for(int i = 0; i < 3 ; i++) {
			influencing = influencing.substring(influencing.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = influencing.substring(0, influencing.indexOf("\",\""));
			influencing = influencing.substring(influencing.indexOf("\"nickname\":")+ 12);
			//creating new empty mood
			String influencingToAssign = influencing.substring(0, influencing.indexOf("\""));
			//removing the mood we used
			influencing = influencing.substring(influencing.indexOf("\"score\":") + 8);
			String influencingScore = influencing.substring(0, influencing.indexOf("}"));
			System.out.println(influencingToAssign);
			System.out.println(influencingScore);
			toReturn[i] = new InfluencingChunk(influencingToAssign, UID, influencingScore);
		}
		
		return toReturn;
	}

}
