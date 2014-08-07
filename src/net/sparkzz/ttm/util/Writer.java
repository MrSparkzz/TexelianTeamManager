package net.sparkzz.ttm.util;

import net.sparkzz.ttm.Frame;

import javax.swing.JLabel;

/**
 * Created by Brendon on 8/7/2014.
 */
public class Writer {

	private static JLabel label = Frame.info;

	public static void onScreenInfo(String message) {
		label.setText(message);
	}
}