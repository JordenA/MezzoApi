package textReader;

import DNA.Chunk;
import DNA.InfluencingChunk;
import DNA.PropertiesChunk;

public class PropertiesReader extends AbstractReader {
	
	@Override
	public synchronized  Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[3];
		String results;

		results = strToRead;
		//results  = this.getGenericProperties(); 
		for(int i = 0; i < toReturn.length ; i++) {
			results = results.substring(results.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = results.substring(0, results.indexOf("\",\""));
			results = results.substring(results.indexOf("\"name\":\"")+ "\"name\":\"".length());
			//creating new empty mood
			String propertyName = results.substring(0, results.indexOf("\""));
			//removing the mood we used
			results = results.substring(results.indexOf("\"category\":\"") + "\"category\":\"".length());
			String propertyCategory = results.substring(0, results.indexOf("\""));
			//getting importance
			results = results.substring(results.indexOf("\"importance\":") + "\"importance\":".length());
			String propertyScore = results.substring(0, results.indexOf("}"));
			toReturn[i] = new PropertiesChunk(propertyName, propertyCategory, UID, propertyScore);
			System.out.println(propertyName);
			System.out.println(UID);
			System.out.println(propertyScore);
			System.out.println(propertyCategory);
		}
		
		return toReturn;
	}
	
	@Override
	public Chunk[] readChunk() {
		return this.readChunk(this.getGenericProperties());
	}
	
	/**
	 * a helper method for debug
	 * @return striung example to use
	 */
	private String getGenericProperties() {
		return "{\"total\":8298190,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"D2A354DC-5C2F-D560-88FF-D6CAED669C1B\",\"name\":\"337-4 46842 BFG-12\",\"properties\":[{\"uid\":\"4E057AD2-4436-94E2-4902-38E9782FC83F\",\"name\":\"Classical Crossover\",\"category\":\"Substyle\",\"importance\":38},{\"uid\":\"61050BBC-862D-546D-2550-225DBB86C249\",\"name\":\"CLASSICAL\",\"category\":\"Substyle\",\"importance\":43},{\"uid\":\"BFBF26FD-35FF-23E0-BAC6-98A73ED11CEE\",\"name\":\"Sax Master\",\"category\":\"InstrumentFamily\",\"importance\":65},{\"uid\":\"EB95124A-5EF0-F660-FE91-56DCB798F58F\",\"name\":\"Band Leader\",\"category\":\"Instrument\",\"importance\":66},{\"uid\":\"F67284C7-89D5-B446-138C-80E7FBF1355A\",\"name\":\"Sax alto jazz master\",\"category\":\"InstrumentFamily\",\"importance\":75},{\"uid\":\"51A26A14-74FB-BCFC-FE5C-661A43A9377C\",\"name\":\"Saxophone\",\"category\":\"Instrument\",\"importance\":85},{\"uid\":\"E59EF111-838A-661A-6552-D5F498DF13CF\",\"name\":\"JAZZ\",\"category\":\"Substyle\",\"importance\":95},{\"uid\":\"C9E490BF-CBAE-875E-0C24-8941F536D9F5\",\"name\":\"Afro-american\",\"category\":\"EthnosGroup\",\"importance\":100}],\"score\":100},{\"uid\":\"C9268C80-DF95-ED4A-2C4D-4B71863A71C7\",\"name\":\"Isotope 56Fe\",\"properties\":[{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":48},{\"uid\":\"39A3EF53-07D7-B274-471B-57FD23478F06\",\"name\":\"Stillness\",\"category\":\"RhythmicMood\",\"importance\":126}],\"score\":88.89},{\"uid\":\"ACCEB12B-DD52-9C4E-83B4-F463DE6BC610\",\"name\":\"MC-6FES\",\"properties\":[{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":48},{\"uid\":\"97F752F5-6161-5D51-B2E0-044399925FF6\",\"name\":\"Noise\",\"category\":\"Instrument\",\"importance\":48}],\"score\":88.89},{\"uid\":\"53679634-8BF1-1949-1E5C-365E2D04F4B6\",\"name\":\"200BFR.\",\"properties\":[{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":95}],\"score\":88.89},{\"uid\":\"FF87E68E-62AF-B111-1A9A-D0BD35362515\",\"name\":\"Cut Two: 337-4 46842 BFG-12\",\"properties\":[{\"uid\":\"4E057AD2-4436-94E2-4902-38E9782FC83F\",\"name\":\"Classical Crossover\",\"category\":\"Substyle\",\"importance\":38},{\"uid\":\"61050BBC-862D-546D-2550-225DBB86C249\",\"name\":\"CLASSICAL\",\"category\":\"Substyle\",\"importance\":43},{\"uid\":\"BFBF26FD-35FF-23E0-BAC6-98A73ED11CEE\",\"name\":\"Sax Master\",\"category\":\"InstrumentFamily\",\"importance\":65},{\"uid\":\"EB95124A-5EF0-F660-FE91-56DCB798F58F\",\"name\":\"Band Leader\",\"category\":\"Instrument\",\"importance\":66},{\"uid\":\"F67284C7-89D5-B446-138C-80E7FBF1355A\",\"name\":\"Sax alto jazz master\",\"category\":\"InstrumentFamily\",\"importance\":75},{\"uid\":\"51A26A14-74FB-BCFC-FE5C-661A43A9377C\",\"name\":\"Saxophone\",\"category\":\"Instrument\",\"importance\":85},{\"uid\":\"E59EF111-838A-661A-6552-D5F498DF13CF\",\"name\":\"JAZZ\",\"category\":\"Substyle\",\"importance\":95},{\"uid\":\"C9E490BF-CBAE-875E-0C24-8941F536D9F5\",\"name\":\"Afro-american\",\"category\":\"EthnosGroup\",\"importance\":100}],\"score\":88.89},{\"uid\":\"C842B75C-0153-A057-084C-847FB0823266\",\"name\":\"\\u0026#32566\\u0026#12467\\u0026#12540\\u0026#12498\\u0026#12540 (Can Coffee)\",\"properties\":[{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":48}],\"score\":77.78},{\"uid\":\"B380A915-5193-2B01-C3F7-E6FF48FCB21A\",\"name\":\"426F 574F 5F6F\",\"properties\":[{\"uid\":\"97F752F5-6161-5D51-B2E0-044399925FF6\",\"name\":\"Noise\",\"category\":\"Instrument\",\"importance\":48},{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":48}],\"score\":77.78},{\"uid\":\"AFCDF3B1-D1AA-7032-F509-30EB3323668C\",\"name\":\"\\u003Ca href=\\u0022http:\\/\\/www.discogs.com\\/release\\/2533256\\u0022\\u003E Clarinet Sonatas\\u003C\\/a\\u003E\",\"properties\":[],\"score\":66.67},{\"uid\":\"FBB0CCE7-2D62-56FE-73AC-6F3BA1B8E24B\",\"name\":\"Basef3\",\"properties\":[{\"uid\":\"88395F9D-E37E-3410-8064-71999F762EAD\",\"name\":\"Effects\",\"category\":\"Instrument\",\"importance\":48},{\"uid\":\"7F0D99A3-4620-98F9-7205-C2B38C3FC5C4\",\"name\":\"Acid techno\",\"category\":\"Substyle\",\"importance\":48},{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":95}],\"score\":66.67},{\"uid\":\"8E9D064C-845A-AF4C-4F4B-968209C39AF3\",\"name\":\"Basef3\",\"properties\":[{\"uid\":\"88395F9D-E37E-3410-8064-71999F762EAD\",\"name\":\"Effects\",\"category\":\"Instrument\",\"importance\":48},{\"uid\":\"7F0D99A3-4620-98F9-7205-C2B38C3FC5C4\",\"name\":\"Acid techno\",\"category\":\"Substyle\",\"importance\":48},{\"uid\":\"11DE0129-EB7F-4EC4-E2EA-81B39A4AAE9E\",\"name\":\"ELECTRO\",\"category\":\"Substyle\",\"importance\":95}],\"score\":66.67}]}";
	}

}
