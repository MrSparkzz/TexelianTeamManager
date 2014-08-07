package net.sparkzz.ttm.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Brendon on 8/6/2014.
 */
public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "I've been pressed", "What happened?", JOptionPane.INFORMATION_MESSAGE);
	}
}