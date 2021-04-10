package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class ViewPlayerScreen extends JFrame {

	private JPanel contentPane;
	private JTable viewPlayerTableDisplaySkills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlayerScreen frame = new ViewPlayerScreen();
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
	public ViewPlayerScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 113, 300, 235);
		contentPane.add(scrollPane);
		
		viewPlayerTableDisplaySkills = new JTable();
		viewPlayerTableDisplaySkills.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		viewPlayerTableDisplaySkills.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Skill Category", "Skill Name", "Rating"
			}
		));
		scrollPane.setViewportView(viewPlayerTableDisplaySkills);
		
		JButton viewPlayerBtnViewNotes = new JButton("View Notes on Selected Category");
		viewPlayerBtnViewNotes.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnViewNotes.setBounds(294, 66, 214, 36);
		contentPane.add(viewPlayerBtnViewNotes);
		
		JLabel viewPlayerLblHeader = new JLabel("Viewing {Player Name}");
		viewPlayerLblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader.setBounds(20, 11, 356, 30);
		contentPane.add(viewPlayerLblHeader);
		
		JButton viewPlayerBtnReturn = new JButton("Return to Menu");
		viewPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnReturn.setBounds(439, 14, 124, 31);
		contentPane.add(viewPlayerBtnReturn);
		
		JLabel viewPlayerLblHeader2 = new JLabel("Player Information");
		viewPlayerLblHeader2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader2.setBounds(26, 69, 154, 30);
		contentPane.add(viewPlayerLblHeader2);
		
		JLabel viewPlayerLblPlayerIDTooltip = new JLabel("Player ID:");
		viewPlayerLblPlayerIDTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblPlayerIDTooltip.setBounds(26, 113, 63, 24);
		contentPane.add(viewPlayerLblPlayerIDTooltip);
		
		JLabel viewPlayerLblPositionTooltip = new JLabel("Position:");
		viewPlayerLblPositionTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblPositionTooltip.setBounds(26, 159, 63, 24);
		contentPane.add(viewPlayerLblPositionTooltip);
		
		JLabel viewPlayerLblECNameToolTip = new JLabel("Emergency Contact Name:");
		viewPlayerLblECNameToolTip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblECNameToolTip.setBounds(26, 208, 171, 24);
		contentPane.add(viewPlayerLblECNameToolTip);
		
		JLabel viewPlayerLblECNumberTooltip = new JLabel("Emergency Contact Phone Number:");
		viewPlayerLblECNumberTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblECNumberTooltip.setBounds(26, 258, 207, 24);
		contentPane.add(viewPlayerLblECNumberTooltip);
		
		JLabel viewPlayerLblPlayerID = new JLabel("{PlayerID}");
		viewPlayerLblPlayerID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPlayerID.setBounds(26, 134, 154, 24);
		contentPane.add(viewPlayerLblPlayerID);
		
		JLabel viewPlayerLblPosition = new JLabel("{position}");
		viewPlayerLblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPosition.setBounds(26, 182, 154, 24);
		contentPane.add(viewPlayerLblPosition);
		
		JLabel viewPlayerLblECName = new JLabel("{Emergency Contact Name}");
		viewPlayerLblECName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECName.setBounds(26, 234, 207, 24);
		contentPane.add(viewPlayerLblECName);
		
		JLabel viewPlayerLblECNumber = new JLabel("{Emergency Contact Number}");
		viewPlayerLblECNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECNumber.setBounds(26, 282, 214, 24);
		contentPane.add(viewPlayerLblECNumber);
		
		JButton btnEditPlayer = new JButton("Edit Player");
		btnEditPlayer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnEditPlayer.setBounds(56, 317, 124, 31);
		contentPane.add(btnEditPlayer);
		
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(20, 52, 543, 303);
		contentPane.add(outlineRectangle);
	}
}
