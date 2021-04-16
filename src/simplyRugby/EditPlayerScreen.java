package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

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
		setBounds(660, 340, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit to the main menu? \n Your changes will be saved.", "Return to Menu?",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.requestSave();
			    simplyRugbyController.displayMenu(currentUser);
			    dispose();
			      
			    } else 
			    { 
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		JButton editPlayerBtnReturn = new JButton("Return to Menu");
		editPlayerBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		editPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		editPlayerBtnReturn.setBounds(457, 20, 124, 31);
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
		editPlayerBtnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame popup;
				
				popup = new JFrame(); 
				
				boolean retVal = false;
				
				String categoryName = JOptionPane.showInputDialog(popup, "Please enter the name of the new Skill Category.");
				
				if (categoryName.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't entered a value for the name of the skill category. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				} else
				{
					
					String categoryNote = JOptionPane.showInputDialog(popup, "Please enter a note for the new category: " + categoryName + ".\n Please note this is not required and can be updated later.");
					
					retVal = simplyRugbyController.addSkillCategory(playerObj, categoryName, categoryNote);
					
					if (retVal == true)
					{
						JOptionPane.showMessageDialog(contentPane, "Yay! You have created a new Category!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
					} else 
					{
						JOptionPane.showMessageDialog(contentPane, "Uh Oh! That skill category already exists! \n Please enter a unique name for the new category.", "Alert!", JOptionPane.WARNING_MESSAGE);	
					}
				}
				
			}
		});
		
		editPlayerBtnAddCategory.setBounds(28, 136, 176, 36);
		contentPane.add(editPlayerBtnAddCategory);
		
		JButton editPlayerBtnAddSkillToCategory = new JButton("Add Skill to Category");
		editPlayerBtnAddSkillToCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame popup;
				
				popup = new JFrame(); 
				
				boolean retVal = false;
				
				ArrayList<String> skillCategoryNames = simplyRugbyController.findAllPlayerSkills(currentPlayer);
				
				String[] choices = skillCategoryNames.toArray(new String[skillCategoryNames.size()]);
			    String categoryInput = (String) JOptionPane.showInputDialog(null, "Please choose a category to add a skill to!",
			        "Choose a Category", JOptionPane.QUESTION_MESSAGE, null,
			                                                                       
			        choices, // Array of choices
			        choices[1]); // Initial choice
			    
			    if (categoryInput.trim().isEmpty())
			    {
			    	JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a value for the name of the skill category. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    } else 
			    {
			    	String skillName = JOptionPane.showInputDialog(popup, "Please enter the name of the new Skill.");
			    	
			    	if (skillName.trim().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't inputted a value for the name of the skill. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    	} else
			    	{
			    		
			    		try {
			    			int skillRating  = Integer.parseInt(JOptionPane.showInputDialog(popup, "Please enter the rating of the new Skill. \n Numbers between 0 - 100 only"));
			    			
			    			if (skillRating < 0 || skillRating > 100)
			    			{
			    				JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you entered an unexpected number. Please input numbers between 0 - 100 only! \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    			} else 
			    			{
			    				 retVal = simplyRugbyController.addSkill(playerObj, categoryInput, skillName, skillRating);
			    			}
			    			
			    			}
			    			catch(NumberFormatException numError) {
			    				JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you entered an unexpected character. Please input numbers between 0 - 100 only! \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    			} catch (Exception otherError){
			    				
			    			}
			    		
			    		if (retVal == true)
			    		{
			    			simplyRugbyController.displayEditPlayer(coachObj, currentPlayer);
			    			dispose();
			    			JOptionPane.showMessageDialog(contentPane, "Yay! You have created a new Skill!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
			    		} else 
			    		{
			    			JOptionPane.showMessageDialog(contentPane, "Uh Oh! That skill already exists! \n Please enter a unique name for the new skill.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    		}
			    		
			    	}
			    	
			    }
			    
			}
		});

		editPlayerBtnAddSkillToCategory.setBounds(28, 176, 176, 36);
		contentPane.add(editPlayerBtnAddSkillToCategory);
		
		JButton editPlayerBtnEditSkillRating = new JButton("Edit Skill Rating");
		editPlayerBtnEditSkillRating.setBounds(28, 216, 176, 36);
		contentPane.add(editPlayerBtnEditSkillRating);
		
		JButton editPlayerbtnEditCategoryNote = new JButton("Edit Category Note");
		editPlayerbtnEditCategoryNote.setBounds(28, 256, 176, 36);
		contentPane.add(editPlayerbtnEditCategoryNote);
		
		JButton editPlayerBtnSaveChanges = new JButton("Save Changes");
		editPlayerBtnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlayer.setPosition(editPlayerComboBoxPlayerPosition.getSelectedItem().toString());  
				
				boolean saveStatus = simplyRugbyController.requestSave();
				
				if (saveStatus == true)
				{
					JOptionPane.showMessageDialog(contentPane, "Changes Saved Successfully", "Save", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(contentPane, "There has been an issue saving your changes, please try again.", "Save", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		editPlayerBtnSaveChanges.setBounds(44, 303, 152, 36);
		contentPane.add(editPlayerBtnSaveChanges);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(16, 61, 568, 299);
		contentPane.add(panel);
	}
}
