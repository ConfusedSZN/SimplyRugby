package simplyRugby;

/**
 * <H1> Class - Member</H1>
 * <p>
 * This class is responsible for holding information that is important to members. 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * 
 */

public class Member implements java.io.Serializable{
	//Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	private static final long serialVersionUID = 541583651513199852L;
	//Declares memberID variable that is used as an identifier for the member.
	private String memberID;
	//Declares firstName variable that is used to store the members first name. 
	private String firstName;
	//Declares middleNames variable that is used to store the members middle names. 
	private String middleNames;
	//Declares lastName variable that is used to store the members last name.
	private String lastName;
	//Declares email variable that is used to store the members email.
	private String email;
	//Declares phoneNo variable that is used to store the members phone number.
	private String phoneNo;
	//Declares address1 variable that is used to store the first line of the members address.
	private String address1;
	//Declares address2 variable that is used to store the second line of the member address.
	private String address2;
	//Declares city variable that is used to store the name of the city the member lives in.
	private String city;
	//Declares postcode variable that is used to store the postcode of the member.
	private String postcode;
	
	/**
	 * Constructors
	 * Constructor for the Member super class.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	public Member()
	{
		//Sets the value of memberID to null.
		memberID = null;
		//Sets the value of firstName to null.
		firstName = null;
		//Sets the value of middleNames to null.
		middleNames = null;
		//Sets the value of lastName to null.
		lastName = null;
		//Sets the value of email to null.
		email = null;
		//Sets the value of phoneNo to null.
		phoneNo = null;
		//Sets the value of address1 to null.
		address1 = null;
		//Sets the value of address2 to null.
		address2 = null;
		//Sets the value of city to null.
		city = null;
		//Sets the value of postcode to null.
		postcode = null;
	}
	
	public Member(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode)
	{
		//Sets the memberID variable within the Class to the value in the passed in parameter.
		this.memberID = memberID;
		//Sets the firstName variable within the Class to the value in the passed in parameter.
		this.firstName = firstName;
		//Sets the middleNames variable within the Class to the value in the passed in parameter.
		this.middleNames = middleNames;
		//Sets the lastName variable within the Class to the value in the passed in parameter.
		this.lastName = lastName;
		//Sets the email variable within the Class to the value in the passed in parameter.
		this.email = email;
		//Sets the phoneNo variable within the Class to the value in the passed in parameter.
		this.phoneNo = phoneNo;
		//Sets the address1 variable within the Class to the value in the passed in parameter.
		this.address1 = address1;
		//Sets the address2 variable within the Class to the value in the passed in parameter.
		this.address2 = address2;
		//Sets the city variable within the Class to the value in the passed in parameter.
		this.city = city;
		//Sets the postcode variable within the Class to the value in the passed in parameter.
		this.postcode = postcode;
	}
	
	/**
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleNames
	 */
	public String getMiddleNames() {
		return middleNames;
	}
	/**
	 * @param middleNames the middleNames to set
	 */
	public void setMiddleNames(String middleNames) {
		this.middleNames = middleNames;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
