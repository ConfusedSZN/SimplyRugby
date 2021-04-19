package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Menu;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuScreen frame = new MenuScreen();
					frame.pack();
					frame.setSize(600, 400);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @param coachObj 
	 */
	public MenuScreen(Coach coachObj, Controller control) {
		Coach currentUser = coachObj;
		Controller simplyRugbyController = control;
		setTitle("Simply Rugby");
		setResizable(false);
		setBounds(660, 340, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit to login?", "Logout?",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.displayLogin();
			    dispose();
			      
			    } else 
			    {
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		JButton menuBtnLogout = new JButton("Logout");
		menuBtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayLogin();
			}
		});
		menuBtnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnLogout.setBounds(460, 11, 124, 31);
		contentPane.add(menuBtnLogout);
		
		/**
		 * menuLblHeader is the label that is at the head of the menu.
		 * It is used to display a greeting message to the Coach upon them opening the menu.
		 * A Calendar is used in this process to get the current time of the system.
		 */
		
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		
		String timeFrame = null;

		if(timeOfDay >= 0 && timeOfDay < 12){
			timeFrame = "Morning";
		         
		}else if(timeOfDay >= 12 && timeOfDay < 16){
			timeFrame = "Afternoon";
		
		}else if(timeOfDay >= 16 && timeOfDay < 24){
			timeFrame = "Evening";
		} else
		{
			timeFrame = "Day";
		}
		
		JLabel menuLblHeader = new JLabel("Good " + timeFrame + " Coach " + currentUser.getLastName());
		menuLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuLblHeader.setBounds(16, 8, 316, 31);
		contentPane.add(menuLblHeader);
		
		JLabel menuLblMenuHeader = new JLabel("Menu");
		menuLblMenuHeader.setFont(new Font("Tahoma", Font.PLAIN, 24));
		menuLblMenuHeader.setBounds(269, 97, 58, 32);
		contentPane.add(menuLblMenuHeader);
		
		JLabel menuMyProfileLabelIcon = new JLabel("");
		menuMyProfileLabelIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				simplyRugbyController.displayProfile(currentUser);
			}
		});
		menuMyProfileLabelIcon.setBounds(398, 2, 36, 36);
		BufferedImage loginImg = null;
		try {
			loginImg = ImageIO.read(new File(
				    "src/images/user.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon loginIcon = new ImageIcon(loginImg);
		menuMyProfileLabelIcon.setIcon(loginIcon);
		contentPane.add(menuMyProfileLabelIcon);

		JButton menuBtnViewSquad = new JButton("View Squad");
		menuBtnViewSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (currentUser.getCoachesSquadID().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Oh no! You don't have a squad linked to your account, please talk to administrator to resolve this issue.", "Alert!", JOptionPane.ERROR_MESSAGE);
				} else
				{
					dispose();
					simplyRugbyController.displaySquadView(currentUser);
				}
			}
		});
		menuBtnViewSquad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnViewSquad.setBounds(77, 136, 137, 38);
		contentPane.add(menuBtnViewSquad);
		
		JButton menuBtnPlaceholder_1 = new JButton("Placeholder");
		menuBtnPlaceholder_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder_1.setBounds(230, 136, 137, 38);
		contentPane.add(menuBtnPlaceholder_1);
		
		JButton menuBtnPlaceholder_1_1 = new JButton("Placeholder");
		menuBtnPlaceholder_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder_1_1.setBounds(383, 136, 137, 38);
		contentPane.add(menuBtnPlaceholder_1_1);
		
		JButton menuBtnPlaceholder_2 = new JButton("Placeholder");
		menuBtnPlaceholder_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder_2.setBounds(77, 190, 137, 38);
		contentPane.add(menuBtnPlaceholder_2);
		
		JButton menuBtnPlaceholder_2_1 = new JButton("Placeholder");
		menuBtnPlaceholder_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder_2_1.setBounds(230, 190, 137, 38);
		contentPane.add(menuBtnPlaceholder_2_1);
		
		JButton menuBtnPlaceholder_2_2 = new JButton("Placeholder");
		menuBtnPlaceholder_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder_2_2.setBounds(383, 190, 137, 38);
		contentPane.add(menuBtnPlaceholder_2_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(16, 53, 568, 299);
		contentPane.add(panel);
		
		JLabel menuLblMyProfileText = new JLabel("My Profile");
		menuLblMyProfileText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				simplyRugbyController.displayProfile(currentUser);
			}
		});
		
		menuLblMyProfileText.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		menuLblMyProfileText.setBounds(392, 40, 51, 13);
		contentPane.add(menuLblMyProfileText);
		
	}
}
