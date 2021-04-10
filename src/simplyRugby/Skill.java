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