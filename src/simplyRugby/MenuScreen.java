package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class MenuScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MenuScreen() {
		setTitle("Simply Rugby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton menuBtnLogout = new JButton("Logout");
		menuBtnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnLogout.setBounds(460, 11, 124, 31);
		contentPane.add(menuBtnLogout);
		
		JLabel menuLblHeader = new JLabel("Good {TimeFrame} Coach {Name}");
		menuLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuLblHeader.setBounds(16, 8, 316, 31);
		contentPane.add(menuLblHeader);
		
		JLabel menuLblMenuHeader = new JLabel("Menu");
		menuLblMenuHeader.setFont(new Font("Tahoma", Font.PLAIN, 24));
		menuLblMenuHeader.setBounds(269, 97, 58, 32);
		contentPane.add(menuLblMenuHeader);
		
		JLabel menuLblMyProfile = new JLabel("My Profile");
		menuLblMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuLblMyProfile.setBounds(387, 7, 63, 38);
		contentPane.add(menuLblMyProfile);
		
		JButton menuBtnPlaceholder = new JButton("Placeholder");
		menuBtnPlaceholder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnPlaceholder.setBounds(77, 136, 137, 38);
		contentPane.add(menuBtnPlaceholder);
		
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
		
	}
}
