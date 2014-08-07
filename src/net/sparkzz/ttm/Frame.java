package net.sparkzz.ttm;

import net.sparkzz.ttm.Event.ButtonHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brendon on 8/6/2014.
 */
public class Frame extends JFrame {

	private String TITLE = "Texelian Team Manager",
					VERSION = "ALPHA-0.0.1";

	private static Frame frame = null;
	private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private Dimension dimension = new Dimension(),
			scrDimension = new Dimension(graphicsDevice.getDisplayMode().getWidth(), graphicsDevice.getDisplayMode().getHeight());

	// tabs: Fighters, Editor, Team Builder, Compare (Compare multiple fighters)
	public static final Font font = new Font("euphemia", Font.BOLD, 16);
	public static final JPanel[] tab = new JPanel[4];
	public static final JLabel info = new JLabel();
	public static final JTabbedPane tabbedPane = new JTabbedPane();

	public static void main(String args[]) {
		frame = new Frame();
	}

	public Frame() {
		initUI();

		FighterTab.init();
	}

	private void initUI() {
		setTitle(TITLE + " " + VERSION);
		setSize(dimensionBasedOnResolution());

		dimension = dimensionBasedOnResolution();

		getContentPane().add(tabbedPane);

		tab[0] = new FighterTab();

		info.setHorizontalAlignment(0);
		info.setVerticalAlignment(0);

		tabbedPane.add("Fighters", tab[0]);
		tab[0].add(info);

		validate();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(scrDimension.width/2 - this.getWidth()/2, scrDimension.height/2 - this.getHeight()/2);
		setVisible(true);
	}

	private Dimension dimensionBasedOnResolution() {
		int pixels = (int) (scrDimension.getWidth() * scrDimension.getHeight());

		switch (pixels) {
			case 2073600:
				return new Dimension(1280, 720);
			case 921600:
				return new Dimension(854, 480);
			case 786432:
				return new Dimension(854, 480);
			default:
				return new Dimension((int) Math.ceil(scrDimension.getWidth()*.6666), (int) Math.ceil(scrDimension.getHeight()*.6666));
		}
	}
}