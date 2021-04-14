package simplyRugby;

import java.util.ArrayList;
import java.util.Date;

/**
 * <H1> Class - JuniorPlayer</H1>
 * <p>
 * This class is responsible for holding information that is specific to a junior player.
 * This class extends from the player class that extends from the member super class.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * 
 */

public class JuniorPlayer extends Player{
	
	//Declares guardianName variable that is used to store the junior player guardians name that will be used as contact information if required.
	private String guardianName;
	//Declares guardianPhoneNo variable that is used to store the junior player guardians name that will be used as contact information if required.
	private String guardianPhoneNo;
	
	/**
	 * Constructors
	 * Constructor for the Player child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public JuniorPlayer()
	{
		//Sets the value of guardianName to null.
		guardianName = null;
		//Sets the value of guardianPhoneNo to null.
		guardianPhoneNo = null;
	}
	
	public JuniorPlayer(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB, String scrumsID, String position, String emergencyContactName,
			String emergencyContactNo, ArrayList<SkillCategory> playerSkills, String guardianName, String guardianPhoneNo)
	{
		//The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode, DOB, scrumsID, position, emergencyContactName, emergencyContactNo, playerSkills);
		//Sets the guardianName variable within the Class to the value in the passed in parameter.
		this.guardianName = guardianName;
		//Sets the guardianPhoneNo variable within the Class to the value in the passed in parameter.
		this.guardianPhoneNo = guardianPhoneNo;
	}
	
	/**
	 * @return the guardianName
	 */
	public String getGuardianName() {
		return guardianName;
	}
	/**
	 * @param guardianName the guardianName to set
	 */
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	/**
	 * @return the guardianPhoneNo
	 */
	public String getGuardianPhoneNo() {
		return guardianPhoneNo;
	}
	/**
	 * @param guardianPhoneNo the guardianPhoneNo to set
	 */
	public void setGuardianPhoneNo(String guardianPhoneNo) {
		this.guardianPhoneNo = guardianPhoneNo;
	}
	
}