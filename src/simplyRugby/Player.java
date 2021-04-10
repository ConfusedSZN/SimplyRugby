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

public class Player extends Member{
	
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