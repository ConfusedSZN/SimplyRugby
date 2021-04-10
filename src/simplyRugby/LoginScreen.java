package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField loginPasswordField;
	private JTextField loginTextFieldUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setTitle("Simply Rugby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton loginBtnLogin = new JButton("Login");
		loginBtnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtnLogin.setBounds(399, 301, 137, 38);
		contentPane.add(loginBtnLogin);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(344, 238, 240, 38);
		contentPane.add(loginPasswordField);
		
		loginTextFieldUsername = new JTextField();
		loginTextFieldUsername.setBounds(344, 173, 240, 38);
		contentPane.add(loginTextFieldUsername);
		loginTextFieldUsername.setColumns(10);
		
		JLabel loginLblUsername = new JLabel("Username:");
		loginLblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblUsername.setBounds(344, 158, 77, 14);
		contentPane.add(loginLblUsername);
		
		JLabel loginLblPassword = new JLabel("Password:");
		loginLblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblPassword.setBounds(344, 222, 77, 14);
		contentPane.add(loginLblPassword);
		
		JLabel loginLblInstruction = new JLabel("Please enter your\r\n");
		loginLblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblInstruction.setBounds(399, 76, 126, 50);
		contentPane.add(loginLblInstruction);
		
		JLabel loginLblInstruction2 = new JLabel("credentials below!");
		loginLblInstruction2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblInstruction2.setBounds(399, 101, 126, 50);
		contentPane.add(loginLblInstruction2);
		
		JLabel loginLblHeader = new JLabel("Simply Rugby");
		loginLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loginLblHeader.setBounds(364, 35, 200, 50);
		contentPane.add(loginLblHeader);
	}
}
