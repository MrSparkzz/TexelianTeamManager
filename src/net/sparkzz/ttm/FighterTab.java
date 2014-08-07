package net.sparkzz.ttm;

import net.sparkzz.ttm.Event.ButtonHandler;
import net.sparkzz.ttm.util.Populator;
import net.sparkzz.ttm.util.SpreadsheetManager;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * Created by Brendon on 8/7/2014.
 */
public class FighterTab extends JPanel {

	public static List<Fighter> fighters = null;

	public static JButton updateBtn = new JButton();
	public static TableModel dataModel = new AbstractTableModel() {

		@Override
		public int getColumnCount() {
			return 18;
		}

		@Override
		public int getRowCount() {
			return 1;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return new Integer(row*col);
		}
	};
	public static JTable table = new JTable(dataModel);
	public static JScrollPane scrollPane = new JScrollPane(table);

	public static String[] columnNames = {"Icon", "Name", "HP", "ATK", "DEF", "WIS",
			"AGI", "Skill", "Skill Target", "Skill Target 2", "Skill Rank", "Cooldown",
			"Class", "Sign", "SEF", "Minimum Level", "Maximum Level"};
	public static Object[][] data;

	public static void init() {
		updateBtn.setFont(Frame.font);
		updateBtn.setText("Update!");
		updateBtn.addActionListener(new ButtonHandler());

		Frame.tab[0].add(updateBtn);
	}

	public static void populate() {
		fighters = SpreadsheetManager.getFighterList();

		if (fighters.isEmpty()) {
			System.out.println("Emptpy Fighter List!");
		}

		int i = 0;

		for (Fighter fighter : fighters) {
			dataModel.setValueAt(fighter.getSprite(), i, 1);
			dataModel.setValueAt(fighter.getName(), i, 2);
			dataModel.setValueAt(fighter.getHP(), i, 3);
			dataModel.setValueAt(fighter.getATK(), i, 4);
			dataModel.setValueAt(fighter.getDEF(), i, 5);
			dataModel.setValueAt(fighter.getWIS(), i, 6);
			dataModel.setValueAt(fighter.getAGI(), i, 7);
			dataModel.setValueAt(fighter.getSkill(), i, 8);
			dataModel.setValueAt(fighter.getTarget(1), i, 9);
			dataModel.setValueAt(fighter.getTarget(2), i, 10);
			dataModel.setValueAt(fighter.getSkillRank(), i, 11);
			dataModel.setValueAt(fighter.getCooldown(), i, 12);
			dataModel.setValueAt(fighter.getFClass(), i, 13);
			dataModel.setValueAt(fighter.getSign(), i, 14);
			dataModel.setValueAt(fighter.getSEF(), i, 15);
			dataModel.setValueAt(fighter.getLvMIN(), i, 16);
			dataModel.setValueAt(fighter.getLvMAX(), i, 17);
			//dataModel.setValueAt(fighter.get, i, 18);
			//dataModel.setValueAt(fighter.get, i, 19);
			i++;
		}

		table.updateUI();

		Frame.tab[0].add(scrollPane);
		Frame.tab[0].revalidate();
	}
}