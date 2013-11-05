package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;

import json.JSONFailureException;
import ttable.User;

/**
 * The Class LockScreen.
 */
public class LockScreen extends BackgroundPanel {
	
	/**
	 * Instantiates a new lock screen.
	 *
	 * @param controller the controller
	 */
	public LockScreen(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		this.setup(controller);
		this.addImg(1);
	}
	
	/**
	 * Instantiate a new lock screen with error messages.
	 * 
	 * @param the controller
	 * @param list of errors
	 */
	public LockScreen(Controller controller, ArrayList<String> errors) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		setup(controller);
		int gridY = 2;
		Iterator<String> error = errors.iterator();
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = gridY;
		add(new JLabel(error.toString()));
		while (error.hasNext()) {
			gridY++;
			c.gridy = gridY;
			JLabel label = new JLabel(error.next().toString());
			label.setForeground(Color.RED);
			label.setFont(controller.getFont().deriveFont(Font.PLAIN, 18));
			add(label, c);
		}
		gridY++;
		addImg(gridY);
	}

	public void setup(Controller controller) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,100,0);			
		c.weightx = 0;
		c.weighty = 0;
		c.gridy = 0;

		JLabel pwdLabel = new JLabel("Password: ");
		pwdLabel.setFont(controller.getFont().deriveFont(Font.BOLD, 60));
		c.insets = new Insets(100,200,50,5);
		c.gridx = 0;
		add(pwdLabel, c);

		JButton ok = new JButton();
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/ok.png"));
			ok.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			ok.setText("Ok");
		}

		JButton reset = new JButton();
		reset.setContentAreaFilled(false);
		reset.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/reset.png"));
			ok.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			ok.setText("Reset...");
		}
		
		JPasswordField passwordField = new JPasswordField("000000");
		passwordField.addKeyListener(new EnterListener(ok));
		c.insets = new Insets(100,5,50,5);
		c.gridx = 1;
		add(passwordField, c);
		
		ok.addActionListener(new PressOk(controller, passwordField));
		c.insets = new Insets(100,5,50,20);
		c.gridx = 2;
		add(ok, c);
		
		reset.addActionListener(new PressReset(controller));
		c.insets = new Insets(100,5,50,20);
		c.gridx = 3;
		add(reset, c);
	}
	
	/**
	 * Adds the lock image to the screen.
	 * 
	 * @param Y alignment
	 */
	public void addImg(int gridY) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,100,0);
		c.gridx = 1;
		c.gridy = gridY;
		
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/lock.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("<html>Oops!<br>"
					+ "It seems we are having trouble communicating!</html>"), c);
		}
	}
}

/**
 * The Class PressOk.
 */
class PressOk implements ActionListener {
	private int errors;
	private Controller controller;
	private JPasswordField pwdf;
	
	/**
	 * Instantiates a new PressOk listener.
	 * 
	 * @param the controller
	 * @param the password field
	 */
	public PressOk(Controller control, JPasswordField passwordField) {
		super();
		controller = control;
		pwdf = passwordField;
	}
	
	/**
	 * Performs the action on event.
	 * 
	 * @param the action event
	 */
	public void actionPerformed(ActionEvent evt) {
		char[] pwds = pwdf.getPassword();
		String pwd = pwds.toString();
		
		try {
			User.authenticate(pwd);
			Settings screen = new Settings(controller);
			controller.setScreen(screen);
		} catch (JSONFailureException e) {
			if (e.getMessages().get(0).compareTo("Too many login attempts") == 0) {
				SecurityQ seq = new SecurityQ(controller);
				controller.setScreen(seq);
			}
			else {
				JLabel message = new JLabel((3 - errors) + " attempts remaining");
				message.setFont(controller.getFont().deriveFont(Font.PLAIN, 16));
				message.setForeground(Color.RED);
				LockScreen screen = new LockScreen(controller, e.getMessages());
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = 1;
				c.gridy = 1;
				screen.add(message);
				controller.setScreen(screen);
			}
		}
	}
}

/**
 * The Class PressReset.
 */
class PressReset implements ActionListener {

	private Controller controller;
	
	/**
	 * Instantiates a PressReset listener.
	 * 
	 * @param the controller
	 */
	public PressReset(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/**
	 * Performs the action on event.
	 * 
	 * @param the action event
	 */
	public void actionPerformed(ActionEvent evt) {
	
		PasswordReset reset = new PasswordReset(controller);
		controller.setScreen(reset);
		
	}
}
