package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

import BCrypt.*;

public class Controller {

	private Model simplyRugbyModel;
	private SplashScreen splashScreen;
	private LoginScreen loginScreen;
	
	public Controller()
	{
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
	
	public boolean authenticateUser(String username, String password)
	{
		
		boolean retVal = false;
		
		ArrayList<Coach> userList = simplyRugbyModel.getCoachData();
		
		Iterator<Coach> it = userList.iterator();
		
		while(it.hasNext() == true)
		{
			Coach currentUser = it.next();
			
			if (currentUser.getUsername().equals(username) && BCrypt.checkpw(password, currentUser.getPassword()))
			{
				retVal = true;
				
				Coach coachObj = currentUser;
		
				loginScreen.setVisible(false);
				
				MenuScreen menu = new MenuScreen(coachObj, this);
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
	
}