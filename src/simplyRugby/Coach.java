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
	
	//Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	private static final long serialVersionUID = 541583651513199852L;
	//Declares the username String that is used to store the coaches username used in the login process.
	private String username;
	//Declares the password String that is used to store the coaches password that is used in the login process.
	private String password;
	//Declares the coachesSquadID String that is used to store the ID of the Squad that is coached by them. 
	private String coachesSquadID;
	
	/**
	 * Constructors
	 * Constructor for the Coach child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	public Coach()
	{
		//Sets the value of username to null.
		username = null;
		//Sets the value of password to null.
		password = null;
		//Sets the value of coachesSquadID to null.
		coachesSquadID = null;
		
	}
	
	public Coach(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, String username, String password, String coachesSquadID)
	{
		//The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode);
		//Sets the username variable within the Class to the value in the passed in parameter.
		this.username = username;
		//Sets the password variable within the Class to the value in the passed in parameter.
		this.password = password;
		//Sets the coachesSquadID variable within the Class to the value in the passed in parameter.
		this.coachesSquadID = coachesSquadID;
	}
	
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