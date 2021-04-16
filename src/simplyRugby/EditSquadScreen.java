package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EditSquadScreen extends JFrame {

	private JPanel contentPane;
	private JTextField editSquadSquadNameInput;
	private JTextField editSquadPlayerMemberInput;
	private JTable editSquadTablePlayerData;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSquadScreen frame = new EditSquadScreen();
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
	 * @param control 
	 * @param squad 
	 * @param coach 
	 */
	public EditSquadScreen(Coach coachObj, Squad squadObj, Controller control) {
		Coach currentUser = coachObj;
		Squad currentSquad = squadObj;
		Controller simplyRugbyController = control;
		setBounds(660, 340, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
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
		
		JButton editSquadBtnReturn = new JButton("Return to Menu");
		editSquadBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		editSquadBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editSquadBtnReturn.setBounds(450, 11, 124, 31);
		contentPane.add(editSquadBtnReturn);
		
		JLabel editSquadLblHeader = new JLabel("Editing " + currentSquad.getName());
		editSquadLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSquadLblHeader.setBounds(10, 11, 427, 31);
		contentPane.add(editSquadLblHeader);
		
		editSquadSquadNameInput = new JTextField();
		editSquadSquadNameInput.setText(currentSquad.getName());
		editSquadSquadNameInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSquadSquadNameInput.setBounds(35, 114, 196, 34);
		contentPane.add(editSquadSquadNameInput);
		editSquadSquadNameInput.setColumns(10);
		
		JLabel editSquadLblSquadNameTooltip = new JLabel("Squad Name:");
		editSquadLblSquadNameTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editSquadLblSquadNameTooltip.setBounds(35, 94, 78, 14);
		contentPane.add(editSquadLblSquadNameTooltip);
		
		JComboBox editSquadComboBoxAgeRange = new JComboBox();
		editSquadComboBoxAgeRange.setModel(new DefaultComboBoxModel(new String[] {"6 - 8", "U8", "U9", "U10", "U11", "U12", "U13", "U14", "U15", "U16", "U18", "U20", "Senior"}));
		
		switch(currentSquad.getAgeRange()) {
		  case "6 - 8":
			  editSquadComboBoxAgeRange.setSelectedIndex(0);
		    break;
		  case "U8":
			  editSquadComboBoxAgeRange.setSelectedIndex(1);
		    break;
		  case "U9":
			  editSquadComboBoxAgeRange.setSelectedIndex(2);
			    break;
		  case "U10":
			  editSquadComboBoxAgeRange.setSelectedIndex(3);
			    break;
		  case "U11":
			  editSquadComboBoxAgeRange.setSelectedIndex(4);
			    break;
		  case "U12":
			  editSquadComboBoxAgeRange.setSelectedIndex(5);
			    break;
		  case "U13":
			  editSquadComboBoxAgeRange.setSelectedIndex(6);
			    break;
		  case "U14":
			  editSquadComboBoxAgeRange.setSelectedIndex(7);
			    break;
		  case "U15":
			  editSquadComboBoxAgeRange.setSelectedIndex(8);
			    break;
		  case "U16":
			  editSquadComboBoxAgeRange.setSelectedIndex(9);
			    break;
		  case "U18":
			  editSquadComboBoxAgeRange.setSelectedIndex(10);
			    break;
		  case "U20":
			  editSquadComboBoxAgeRange.setSelectedIndex(11);
			    break;
		  case "Senior":
			  editSquadComboBoxAgeRange.setSelectedIndex(12);
			    break;
		  default:
			  editSquadComboBoxAgeRange.setSelectedIndex(-1);
		}
		
		editSquadComboBoxAgeRange.setBounds(237, 114, 180, 34);
		contentPane.add(editSquadComboBoxAgeRange);
		
		JLabel editSquadLblSquadAgeRangeToolTip = new JLabel("Squad Age Range:");
		editSquadLblSquadAgeRangeToolTip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editSquadLblSquadAgeRangeToolTip.setBounds(237, 95, 102, 14);
		contentPane.add(editSquadLblSquadAgeRangeToolTip);
		
		JButton editSquadBtnSaveAndReturn = new JButton("Save");
		editSquadBtnSaveAndReturn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		editSquadBtnSaveAndReturn.setBounds(424, 114, 150, 34);
		contentPane.add(editSquadBtnSaveAndReturn);
		
		JButton editSquadBtnRemoveSelectedPlayer = new JButton("Remove Selected Player");
		editSquadBtnRemoveSelectedPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editSquadBtnRemoveSelectedPlayer.setBounds(312, 171, 262, 36);
		contentPane.add(editSquadBtnRemoveSelectedPlayer);
		
		editSquadPlayerMemberInput = new JTextField();
		editSquadPlayerMemberInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSquadPlayerMemberInput.setColumns(10);
		editSquadPlayerMemberInput.setBounds(35, 173, 176, 34);
		contentPane.add(editSquadPlayerMemberInput);
		
		JButton editSquadBtnAddPlayer = new JButton("Add Player");
		editSquadBtnAddPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editSquadBtnAddPlayer.setBounds(216, 172, 93, 36);
		contentPane.add(editSquadBtnAddPlayer);
		
		JLabel editSquadLblPlayerMemberID = new JLabel("Player Member ID:");
		editSquadLblPlayerMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editSquadLblPlayerMemberID.setBounds(35, 159, 102, 14);
		contentPane.add(editSquadLblPlayerMemberID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 214, 539, 136);
		contentPane.add(scrollPane);
		
		ArrayList<Player> retVal = simplyRugbyController.findAllPlayerInformation(currentSquad);
		
		DefaultTableModel model = new DefaultTableModel()
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};

		editSquadTablePlayerData = new JTable(model);
		
		model.addColumn("Player Name"); 
		model.addColumn("Position"); 
		model.addColumn("Overall Rating");
		
		for (Player p : retVal)
		{
			
			int overallSkill = 0;
			
			int skillCount = 0;
			
			ArrayList<SkillCategory> skillCategories = p.getPlayerSkills();
			
			for (SkillCategory sc : skillCategories)
			{
				ArrayList<Skill> skill = sc.getCategorySkillList();
				
				for (Skill s: skill)
				{
					overallSkill += s.getRating();
					skillCount += 1;
				}
				
			}
			
			overallSkill = overallSkill / skillCount;
			
			model.addRow(new Object[]{p.getFirstName() + " " + p.getLastName(), p.getPosition(), overallSkill});
		}
		
		scrollPane.setViewportView(editSquadTablePlayerData);
	}
}