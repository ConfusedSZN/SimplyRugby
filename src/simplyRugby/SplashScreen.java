package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	protected static JProgressBar splashProgressBar;

	/**
	 * Create the frame.
	 */
	public SplashScreen(Controller control) {
		Controller simplyRugbyController = control;
		setTitle("Simply Rugby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(660, 340, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		splashProgressBar = new JProgressBar();
		splashProgressBar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		splashProgressBar.setToolTipText("");
		splashProgressBar.setBounds(50, 320, 500, 40);
		contentPane.add(splashProgressBar);
		
		JLabel splashLblPleaseWait = new JLabel("Please Wait");
		splashLblPleaseWait.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		splashLblPleaseWait.setBounds(220, 269, 159, 40);
		contentPane.add(splashLblPleaseWait);
		
		JLabel splashLblNowLoading = new JLabel("Now Loading");
		splashLblNowLoading.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		splashLblNowLoading.setBounds(206, 218, 174, 40);
		contentPane.add(splashLblNowLoading);
		
		JLabel splashLblSimplyRugby = new JLabel("Simply Rugby");
		splashLblSimplyRugby.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		splashLblSimplyRugby.setBounds(90, 11, 412, 78);
		contentPane.add(splashLblSimplyRugby);
	}
}
