package net.sparkzz.ttm.util;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.ServiceException;
import net.sparkzz.ttm.Fighter;
import net.sparkzz.ttm.Frame;

import javax.swing.text.Element;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brendon on 8/7/2014.
 */
public class SpreadsheetManager {

	public static List<Fighter> fighterList = new ArrayList<Fighter>();

	public static final String GOOGLE_ACCOUNT_USERNAME = "dummy4252@gmail.com"; // Fill in google account username
	public static final String GOOGLE_ACCOUNT_PASSWORD = "DisIsDummy"; // Fill in google account password
	public static final String SPREADSHEET_URL = "https://spreadsheets.google.com/feeds/spreadsheets/0AsWoQYWT8AhrdEJaOE1uLVJrcVA1ajBDcGR2NFZtWVE"; //Fill in google spreadsheet URI

	private static void readSpreadsheet() throws IOException, ServiceException {
		SpreadsheetService service = new SpreadsheetService("TexelianTeamManager");

		service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME, GOOGLE_ACCOUNT_PASSWORD);

		// Load sheet
		URL metafeedUrl = new URL(SPREADSHEET_URL);
		SpreadsheetEntry spreadsheet = service.getEntry(metafeedUrl, SpreadsheetEntry.class);
		URL listFeedUrl = ((WorksheetEntry) spreadsheet.getWorksheets().get(0)).getListFeedUrl();

		// Print entries
		ListFeed feed = (ListFeed) service.getFeed(listFeedUrl, ListFeed.class);

		Thread thread = new Thread(new Populator(feed));

		thread.start();
	}

	public SpreadsheetManager() {
		try {
			readSpreadsheet();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public static List getFighterList() {
		return fighterList;
	}

	public static void setupFighterList(List fighters) {
		fighterList = fighters;
	}
}