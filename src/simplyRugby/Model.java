package simplyRugby;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import BCrypt.BCrypt;

public class Model {

	private ArrayList<Coach> coachData = new ArrayList<Coach>();
	private ArrayList<Squad> squadData = new ArrayList<Squad>();
	
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
		
		/**
		 * Data Prepopulation for Coach.
		 */
		String coachPassword1 = "123";
		String coachPassword2 = "456";
		String coachPassword3 = "789";
		String passwordHashed1 = BCrypt.hashpw(coachPassword1, BCrypt.gensalt());
		String passwordHashed2 = BCrypt.hashpw(coachPassword2, BCrypt.gensalt());
		String passwordHashed3 = BCrypt.hashpw(coachPassword3, BCrypt.gensalt());
		
		coachData.add(new Coach("6SH6A521", "Kris", "Crawford","Forbes","krisforbes@simplyrugby.com", "07751259892", "57", "Boat Lane", "Reedham", "NR13 5WE", "Kris", passwordHashed1, "H26YZA99"));
		coachData.add(new Coach("4B3NR2SK", "Tristan", "McIntosh","Ritchie","tristanritchie@simplyrugby.com", "07043645025", "78", "Farburn Terrace", "Reedham", "NR13 8WZ", "Tristan",passwordHashed2 , ""));
		coachData.add(new Coach("B0P2BJR6", "Angus", "MacDonald","Stevenson","angusstevenson@simplyrugby.com", "07774612118", "89", "Osborne Road", "Reedham", "NR13 4GH", "Angus", passwordHashed3 , "8ABTY625"));
		
		/**
		 * Data prepopulation for skills
		 */
		ArrayList<Skill> skillList1 = new ArrayList<Skill>();
		ArrayList<Skill> skillList2 = new ArrayList<Skill>();
		ArrayList<Skill> skillList3 = new ArrayList<Skill>();
		
		Skill Skill1 = new Skill("Speed", 33);
		Skill Skill2 = new Skill("Decision Making", 66);
		Skill Skill3 = new Skill("Penality Taking", 99);
		
		skillList1.add(Skill1);
		skillList2.add(Skill2);
		skillList3.add(Skill3);
		
		/**
		 * Data prepopulation for skill categories
		 */
		
		SkillCategory Category1 = new SkillCategory("Physical", "Skills to do with Physical attributes.", skillList1);
		SkillCategory Category2 = new SkillCategory("Mental", "Skills to do with Mental activities.", skillList2);
		SkillCategory Category3 = new SkillCategory("Kicking", "Skills to do with Kicking the ball.", skillList3);
	
		/**
		 * Data prepopulation for players
		 */
		
		Player Player1 = new Player();
		Player Player2 = new Player();
		Player Player3 = new Player();
		
		/**
		 * Data Prepopulation for Squad's.
		 */
		
		ArrayList<Player> playerList1 = null;
		ArrayList<Player> playerList2 = null;
		ArrayList<Player> playerList3 = null;
		
		playerList1.add(Player1);
		playerList2.add(Player2);
		playerList3.add(Player3);
		
		Squad Squad1 = new Squad();
		Squad Squad2 = new Squad();
		Squad Squad3 = new Squad();
		
		saveData();
	}

	/**
	 * @return the coachData
	 */
	public ArrayList<Coach> getCoachData() {
		return coachData;
	}

	/**
	 * @param coachData the coachData to set
	 */
	public void setCoachData(ArrayList<Coach> coachData) {
		this.coachData = coachData;
	}

	/**
	 * @return the squadData
	 */
	public ArrayList<Squad> getSquadData() {
		return squadData;
	}


	/**
	 * @param squadData the squadData to set
	 */
	public void setSquadData(ArrayList<Squad> squadData) {
		this.squadData = squadData;
	}
}