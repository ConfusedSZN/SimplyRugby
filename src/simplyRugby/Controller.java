package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public ArrayList<Player> findPlayerInformation(Squad squad)
	{
		
		ArrayList<Player> retVal = squad.getPlayerList();
		
		return retVal;

	}
}