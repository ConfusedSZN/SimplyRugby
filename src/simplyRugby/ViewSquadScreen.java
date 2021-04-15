package simplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BCrypt.BCrypt;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSquadScreen extends JFrame {

	private JPanel contentPane;
	private JTable viewSquadTablePlayerData;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSquadScreen frame = new ViewSquadScreen();
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
	 * @param squadObj 
	 * @param coachObj 
	 */
	public ViewSquadScreen(Coach coachObj, Squad squadObj, Controller control) {
		Coach currentUser = coachObj;
		Squad currentSquad = squadObj;
		Controller simplyRugbyController = control;
	
		setTitle("Simply Rugby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton viewSquadBtnReturn = new JButton("Return to Menu");
		viewSquadBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		viewSquadBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewSquadBtnReturn.setBounds(460, 11, 124, 31);
		contentPane.add(viewSquadBtnReturn);
		
		JLabel lblsquadNameAt = new JLabel(currentSquad.getName() + " at " + currentSquad.getAgeRange() + " Information");
		lblsquadNameAt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsquadNameAt.setBounds(10, 11, 440, 31);
		contentPane.add(lblsquadNameAt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 93, 528, 202);
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
		
		viewSquadTablePlayerData = new JTable(model);
		
		model.addColumn("Player Member ID"); 
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
			
			model.addRow(new Object[]{p.getMemberID(), p.getFirstName() + " " + p.getLastName(), p.getPosition(), overallSkill});
			
		}
		
		scrollPane.setViewportView(viewSquadTablePlayerData);
		
		JButton viewSquadBtnViewSelectedPlayer = new JButton("View Selected Player");
		viewSquadBtnViewSelectedPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column = 0;
				
				int row = viewSquadTablePlayerData.getSelectedRow();
				
				String playerID = viewSquadTablePlayerData.getModel().getValueAt(row, column).toString();
					
				simplyRugbyController.displayViewPlayer(currentUser, playerID);
				
				dispose();
			}
		});
		viewSquadBtnViewSelectedPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewSquadBtnViewSelectedPlayer.setBounds(116, 310, 183, 36);
		contentPane.add(viewSquadBtnViewSelectedPlayer);
		
		JButton viewSquadBtnEditSquad = new JButton("Edit Squad");
		viewSquadBtnEditSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displaySquadEdit(currentUser);
			}
		});
		viewSquadBtnEditSquad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewSquadBtnEditSquad.setBounds(315, 310, 153, 36);
		contentPane.add(viewSquadBtnEditSquad);
		
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(28, 53, 543, 303);
		contentPane.add(outlineRectangle);
	}
}
