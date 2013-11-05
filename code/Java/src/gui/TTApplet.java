package gui;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import json.JSONFailureException;

/**
 * The Class TTApplet.
 */
public class TTApplet extends JApplet {
	
	/** The controller. */
	Controller controller;
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		try {
			controller = new Controller();
			TitlePanel titlePanel = new TitlePanel(controller);
			controller.setHeader(titlePanel);
			Welcome welcome = new Welcome(controller);
			controller.setScreen(welcome);
			controller.setFrameColour(Color.black);
			this.add(controller.getPane());
		} catch (JSONFailureException e) {
			JPanel screen = new JPanel();
			screen.add(new JLabel("<html>Oops!<br>"
					+ "It appears we are having some issues!<br>"
					+ "Make sure you are logged into Facebook and try again.</html>"));
			this.add(screen);
		}
		
		
	}
}
