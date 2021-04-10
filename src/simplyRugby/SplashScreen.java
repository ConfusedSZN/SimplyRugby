package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		setTitle("Simply Rugby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JProgressBar splashProgressBar = new JProgressBar();
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
