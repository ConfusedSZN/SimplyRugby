package simplyRugby;

/**
 * <H1> Class - Coach</H1>
 * <p>
 * This class is to be used as a blueprint for creating coach members. 
 * The class extends from the Member super class that allows it to store specific 
 * information connected to the coach.
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 *
 */

public class Coach extends Member{
	
	//Declares the username String that is used to store the coaches username used in the login process.
	private String username;
	//Declares the password String that is used to store the coaches password that is used in the login process.
	private String password;
	//Declares the coachesSquadID String that is used to store the ID of the Squad that is coached by them. 
	private String coachesSquadID;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the coachesSquadID
	 */
	public String getCoachesSquadID() {
		return coachesSquadID;
	}
	/**
	 * @param coachesSquadID the coachesSquadID to set
	 */
	public void setCoachesSquadID(String coachesSquadID) {
		this.coachesSquadID = coachesSquadID;
	}
	
}