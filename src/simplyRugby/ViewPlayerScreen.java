package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class ViewPlayerScreen extends JFrame {

	private JPanel contentPane;
	private JTable viewPlayerTableDisplaySkills;

	/**
	 * Launch the application.
	 
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
	*/
	/**
	 * Create the frame.
	 * @param currentPlayer 
	 * @param coach 
	 * @param control 
	 */
	public ViewPlayerScreen(Coach coachObj, Player playerObj, Controller control) {
		Coach currentUser = coachObj;
		Player currentPlayer = playerObj;
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
			        "Are you sure you want to exit to the main menu?", "Return to Menu?",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.displayMenu(currentUser);
			    dispose();
			      
			    } else 
			    {
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 113, 300, 235);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel()
		{
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		model = simplyRugbyController.displayPlayerSkills(currentPlayer);
		
		viewPlayerTableDisplaySkills = new JTable(model);
	
		scrollPane.setViewportView(viewPlayerTableDisplaySkills);
		
		JButton viewPlayerBtnViewNotes = new JButton("View Notes on Selected Category");
		viewPlayerBtnViewNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column = 0;
				
				int row = viewPlayerTableDisplaySkills.getSelectedRow();
				
				String categoryName = viewPlayerTableDisplaySkills.getModel().getValueAt(row, column).toString();
				
				String msgContainer = simplyRugbyController.getSkillCategoryNote(currentPlayer, categoryName);
				
				JTextArea msg = new JTextArea(msgContainer);
				msg.setLineWrap(true);
				msg.setWrapStyleWord(true);
				msg.setEditable(false);
				JScrollPane MsgScrollPane = new JScrollPane(msg);
				JOptionPane.showMessageDialog(null, MsgScrollPane);
			}
		});
		viewPlayerBtnViewNotes.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnViewNotes.setBounds(294, 66, 214, 36);
		contentPane.add(viewPlayerBtnViewNotes);
		
		JLabel viewPlayerLblHeader = new JLabel("Viewing " + currentPlayer.getFirstName() + " " + currentPlayer.getLastName());
		viewPlayerLblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader.setBounds(20, 11, 356, 30);
		contentPane.add(viewPlayerLblHeader);
		
		JButton viewPlayerBtnReturn = new JButton("Return to Menu");
		viewPlayerBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		viewPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnReturn.setBounds(439, 14, 124, 31);
		contentPane.add(viewPlayerBtnReturn);
		
		JLabel viewPlayerLblHeader2 = new JLabel("Player Information");
		viewPlayerLblHeader2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader2.setBounds(26, 69, 154, 30);
		contentPane.add(viewPlayerLblHeader2);
		
		JLabel viewPlayerLblPlayerIDTooltip = new JLabel("Player Scrums ID:");
		viewPlayerLblPlayerIDTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblPlayerIDTooltip.setBounds(26, 113, 110, 24);
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
		
		JLabel viewPlayerLblPlayerID = new JLabel(currentPlayer.getScrumsID());
		viewPlayerLblPlayerID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPlayerID.setBounds(26, 134, 207, 24);
		contentPane.add(viewPlayerLblPlayerID);
		
		JLabel viewPlayerLblPosition = new JLabel(currentPlayer.getPosition());
		viewPlayerLblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPosition.setBounds(26, 182, 215, 24);
		contentPane.add(viewPlayerLblPosition);
		
		JLabel viewPlayerLblECName = new JLabel(currentPlayer.getEmergencyContactName());
		viewPlayerLblECName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECName.setBounds(26, 234, 207, 24);
		contentPane.add(viewPlayerLblECName);
		
		JLabel viewPlayerLblECNumber = new JLabel(currentPlayer.getEmergencyContactNo());
		viewPlayerLblECNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECNumber.setBounds(26, 282, 214, 24);
		contentPane.add(viewPlayerLblECNumber);
		
		JButton btnEditPlayer = new JButton("Edit Player");
		btnEditPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayEditPlayer(coachObj, currentPlayer);
			}
		});
		btnEditPlayer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnEditPlayer.setBounds(56, 317, 124, 31);
		contentPane.add(btnEditPlayer);
		
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(20, 52, 543, 303);
		contentPane.add(outlineRectangle);
	}
}
