package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The Class LGameMenu.
 */
public class LGameMenu extends BackgroundPanel {
	
	/**
	 * Instantiates a new l game menu.
	 *
	 * @param controller the controller
	 */
	public LGameMenu(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(40,150,5,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/lgame.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Level Game Menu"), c);
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
				button.addActionListener(new SelectLGame(controller, level));
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
 * The Class SelectLGame.
 */
class SelectLGame implements ActionListener {

	private Controller controller;
	private int level;
	
	/**
	 * The ChildProgress constructor.
	 * 
	 * @param the controller
	 * @param the level selected
	 */
	public SelectLGame(Controller controller, int level) {
		super();
		controller = controller;
		this.level = level;
	}
	
	/**
	 * The action performed method for SelectLGame Listener.
	 * 
	 * @param action event
	 */
	public void actionPerformed(ActionEvent e) {
		
		LGame screen = new LGame(controller, level);
		controller.setScreen(screen);
	}
}
