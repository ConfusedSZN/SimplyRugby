package simplyRugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditSquad extends JFrame {

	private JPanel contentPane;
	private JTextField editSquadSquadNameInput;
	private JTextField editSquadPlayerMemberInput;
	private JTable editSquadTablePlayerData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSquad frame = new EditSquad();
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
	public EditSquad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton editSquadBtnReturn = new JButton("Return to Menu");
		editSquadBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editSquadBtnReturn.setBounds(450, 11, 124, 31);
		contentPane.add(editSquadBtnReturn);
		
		JLabel editSquadLblHeader = new JLabel("Editing {Squad Name}");
		editSquadLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSquadLblHeader.setBounds(10, 11, 427, 31);
		contentPane.add(editSquadLblHeader);
		
		editSquadSquadNameInput = new JTextField();
		editSquadSquadNameInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSquadSquadNameInput.setBounds(35, 114, 196, 34);
		contentPane.add(editSquadSquadNameInput);
		editSquadSquadNameInput.setColumns(10);
		
		JLabel editSquadLblSquadNameTooltip = new JLabel("Squad Name:");
		editSquadLblSquadNameTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editSquadLblSquadNameTooltip.setBounds(35, 94, 78, 14);
		contentPane.add(editSquadLblSquadNameTooltip);
		
		JComboBox editSquadComboBoxAgeRange = new JComboBox();
		editSquadComboBoxAgeRange.setBounds(237, 114, 180, 34);
		contentPane.add(editSquadComboBoxAgeRange);
		
		JLabel editSquadLblSquadAgeRangeToolTip = new JLabel("Squad Age Range:");
		editSquadLblSquadAgeRangeToolTip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editSquadLblSquadAgeRangeToolTip.setBounds(237, 95, 102, 14);
		contentPane.add(editSquadLblSquadAgeRangeToolTip);
		
		JButton editSquadBtnSaveAndReturn = new JButton("Save & Return to Menu");
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
		
		editSquadTablePlayerData = new JTable();
		editSquadTablePlayerData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Player Name", "Position", "Rating"
			}
		));
		scrollPane.setViewportView(editSquadTablePlayerData);
	}
}