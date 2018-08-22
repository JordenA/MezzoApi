package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;
import DNA.MoodChunk;

/**
 * 
 * this class is an influencing by reader as defiened in the API of MUSIMAP
 * For more information on this look up musimap.com
 * 
 * @author Tuval
 *
 */
public class InfluencingReader extends AbstractReader {

	String influencingStr = "Array ( [total] => 58 [limit] => 3 [offset] => 0 [results] => Array ( [0] => Array ( [uid] => 4D9B6DA8-751A-6B0E-539C-BD3C216B7B13 [nickname] => Goldrush [realname] => Matt Brooks [gender] => [website] => [date_of_birth] => [place_of_birth] => [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => Spotify [values] => Array ( [0] => 4hvUds7bICxtDRJydorhpg ) ) [1] => Array ( [source] => Qobuz [values] => Array ( [0] => 60908 ) ) [2] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0001514546 [1] => mn0000949579 ) ) [3] => Array ( [source] => Echonest [values] => Array ( [0] => ARKE1NS1187FB3DACA ) ) [4] => Array ( [source] => Discogs [values] => Array ( [0] => 51843 ) ) [5] => Array ( [source] => Deezer [values] => Array ( [0] => 243992 ) ) ) [score] => 100 ) [1] => Array ( [uid] => 9FE89B27-7E84-3396-BCD0-7606BB0C0E8F [nickname] => Sway Clarke II [realname] => [gender] => male [website] => http://www.swayclarke.com/ [date_of_birth] => [place_of_birth] => Toronto [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => iTunes [values] => Array ( [0] => 695625843 [1] => 595993254 ) ) [1] => Array ( [source] => BandPage [values] => Array ( [0] => 228959289711022080 ) ) [2] => Array ( [source] => Wikipedia [values] => Array ( [0] => https://en.wikipedia.org/wiki/Sway_Clarke_II ) ) [3] => Array ( [source] => Echonest [values] => Array ( [0] => ARPARSY1443BB5C340 ) ) [4] => Array ( [source] => Discogs [values] => Array ( [0] => 3543725 ) ) [5] => Array ( [source] => Deezer [values] => Array ( [0] => 5152198 ) ) [6] => Array ( [source] => Qobuz [values] => Array ( [0] => 1317178 [1] => 1475067 ) ) [7] => Array ( [source] => Spotify [values] => Array ( [0] => 1chXzMmrrsZU1vnIMMepTr ) ) [8] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0003174987 ) ) ) [score] => 64.29 ) [2] => Array ( [uid] => FCFA14A4-615B-6567-9956-8BF3071EAF2A [nickname] => Olly Murs [realname] => Oliver Stanley Murs [gender] => male [website] => http://www.ollymurs.com/ [date_of_birth] => 14/05/1984 [place_of_birth] => United Kingdom [date_of_death] => [place_of_death] => [references] => Array ( [0] => Array ( [source] => Wikipedia [values] => Array ( [0] => https://en.wikipedia.org/wiki/Olly_Murs [1] => https://fr.wikipedia.org/wiki/Olly_Murs ) ) [1] => Array ( [source] => Qobuz [values] => Array ( [0] => 2071462 [1] => 409440 [2] => 945441 [3] => 1306530 [4] => 620087 ) ) [2] => Array ( [source] => Last.FM [values] => Array ( [0] => http://www.last.fm/music/Olly+Murs ) ) [3] => Array ( [source] => Twitter [values] => Array ( [0] => ollyofficial ) ) [4] => Array ( [source] => Facebook [values] => Array ( [0] => ollymurs ) ) [5] => Array ( [source] => MusicBrainz [values] => Array ( [0] => 0b108024-ccb5-468f-b2e9-77ed4f5615c6 ) ) [6] => Array ( [source] => iTunes [values] => Array ( [0] => 382815022 ) ) [7] => Array ( [source] => BandPageTour [values] => Array ( [0] => 12334259553701888 ) ) [8] => Array ( [source] => BandPage [values] => Array ( [0] => 12334259553701888 ) ) [9] => Array ( [source] => Spotify [values] => Array ( [0] => 3whuHq0yGx60atvA2RCVRW ) ) [10] => Array ( [source] => AllMusic [values] => Array ( [0] => mn0002517606 ) ) [11] => Array ( [source] => Deezer [values] => Array ( [0] => 399881 ) ) [12] => Array ( [source] => Echonest [values] => Array ( [0] => ARGLFXO12592CDB6B4 ) ) [13] => Array ( [source] => Discogs [values] => Array ( [0] => 1928902 ) ) ) [score] => 64.29 ) ) )\r\n";
	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[3];
		String influencing;
//		if(strToRead.length() < 9) {
//			influencing = this.getGeneric();
//		}else {
//			influencing = strToRead.substring(strToRead.lastIndexOf(" \\\"results\\\": ") + 1);
//		}
		influencing = this.getGeneric();
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
			toReturn[i] = new InfluencingChunk(influencingToAssign, UID, influencingScore);
		}
		
		return toReturn;
	}

	/**
	 * method for debug perpuses
	 * @return
	 */
	private String getGeneric() {
		return "{\"total\":20,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"127C2589-7F94-8C56-EA0A-A24C9F7AACE1\",\"name\":\"Airbag\",\"duration\":288,\"bpm\":172,\"index\":\"01\\/01\",\"year\":\"07\\/1997\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"3OsUjkcv1C1v5udFhgRSFg\"]},{\"source\":\"Deezer\",\"values\":[\"3147289\"]},{\"source\":\"ISRC\",\"values\":[\"GBAYE9701274\"]},{\"source\":\"EAN\",\"values\":[\"0634904078164\"]},{\"source\":\"Qobuz\",\"values\":[\"33978480\"]}],\"score\":100},{\"uid\":\"948B74D0-4BF0-D581-F88E-0AE041CFB39C\",\"name\":\"Cocaine\",\"duration\":170,\"bpm\":104,\"index\":\"01\\/A6\",\"year\":\"03\\/1976\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"6G3NoUqDpqD3Rgfel2pD6s\"]},{\"source\":\"Deezer\",\"values\":[\"1113923\"]},{\"source\":\"Qobuz\",\"values\":[\"625129\"]},{\"source\":\"EAN\",\"values\":[\"0004228100012\"]},{\"source\":\"ISRC\",\"values\":[\"NLF057690004\"]}],\"score\":71.43},{\"uid\":\"BF1C8322-64AF-62FE-E0BC-F4C1D5DE32BD\",\"name\":\"Stray Cat Blues\",\"duration\":278,\"bpm\":101,\"index\":\"01\\/08\",\"year\":\"04\\/1968\",\"best_of_jury\":false,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"5AQY8tgOjZs9zptmJUMDTf\"]},{\"source\":\"MusicBrainz\",\"values\":[\"c5abe2b9-cf5c-4272-bdf2-910da3160c5c\"]},{\"source\":\"Deezer\",\"values\":[\"9956070\"]},{\"source\":\"ISRC\",\"values\":[\"USA176810080\"]},{\"source\":\"EAN\",\"values\":[\"0001877181902\",\"0001877181912\",\"0001877195392\"]},{\"source\":\"Qobuz\",\"values\":[\"20719421\",\"20667408\",\"3377896\"]}],\"score\":71.43},{\"uid\":\"533A4054-8125-5F97-B29E-6F118A79E9C0\",\"name\":\"Electioneering\",\"duration\":231,\"bpm\":162,\"index\":\"01\\/08\",\"year\":\"07\\/1997\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"6PBHfI3G8MlQ8qdItoVoxL\"]},{\"source\":\"Deezer\",\"values\":[\"3147296\"]},{\"source\":\"ISRC\",\"values\":[\"GBAYE9701371\"]},{\"source\":\"EAN\",\"values\":[\"0634904078164\"]},{\"source\":\"Qobuz\",\"values\":[\"33978487\"]}],\"score\":42.86},{\"uid\":\"DFDE187B-F2E4-46A3-D6C6-46C4327C93BF\",\"name\":\"Fitter Happier\",\"duration\":117,\"bpm\":151,\"index\":\"01\\/07\",\"year\":\"07\\/1997\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"53aFGAl0Vebwp2bo8wtdWR\"]},{\"source\":\"Deezer\",\"values\":[\"3147295\"]},{\"source\":\"ISRC\",\"values\":[\"GBAYE9701373\"]},{\"source\":\"EAN\",\"values\":[\"0634904078164\"]},{\"source\":\"Qobuz\",\"values\":[\"33978486\"]}],\"score\":42.86},{\"uid\":\"29A4019F-D225-4411-A8A5-7BB25FD37166\",\"name\":\"No Surprises\",\"duration\":229,\"bpm\":151,\"index\":\"01\\/10\",\"year\":\"07\\/1997\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":true,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"1bSpwPhAxZwlR2enJJsv7U\"]},{\"source\":\"Deezer\",\"values\":[\"3147298\",\"64505043\"]},{\"source\":\"ISRC\",\"values\":[\"GBAYE9700386\"]},{\"source\":\"EAN\",\"values\":[\"0634904078164\"]},{\"source\":\"Qobuz\",\"values\":[\"33978489\"]}],\"score\":42.86},{\"uid\":\"2BDA6C15-0DB9-E5EB-28FB-BE84447F886C\",\"name\":\"Something Happened To Me Yesterday\",\"duration\":295,\"bpm\":141,\"index\":\"01\\/12\",\"year\":\"08\\/1966\",\"best_of_jury\":false,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"0CxcNZFoAULGLih1zDG1o2\",\"0mq6cO9fAL0T2PGolVVV9S\"]},{\"source\":\"Qobuz\",\"values\":[\"3381251\",\"3377972\",\"20800611\",\"20971381\",\"20800598\",\"20971368\"]},{\"source\":\"EAN\",\"values\":[\"0001877195002\",\"0001877194992\",\"0001877181932\",\"0001877181922\",\"0001877181852\",\"0001877181842\"]},{\"source\":\"ISRC\",\"values\":[\"USA176710120\"]},{\"source\":\"Deezer\",\"values\":[\"9938460\"]}],\"score\":42.86},{\"uid\":\"52FA749D-6260-D80D-F19C-52CF996AC957\",\"name\":\"Black Dog\",\"duration\":294,\"bpm\":162,\"index\":\"1\\/1\",\"year\":\"11\\/1971\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":true,\"unrecorded\":false,\"references\":[{\"source\":\"ISRC\",\"values\":[\"USAT21300956\",\"USAT29900608\"]},{\"source\":\"Spotify\",\"values\":[\"3qT4bUD1MaWpGrTwcvguhb\",\"0D58ERdLBDRgT86BPnH8ps\",\"0NSeXLBOh16zjbENkAu0P6\"]},{\"source\":\"Deezer\",\"values\":[\"88003853\"]},{\"source\":\"iHeart Radio\",\"values\":[\"1093831\"]},{\"source\":\"EAN\",\"values\":[\"0603497988235\"]},{\"source\":\"Qobuz\",\"values\":[\"2885305\"]}],\"score\":42.86},{\"uid\":\"48D1E46F-11F6-99AE-96CA-3D1A79B8332A\",\"name\":\"Exit Music (For a Film)\",\"duration\":267,\"bpm\":121,\"index\":\"01\\/04\",\"year\":\"07\\/1997\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":false,\"unrecorded\":false,\"references\":[{\"source\":\"Spotify\",\"values\":[\"4Na0siMtWOW9pJoWJ1Ponv\"]},{\"source\":\"Deezer\",\"values\":[\"3147292\"]},{\"source\":\"ISRC\",\"values\":[\"GBAYE9701372\"]},{\"source\":\"EAN\",\"values\":[\"0634904078164\"]},{\"source\":\"Qobuz\",\"values\":[\"33978483\"]}],\"score\":42.86},{\"uid\":\"614D8AE6-566B-97D7-9687-494E27FB61B8\",\"name\":\"Don\\u0027t Leave Me This Way\",\"duration\":364,\"bpm\":121,\"index\":\"02\\/\",\"year\":\"04\\/1975\",\"best_of_jury\":true,\"live\":false,\"instrumental\":false,\"bonus\":false,\"hidden\":false,\"hit_parade\":true,\"unrecorded\":false,\"references\":[{\"source\":\"Qobuz\",\"values\":[\"13951405\",\"47473\"]},{\"source\":\"EAN\",\"values\":[\"0886444412780\",\"0074643380829\"]},{\"source\":\"ISRC\",\"values\":[\"USLIC0500354\",\"USSM10020630\"]},{\"source\":\"Wikipedia\",\"values\":[\"https:\\/\\/en.wikipedia.org\\/wiki\\/Don%27t_Leave_Me_This_Way\"]}],\"score\":42.86}]}\r\n";
	}
}
