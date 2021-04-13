package simplyRugby;
/**
 * <H1> Class - Skill</H1>
 * <p>
 * This class is to be used as a blueprint for creating skills that will be used as
 * a part of the skill tracking system for Simply Rugby. 
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 *
 */

public class Skill {
	//Declares the skillName variable for use within the skill tracking part of the system.
	private String skillName;
	//Declares the rating variable for use within the skill tracking part of the system.
	private int rating;
	
	/**
	 * Constructors
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public Skill()
	{
		//Sets the value of skillName to null.
		skillName = null;
		//Sets the value of rating to 0 (null).
		rating = 0;
	}
	
	public Skill(String skillName, int rating)
	{
		//Sets the skillName variable within the Class to the value in the passed in parameter.
		this.skillName = skillName;
		//Sets the rating variable within the Class to the value in the passed in parameter.
		this.rating = rating;
	}
	
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}