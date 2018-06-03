//package textReader;
//
//import view.Song;
//
//public class songReader {
//
//	
//	public static Song[] getSong(String strToRead) {
//		String str = "{\"total\":11,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"8B2BE602-A55E-19D8-F8DC-74039B34BF39\",\"name\":\"Message To Michael\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"FE65179C-7698-3CB3-9C1C-E1020A1DCD96\",\"name\":\"Let\\u0027s Get High\",\"owners\":[{\"uid\":\"569959D7-7E25-B47B-0FEF-EFF3F1D8DB80\",\"nickname\":\"Lenny Kravitz\"}],\"score\":100},{\"uid\":\"1EC25CEE-48CD-105C-99DA-B5D44A4B02C3\",\"name\":\"Lonely Rainbows\",\"owners\":[{\"uid\":\"B55E75D3-D55D-7033-4227-4924D25E9D44\",\"nickname\":\"Vanessa Paradis\"}],\"score\":100},{\"uid\":\"DA46FB60-74E6-1BF1-3FFB-E45996A9CCDA\",\"name\":\"Mood Indigo\",\"owners\":[{\"uid\":\"E366801D-1E61-1995-3732-F3842217132F\",\"nickname\":\"Louis Armstrong\"}],\"score\":100},{\"uid\":\"4BCCCF6D-126C-F723-9444-058C759BCF36\",\"name\":\"(They Long To Be) Close To You\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"B0DD138B-7B65-86F7-0EA4-BF97E842FFD1\",\"name\":\"J\\u0027t\\u0027emm\\u00e8ne au vent\",\"owners\":[{\"uid\":\"81EB577E-4F36-4610-8B91-B7EB607E59FF\",\"nickname\":\"Louise Attaque\"}],\"score\":100},{\"uid\":\"C09F3D29-980E-B1BA-4B16-3323526ED180\",\"name\":\"The Look Of Love\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"85D4EE26-3815-714B-94AD-08471FFE621E\",\"name\":\"In The Stone\",\"owners\":[{\"uid\":\"B36EC115-6071-6FA7-55BD-797461759250\",\"nickname\":\"Earth, Wind \\u0026 Fire\"}],\"score\":100},{\"uid\":\"EE3ABEE3-6AD4-172B-A535-BF15548E8E58\",\"name\":\"The Windows Of The World\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"C5A560B7-DA61-9A4E-EC28-632A9F3C127B\",\"name\":\"Lisa\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100}]}"; 
//		Song[] toReturn = new Song[10];
//		String helper = str.substring(str.indexOf(",\"results\":[{\"") + ",\"results\":[{\"".length());
//		
//		for (int i=0;i<toReturn.length;i++) {
//		helper = helper.substring(helper.indexOf("uid\":\"")+ "uid\":\"".length());
//		String UID=helper.substring(0,helper.indexOf("\",\""));
//		helper=helper.substring(helper.indexOf("name\":\"")+"name\":\"".length());		
//		String SONG=helper.substring(0,helper.indexOf("\",\""));
//		System.out.println();
//		}
//		
//	
//		return null;
//		
//		
//	}
//	
////	public static void main(String[] args) {
////		getSong(null);
////
////	}
//}
//
//
//
//

package textReader;

import view.Song;

public class SongReader {

	
	
	public static Song[] createSongArr(String strToRead) {
		//String str = "{\"total\":11,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"8B2BE602-A55E-19D8-F8DC-74039B34BF39\",\"name\":\"Message To Michael\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"FE65179C-7698-3CB3-9C1C-E1020A1DCD96\",\"name\":\"Let\\u0027s Get High\",\"owners\":[{\"uid\":\"569959D7-7E25-B47B-0FEF-EFF3F1D8DB80\",\"nickname\":\"Lenny Kravitz\"}],\"score\":100},{\"uid\":\"1EC25CEE-48CD-105C-99DA-B5D44A4B02C3\",\"name\":\"Lonely Rainbows\",\"owners\":[{\"uid\":\"B55E75D3-D55D-7033-4227-4924D25E9D44\",\"nickname\":\"Vanessa Paradis\"}],\"score\":100},{\"uid\":\"DA46FB60-74E6-1BF1-3FFB-E45996A9CCDA\",\"name\":\"Mood Indigo\",\"owners\":[{\"uid\":\"E366801D-1E61-1995-3732-F3842217132F\",\"nickname\":\"Louis Armstrong\"}],\"score\":100},{\"uid\":\"4BCCCF6D-126C-F723-9444-058C759BCF36\",\"name\":\"(They Long To Be) Close To You\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"B0DD138B-7B65-86F7-0EA4-BF97E842FFD1\",\"name\":\"J\\u0027t\\u0027emm\\u00e8ne au vent\",\"owners\":[{\"uid\":\"81EB577E-4F36-4610-8B91-B7EB607E59FF\",\"nickname\":\"Louise Attaque\"}],\"score\":100},{\"uid\":\"C09F3D29-980E-B1BA-4B16-3323526ED180\",\"name\":\"The Look Of Love\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"85D4EE26-3815-714B-94AD-08471FFE621E\",\"name\":\"In The Stone\",\"owners\":[{\"uid\":\"B36EC115-6071-6FA7-55BD-797461759250\",\"nickname\":\"Earth, Wind \\u0026 Fire\"}],\"score\":100},{\"uid\":\"EE3ABEE3-6AD4-172B-A535-BF15548E8E58\",\"name\":\"The Windows Of The World\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100},{\"uid\":\"C5A560B7-DA61-9A4E-EC28-632A9F3C127B\",\"name\":\"Lisa\",\"owners\":[{\"uid\":\"51842AC4-1704-B6A8-3889-58C8067D1EE7\",\"nickname\":\"Burt Bacharach\"}],\"score\":100}]}"; 

		Song[] toReturn = new Song[10];
		String helper = strToRead.substring(strToRead.indexOf(",\"results\":[{\"") + ",\"results\":[{\"".length());
		
		for (int i=0;i<toReturn.length;i++) {
			
		helper = helper.substring(helper.indexOf("uid\":\"")+ "uid\":\"".length());
		String UID=helper.substring(0,helper.indexOf("\",\""));
		helper=helper.substring(helper.indexOf("name\":\"")+"name\":\"".length());		
		String SONG=helper.substring(0,helper.indexOf("\",\""));
		helper=helper.substring(helper.indexOf(",\"nickname\":\"")+",\"nickname\":\"".length());		
		String owner=helper.substring(0,helper.indexOf("\""));
//		System.out.println(UID);
//		System.out.println(SONG);
//		System.out.println(owner);

		toReturn[i]=new Song(SONG,owner,UID,true,false); // set IsLiked to be TRUE as deafult		
		
		}		
		toReturn[9].setEnd(true); //mark last song as the end of list
		return toReturn;
}
}