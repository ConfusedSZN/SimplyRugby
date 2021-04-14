package simplyRugby;

/**
 * <H1> Class - Squad</H1>
 * <p>
 * This class is responsible for holding information that is linked to a Squad at the Simply Rugby Club.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * 
 */

import java.util.ArrayList;

public class Squad implements java.io.Serializable{
	//Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	private static final long serialVersionUID = 541583651513199852L;
	//Declares the squadID variable that is used to store a identifier for the squad. 
	private String squadID;
	//Declares the name variable that is used to store the name of the squad within the system.
	private String name;
	//Declares the ageRange variable that is used to store the range of ages that the players of the squad play at.
	private String ageRange;
	//Declares the playerList variable that is used to store a list of player objects within the squad.
	private ArrayList<Player> playerList;
	
	/**
	 * Constructors
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public Squad()
	{
		//Sets the value of squadID to null.
		squadID = null;
		//Sets the value of name to null.
		name = null;
		//Sets the value of ageRange to null.
		ageRange = null;
		//Sets the value of playerList to null.
		playerList = null;
	}
	
	public Squad(String squadID, String name, String ageRange, ArrayList<Player> playerList)
	{
		//Sets the squadID variable within the Class to the value in the passed in parameter.
		this.squadID = squadID;
		//Sets the name variable within the Class to the value in the passed in parameter.
		this.name = name;
		//Sets the ageRange variable within the Class to the value in the passed in parameter.
		this.ageRange = ageRange;
		//Sets the playerList variable within the Class to the value in the passed in parameter.
		this.playerList = playerList;
	}
	
	
	/**
	 * @return the squadID
	 */
	public String getSquadID() {
		return squadID;
	}
	/**
	 * @param squadID the squadID to set
	 */
	public void setSquadID(String squadID) {
		this.squadID = squadID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ageRange
	 */
	public String getAgeRange() {
		return ageRange;
	}
	/**
	 * @param ageRange the ageRange to set
	 */
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	/**
	 * @return the playerList
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	/**
	 * @param playerList the playerList to set
	 */
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
}