package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class ProfileScreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField profilePasswordInputConfirm;
	private JPasswordField profilePasswordInputNew;
	private JPasswordField profilePasswordInputCurrent;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public ProfileScreen() {
		setTitle("Simply Rugby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton profileBtnReturn = new JButton("Return to Menu");
		profileBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		profileBtnReturn.setBounds(450, 11, 124, 31);
		contentPane.add(profileBtnReturn);
		
		JLabel profileLblHeader = new JLabel("{Name}'s Profile");
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
		
		JLabel profileLblMemberID = new JLabel("{MemberID}");
		profileLblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profileLblMemberID.setBounds(53, 137, 90, 24);
		contentPane.add(profileLblMemberID);
		
		JLabel profileLblSquadID = new JLabel("{SquadID}");
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
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangePassword.setBounds(387, 306, 124, 31);
		contentPane.add(btnChangePassword);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(6, 53, 568, 299);
		contentPane.add(panel);
	}
}