package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class DrillMenu.
 */
public class DrillMenu extends BackgroundPanel {	

	/**
	 * Instantiates a new drill menu.
	 *
	 * @param controller the controller
	 */
	public DrillMenu(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(40,150,5,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;

		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/drillmenu.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Drill Menu"), c);
		}

		c.insets = new Insets(5,75,5,15);
		c.ipady = 15;
		c.weightx = 0.5;
		c.gridwidth = 1;

		for (int i = 0; i < 4; i++) {
			c.gridx = i;
			if (i == 1) {
				c.insets = new Insets(5,15,5,15);
			}
			else if (i == 3) {
				c.insets = new Insets(5,15,5,75);
			}
			for (int j = 1; j <= 3; j++) {
				int level = (i * 3) + j;

				JButton button = new JButton();
				button.addActionListener(new StartDrill(controller, level));
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				try {
					Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/levels/lvl" + level + "_u.png"));
					button.setIcon(new ImageIcon(img));
				} catch (IOException e) {
					button.setText("Level " + level);
				}
				c.gridy = j;
				add(button, c);
			}
		}
	}
}

/**
 * The Class StartDrill.
 */
class StartDrill implements ActionListener {

	private Controller controller;
	private int level;

	/**
	 * Instantiates a the Start Drill listener.
	 * 
	 * @param the controller
	 * @param the level
	 */
	public StartDrill(Controller control, int level) {
		super();
		controller = control;
		this.level = level;
	}

	/**
	 * Performs the action
	 * 
	 * @param the action event
	 */
	public void actionPerformed(ActionEvent e) {

		Drill screen = new Drill(controller, level);
		controller.setScreen(screen);
	}
}
