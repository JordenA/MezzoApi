package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;
/**
 * 
 * this class is an key words by reader as defiened in the API of MUSIMAP
 * For more information on this look up musimap.com
 * 
 * @author Tuval
 *
 */
public class KeywordReader extends AbstractReader {

	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[6];
		String helper;

		helper = this.getGeneric();
		for(int i = 0; i < toReturn.length ; i++) {
			helper = helper.substring(helper.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = helper.substring(0, helper.indexOf("\",\""));
			helper = helper.substring(helper.indexOf("name\":\"")+ "name\":\"".length());
			//creating new empty mood
			String keywordName = helper.substring(0, helper.indexOf("\""));
			//removing the mood we used
			helper = helper.substring(helper.indexOf("importance\":") + "importance\":".length());
			String keywordImportance = helper.substring(0, helper.indexOf("}"));
			toReturn[i] = new InfluencingChunk(keywordName, UID, keywordImportance);
		}
		
		return toReturn;
	}
	
	private String getGeneric() {
		return "{\"total\":8298190,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"D2A354DC-5C2F-D560-88FF-D6CAED669C1B\",\"name\":\"337-4 46842 BFG-12\",\"keywords\":[{\"uid\":\"B04CB9DA-3EAD-91D7-0F29-8DF7B867926D\",\"name\":\"spiritual jazz\",\"importance\":38},{\"uid\":\"0D0FA5CC-E4A3-7338-4BCA-EAE1F611351E\",\"name\":\"Horns\\/Brass Section\",\"importance\":38},{\"uid\":\"DFC276BA-E51D-102D-37F1-7419263A11FD\",\"name\":\"Avant-garde\",\"importance\":48},{\"uid\":\"9EF0D710-CADF-E6BE-EC08-7B26D5D75B09\",\"name\":\"Improvisation\",\"importance\":48},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":48},{\"uid\":\"4ACD006F-803F-E829-20C5-77254A35069D\",\"name\":\"Constructivism\",\"importance\":66},{\"uid\":\"31BEE092-AEB5-6682-2B9E-BFF7A400F677\",\"name\":\"Creative Orchestra\",\"importance\":66},{\"uid\":\"8C0F07E5-3C92-7B43-404A-BBED2E1C2952\",\"name\":\" Ritardando\",\"importance\":75},{\"uid\":\"34E66C0C-31F9-C6AD-C2C1-204ECAF9E028\",\"name\":\"Accelerando\",\"importance\":75},{\"uid\":\"FD0BBCFA-D8FD-E074-0E92-49548A8D37A4\",\"name\":\"Instrumental level (no singing voice or explicit words )\",\"importance\":85}],\"score\":100},{\"uid\":\"C9268C80-DF95-ED4A-2C4D-4B71863A71C7\",\"name\":\"Isotope 56Fe\",\"keywords\":[{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":95}],\"score\":88.89},{\"uid\":\"ACCEB12B-DD52-9C4E-83B4-F463DE6BC610\",\"name\":\"MC-6FES\",\"keywords\":[{\"uid\":\"417227BD-D5B7-72E2-A7CA-B9142410ADE7\",\"name\":\"Noise rock\",\"importance\":95},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":75},{\"uid\":\"78A4B67D-7432-B819-9851-D4956747C847\",\"name\":\"Noise (music)\",\"importance\":71},{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48}],\"score\":88.89},{\"uid\":\"53679634-8BF1-1949-1E5C-365E2D04F4B6\",\"name\":\"200BFR.\",\"keywords\":[{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48},{\"uid\":\"D91864DC-1D8A-DFE6-B1C1-5F0F93C5E5D5\",\"name\":\"Detroit Techno\",\"importance\":75}],\"score\":88.89},{\"uid\":\"FF87E68E-62AF-B111-1A9A-D0BD35362515\",\"name\":\"Cut Two: 337-4 46842 BFG-12\",\"keywords\":[{\"uid\":\"B04CB9DA-3EAD-91D7-0F29-8DF7B867926D\",\"name\":\"spiritual jazz\",\"importance\":38},{\"uid\":\"0D0FA5CC-E4A3-7338-4BCA-EAE1F611351E\",\"name\":\"Horns\\/Brass Section\",\"importance\":38},{\"uid\":\"DFC276BA-E51D-102D-37F1-7419263A11FD\",\"name\":\"Avant-garde\",\"importance\":48},{\"uid\":\"9EF0D710-CADF-E6BE-EC08-7B26D5D75B09\",\"name\":\"Improvisation\",\"importance\":48},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":48},{\"uid\":\"4ACD006F-803F-E829-20C5-77254A35069D\",\"name\":\"Constructivism\",\"importance\":66},{\"uid\":\"31BEE092-AEB5-6682-2B9E-BFF7A400F677\",\"name\":\"Creative Orchestra\",\"importance\":66},{\"uid\":\"8C0F07E5-3C92-7B43-404A-BBED2E1C2952\",\"name\":\" Ritardando\",\"importance\":75},{\"uid\":\"34E66C0C-31F9-C6AD-C2C1-204ECAF9E028\",\"name\":\"Accelerando\",\"importance\":75},{\"uid\":\"FD0BBCFA-D8FD-E074-0E92-49548A8D37A4\",\"name\":\"Instrumental level (no singing voice or explicit words )\",\"importance\":85}],\"score\":88.89},{\"uid\":\"C842B75C-0153-A057-084C-847FB0823266\",\"name\":\"\\u0026#32566\\u0026#12467\\u0026#12540\\u0026#12498\\u0026#12540 (Can Coffee)\",\"keywords\":[{\"uid\":\"78A4B67D-7432-B819-9851-D4956747C847\",\"name\":\"Noise (music)\",\"importance\":14},{\"uid\":\"417227BD-D5B7-72E2-A7CA-B9142410ADE7\",\"name\":\"Noise rock\",\"importance\":19},{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48},{\"uid\":\"636E1A80-C98B-11BB-B21F-4FE5C8C6D771\",\"name\":\"Bluesy\",\"importance\":75},{\"uid\":\"E46673FC-5B55-F043-BDD0-AD2AFD698DB2\",\"name\":\"Psychedelic\",\"importance\":84},{\"uid\":\"DFC276BA-E51D-102D-37F1-7419263A11FD\",\"name\":\"Avant-garde\",\"importance\":95},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":95}],\"score\":77.78},{\"uid\":\"B380A915-5193-2B01-C3F7-E6FF48FCB21A\",\"name\":\"426F 574F 5F6F\",\"keywords\":[{\"uid\":\"417227BD-D5B7-72E2-A7CA-B9142410ADE7\",\"name\":\"Noise rock\",\"importance\":95},{\"uid\":\"7A7B2CAB-A673-0185-5952-64983DA3F02B\",\"name\":\"Experimental\",\"importance\":95},{\"uid\":\"222E1051-31C0-9CE3-ED67-9C534CC48584\",\"name\":\"Industrial Dance\",\"importance\":75},{\"uid\":\"E4B0019F-01D3-E4FB-6814-C81CE46860A1\",\"name\":\"Electro-Industrial\",\"importance\":75},{\"uid\":\"F1A2E184-90DB-4B01-1DA7-0B0202C10E40\",\"name\":\"Post-industrial\",\"importance\":75},{\"uid\":\"78A4B67D-7432-B819-9851-D4956747C847\",\"name\":\"Noise (music)\",\"importance\":71},{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48}],\"score\":77.78},{\"uid\":\"AFCDF3B1-D1AA-7032-F509-30EB3323668C\",\"name\":\"\\u003Ca href=\\u0022http:\\/\\/www.discogs.com\\/release\\/2533256\\u0022\\u003E Clarinet Sonatas\\u003C\\/a\\u003E\",\"keywords\":[],\"score\":66.67},{\"uid\":\"FBB0CCE7-2D62-56FE-73AC-6F3BA1B8E24B\",\"name\":\"Basef3\",\"keywords\":[{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48},{\"uid\":\"F0C7C6A3-2209-3FB7-499E-ECB9C6EE9686\",\"name\":\"Non-Music\",\"importance\":76}],\"score\":66.67},{\"uid\":\"8E9D064C-845A-AF4C-4F4B-968209C39AF3\",\"name\":\"Basef3\",\"keywords\":[{\"uid\":\"65763BDA-2AD5-4A55-6EA3-95B7B4358F20\",\"name\":\"Electronic\",\"importance\":48},{\"uid\":\"F0C7C6A3-2209-3FB7-499E-ECB9C6EE9686\",\"name\":\"Non-Music\",\"importance\":76}],\"score\":66.67}]}\r\n";
	}

}
