package api;
/**
 * GeneralAPI interface, in case we want to change api 
 * @author Yarden
 *
 */
public interface GeneralAPI {
	String getToken() throws Exception;  //Each API need its own TOKEN
}
