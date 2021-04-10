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

public class Squad {
	
	//Declares the squadID variable that is used to store a identifier for the squad. 
	private String squadID;
	//Declares the name variable that is used to store the name of the squad within the system.
	private String name;
	//Declares the ageRange variable that is used to store the range of ages that the players of the squad play at.
	private String ageRange;
	//Declares the playerList variable that is used to store a list of player objects within the squad.
	private ArrayList<Player> playerList;
	
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