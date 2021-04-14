package simplyRugby;


/**
 * <H1> Class - Player</H1>
 * <p>
 * This class is to be used as a blueprint for creating player members. 
 * The class extends from the Member super class that allows it to store specific 
 * information connected to the player.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * 
 */

//Imports ArrayList utility for storing data as an array list.
import java.util.ArrayList;
import java.util.Date;

public class Player extends Member{
	//Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	private static final long serialVersionUID = 541583651513199852L;
	//Declares scrumsID variable that is used to store the players scrums identification number.
	private String scrumsID;
	//Declares position variable that is used to store the position that the player plays in. 
	private String position;
	//Declares emergencyContactName variable that is used to store the name of the emergency contact. 
	private String emergencyContactName;
	//Declares emergencyContactNo variable that is used to store the contact number of the emergency contact. 
	private String emergencyContactNo;
	//Declares playerSkills variable that is used to store a list of skill categories. 
	private ArrayList<SkillCategory> playerSkills;
	
	/**
	 * Constructors
	 * Constructor for the Player child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public Player()
	{
		//Sets the value of scrumsID to null.
		scrumsID = null;
		//Sets the value of position to null.
		position = null;
		//Sets the value of emergencyContactName to null.
		emergencyContactName = null;
		//Sets the value of emergencyContactNo to null.
		emergencyContactNo = null;
		//Sets the value of playerSkills to null.
		playerSkills = null;
	}
	
	public Player(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB, String scrumsID, String position, String emergencyContactName,
			String emergencyContactNo, ArrayList<SkillCategory> playerSkills)
	{
		//The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode, DOB);
		//Sets the scrumsID variable within the Class to the value in the passed in parameter.
		this.scrumsID = scrumsID;
		//Sets the position variable within the Class to the value in the passed in parameter.
		this.position = position;
		//Sets the emergencyContactName variable within the Class to the value in the passed in parameter.
		this.emergencyContactName = emergencyContactName;
		//Sets the emergencyContactNo variable within the Class to the value in the passed in parameter.
		this.emergencyContactNo = emergencyContactNo;
		//Sets the playerSkills variable within the Class to the value in the passed in parameter.
		this.playerSkills = playerSkills;
	}
	
	/**
	 * @return the scrumsID
	 */
	public String getScrumsID() {
		return scrumsID;
	}
	/**
	 * @param scrumsID the scrumsID to set
	 */
	public void setScrumsID(String scrumsID) {
		this.scrumsID = scrumsID;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the emergencyContactName
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/**
	 * @param emergencyContactName the emergencyContactName to set
	 */
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	/**
	 * @return the emergencyContactNo
	 */
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}
	/**
	 * @param emergencyContactNo the emergencyContactNo to set
	 */
	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}
	/**
	 * @return the playerSkills
	 */
	public ArrayList<SkillCategory> getPlayerSkills() {
		return playerSkills;
	}
	/**
	 * @param playerSkills the playerSkills to set
	 */
	public void setPlayerSkills(ArrayList<SkillCategory> playerSkills) {
		this.playerSkills = playerSkills;
	}

}