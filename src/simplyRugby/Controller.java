package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BCrypt.*;

public class Controller {

	private Model simplyRugbyModel;
	private SplashScreen splashScreen;
	
	public Controller()
	{
		
		LoginScreen loginScreen;
		
		simplyRugbyModel = new Model();
		splashScreen = new SplashScreen(this);
		loginScreen = new LoginScreen(this);
		splashScreen.setVisible(true);
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
		simplyRugbyModel.loadData();
		splashScreen.setVisible(false);
		loginScreen.setVisible(true);
	}
	
	public void displayLogin()
	{
		LoginScreen loginScreen;
		
		loginScreen = new LoginScreen(this);
		loginScreen.setVisible(true);
		
	}
	
	public void displayMenu(Coach coach)
	{
		MenuScreen menuScreen;
		
		menuScreen = new MenuScreen(coach, null, this);
		menuScreen.setVisible(true);
		
	}
	
	public void displayProfile(Coach coach)
	{
		ProfileScreen profileScreen;
		
		profileScreen = new ProfileScreen(coach, this);
		profileScreen.setVisible(true);
		
	}
	
	public void displaySquadView(Coach coach)
	{
		ViewSquadScreen squadViewScreen;
		squadViewScreen = new ViewSquadScreen(coach, findSquad(coach), this);
		squadViewScreen.setVisible(true);
	}
	
	public void displaySquadEdit(Coach coach)
	{
		EditSquadScreen squadEditScreen;
		squadEditScreen = new EditSquadScreen(coach, findSquad(coach), this);
		squadEditScreen.setVisible(true);
				
	}
	
	public void displayViewPlayer(Coach coach, String playerMemberID)
	{
		
		Player currentPlayer = findSpecificPlayerInformation(playerMemberID, findSquad(coach));
		
		ViewPlayerScreen viewPlayerScreen;
		viewPlayerScreen = new ViewPlayerScreen(coach, currentPlayer, this);
		viewPlayerScreen.setVisible(true);
	}
	
	public void displayEditPlayer(Coach coach, Player player)
	{
		
		EditPlayerScreen editPlayerScreen;
		editPlayerScreen = new EditPlayerScreen(coach, player, this);
		editPlayerScreen.setVisible(true);
		
	}
	
	public boolean requestSave()
	{
		
		simplyRugbyModel.saveData();
		
		return true;
	}
	
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
				MenuScreen menu = new MenuScreen(currentUser, findSquad(currentUser), this);
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
		
		DefaultTableModel model = new DefaultTableModel();
		
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
		
		DefaultTableModel retVal = new DefaultTableModel();
		
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
	
}