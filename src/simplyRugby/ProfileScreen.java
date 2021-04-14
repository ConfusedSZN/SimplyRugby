package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileScreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField profilePasswordInputConfirm;
	private JPasswordField profilePasswordInputNew;
	private JPasswordField profilePasswordInputCurrent;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileScreen frame = new ProfileScreen();
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
	 * @param control 
	 */
	public ProfileScreen(Coach coachObj, Controller control) {
		Coach currentUser = coachObj;
		Controller simplyRugbyController = control;
		setTitle("Simply Rugby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton profileBtnReturn = new JButton("Return to Menu");
		profileBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(coachObj);
			}
		});
		profileBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		profileBtnReturn.setBounds(450, 11, 124, 31);
		contentPane.add(profileBtnReturn);
		
		JLabel profileLblHeader = new JLabel(currentUser.getFirstName() + "'s Profile");
		profileLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profileLblHeader.setBounds(10, 8, 155, 31);
		contentPane.add(profileLblHeader);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMyProfile.setBounds(256, 81, 105, 31);
		contentPane.add(lblMyProfile);
		
		JLabel profileLblMemberToolTip = new JLabel("My Member ID:");
		profileLblMemberToolTip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblMemberToolTip.setBounds(30, 113, 124, 22);
		contentPane.add(profileLblMemberToolTip);
		
		JLabel profileLblSquadIDToolTip = new JLabel("My Squad ID:");
		profileLblSquadIDToolTip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblSquadIDToolTip.setBounds(30, 163, 109, 22);
		contentPane.add(profileLblSquadIDToolTip);
		
		JLabel profileLblMemberID = new JLabel(currentUser.getMemberID());
		profileLblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profileLblMemberID.setBounds(53, 137, 90, 24);
		contentPane.add(profileLblMemberID);
		
		JLabel profileLblSquadID = new JLabel(currentUser.getCoachesSquadID());
		profileLblSquadID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profileLblSquadID.setBounds(53, 185, 77, 24);
		contentPane.add(profileLblSquadID);
		
		JLabel profileLblChangePassword = new JLabel("Change Password:");
		profileLblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblChangePassword.setBounds(348, 113, 155, 22);
		contentPane.add(profileLblChangePassword);
		
		profilePasswordInputConfirm = new JPasswordField();
		profilePasswordInputConfirm.setBounds(348, 267, 202, 34);
		contentPane.add(profilePasswordInputConfirm);
		
		profilePasswordInputNew = new JPasswordField();
		profilePasswordInputNew.setBounds(348, 213, 202, 34);
		contentPane.add(profilePasswordInputNew);
		
		profilePasswordInputCurrent = new JPasswordField();
		profilePasswordInputCurrent.setBounds(348, 159, 202, 34);
		contentPane.add(profilePasswordInputCurrent);
		
		JLabel profileLblCurrentTooltip = new JLabel("Current Password:");
		profileLblCurrentTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblCurrentTooltip.setBounds(348, 143, 105, 14);
		contentPane.add(profileLblCurrentTooltip);
		
		JLabel profileLblNewPassword = new JLabel("New Password:");
		profileLblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblNewPassword.setBounds(348, 196, 105, 14);
		contentPane.add(profileLblNewPassword);
		
		JLabel profileLblConfirmPassword = new JLabel("Confirm Password:");
		profileLblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblConfirmPassword.setBounds(348, 253, 105, 14);
		contentPane.add(profileLblConfirmPassword);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (profilePasswordInputConfirm.getText().trim().isEmpty() || profilePasswordInputNew.getText().trim().isEmpty() || profilePasswordInputCurrent.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Oh No! It appears you have missed an input, please try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
				} else if (profilePasswordInputNew.getText().equals(profilePasswordInputConfirm.getText()))
				{
					
					boolean result = control.changePassword(profilePasswordInputCurrent.getText(), profilePasswordInputNew.getText(), currentUser);
					
					if(result)
					{
						JOptionPane.showMessageDialog(contentPane, "Yay! Your new password has been saved!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(contentPane, "Oh no! It appears that an error has occured. Please try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
					}
					
				} else
				{
					JOptionPane.showMessageDialog(contentPane, "Oh No! Your new passwords don't match. Make sure that you input your new password into both the New Password and Confirm Password inputs correctly. Please Try Again.", "Alert!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangePassword.setBounds(387, 306, 124, 31);
		contentPane.add(btnChangePassword);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(6, 53, 568, 299);
		contentPane.add(panel);
	}
}