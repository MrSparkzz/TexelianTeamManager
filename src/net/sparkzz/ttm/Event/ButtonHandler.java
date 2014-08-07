package net.sparkzz.ttm.Event;

import com.google.gdata.data.docs.SpreadsheetEntry;
import com.google.gdata.util.ServiceException;
import net.sparkzz.ttm.FighterTab;
import net.sparkzz.ttm.Frame;
import net.sparkzz.ttm.util.SpreadsheetManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Brendon on 8/6/2014.
 */
public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == FighterTab.updateBtn) {
			Frame.tab[0].removeAll();
			Frame.tab[0].repaint();

			SpreadsheetManager spreadsheetManager = new SpreadsheetManager();
		}
	}
}