package simplyRugby;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	
	private void saveData()
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
		System.out.println("We doing the ting");
		coachData.add(new Coach("6SH6A521", "Kris", "Crawford","Forbes","krisforbes@simplyrugby.com", "07751259892", "57", "Boat Lane", "Reedham", "NR13 5WE", "Kris", "123", "H26YZA99"));
		coachData.add(new Coach("4B3NR2SK", "Tristan", "McIntosh","Ritchie","tristanritchie@simplyrugby.com", "07043645025", "78", "Farburn Terrace", "Reedham", "NR13 8WZ", "Tristan", "123", ""));
		coachData.add(new Coach("B0P2BJR6", "Angus", "MacDonald","Stevenson","angusstevenson@simplyrugby.com", "07774612118", "89", "Osborne Road", "Reedham", "NR13 4GH", "Angus", "123", "8ABTY625"));
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