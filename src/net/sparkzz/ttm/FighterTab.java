package net.sparkzz.ttm;

import net.sparkzz.ttm.Event.ButtonHandler;
import net.sparkzz.ttm.util.Populator;
import net.sparkzz.ttm.util.SpreadsheetManager;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by Brendon on 8/7/2014.
 */
public class FighterTab extends JPanel {

	private static HashMap<String, List<Object>> fighterData = new HashMap<String, List<Object>>();
	private static List<Fighter> fighters = null;

	public static JButton updateBtn = new JButton();
	public static JTable table;

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
			return;
		}

		int i = 0;

		for (Fighter fighter : fighters) {
			List<Object> data = new ArrayList<Object>();

			data.add(fighter.getHP());
			data.add(fighter.getATK());
			data.add(fighter.getDEF());
			data.add(fighter.getWIS());
			data.add(fighter.getAGI());
			data.add(fighter.getSkill());
			data.add(fighter.getTarget(1));
			data.add(fighter.getTarget(2));
			data.add(fighter.getSkillRank());
			data.add(fighter.getCooldown());
			data.add(fighter.getFClass());
			data.add(fighter.getSign());
			data.add(fighter.getSEF());
			data.add(fighter.getLvMIN());
			data.add(fighter.getLvMAX());

			fighterData.put(fighter.getName(), data);

			System.out.println("Added to list: " + fighter.getName());
		}

		fighters.clear();

		table = new JTable(convertToTableModel(fighterData));
		table.setSize(Frame.tab[0].getSize());

		Frame.tab[0].add(table);
		Frame.tab[0].revalidate();
		Frame.tab[0].repaint();
	}

	public static TableModel convertToTableModel(HashMap<String, List<Object>> hashMap) {
		DefaultTableModel model = new DefaultTableModel();

		for (String name : hashMap.keySet()) {
			List<Object> list = hashMap.get(name);

			Vector vector = new Vector();

			vector.add(name);

			for (int i = 0; i < list.size(); i++) {
				vector.add(list.get(i));
				System.out.println(list.get(i));
			}

			model.addRow(vector);

		}
		return model;
	}
}