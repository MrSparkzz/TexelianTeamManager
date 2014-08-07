package net.sparkzz.ttm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brendon on 8/6/2014.
 */
public class Frame extends JFrame {

	private String TITLE = "Texelian Team Manager",
					VERSION = "ALPHA-0.0.1";

	// tabs: Fighters, Editor, Team Builder, Compare (Compare multiple fighters)
	private final Font font = new Font("euphemia", Font.BOLD, 16);
	private final JPanel[] tab = new JPanel[4];
	private final JTabbedPane tabbedPane = new JTabbedPane();

	private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private Dimension dimension = new Dimension(),
						scrDimension = new Dimension(graphicsDevice.getDisplayMode().getWidth(), graphicsDevice.getDisplayMode().getHeight());

	public static void main(String args[]) {
		Frame frame = new Frame();
	}

	public Frame() {
		initUI();

		fighterTab();
	}

	// tab for all the fighters
	private void fighterTab() {
		JButton button = new JButton();

		button.setFont(font);
		button.setText("Update!");

		tab[0].add(button);
	}

	private void initUI() {
		setTitle(TITLE + " " + VERSION);
		setSize(dimensionBasedOnResolution());

		getContentPane().add(tabbedPane);

		int i = 0;

		do {
			tab[i] = new JPanel();

			i++;
		} while (i < 4);

		tabbedPane.add("Fighters", tab[0]);

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