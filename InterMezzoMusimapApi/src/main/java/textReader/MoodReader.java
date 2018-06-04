package textReader;

import java.util.HashMap;
import java.util.Map;

import DNA.Chunk;
import DNA.MoodChunk;

public class MoodReader extends AbstractReader {

	
	@Override
	public Chunk[] readChunk(String strToRead) {
		Chunk[] toReturn = new Chunk[30];
		String mood;
//		if(strToRead.length() < 9) {
//			mood = this.getGenericMood();
//		}else {
//			mood = strToRead.substring(strToRead.indexOf("\"moods\":") + "\"moods\":".length());
//		}
		mood = this.getGenericMood();
		for(int i = 0; i < 30 ; i++) {
			if(mood.length() < 9) {
				break;
			}
			mood = mood.substring(mood.indexOf("\"uid\":\"")+ "\"uid\":\"".length());
			//removing everything from what we want to assign
			String UID = mood.substring(0, mood.indexOf("\",\""));
			mood = mood.substring(mood.indexOf("\"name\":\"")+ "\"name\":\"".length());
			//creating new empty mood
			String moodToAssign = mood.substring(0, mood.indexOf("\""));
			//removing the mood we used
			mood = mood.substring(mood.indexOf("\"importance\":") + "\"importance\":".length());
			
			String moodImportance = mood.substring(0, mood.indexOf("}"));
			//System.out.println(moodToAssign);
			//System.out.println(UID);
			//System.out.println(moodImportance);
			
			toReturn[i] = new MoodChunk(moodToAssign,UID,  moodImportance);
		}
		// TODO Auto-generated method stub
		return toReturn;
	}
	
	private String getGenericMood() {
		return "{\"total\":8298190,\"limit\":10,\"offset\":0,\"results\":[{\"uid\":\"D2A354DC-5C2F-D560-88FF-D6CAED669C1B\",\"name\":\"337-4 46842 BFG-12\",\"moods\":[{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":23},{\"uid\":\"59B0964A-D326-E5B8-22FE-659B160B8EFF\",\"name\":\"In\\/within (Water)\",\"importance\":37},{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":13},{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":24},{\"uid\":\"404BFE84-FF2E-528E-FA9A-47DE57E17BAC\",\"name\":\"On (Ground)\",\"importance\":50},{\"uid\":\"8E4F875D-7087-64ED-DECA-5295038D9A12\",\"name\":\"Above (Fire)\",\"importance\":33},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":35},{\"uid\":\"38161F57-8D19-7675-03A6-51505BC8261A\",\"name\":\"self control\",\"importance\":47},{\"uid\":\"6D5AE713-FA4A-2067-6CC8-B296D29EF57B\",\"name\":\"sensibility\",\"importance\":18},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":28},{\"uid\":\"6755A82E-689A-E825-EE02-5551736CDB4D\",\"name\":\"love\",\"importance\":34},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":19},{\"uid\":\"AEC666EF-1869-A54E-18F0-A8F87FB1FEC8\",\"name\":\"intellect\",\"importance\":54},{\"uid\":\"2294612B-1233-4F34-B5B6-BDCEA772B1CC\",\"name\":\"roots\",\"importance\":27},{\"uid\":\"C63CE1D1-6178-7984-8629-6C70B180270A\",\"name\":\"temperament\",\"importance\":28},{\"uid\":\"9FFC5764-3EE0-1C96-A840-4EE4FD0F974F\",\"name\":\"playfulness\",\"importance\":65},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":13},{\"uid\":\"F05F72AD-E056-CEA2-3BD2-E109EFA0C02B\",\"name\":\"happiness\",\"importance\":10},{\"uid\":\"CE8CFA4A-2FD0-6408-7497-C141256C7489\",\"name\":\"warrior\",\"importance\":51},{\"uid\":\"8A74B98A-887C-A9BC-ECDF-A495765820BE\",\"name\":\"imagination\",\"importance\":31},{\"uid\":\"596EC170-93CD-EBA6-8ACC-A3B51ABB3F18\",\"name\":\"intellectual\",\"importance\":43},{\"uid\":\"458E616F-1B47-310F-755B-CA07EA19E8B6\",\"name\":\"proud\",\"importance\":43},{\"uid\":\"3A9A56D6-5138-0E95-3B40-4C1C795D1680\",\"name\":\"happy\",\"importance\":43},{\"uid\":\"13F575EB-9BD7-BC37-61A8-4E80DED7F1AD\",\"name\":\"warm-hearted\",\"importance\":43},{\"uid\":\"79859BD2-3DCC-3F81-2048-0F0897C04104\",\"name\":\"experimental\",\"importance\":48},{\"uid\":\"6EA33110-3D34-D405-417A-C16AC9A7CE69\",\"name\":\"hesitant\",\"importance\":65},{\"uid\":\"6224027F-950C-0C12-BD5B-8541C8F2FDB1\",\"name\":\"introvert\",\"importance\":67},{\"uid\":\"06CB5405-5031-9D8B-B099-9B6966AFDB6A\",\"name\":\"cerebral\",\"importance\":67},{\"uid\":\"FB7512D3-477D-362B-CAA6-66F5278E40FD\",\"name\":\"conquering\",\"importance\":75},{\"uid\":\"B4C4223B-69C9-6556-BDD5-3EDBF6041C38\",\"name\":\"challenging\",\"importance\":75},{\"uid\":\"A424620A-6B62-5AE4-7201-AECD3BDD9BBB\",\"name\":\"odd\",\"importance\":75},{\"uid\":\"8CE7BC69-1374-D131-3284-B50986ED8462\",\"name\":\"seeking\",\"importance\":75},{\"uid\":\"8A6740FA-59F2-5D2C-F5E6-C3FCE7ECA68F\",\"name\":\"vigorous\",\"importance\":75},{\"uid\":\"6933A010-6D30-A84F-BD02-0B5F385C2B26\",\"name\":\"ambitious\",\"importance\":75},{\"uid\":\"6338D4BD-8531-AEF0-50D7-B7CF0286C845\",\"name\":\"evolving\",\"importance\":75},{\"uid\":\"5BC6DCE0-5979-2889-25B7-52C05CE2D721\",\"name\":\"emotional\",\"importance\":75},{\"uid\":\"57EDB459-31A5-727C-3702-369473AB1521\",\"name\":\"inspired\",\"importance\":75},{\"uid\":\"55BEDE8D-6CC4-0C4A-F362-15A8560151C8\",\"name\":\"organic\",\"importance\":75},{\"uid\":\"C86494B7-B7E3-1492-419C-9A761C3F03C8\",\"name\":\"serious\",\"importance\":76},{\"uid\":\"F56B6D0A-C6D6-50A1-4150-389E59F67972\",\"name\":\"changing\",\"importance\":81},{\"uid\":\"859A9B2A-B8C8-82AC-05DD-1A6FDB881295\",\"name\":\"technical\",\"importance\":81},{\"uid\":\"6F1D3063-E8E1-C3FF-48C4-FD8C81913DCA\",\"name\":\"complex\",\"importance\":95},{\"uid\":\"7488B6B9-5EB0-09B7-02C4-21FBC68090FB\",\"name\":\"sophisticated\",\"importance\":95},{\"uid\":\"C9A7795C-6088-AD6D-EF05-050B5CE013E3\",\"name\":\"duelling\",\"importance\":95},{\"uid\":\"04EAD4A4-2A90-BC36-579D-408F47E4F0AC\",\"name\":\"bright\",\"importance\":85},{\"uid\":\"0F009D11-53FD-52C7-FCF3-B12A853DA171\",\"name\":\"determined\",\"importance\":85},{\"uid\":\"1239178A-A38F-AD13-0A21-689206A78F1E\",\"name\":\"provocative\",\"importance\":85},{\"uid\":\"30DF5DDC-46B1-3BD8-0D2D-DC0CC813624B\",\"name\":\"fragile\",\"importance\":85},{\"uid\":\"446DDB2A-513B-0BDB-B2FD-6F25C401428A\",\"name\":\"thoughtful\",\"importance\":85},{\"uid\":\"88E4D296-5FD6-4A9E-C4E4-5E1DD302CB8B\",\"name\":\"intense\",\"importance\":85},{\"uid\":\"B38CF6B8-2C47-96B1-E568-7A7CA3C88A6F\",\"name\":\"cathartic\",\"importance\":85},{\"uid\":\"BBBEB03B-DE97-EC0E-D6EC-94EF10DED278\",\"name\":\"inhibited\",\"importance\":85},{\"uid\":\"E0546129-DB97-6517-05E7-63C9720E2AE5\",\"name\":\"vulnerable\",\"importance\":85},{\"uid\":\"F7948819-E666-5D98-EB31-AACB6ABEEA9D\",\"name\":\"isolated\",\"importance\":85},{\"uid\":\"2A6B8129-F257-FE95-A0CA-9D4F3097E708\",\"name\":\"performing\",\"importance\":81}],\"score\":100},{\"uid\":\"C9268C80-DF95-ED4A-2C4D-4B71863A71C7\",\"name\":\"Isotope 56Fe\",\"moods\":[],\"score\":88.89},{\"uid\":\"ACCEB12B-DD52-9C4E-83B4-F463DE6BC610\",\"name\":\"MC-6FES\",\"moods\":[{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":18},{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":34},{\"uid\":\"404BFE84-FF2E-528E-FA9A-47DE57E17BAC\",\"name\":\"On (Ground)\",\"importance\":24},{\"uid\":\"59B0964A-D326-E5B8-22FE-659B160B8EFF\",\"name\":\"In\\/within (Water)\",\"importance\":32},{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":17},{\"uid\":\"8E4F875D-7087-64ED-DECA-5295038D9A12\",\"name\":\"Above (Fire)\",\"importance\":20},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":28},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":20},{\"uid\":\"9FFC5764-3EE0-1C96-A840-4EE4FD0F974F\",\"name\":\"playfulness\",\"importance\":42},{\"uid\":\"9B58478C-75C0-502B-A8D1-02EB242E8E38\",\"name\":\"extroversion\",\"importance\":18},{\"uid\":\"38161F57-8D19-7675-03A6-51505BC8261A\",\"name\":\"self control\",\"importance\":34},{\"uid\":\"C63CE1D1-6178-7984-8629-6C70B180270A\",\"name\":\"temperament\",\"importance\":14},{\"uid\":\"AEC666EF-1869-A54E-18F0-A8F87FB1FEC8\",\"name\":\"intellect\",\"importance\":55},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":38},{\"uid\":\"C56B7569-62B0-9BDA-A116-40DC13465D16\",\"name\":\"coldness\",\"importance\":44},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":11},{\"uid\":\"06CB5405-5031-9D8B-B099-9B6966AFDB6A\",\"name\":\"cerebral\",\"importance\":75},{\"uid\":\"308A7A63-573F-3643-1B65-596B18F8A1B9\",\"name\":\"self-destructive\",\"importance\":75},{\"uid\":\"4456A94C-9709-0939-C5F5-1575F60C4CF8\",\"name\":\"crushed\",\"importance\":75},{\"uid\":\"596EC170-93CD-EBA6-8ACC-A3B51ABB3F18\",\"name\":\"intellectual\",\"importance\":75},{\"uid\":\"63093204-017F-A80B-359E-9B5CC8908878\",\"name\":\"analytical\",\"importance\":75},{\"uid\":\"6933A010-6D30-A84F-BD02-0B5F385C2B26\",\"name\":\"ambitious\",\"importance\":75},{\"uid\":\"79859BD2-3DCC-3F81-2048-0F0897C04104\",\"name\":\"experimental\",\"importance\":75},{\"uid\":\"8CE7BC69-1374-D131-3284-B50986ED8462\",\"name\":\"seeking\",\"importance\":75},{\"uid\":\"BD7BA5CE-1C02-ABE0-F767-58EA2B13E98B\",\"name\":\"difficult\",\"importance\":75},{\"uid\":\"CB33F8DA-CE51-5869-89B0-80FD78F3176B\",\"name\":\"exploratory\",\"importance\":75},{\"uid\":\"E062FF9A-D4EB-AE9D-FDB5-C6B5E562FA36\",\"name\":\"incisive\",\"importance\":75},{\"uid\":\"EBD9117A-0D69-66FF-EADB-FDDDE57F158D\",\"name\":\"sharp\",\"importance\":75},{\"uid\":\"F7948819-E666-5D98-EB31-AACB6ABEEA9D\",\"name\":\"isolated\",\"importance\":75},{\"uid\":\"2E135095-8C4D-34C5-4344-FD60E20718C6\",\"name\":\"cynical\",\"importance\":74},{\"uid\":\"9F23A24B-47A8-0A5D-6F30-EA5A613F0650\",\"name\":\"off-putting\",\"importance\":74},{\"uid\":\"2A6B8129-F257-FE95-A0CA-9D4F3097E708\",\"name\":\"performing\",\"importance\":68},{\"uid\":\"2AD989FA-7E04-54B0-5ED8-924EE47604C0\",\"name\":\"energetic\",\"importance\":66},{\"uid\":\"5E579C46-BD0F-D09B-1B52-498CAE52A095\",\"name\":\"bravado\",\"importance\":66},{\"uid\":\"A58FF1BE-221B-FB43-B65F-F952EE168128\",\"name\":\"intricate\",\"importance\":66},{\"uid\":\"F56B6D0A-C6D6-50A1-4150-389E59F67972\",\"name\":\"changing\",\"importance\":66},{\"uid\":\"1239178A-A38F-AD13-0A21-689206A78F1E\",\"name\":\"provocative\",\"importance\":58},{\"uid\":\"40B9437C-5F2F-7FF2-C23D-2D70A9EDEBA3\",\"name\":\"lazy\",\"importance\":58},{\"uid\":\"B7004C0A-AB8F-E12B-F1F5-1A8B65867C55\",\"name\":\"rude\",\"importance\":58},{\"uid\":\"C8CE51CC-9806-10C7-C5DB-5F14EA3D69A1\",\"name\":\"biting\",\"importance\":58},{\"uid\":\"9B574DAE-6872-1F28-48B3-2C4FDC33AEA7\",\"name\":\"metallic\",\"importance\":52},{\"uid\":\"4EC1DBCB-A22D-D414-9B2B-7F7279BA0470\",\"name\":\"paranoid\",\"importance\":50},{\"uid\":\"6224027F-950C-0C12-BD5B-8541C8F2FDB1\",\"name\":\"introvert\",\"importance\":50},{\"uid\":\"E23CDC4A-1991-F807-027E-2EFCAF617B94\",\"name\":\"nasty\",\"importance\":50},{\"uid\":\"679B00B2-1FE1-44AF-50B9-10C8961F3048\",\"name\":\"virile\",\"importance\":45},{\"uid\":\"859A9B2A-B8C8-82AC-05DD-1A6FDB881295\",\"name\":\"technical\",\"importance\":41},{\"uid\":\"B38CF6B8-2C47-96B1-E568-7A7CA3C88A6F\",\"name\":\"cathartic\",\"importance\":41},{\"uid\":\"EBD72BDD-08AC-1AF2-B72F-DA30FF41730F\",\"name\":\"melodramatic\",\"importance\":41},{\"uid\":\"7D4A6714-A918-43F7-D1F5-96A1963DFC00\",\"name\":\"in your face\",\"importance\":38},{\"uid\":\"F14B73B9-C320-B6E1-0911-CC6D7837D8F5\",\"name\":\"loud\",\"importance\":38},{\"uid\":\"FDB39FC5-786B-412D-9C0E-0BA799B375A4\",\"name\":\"unconventional\",\"importance\":38}],\"score\":88.89},{\"uid\":\"53679634-8BF1-1949-1E5C-365E2D04F4B6\",\"name\":\"200BFR.\",\"moods\":[{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":16},{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":18},{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":22},{\"uid\":\"59B0964A-D326-E5B8-22FE-659B160B8EFF\",\"name\":\"In\\/within (Water)\",\"importance\":16},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":24},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":32},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":23},{\"uid\":\"1BEECA8A-0184-F79B-6924-5188DAF241BD\",\"name\":\"nourishment\",\"importance\":27},{\"uid\":\"C56B7569-62B0-9BDA-A116-40DC13465D16\",\"name\":\"coldness\",\"importance\":15},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":16},{\"uid\":\"9B58478C-75C0-502B-A8D1-02EB242E8E38\",\"name\":\"extroversion\",\"importance\":25},{\"uid\":\"C2FAA0CF-DC3C-2F74-2EA4-C87A4317E7E1\",\"name\":\"clinical\",\"importance\":38},{\"uid\":\"BAFE4EDF-9FDD-0362-66B3-9AA6C6632BBB\",\"name\":\"sanitized\",\"importance\":38},{\"uid\":\"D96D8067-DADB-A63B-172F-1F055493EC24\",\"name\":\"hedonist\",\"importance\":75},{\"uid\":\"D70B66E1-B04C-EBA9-578C-0C1B986CC26F\",\"name\":\"rhythmic\",\"importance\":75},{\"uid\":\"C5131D74-04FA-F960-16D8-49570FB115E5\",\"name\":\"impulsive\",\"importance\":75},{\"uid\":\"C482D5A7-ED0E-D1BA-34C4-A52B20798975\",\"name\":\"romping\",\"importance\":75},{\"uid\":\"B38CF6B8-2C47-96B1-E568-7A7CA3C88A6F\",\"name\":\"cathartic\",\"importance\":75},{\"uid\":\"AEEC9A7C-02BD-46AB-ABF5-91817B003BB6\",\"name\":\"precise\",\"importance\":75},{\"uid\":\"72B27930-5336-000C-470B-59A6786F254D\",\"name\":\"ample\",\"importance\":75},{\"uid\":\"68F64A5D-CC1E-8E08-7A53-ADEFCBF94626\",\"name\":\"methodical\",\"importance\":75},{\"uid\":\"49336459-DB72-CBF7-ED17-AE9CBFADC7E4\",\"name\":\"tough\",\"importance\":75},{\"uid\":\"083AE5B4-A1B7-CF1F-4701-F4F2C2CFF60B\",\"name\":\"hypnotic\",\"importance\":75}],\"score\":88.89},{\"uid\":\"FF87E68E-62AF-B111-1A9A-D0BD35362515\",\"name\":\"Cut Two: 337-4 46842 BFG-12\",\"moods\":[{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":13},{\"uid\":\"8E4F875D-7087-64ED-DECA-5295038D9A12\",\"name\":\"Above (Fire)\",\"importance\":33},{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":24},{\"uid\":\"404BFE84-FF2E-528E-FA9A-47DE57E17BAC\",\"name\":\"On (Ground)\",\"importance\":50},{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":23},{\"uid\":\"59B0964A-D326-E5B8-22FE-659B160B8EFF\",\"name\":\"In\\/within (Water)\",\"importance\":37},{\"uid\":\"8A74B98A-887C-A9BC-ECDF-A495765820BE\",\"name\":\"imagination\",\"importance\":31},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":28},{\"uid\":\"AEC666EF-1869-A54E-18F0-A8F87FB1FEC8\",\"name\":\"intellect\",\"importance\":54},{\"uid\":\"CE8CFA4A-2FD0-6408-7497-C141256C7489\",\"name\":\"warrior\",\"importance\":51},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":19},{\"uid\":\"38161F57-8D19-7675-03A6-51505BC8261A\",\"name\":\"self control\",\"importance\":47},{\"uid\":\"6D5AE713-FA4A-2067-6CC8-B296D29EF57B\",\"name\":\"sensibility\",\"importance\":18},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":13},{\"uid\":\"2294612B-1233-4F34-B5B6-BDCEA772B1CC\",\"name\":\"roots\",\"importance\":27},{\"uid\":\"F05F72AD-E056-CEA2-3BD2-E109EFA0C02B\",\"name\":\"happiness\",\"importance\":10},{\"uid\":\"6755A82E-689A-E825-EE02-5551736CDB4D\",\"name\":\"love\",\"importance\":34},{\"uid\":\"C63CE1D1-6178-7984-8629-6C70B180270A\",\"name\":\"temperament\",\"importance\":28},{\"uid\":\"9FFC5764-3EE0-1C96-A840-4EE4FD0F974F\",\"name\":\"playfulness\",\"importance\":65},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":35},{\"uid\":\"596EC170-93CD-EBA6-8ACC-A3B51ABB3F18\",\"name\":\"intellectual\",\"importance\":43},{\"uid\":\"458E616F-1B47-310F-755B-CA07EA19E8B6\",\"name\":\"proud\",\"importance\":43},{\"uid\":\"3A9A56D6-5138-0E95-3B40-4C1C795D1680\",\"name\":\"happy\",\"importance\":43},{\"uid\":\"13F575EB-9BD7-BC37-61A8-4E80DED7F1AD\",\"name\":\"warm-hearted\",\"importance\":43},{\"uid\":\"79859BD2-3DCC-3F81-2048-0F0897C04104\",\"name\":\"experimental\",\"importance\":48},{\"uid\":\"6EA33110-3D34-D405-417A-C16AC9A7CE69\",\"name\":\"hesitant\",\"importance\":65},{\"uid\":\"6224027F-950C-0C12-BD5B-8541C8F2FDB1\",\"name\":\"introvert\",\"importance\":67},{\"uid\":\"06CB5405-5031-9D8B-B099-9B6966AFDB6A\",\"name\":\"cerebral\",\"importance\":67},{\"uid\":\"FB7512D3-477D-362B-CAA6-66F5278E40FD\",\"name\":\"conquering\",\"importance\":75},{\"uid\":\"B4C4223B-69C9-6556-BDD5-3EDBF6041C38\",\"name\":\"challenging\",\"importance\":75},{\"uid\":\"A424620A-6B62-5AE4-7201-AECD3BDD9BBB\",\"name\":\"odd\",\"importance\":75},{\"uid\":\"8CE7BC69-1374-D131-3284-B50986ED8462\",\"name\":\"seeking\",\"importance\":75},{\"uid\":\"6F1D3063-E8E1-C3FF-48C4-FD8C81913DCA\",\"name\":\"complex\",\"importance\":95},{\"uid\":\"7488B6B9-5EB0-09B7-02C4-21FBC68090FB\",\"name\":\"sophisticated\",\"importance\":95},{\"uid\":\"C9A7795C-6088-AD6D-EF05-050B5CE013E3\",\"name\":\"duelling\",\"importance\":95},{\"uid\":\"04EAD4A4-2A90-BC36-579D-408F47E4F0AC\",\"name\":\"bright\",\"importance\":85},{\"uid\":\"0F009D11-53FD-52C7-FCF3-B12A853DA171\",\"name\":\"determined\",\"importance\":85},{\"uid\":\"1239178A-A38F-AD13-0A21-689206A78F1E\",\"name\":\"provocative\",\"importance\":85},{\"uid\":\"30DF5DDC-46B1-3BD8-0D2D-DC0CC813624B\",\"name\":\"fragile\",\"importance\":85},{\"uid\":\"446DDB2A-513B-0BDB-B2FD-6F25C401428A\",\"name\":\"thoughtful\",\"importance\":85},{\"uid\":\"88E4D296-5FD6-4A9E-C4E4-5E1DD302CB8B\",\"name\":\"intense\",\"importance\":85},{\"uid\":\"B38CF6B8-2C47-96B1-E568-7A7CA3C88A6F\",\"name\":\"cathartic\",\"importance\":85},{\"uid\":\"BBBEB03B-DE97-EC0E-D6EC-94EF10DED278\",\"name\":\"inhibited\",\"importance\":85},{\"uid\":\"E0546129-DB97-6517-05E7-63C9720E2AE5\",\"name\":\"vulnerable\",\"importance\":85},{\"uid\":\"F7948819-E666-5D98-EB31-AACB6ABEEA9D\",\"name\":\"isolated\",\"importance\":85},{\"uid\":\"2A6B8129-F257-FE95-A0CA-9D4F3097E708\",\"name\":\"performing\",\"importance\":81},{\"uid\":\"859A9B2A-B8C8-82AC-05DD-1A6FDB881295\",\"name\":\"technical\",\"importance\":81},{\"uid\":\"F56B6D0A-C6D6-50A1-4150-389E59F67972\",\"name\":\"changing\",\"importance\":81},{\"uid\":\"C86494B7-B7E3-1492-419C-9A761C3F03C8\",\"name\":\"serious\",\"importance\":76},{\"uid\":\"55BEDE8D-6CC4-0C4A-F362-15A8560151C8\",\"name\":\"organic\",\"importance\":75},{\"uid\":\"57EDB459-31A5-727C-3702-369473AB1521\",\"name\":\"inspired\",\"importance\":75},{\"uid\":\"5BC6DCE0-5979-2889-25B7-52C05CE2D721\",\"name\":\"emotional\",\"importance\":75},{\"uid\":\"6338D4BD-8531-AEF0-50D7-B7CF0286C845\",\"name\":\"evolving\",\"importance\":75},{\"uid\":\"6933A010-6D30-A84F-BD02-0B5F385C2B26\",\"name\":\"ambitious\",\"importance\":75},{\"uid\":\"8A6740FA-59F2-5D2C-F5E6-C3FCE7ECA68F\",\"name\":\"vigorous\",\"importance\":75}],\"score\":88.89},{\"uid\":\"C842B75C-0153-A057-084C-847FB0823266\",\"name\":\"\\u0026#32566\\u0026#12467\\u0026#12540\\u0026#12498\\u0026#12540 (Can Coffee)\",\"moods\":[{\"uid\":\"8E4F875D-7087-64ED-DECA-5295038D9A12\",\"name\":\"Above (Fire)\",\"importance\":24},{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":25},{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":32},{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":15},{\"uid\":\"404BFE84-FF2E-528E-FA9A-47DE57E17BAC\",\"name\":\"On (Ground)\",\"importance\":34},{\"uid\":\"59B0964A-D326-E5B8-22FE-659B160B8EFF\",\"name\":\"In\\/within (Water)\",\"importance\":34},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":29},{\"uid\":\"C56B7569-62B0-9BDA-A116-40DC13465D16\",\"name\":\"coldness\",\"importance\":20},{\"uid\":\"9B58478C-75C0-502B-A8D1-02EB242E8E38\",\"name\":\"extroversion\",\"importance\":39},{\"uid\":\"633210E7-D8C2-9E3C-07A6-03968D0298AC\",\"name\":\"spirituality\",\"importance\":25},{\"uid\":\"F05F72AD-E056-CEA2-3BD2-E109EFA0C02B\",\"name\":\"happiness\",\"importance\":15},{\"uid\":\"38161F57-8D19-7675-03A6-51505BC8261A\",\"name\":\"self control\",\"importance\":34},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":23},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":22},{\"uid\":\"AEC666EF-1869-A54E-18F0-A8F87FB1FEC8\",\"name\":\"intellect\",\"importance\":55},{\"uid\":\"CE8CFA4A-2FD0-6408-7497-C141256C7489\",\"name\":\"warrior\",\"importance\":21},{\"uid\":\"9FFC5764-3EE0-1C96-A840-4EE4FD0F974F\",\"name\":\"playfulness\",\"importance\":47},{\"uid\":\"6D5AE713-FA4A-2067-6CC8-B296D29EF57B\",\"name\":\"sensibility\",\"importance\":24},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":33},{\"uid\":\"2294612B-1233-4F34-B5B6-BDCEA772B1CC\",\"name\":\"roots\",\"importance\":27},{\"uid\":\"6755A82E-689A-E825-EE02-5551736CDB4D\",\"name\":\"love\",\"importance\":23},{\"uid\":\"6EDA4243-4259-6949-D95E-31F430B9E50F\",\"name\":\"free\",\"importance\":38},{\"uid\":\"FDB39FC5-786B-412D-9C0E-0BA799B375A4\",\"name\":\"unconventional\",\"importance\":48},{\"uid\":\"F7948819-E666-5D98-EB31-AACB6ABEEA9D\",\"name\":\"isolated\",\"importance\":48},{\"uid\":\"F56B6D0A-C6D6-50A1-4150-389E59F67972\",\"name\":\"changing\",\"importance\":48},{\"uid\":\"B6DF5F89-E389-EFD3-2175-7EF6BE38FF43\",\"name\":\"atmospheric\",\"importance\":48},{\"uid\":\"90E92479-7B16-3224-3D57-3074064EFC7A\",\"name\":\"mysterious\",\"importance\":48},{\"uid\":\"596EC170-93CD-EBA6-8ACC-A3B51ABB3F18\",\"name\":\"intellectual\",\"importance\":95},{\"uid\":\"06CB5405-5031-9D8B-B099-9B6966AFDB6A\",\"name\":\"cerebral\",\"importance\":76},{\"uid\":\"39ACA5F9-01D8-57AA-1E6F-CE6ACF27B6DA\",\"name\":\"mannered\",\"importance\":76},{\"uid\":\"57EDB459-31A5-727C-3702-369473AB1521\",\"name\":\"inspired\",\"importance\":76},{\"uid\":\"6F1D3063-E8E1-C3FF-48C4-FD8C81913DCA\",\"name\":\"complex\",\"importance\":76},{\"uid\":\"7488B6B9-5EB0-09B7-02C4-21FBC68090FB\",\"name\":\"sophisticated\",\"importance\":76},{\"uid\":\"AEEC9A7C-02BD-46AB-ABF5-91817B003BB6\",\"name\":\"precise\",\"importance\":76},{\"uid\":\"BD7BA5CE-1C02-ABE0-F767-58EA2B13E98B\",\"name\":\"difficult\",\"importance\":76},{\"uid\":\"0F009D11-53FD-52C7-FCF3-B12A853DA171\",\"name\":\"determined\",\"importance\":75},{\"uid\":\"2A6B8129-F257-FE95-A0CA-9D4F3097E708\",\"name\":\"performing\",\"importance\":75},{\"uid\":\"3419CB61-7C05-DD3B-432E-98F2C463B403\",\"name\":\"intuitive\",\"importance\":75},{\"uid\":\"412E2463-7085-1C4E-B601-B74286465235\",\"name\":\"extravagant\",\"importance\":75},{\"uid\":\"49336459-DB72-CBF7-ED17-AE9CBFADC7E4\",\"name\":\"tough\",\"importance\":75},{\"uid\":\"5A452A1D-1AF5-9E1A-B83D-5D77A64CE5A0\",\"name\":\"raucous\",\"importance\":75},{\"uid\":\"679B00B2-1FE1-44AF-50B9-10C8961F3048\",\"name\":\"virile\",\"importance\":75},{\"uid\":\"72B27930-5336-000C-470B-59A6786F254D\",\"name\":\"ample\",\"importance\":75},{\"uid\":\"859A9B2A-B8C8-82AC-05DD-1A6FDB881295\",\"name\":\"technical\",\"importance\":75},{\"uid\":\"88E4D296-5FD6-4A9E-C4E4-5E1DD302CB8B\",\"name\":\"intense\",\"importance\":75},{\"uid\":\"8B3FF0C8-C5D1-56ED-CA65-49909BCA2D81\",\"name\":\"essential\",\"importance\":75},{\"uid\":\"C5131D74-04FA-F960-16D8-49570FB115E5\",\"name\":\"impulsive\",\"importance\":75},{\"uid\":\"C88C7AFC-FC19-0AF3-D982-546E6864EB1E\",\"name\":\"wild\",\"importance\":75},{\"uid\":\"C9A7795C-6088-AD6D-EF05-050B5CE013E3\",\"name\":\"duelling\",\"importance\":75},{\"uid\":\"D70B66E1-B04C-EBA9-578C-0C1B986CC26F\",\"name\":\"rhythmic\",\"importance\":75},{\"uid\":\"03913886-FE4A-5982-68E1-E14E91ADBAAF\",\"name\":\"maniac\",\"importance\":71},{\"uid\":\"044BC3C6-9073-B7F4-E171-31F09E59FD73\",\"name\":\"deep\",\"importance\":71},{\"uid\":\"0599F73B-6A25-E9DA-4668-589A71739A73\",\"name\":\"pretentious\",\"importance\":71},{\"uid\":\"C2FAA0CF-DC3C-2F74-2EA4-C87A4317E7E1\",\"name\":\"clinical\",\"importance\":71},{\"uid\":\"6224027F-950C-0C12-BD5B-8541C8F2FDB1\",\"name\":\"introvert\",\"importance\":57},{\"uid\":\"79859BD2-3DCC-3F81-2048-0F0897C04104\",\"name\":\"experimental\",\"importance\":48}],\"score\":77.78},{\"uid\":\"B380A915-5193-2B01-C3F7-E6FF48FCB21A\",\"name\":\"426F 574F 5F6F\",\"moods\":[{\"uid\":\"404BFE84-FF2E-528E-FA9A-47DE57E17BAC\",\"name\":\"On (Ground)\",\"importance\":26},{\"uid\":\"C616FB42-6F61-630A-E681-D170F84D1742\",\"name\":\"Out (Wood)\",\"importance\":38},{\"uid\":\"C5EF7029-5E84-7F61-B2D1-97D8030F514C\",\"name\":\"Up (Air)\",\"importance\":20},{\"uid\":\"962C3966-5E12-696F-EF7E-68ABF6A2AFA7\",\"name\":\"Down (Metal)\",\"importance\":30},{\"uid\":\"1E66C428-F242-7510-C474-303C768870F4\",\"name\":\"dynamism\",\"importance\":34},{\"uid\":\"A03A702B-0EC4-300A-D18C-1542C9023315\",\"name\":\"good vibrations\",\"importance\":32},{\"uid\":\"9FFC5764-3EE0-1C96-A840-4EE4FD0F974F\",\"name\":\"playfulness\",\"importance\":26},{\"uid\":\"CE8CFA4A-2FD0-6408-7497-C141256C7489\",\"name\":\"warrior\",\"importance\":37},{\"uid\":\"6D5AE713-FA4A-2067-6CC8-B296D29EF57B\",\"name\":\"sensibility\",\"importance\":17},{\"uid\":\"9B58478C-75C0-502B-A8D1-02EB242E8E38\",\"name\":\"extroversion\",\"importance\":42},{\"uid\":\"C56B7569-62B0-9BDA-A116-40DC13465D16\",\"name\":\"coldness\",\"importance\":41},{\"uid\":\"92E96FA3-74B5-75B2-27C1-96B7D22D4BBB\",\"name\":\"manliness\",\"importance\":40},{\"uid\":\"F695778E-6475-F312-350C-66114B1BDEC8\",\"name\":\"withdrawal\",\"importance\":26},{\"uid\":\"0F009D11-53FD-52C7-FCF3-B12A853DA171\",\"name\":\"determined\",\"importance\":75},{\"uid\":\"2AD989FA-7E04-54B0-5ED8-924EE47604C0\",\"name\":\"energetic\",\"importance\":75},{\"uid\":\"412E2463-7085-1C4E-B601-B74286465235\",\"name\":\"extravagant\",\"importance\":75},{\"uid\":\"5A452A1D-1AF5-9E1A-B83D-5D77A64CE5A0\",\"name\":\"raucous\",\"importance\":75},{\"uid\":\"679B00B2-1FE1-44AF-50B9-10C8961F3048\",\"name\":\"virile\",\"importance\":75},{\"uid\":\"72B27930-5336-000C-470B-59A6786F254D\",\"name\":\"ample\",\"importance\":75},{\"uid\":\"9B574DAE-6872-1F28-48B3-2C4FDC33AEA7\",\"name\":\"metallic\",\"importance\":75},{\"uid\":\"9F0A9F9C-501D-F853-4376-AD2F9A856D1C\",\"name\":\"aggressive\",\"importance\":75},{\"uid\":\"B38CF6B8-2C47-96B1-E568-7A7CA3C88A6F\",\"name\":\"cathartic\",\"importance\":75},{\"uid\":\"E062FF9A-D4EB-AE9D-FDB5-C6B5E562FA36\",\"name\":\"incisive\",\"importance\":75},{\"uid\":\"EBD9117A-0D69-66FF-EADB-FDDDE57F158D\",\"name\":\"sharp\",\"importance\":75},{\"uid\":\"F14B73B9-C320-B6E1-0911-CC6D7837D8F5\",\"name\":\"loud\",\"importance\":75},{\"uid\":\"FD1F84B8-9FBB-428D-6469-0C9FA70E5AA5\",\"name\":\"strong\",\"importance\":75},{\"uid\":\"03913886-FE4A-5982-68E1-E14E91ADBAAF\",\"name\":\"maniac\",\"importance\":68},{\"uid\":\"4EC1DBCB-A22D-D414-9B2B-7F7279BA0470\",\"name\":\"paranoid\",\"importance\":68},{\"uid\":\"D70B66E1-B04C-EBA9-578C-0C1B986CC26F\",\"name\":\"rhythmic\",\"importance\":68},{\"uid\":\"F6C5910A-03A8-EF23-F5B6-1AA0258C419D\",\"name\":\"threatening\",\"importance\":68},{\"uid\":\"49336459-DB72-CBF7-ED17-AE9CBFADC7E4\",\"name\":\"tough\",\"importance\":66},{\"uid\":\"EFE2C415-2781-B731-1AD1-FEEDD20B370A\",\"name\":\"heroic\",\"importance\":66},{\"uid\":\"213BBCF2-F9B1-5AE8-1440-3C8EFAEE7EAF\",\"name\":\"anxiety\",\"importance\":60},{\"uid\":\"7D4A6714-A918-43F7-D1F5-96A1963DFC00\",\"name\":\"in your face\",\"importance\":60},{\"uid\":\"68F64A5D-CC1E-8E08-7A53-ADEFCBF94626\",\"name\":\"methodical\",\"importance\":58},{\"uid\":\"6DCC7FFC-A6D0-8352-8198-97448BCEDF7D\",\"name\":\"exaggerated\",\"importance\":58},{\"uid\":\"87BA8902-D4FB-BB32-4CA6-BD5AD90A8625\",\"name\":\"violent\",\"importance\":58},{\"uid\":\"E23CDC4A-1991-F807-027E-2EFCAF617B94\",\"name\":\"nasty\",\"importance\":58},{\"uid\":\"F56B6D0A-C6D6-50A1-4150-389E59F67972\",\"name\":\"changing\",\"importance\":58},{\"uid\":\"F87F7D70-70F1-D5A1-865C-AEC83B0E6BE7\",\"name\":\"vulgar\",\"importance\":58},{\"uid\":\"2A67558C-2FF3-2D44-6DFB-523F80176453\",\"name\":\"powerful\",\"importance\":50},{\"uid\":\"F89DEB79-525C-7DBF-A04C-44FC4833743B\",\"name\":\"lightless\",\"importance\":50},{\"uid\":\"5E579C46-BD0F-D09B-1B52-498CAE52A095\",\"name\":\"bravado\",\"importance\":45},{\"uid\":\"1239178A-A38F-AD13-0A21-689206A78F1E\",\"name\":\"provocative\",\"importance\":41},{\"uid\":\"3CD8FE90-F6BC-B74E-6770-460A4C8DC5F4\",\"name\":\"rebellious\",\"importance\":38},{\"uid\":\"A2C40F67-10C1-55A0-9350-0FCBAF68A070\",\"name\":\"ironic\",\"importance\":38},{\"uid\":\"B4C4223B-69C9-6556-BDD5-3EDBF6041C38\",\"name\":\"challenging\",\"importance\":38},{\"uid\":\"C88C7AFC-FC19-0AF3-D982-546E6864EB1E\",\"name\":\"wild\",\"importance\":38}],\"score\":77.78},{\"uid\":\"AFCDF3B1-D1AA-7032-F509-30EB3323668C\",\"name\":\"\\u003Ca href=\\u0022http:\\/\\/www.discogs.com\\/release\\/2533256\\u0022\\u003E Clarinet Sonatas\\u003C\\/a\\u003E\",\"moods\":[],\"score\":66.67},{\"uid\":\"FBB0CCE7-2D62-56FE-73AC-6F3BA1B8E24B\",\"name\":\"Basef3\",\"moods\":[],\"score\":66.67},{\"uid\":\"8E9D064C-845A-AF4C-4F4B-968209C39AF3\",\"name\":\"Basef3\",\"moods\":[],\"score\":66.67}]}\r\n";
	}
	

}
