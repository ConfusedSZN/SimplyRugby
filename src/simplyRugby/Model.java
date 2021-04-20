package simplyRugby;

/**
 * <H1> Class - Model</H1>
 * This class is responsible for holding information and saving information linked to the Simply Rugby Club.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 */

/**
 * Imports the Java IO File Input Stream that is used during the data loading process.
 */
import java.io.FileInputStream;
/**
 * Imports the Java IO File Not Found Exception that is used to catch errors during the data loading process.
 */
import java.io.FileNotFoundException;
/**
 * Imports the Java IO File Output Stream that is used during the saving process.
 */
import java.io.FileOutputStream;
/**
 * Imports the Java IO Exception handler that is used to catch errors during the loading process.
 */
import java.io.IOException;
/**
 * Imports Java IO Object Input Stream that is used during the loading process.
 */
import java.io.ObjectInputStream;
/**
 * Imports Java IO Object Output Stream that is used during the saving process.
 */
import java.io.ObjectOutputStream;
/**
 * Imports Java Text ParseException that is used to catch Parse Exceptions in the data pre population process.
 */
import java.text.ParseException;
/**
 * Imports the Java Text SimpleDataFormat which is used during the data pre population process.
 */
import java.text.SimpleDateFormat;
/**
 * Imports the Java ArrayList utility that is used to store the list of the coaches and squad in the class.
 */
import java.util.ArrayList;
/**
 * Imports the Java Date Utility that is used in data prepopulation.
 */
import java.util.Date;
/**
 * Imports all of the BCrypt functions, BCrypt is a password hashing function that will be used during the data prepopulation process. 
 */
import BCrypt.BCrypt;

/**
 * <p>
 * Model class that will be used by the controller to load and save data.
 *
 */
public class Model {

	/**
	 * Declares and Initialises the coachData array list that holds data about coaches in the system.
	 */
	private ArrayList<Coach> coachData = new ArrayList<Coach>();
	/**
	 * Declares and initalises the squadData array list that holds data about squads within the system.
	 */
	private ArrayList<Squad> squadData = new ArrayList<Squad>();
	
	/**
	 * Model Constructor that is used upon application start to load the data for the system.
	 */
	public Model()
	{
		loadData();
	}

	@SuppressWarnings("unchecked")
	protected void loadData(){
		//Opens a Try block, this allows for easy error catching
		 try {
			//Starts a new FIS(File Input Stream) for the file "SimplyRugbyData.ser".
				FileInputStream fileIn = new FileInputStream("SimplyRugbyData.ser");
				//Starts a new OIS(Object Input Stream)
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				//Reads the Data input coachData ArrayList from the file.
				setCoachData((ArrayList<Coach>)objIn.readObject());
				//Reads the Data input squadData ArrayList from the file.
				setSquadData((ArrayList<Squad>)objIn.readObject());
				//Closes the OIS(Object Input Stream)
				objIn.close();
				//Closes the FIS(File Input Stream)
				fileIn.close();
				//Catch block for if the file does not exist, if this happens Data Pre Populates.
			} catch (FileNotFoundException ioError) {
				//File not found so the Software prepopulates inital data.
				prePopulate();
			} catch (IOException e) {
				e.printStackTrace();
				//Catch Block for errors surrounding the File existing but not containing the right type of Data.
			} catch (ClassNotFoundException badClass) {
				System.out.println("Coach class or Squad Class not found in file.");
			}
	}
	
	protected void saveData()
	{
		//Opens a Try block, this allows for easy error catching
		 try {
			 //Starts a new FOS(File Output Stream) to the file "SimplyRugbyData.ser".
        	FileOutputStream fos = new FileOutputStream("SimplyRugbyData.ser");
        	//Starts a new OOS(Object Output Stream)
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	//Writes the coachData Object to the file.
        	oos.writeObject(coachData);
        	//Writes the squadData Object to the file.
        	oos.writeObject(squadData);
        	//Closes the FOS(File Output Stream) which saves the file.
        	fos.close();
        	//Catch Block for errors to do with files becoming unavailable, read/write permissions and running out of disk space.
        	}catch(IOException ioe) {
        		ioe.printStackTrace();
        	}
	}
	
	private void prePopulate()
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		/**
		 * Data Prepopulation for Coach.
		 */
		String coachPassword1 = "123";
		String coachPassword2 = "456";
		String coachPassword3 = "789";
		String passwordHashed1 = BCrypt.hashpw(coachPassword1, BCrypt.gensalt());
		String passwordHashed2 = BCrypt.hashpw(coachPassword2, BCrypt.gensalt());
		String passwordHashed3 = BCrypt.hashpw(coachPassword3, BCrypt.gensalt());
		
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		String strDate1 = "13/6/1982";
		String strDate2 = "27/3/1985";
		String strDate3 = "24/10/1978";
		
		try {
			date1 = dateFormat.parse(strDate1);
			date2 = dateFormat.parse(strDate2);
			date3 = dateFormat.parse(strDate3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		coachData.add(new Coach("6SH6A521", "Kris", "Crawford","Forbes","krisforbes@simplyrugby.com", "07751259892", "57", "Boat Lane", "Reedham", "NR13 5WE", date1, "Kris", passwordHashed1, "H26YZA99"));
		coachData.add(new Coach("4B3NR2SK", "Tristan", "McIntosh","Ritchie","tristanritchie@simplyrugby.com", "07043645025", "78", "Farburn Terrace", "Reedham", "NR13 8WZ", date2, "Tristan",passwordHashed2 , "OKYHF5GS"));
		coachData.add(new Coach("B0P2BJR6", "Angus", "MacDonald","Stevenson","angusstevenson@simplyrugby.com", "07774612118", "89", "Osborne Road", "Reedham", "NR13 4GH", date3, "Angus", passwordHashed3 , "8ABTY625"));

		/**
		 * Data prepopulation for skills
		 */
		ArrayList<Skill> skillList1 = new ArrayList<Skill>();
		ArrayList<Skill> skillList2 = new ArrayList<Skill>();
		ArrayList<Skill> skillList3 = new ArrayList<Skill>();
		ArrayList<Skill> skillList4 = new ArrayList<Skill>();
		ArrayList<Skill> skillList5 = new ArrayList<Skill>();
		ArrayList<Skill> skillList6 = new ArrayList<Skill>();
		ArrayList<Skill> skillList7 = new ArrayList<Skill>();
		ArrayList<Skill> skillList8 = new ArrayList<Skill>();
		ArrayList<Skill> skillList9 = new ArrayList<Skill>();
		
		Skill Skill1 = new Skill("Speed", 33);
		Skill Skill2 = new Skill("Stamina", 56);
		Skill Skill3 = new Skill("Tackling", 77);
		
		Skill Skill4 = new Skill("Decision Making", 66);
		Skill Skill5 = new Skill("Support Play", 60);
		Skill Skill6 = new Skill("Positioning", 88);

		
		Skill Skill7 = new Skill("Place Kick", 99);
		Skill Skill8 = new Skill("Spiral Punt", 78);
		Skill Skill9 = new Skill("End-over-end Kick", 44);
		
		skillList1.add(Skill1);
		skillList2.add(Skill4);
		skillList3.add(Skill7);
		
		skillList4.add(Skill2);
		skillList5.add(Skill5);
		skillList6.add(Skill8);
		
		skillList7.add(Skill3);
		skillList8.add(Skill6);
		skillList9.add(Skill9);
		
		/**
		 * Data prepopulation for skill categories
		 */
		
		ArrayList<SkillCategory> categoryList1 = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> categoryList2 = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> categoryList3 = new ArrayList<SkillCategory>();

		SkillCategory Category1 = new SkillCategory("Physical", "Skills to do with Physical attributes.", skillList1);
		SkillCategory Category2 = new SkillCategory("Mental", "Skills to do with Mental activities.", skillList2);
		SkillCategory Category3 = new SkillCategory("Kicking", "Skills to do with Kicking the ball.", skillList3);
		
		SkillCategory Category4 = new SkillCategory("Physical", "Skills to do with Physical attributes.", skillList4);
		SkillCategory Category5 = new SkillCategory("Mental", "Skills to do with Mental activities.", skillList5);
		SkillCategory Category6 = new SkillCategory("Kicking", "Skills to do with Kicking the ball.", skillList6);
		
		SkillCategory Category7 = new SkillCategory("Physical", "Skills to do with Physical attributes.", skillList7);
		SkillCategory Category8 = new SkillCategory("Mental", "Skills to do with Mental activities.", skillList8);
		SkillCategory Category9 = new SkillCategory("Kicking", "Skills to do with Kicking the ball.", skillList9);
	
		categoryList1.add(Category1);
		categoryList1.add(Category2);
		categoryList1.add(Category3);
		
		categoryList2.add(Category4);
		categoryList2.add(Category5);
		categoryList2.add(Category6);
		
		categoryList3.add(Category7);
		categoryList3.add(Category8);
		categoryList3.add(Category9);
		
		/**
		 * Data prepopulation for players
		 */
		
		Date date4 = null;
		Date date5 = null;
		Date date6 = null;
		String strDate4 = "02/01/2001";
		String strDate5 = "24/04/1999";
		String strDate6 = "19/02/2015";
		
		try {
			date4 = dateFormat.parse(strDate4);
			date5 = dateFormat.parse(strDate5);
			date6 = dateFormat.parse(strDate6);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Player Player1 = new Player("MFJ0VW90", "Cairn", "Macleod", "Boyle", "cairnboyle@gmail.com", "07737156340", "66", "Simone Weil Avenue", "Reedham", "NR13 5XY", date4, "827643", "Hooker", "Ronan Boyle", "07083368097", categoryList1);
		Player Player2 = new Player("A30OZ0AV", "Jason", "Simpson", "Kerr", "jasonkerr@gmail.com", "07823209884", "38", "Iffley Road", "Reedham", "NR13 2HB", date5, "167405", "Fly Half", "Demi Kerr", "07805774677", categoryList2);
		JuniorPlayer Player3 = new  JuniorPlayer("LK73JCCE", "Logan", "McLean", "Moore", "loganmoore@gmail.com", "07038880548", "61", "Caerfai Bay Road", "Reedham", "NR13 1GX", date6, "642438", "Fly Half", "Amber Moore", "07043896595", categoryList3, "Amber Moore", "07043896595");
		
		/**
		 * Data Prepopulation for Squad's.
		 */
		
		ArrayList<Player> playerList1 = new ArrayList<Player>();
		ArrayList<Player> playerList2 = new ArrayList<Player>();
		ArrayList<Player> playerList3 = new ArrayList<Player>();
		
		playerList1.add(Player1);
		playerList1.add(Player2);
		playerList3.add(Player3);
		
		Squad Squad1 = new Squad("H26YZA99", "U18 Squad 1", "U18", playerList1);
		Squad Squad2 = new Squad("OKYHF5GS", "Senior Squad 1", "Senior", playerList2);
		Squad Squad3 = new Squad("8ABTY625", "U8 Squad 1", "U8", playerList3);
		
		squadData.add(Squad1);
		squadData.add(Squad2);
		squadData.add(Squad3);
		
		saveData();
	}

	/**
	 * Gets the current coachData list and returns it.
	 * @return the coachData
	 */
	public ArrayList<Coach> getCoachData() {
		return coachData;
	}

	/**
	 * Gets the coachData list parameter passed in and sets it to this instances coachData list.
	 * @param coachData the coachData to set
	 */
	public void setCoachData(ArrayList<Coach> coachData) {
		this.coachData = coachData;
	}

	/**
	 * Gets the current squadData list and returns it.
	 * @return the squadData
	 */
	public ArrayList<Squad> getSquadData() {
		return squadData;
	}


	/**
	 * Gets the squadData list parameter passed in and sets it to this instances squadData list.
	 * @param squadData the squadData to set
	 */
	public void setSquadData(ArrayList<Squad> squadData) {
		this.squadData = squadData;
	}
}