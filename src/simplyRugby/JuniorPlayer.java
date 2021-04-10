package simplyRugby;

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