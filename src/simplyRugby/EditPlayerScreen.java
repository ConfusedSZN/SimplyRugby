package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class EditPlayerScreen extends JFrame {

	private JPanel contentPane;
	private JTable editPlayerTableSkillData;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPlayerScreen frame = new EditPlayerScreen();
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
	 * @param playerObj 
	 * @param coachObj 
	 */
	public EditPlayerScreen(Coach coachObj, Player playerObj, Controller control) {
		setTitle("Simply Rugby");
		Coach currentUser = coachObj;
		Player currentPlayer = playerObj;
		Controller simplyRugbyController = control;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton editPlayerBtnReturn = new JButton("Return to Menu");
		editPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		editPlayerBtnReturn.setBounds(457, 20, 124, 31);
		dispose();
		simplyRugbyController.displayMenu(currentUser);
		contentPane.add(editPlayerBtnReturn);
		
		JLabel EditPlayerLblHeader = new JLabel("Editing " + currentPlayer.getFirstName() + " " + currentPlayer.getLastName());
		EditPlayerLblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		EditPlayerLblHeader.setBounds(16, 20, 360, 30);
		contentPane.add(EditPlayerLblHeader);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 75, 360, 271);
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
		
		editPlayerTableSkillData = new JTable(model);
		
		scrollPane.setViewportView(editPlayerTableSkillData);
		
		JLabel editPlayerLblPlayerPositionTooltip = new JLabel("Player Position:");
		editPlayerLblPlayerPositionTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editPlayerLblPlayerPositionTooltip.setBounds(28, 75, 82, 20);
		contentPane.add(editPlayerLblPlayerPositionTooltip);
	
		
		JComboBox editPlayerComboBoxPlayerPosition = new JComboBox();
		editPlayerComboBoxPlayerPosition.setModel(new DefaultComboBoxModel(new String[] {"Loosehead Prop", "Hooker", "Tighthead Prop", "Second Row", "Blindside Flanker", "Openside Flanker"
				, "Number 8", "Scrum Half", "Fly Half", "Inside Centre", "Outside Centre", "Left Wing", "Right Wing", "Full Back"}));
		switch(currentPlayer.getPosition()) {
		  case "Loosehead Prop":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(0);
		    break;
		  case "Hooker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(1);
		    break;
		  case "Tighthead Prop":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(2);
		    break;
		  case "Second Row":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(3);
		    break;
		  case "Blindside Flanker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(4);
		    break;
		  case "Openside Flanker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(5);
		    break;
		  case "Number 8":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(6);
		    break;
		  case "Scrum Half":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(7);
		    break;
		  case "Fly Half":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(8);
		    break;
		  case "Inside Centre":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(9);
		    break;
		  case "Outside Centre":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(10);
		    break;
		  case "Left Wing":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(11);
		    break;
		  case "Right Wing":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(12);
		    break;
		  case "Full Back":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(13);
		    break;
		  default:
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(-1);
		}
		editPlayerComboBoxPlayerPosition.setBounds(28, 98, 176, 34);
		contentPane.add(editPlayerComboBoxPlayerPosition);
		
		JButton editPlayerBtnAddCategory = new JButton("Add Category");
		editPlayerBtnAddCategory.setBounds(28, 136, 176, 36);
		contentPane.add(editPlayerBtnAddCategory);
		
		JButton editPlayerBtnAddSkillToCategory = new JButton("Add Skill to Category");
		editPlayerBtnAddSkillToCategory.setBounds(28, 176, 176, 36);
		contentPane.add(editPlayerBtnAddSkillToCategory);
		
		JButton editPlayerBtnEditSkillRating = new JButton("Edit Skill Rating");
		editPlayerBtnEditSkillRating.setBounds(28, 216, 176, 36);
		contentPane.add(editPlayerBtnEditSkillRating);
		
		JButton editPlayerbtnEditCategoryNote = new JButton("Edit Category Note");
		editPlayerbtnEditCategoryNote.setBounds(28, 256, 176, 36);
		contentPane.add(editPlayerbtnEditCategoryNote);
		
		JButton editPlayerBtnSaveChanges = new JButton("Save Changes");
		editPlayerBtnSaveChanges.setBounds(44, 303, 152, 36);
		contentPane.add(editPlayerBtnSaveChanges);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(16, 61, 568, 299);
		contentPane.add(panel);
	}
}
