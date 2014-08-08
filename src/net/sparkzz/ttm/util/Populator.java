package net.sparkzz.ttm.util;

import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import net.sparkzz.ttm.Fighter;
import net.sparkzz.ttm.FighterTab;
import net.sparkzz.ttm.Frame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brendon on 8/7/2014.
 */
public class Populator implements Runnable {

	public static List<Fighter> fighterList = new ArrayList<Fighter>();

	public ListFeed feed = null;

	public Populator(ListFeed feed) {
		this.feed = feed;
	}

	@Override
	public void run() {
		int i = 0;

		for (ListEntry entry : feed.getEntries()) {
			Fighter fighter = new Fighter();

			CustomElementCollection elements = entry.getCustomElements();

			fighter.setSprite(elements.getValue("name"));
			fighter.setName(elements.getValue("name"));
			fighter.setHP(Integer.parseInt(elements.getValue("hp")));
			fighter.setATK(Integer.parseInt(elements.getValue("atk")));
			fighter.setDEF(Integer.parseInt(elements.getValue("def")));
			fighter.setWIS(Integer.parseInt(elements.getValue("wis")));
			fighter.setAGI(Integer.parseInt(elements.getValue("agi")));
			fighter.setSkill(elements.getValue("skill"));
			fighter.setTarget(elements.getValue("skilltarget"));
			//fighter.setTargetTwo(elements.getValue("skilltarget2")); // add this to the spreadsheet
			fighter.setSkillRank(elements.getValue("skillrank"));
			//fighter.setCooldown(elements.getValue("tier"), Integer.parseInt(elements.getValue("cooldown")));
			fighter.setClass(elements.getValue("class"));
			//fighter.setSign(elements.getValue("sign"));
			//fighter.setSEF(Integer.parseInt("sef"));
			//fighter.setLvMAX(Integer.parseInt("maxlv"));

			System.out.println("Got data for: " + elements.getValue("name"));

			Frame.tab[0].repaint();

			fighterList.add(fighter);

			i++;
			if (i == 5) break;
		}

		SpreadsheetManager.setupFighterList(fighterList);

		FighterTab.populate();

		Frame.tab[0].revalidate();
	}
}