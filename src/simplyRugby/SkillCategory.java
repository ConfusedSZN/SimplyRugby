package simplyRugby;

/**
 * <H1> Class - Skill Category</H1>
 * <p>
 * This class is to be used as a blueprint for creating skill categories that will be used as part of the system
 * the class contains a list of Skills that are specific to their category that can be defined using this class.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * 
 *
 */

//Imports ArrayList utility for storing data as an array list.
import java.util.ArrayList;

public class SkillCategory implements java.io.Serializable{
	//Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	private static final long serialVersionUID = 541583651513199852L;
	//Declares categoryName variable that is used to store information about the name of the category.
	private String categoryName;
	//Declares categoryNotes variable that is used to store information within the category.
	private String categoryNotes;
	//Declares the categorySkillList variable that is used to store a list of the skills in the category.
	private ArrayList<Skill> categorySkillList;
	
	/**
	 * Constructors
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public SkillCategory()
	{
		//Sets the value of categoryName to null.
		categoryName = null;
		//Sets the value of categoryNotes to null.
		categoryNotes = null;
		//Sets the value of categorySkillList to null.
		categorySkillList = null;
	}
	
	public SkillCategory(String categoryName, String categoryNotes, ArrayList<Skill> categorySkillList)
	{
		this.categoryName = categoryName;
		
		this.categoryNotes = categoryNotes;
		
		this.categorySkillList = categorySkillList;
	}
	
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the categoryNotes
	 */
	public String getCategoryNotes() {
		return categoryNotes;
	}
	/**
	 * @param categoryNotes the categoryNotes to set
	 */
	public void setCategoryNotes(String categoryNotes) {
		this.categoryNotes = categoryNotes;
	}
	/**
	 * @return the categorySkillList
	 */
	public ArrayList<Skill> getCategorySkillList() {
		return categorySkillList;
	}
	/**
	 * @param categorySkillList the categorySkillList to set
	 */
	public void setCategorySkillList(ArrayList<Skill> categorySkillList) {
		this.categorySkillList = categorySkillList;
	}
	
}