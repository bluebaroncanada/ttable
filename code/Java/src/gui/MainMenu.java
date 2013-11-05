package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.Controller;

/**
 * The Class MainMenu.
 */
public class MainMenu extends BackgroundPanel {
	
	/**
	 * Instantiates a new main menu.
	 *
	 * @param controller the controller
	 */
	public MainMenu(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,150,0,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/mainmenu.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Main Menu"), c);
		}
		
		c.insets = new Insets(0,150,0,150);
		c.ipady = 20;
		c.weightx = 0.5;
		
		JButton toDrill = new JButton();
		toDrill.setContentAreaFilled(false);
		toDrill.setBorderPainted(false);
		toDrill.addActionListener(new PressDrill(controller));
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/drills.png"));
			toDrill.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toDrill.setText("Drills");
		}
		c.gridy = 1;
		add(toDrill, c);
		
		JButton toLGame = new JButton();
		toLGame.setContentAreaFilled(false);
		toLGame.setBorderPainted(false);
		toLGame.addActionListener(new PressLGame(controller));
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/lgames_l.png"));
			toLGame.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toLGame.setText("Level Games");
		}
		c.gridy = 2;
		add(toLGame, c);

		JButton toFGame = new JButton();
		toFGame.setContentAreaFilled(false);
		toFGame.setBorderPainted(false);
		toFGame.addActionListener(new PressFGame(controller));
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/fgame_l.png"));
			toFGame.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toFGame.setText("Final Game");
		}
		c.gridy = 3;
		add(toFGame, c);
		
		c.insets = new Insets(0,150,0,150);
		
		JButton toStats = new JButton();
		toStats.setContentAreaFilled(false);
		toStats.setBorderPainted(false);
		toStats.addActionListener(new PressStats(controller));
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/scores&stats.png"));
			toStats.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toStats.setText("Scores & Stats");
		}
		c.gridy = 4;
		add(toStats, c);
	}	
}

class PressDrill implements ActionListener {
	
	private Controller controller;
	
	public PressDrill(Controller control) {
		super();
		controller = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		DrillMenu menu = new DrillMenu(controller);
		controller.setScreen(menu);
	}
}

class PressLGame implements ActionListener {

	private Controller controller;
	
	public PressLGame(Controller control) {
		super();
		controller = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		LGameMenu menu = new LGameMenu(controller);
		controller.setScreen(menu);
	}
}

class PressFGame implements ActionListener {

	private Controller controller;
	
	public PressFGame(Controller control) {
		super();
		controller = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		FGameMenu menu = new FGameMenu(controller);
		controller.setScreen(menu);
	}
}

class PressStats implements ActionListener {

	private Controller controller;
	
	public PressStats(Controller control) {
		super();
		controller = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		StatsMenu menu = new StatsMenu(controller);
		controller.setScreen(menu);
	}
}