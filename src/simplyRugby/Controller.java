package simplyRugby;

/**
 * <H1> Class - Controller</H1>
 * 
 * This class is to be used to control the application. 
 * This class will contain all of the main functionality required for the software to preform its functions.
 * This class is responsible for opening different GUI views and passing them the data that they require for their functions.
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 *
 */

/**
 * Imports the Java ArrayList utility that is used throughout different functions required by the system.
 */
import java.util.ArrayList;
/**
 * Imports the Java Iterator utility that is used in the login process to iterate through the coaches. 
 */
import java.util.Iterator;
/**
 * Imports the Java Swing Table DefaultTableModel that is used throughout the program to display the different data via tables.
 */
import javax.swing.table.DefaultTableModel;
/**
 * Imports all of the BCrypt functions, BCrypt is a password hashing function that will be used during the login process. 
 * BCrypt includes functionality for hashing, salting and checking hashed passwords.
 * You can find out more about it in it's part of the Java Doc.
 */
import BCrypt.*;

/**
 * <p>
 * Controller class that will be passed around the application.
 * Views will be able to call functions from the controller upon actions.
 *
 */

public class Controller {

	/**
	 * simplyRugbyModel variable responsible for holding the information about the Model that is connected to the system.
	 */
	private Model simplyRugbyModel;
	/**
	 * splashScreen variable responsible for holding the instance of the Splash Screen used on software start.
	 */
	private SplashScreen splashScreen;
	
	/**
	 * <p>
	 * First Instance of the Controller that will be loaded on software start.
	 * Is used to load the initial start up sequence of the software.
	 * This includes loading the splash screen and updating the value of the loading bar.
	 */
	public Controller()
	{
		/**
		 * Creates and stores a new instance of the Model for use throughout the controller.
		 */
		simplyRugbyModel = new Model();
		/**
		 * Creates and stores a new SplashScreen that is displayed to the user.
		 */
		splashScreen = new SplashScreen(this);
		/**
		 * Sets the splash screen to visible.
		 */
		splashScreen.setVisible(true);
		/**
		 * For loop that is responsible for updating the value of the progress bar on the SplashScreen view.
		 */
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SplashScreen.splashProgressBar.setValue(i);
			SplashScreen.splashProgressBar.setStringPainted(true);
		}
		/**
		 * Model is then used to load the data into the system.
		 */
		simplyRugbyModel.loadData();
		/**
		 * Splash screen is disposed of and the login screen is then displayed to the user.
		 */
		splashScreen.dispose();
		displayLogin();
		
	}
	
	/**
	 * <p>
	 * Display login method.
	 * This method is used to display a new instance of the login screen.
	 * This method is used during startup and is also used in the logout method.
	 */
	public void displayLogin()
	{
		/**
		 * Declares loginScreen that holds an instance of the LoginScreen.
		 */
		LoginScreen loginScreen;
		
		/**
		 * Passes the controller to the loginScreen view that allows it to be called within the view.
		 * The view is then set to visible.
		 */
		loginScreen = new LoginScreen(this);
		loginScreen.setVisible(true);
		
	}
	
	/**
	 * @param coach is passed to display squad menu to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display menu method
	 * This method is used to display a new instance of the menu screen.
	 * This method is used throughout the system to display the menu.
	 * For example when the "Return to Menu" button is clicked.
	 */
	public void displayMenu(Coach coach)
	{
		/**
		 * Declares menuScreen that holds an instance of the MenuScreen.
		 */
		MenuScreen menuScreen;
		
		/**
		 * <p>
		 * Passes the coach object and the controller to the menuScreen view.
		 * This allows the view to access data from the coach record such as their name for the welcome message.
		 * The controller is also passed to the view to allow for calling of methods from within the controller.
		 * The view is then set to visible.
		 */
		menuScreen = new MenuScreen(coach, this);
		menuScreen.setVisible(true);
		
	}
	
	/**
	 * @param coach is passed to display profile to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display profile method.
	 * This method is used to display a new instance of the profile screen.
	 * Since the Coach information is required in this page, their information is passed along with the controller.
	 * This allows data reading straight from the Coach Object and function calling from the controller.
	 * 
	 */
	public void displayProfile(Coach coach)
	{
		/**
		 * Declares profileScreen that holds an instance of the ProfileScreen.
		 */
		ProfileScreen profileScreen;
		/**
		 * Passes the coach object and the controller to the profileScreen view.
		 * This allows the view to access data from the coach record such as their memberID for displaying it on the page. 
		 * The controller is also passed to the view to allow for calling of methods from within the controller.
		 * The view is then set to visible.
		 */
		profileScreen = new ProfileScreen(coach, this);
		profileScreen.setVisible(true);
		
	}
	
	/**
	 * 
	 * @param coach is passed to display squad view to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display squad view method.
	 * This method is used to display a new instance of the squad view screen.
	 * Since the Coach information is required in this page, their information is passed along with the squad and controller.
	 * This allows data reading straight from the Coach Object, Squad Object and function calling from the controller.
	 * In this page, the data from the squad will be displayed. For that reason we make the process simple, by parameter passing the squad object.
	 */
	
	public void displaySquadView(Coach coach)
	{
		/**
		 * Declares squadViewScreen that holds an instance of the ViewSquadScreen.
		 */
		ViewSquadScreen squadViewScreen;
		
		/**
		 * <p>
		 * Passes the coach object and the controller to the viewSquad screen.
		 * The view is then set to visible.
		 * The squad view is passed the coach, squad and the controller data.
		 * This allows for easy data reading and for method calling from the view.
		 * In this method, while constructing the new screen, the controller makes use of other functions that will find the squad data then return it for the constructor to use.
		 * The coach data and the controller are passed as normal and the view is set to be visible.
		 */
		squadViewScreen = new ViewSquadScreen(coach, findSquad(coach), this);
		squadViewScreen.setVisible(true);
	}
	
	/**
	 * 
	 * @param coach is passed to display player view to be used as a easy way to grab data for display in the view.
	 * @param playerMemberID is passed to the display player view to be used as a way to find data for the player easily. 
	 * <p>
	 * Display player view method.
	 * This method is used to display a new instance of the player view screen.
	 * Since this view requires player information, the method first needs to obtain that information.
	 * This is done by using the findSpecificPlayerInformation method. 
	 * This method returns a player object after being given the player member ID and the squad that they are a part of.
	 * Once this information is found it is passed to the view constructor.
	 * 
	 */
	public void displayViewPlayer(Coach coach, String playerMemberID)
	{
		
		/**
		 * Calls the findSpecificPlayerInformation method and stores the returned player object in the currentPlayer variable.
		 */
		Player currentPlayer = findSpecificPlayerInformation(playerMemberID, findSquad(coach));
		
		/**
		 * Declares squadViewScreen that holds an instance of the ViewPlayerScreen.
		 */
		
		ViewPlayerScreen viewPlayerScreen;
		/**
		 * <p>
		 * Passes the coach object, the currentPlayer object and the controller to the view player screen constructor
		 * The view is then set to visible.
		 */
		viewPlayerScreen = new ViewPlayerScreen(coach, currentPlayer, this);
		viewPlayerScreen.setVisible(true);
	}
	
	/**
	 * 
	 * @param coach is passed to display player view to be used as a easy way to grab data for display in the view.
	 * @param player is passed to display player view to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display player view method.
	 * This method is used to display a new instance of the player edit screen.
	 * Since this view requires player information, the method first needs to obtain that information.
	 * As the data already exists in the view, the data is passed from the view to the displayEditPlayer method for use in the next constructor.
	 * 
	 */
	
	public void displayEditPlayer(Coach coach, Player player)
	{
		
		/**
		 * Declares editPlayerScreen that holds an instance of the EditPlayerScreen.
		 */
		EditPlayerScreen editPlayerScreen;
		
		/**
		 * <p>
		 * Passes the coach object, the currentPlayer object and the controller to the edit player screen constructor
		 * The view is then set to visible.
		 */
		
		editPlayerScreen = new EditPlayerScreen(coach, player, this);
		editPlayerScreen.setVisible(true);
		
	}
	
	/**
	 * 
	 * @return is used to define if the save has taken place successfully or not.
	 * <p>
	 * Request Save Method.
	 * This method is used to interact with the Model.
	 * Upon calling of this method a save will be attempted within the model.
	 * If the data is saved successfully the function will return true.
	 */
	
	public boolean requestSave()
	{
		/**
		 * <p>
		 * Calls the saveData method from the Model.
		 */
		simplyRugbyModel.saveData();
		
		return true;
	}
	
	/**
	 * 
	 * @param username is the value entered by the user, this is passed to the method by the view.
	 * @param password is the value entered by the user, this is passed to the method by the view.
	 * @return true or false, determined by the authentication that takes place.
	 * <p>
	 * Authenticate User uses methods from the BCrypt import to preform checks on the password inputted by the user.
	 * The checkpw method is passed the inputted password from the user and the current stored hashed password.
	 * BCrypt then checks the passwords to make sure they match.
	 * If they match, retVal is set to True and the user will be logged in.
	 * If they do not match, retVal is set to False and the user will be displayed an error message.
	 * 
	 */
	
	public boolean authenticateUser(String username, String password)
	{
		
		boolean retVal = false;
		
		ArrayList<Coach> userList = simplyRugbyModel.getCoachData();
		
		Iterator<Coach> coachIt = userList.iterator();
		
		while(coachIt.hasNext() == true)
		{
			Coach currentUser = coachIt.next();
			
			if (currentUser.getUsername().equals(username) && BCrypt.checkpw(password, currentUser.getPassword()))
			{
				
				retVal = true;
				MenuScreen menu = new MenuScreen(currentUser, this);
				menu.setVisible(true);
				break;
			}
		}
		return retVal;
	}
	
	public boolean changePassword(String currentPassword, String newPassword, Coach currentUser)
	{
		
		boolean retVal = false;
		
		if (BCrypt.checkpw(currentPassword, currentUser.getPassword()))
		{
			currentUser.setPassword((BCrypt.hashpw(newPassword, BCrypt.gensalt())));
			simplyRugbyModel.saveData();
			retVal = true;
		}

		return retVal;
	}
	
	public Squad findSquad(Coach currentUser)
	{
		
		Squad currentSquad = null;
		
		String squadID = currentUser.getCoachesSquadID();
		
		ArrayList<Squad> squadList = simplyRugbyModel.getSquadData();
		
		Iterator<Squad> squadIt = squadList.iterator();
		
		while(squadIt.hasNext() == true)
		{
			
			currentSquad = squadIt.next();
			
			if (currentSquad.getSquadID().equals(squadID))
			{
				break;
			}
		}
		return currentSquad;
	}
	
	public Player findSpecificPlayerInformation(String playerMemberID, Squad squad)
	{
		
		ArrayList<Player> playerInformation = findAllPlayerInformation(squad);
		
		 Player retVal = null;
		
		for (Player p: playerInformation)
		{
			 if (p.getMemberID().equals(playerMemberID))
			 {
				retVal = p;
			 }
		}
		
		return retVal;
		
	}
	
	public ArrayList<Player> findAllPlayerInformation(Squad squad)
	{
		
		ArrayList<Player> retVal = squad.getPlayerList();
		
		return retVal;

	}
	
	public ArrayList<String> findAllPlayerSkills(Player playerObj)
	{
		
		ArrayList<String> retVal = new ArrayList<String>();
		
		Player currentPlayer = playerObj;
		
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			retVal.add(sc.getCategoryName());
		}
		
		return retVal;
		
	}
	
	public DefaultTableModel displaySquadPlayers(Squad squadObj)
	{
		Squad currentSquad = squadObj;
		
		DefaultTableModel model = new DefaultTableModel() {
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		ArrayList<Player> players = findAllPlayerInformation(currentSquad);

		model.addColumn("Player Member ID"); 
		model.addColumn("Player Name"); 
		model.addColumn("Position"); 
		model.addColumn("Overall Rating");
		
		for (Player p : players)
		{
			
			int overallSkill = 0;
			
			int skillCount = 0;
			
			ArrayList<SkillCategory> skillCategories = p.getPlayerSkills();
			
			for (SkillCategory sc : skillCategories)
			{
				ArrayList<Skill> skill = sc.getCategorySkillList();
				
				for (Skill s: skill)
				{
					overallSkill += s.getRating();
					skillCount += 1;
				}
				
			}
			
			overallSkill = overallSkill / skillCount;
			
			model.addRow(new Object[]{p.getMemberID(), p.getFirstName() + " " + p.getLastName(), p.getPosition(), overallSkill});
			
		}
		
		return model;

	}
	
	public DefaultTableModel displayPlayerSkills(Player playerObj)
	{
		
		DefaultTableModel retVal = new DefaultTableModel(){
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		Player currentPlayer = playerObj;
		
		retVal.addColumn("Skill Category");
		retVal.addColumn("Skill Name");
		retVal.addColumn("Rating");
		
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			ArrayList<Skill> skill = sc.getCategorySkillList();
				
			String currentSkillName = null;
			int currentSkillRating = 0;
			
			for (Skill s: skill)
			{
				currentSkillName = s.getSkillName();
				currentSkillRating = s.getRating();
				retVal.addRow(new Object[]{sc.getCategoryName(), currentSkillName , currentSkillRating});
			}
			
		}
		
		return retVal;
		
	}
	
	public String getSkillCategoryNote(Player playerObj, String categoryName)
	{
		
		Player currentPlayer = playerObj;
		
		String retVal = null;
		
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			if (sc.getCategoryName().equals(categoryName))
			{
				retVal = sc.getCategoryNotes();
			}
			
		}
		
		return retVal;
		
	}
	
	public boolean addSkillCategory(Player playerObj, String categoryName, String categoryNote)
	{
		
		boolean retVal = true;
		
		Player currentPlayer = playerObj;
		
		ArrayList<Skill> placeholderList = new ArrayList<Skill>();

		try {
			
			ArrayList<SkillCategory> currentSkillCategoryList = currentPlayer.getPlayerSkills();
			
			SkillCategory newCategory = new SkillCategory(categoryName, categoryNote , placeholderList);
			
			for (SkillCategory sc: currentSkillCategoryList)
			{
				if(sc.getCategoryName().toLowerCase().equals(newCategory.getCategoryName().toLowerCase()))
				{
					//Catches the duplicate name
					retVal = false;
					break;
				}
					
			}
			
			if (retVal == false)
			{
				
			} else 
			{
				currentSkillCategoryList.add(newCategory);
				
				retVal = true;
			}
			
			}
			catch(Exception e) {
			  //  Block of code to handle errors
			}
		
		return retVal;
		
	}
		
	public boolean addSkill(Player playerObj, String categoryName, String skillName, int skillRating)
	{
		
		boolean retVal = true;
		
		String newName = skillName;
		
		int newRating = skillRating;

		try {
			
			Player currentPlayer = playerObj;
			
			ArrayList<SkillCategory> currentSkillCategoryList = currentPlayer.getPlayerSkills();
			
			Skill newSkill = new Skill(skillName , skillRating);
			
			for (SkillCategory sc: currentSkillCategoryList)
			{
				if(sc.getCategoryName().toLowerCase().equals(categoryName.toLowerCase()))
				{
					
					ArrayList<Skill> currentSkillList = sc.getCategorySkillList();
					
					for (Skill s: currentSkillList)
					{
						if (s.getSkillName().toLowerCase().equals(newName))
						{
							retVal = false;
							break;
						}

					}
					
					if (retVal == false)
					{
						
					} else 
					{
						currentSkillList.add(newSkill);
						
						retVal = true;
					}
					
				}
				
				
				
			}
		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
			}
		
		return retVal;
		
	}
	
	public boolean editCategoryNote(Player playerObj, String categoryName, String newValue)
	{
		
		boolean retVal = false;
		
		Player currentPlayer = playerObj;
		
		String nameOfCategory = categoryName;
		
		String newNoteValue = newValue;
		
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			if (sc.getCategoryName().equals(nameOfCategory))
			{
				sc.setCategoryNotes(newNoteValue);
				retVal = true;
			}
			
		}
		
		return retVal;

	}
	
	public boolean editSkillRating(Player playerObj, String categoryName, String skillName, int newValue)
	{
		
		boolean retVal = false;
		
		Player currentPlayer = playerObj;
		
		String nameOfCategory = categoryName;
		
		String nameOfSkill = skillName;
		
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			if (sc.getCategoryName().equals(nameOfCategory))
			{
				
				ArrayList<Skill> skills = sc.getCategorySkillList();
				
				for (Skill s: skills)
				{
					
					if (s.getSkillName().equals(nameOfSkill))
					{
						
						s.setRating(newValue);
						
						retVal = true;
						
					}
					
				}
				
			}
			
		}
		return retVal;
	}
}