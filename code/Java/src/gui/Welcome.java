package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import json.JSONFailureException;
import ttable.Progeny;
import ttable.User;

/**
 * The Class Welcome.
 */
public class Welcome extends BackgroundPanel {
	
	/**The controller */
	private Controller controller;
	
	/**
	 * Instantiates the Welcome pane.
	 * 
	 * @param the controller
	 */
	public Welcome(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		this.controller = controller;
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/welcome.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Welcome!"), c);
		}
		
		c.gridy = 1;
		c.insets = new Insets(25,100,0,100);
		controller.getUser();
		try {
			ArrayList<Progeny> progenies = User.getProgenies();
			Vector<String> names = new Vector<String>();
			for (int i = 0; i < progenies.size(); i++) {
				names.add(progenies.get(i).getFirstName());
			}
			JComboBox<String> nameSelector = new JComboBox<String>(names);
			if (names.size() > 0) {
				nameSelector.setFont(controller.getFont().deriveFont(Font.PLAIN, 18));
				add(nameSelector, c);
			}
			else {
				JLabel label = new JLabel("Please click settings to add children to the game.");
				label.setFont(controller.getFont().deriveFont(Font.PLAIN, 26));
				add(label, c);
			}
			
			c.gridy = 2;
			c.insets = new Insets(0,100,0,100);
			JButton ok = new JButton();
			ok.setContentAreaFilled(false);
			ok.setBorderPainted(false);
			ok.addActionListener(new SelectProgeny(controller, nameSelector, progenies));
			try {
				Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/ok.png"));
				ok.setIcon(new ImageIcon(img));
			} catch (IOException e) {
				ok.setText("Ok");
			}
			add(ok, c);
			
			
		} catch (JSONFailureException e) {
			JPanel screen = new JPanel();
			int gridY = 1;
			ArrayList<String> errors = e.getMessages();
			Iterator<String> error = errors.iterator();
			c.gridx = 1;
			c.gridy = gridY;
			screen.add(new JLabel(error.toString()));
			while (error.hasNext()) {
				gridY++;
				c.gridy = gridY;
				JLabel label = new JLabel(error.next().toString());
				label.setForeground(Color.RED);
				label.setFont(controller.getFont().deriveFont(Font.PLAIN, 18));
				screen.add(label, c);
			}
			controller.setScreen(screen);
		}
	}
}

/**
 * The Class SelectProgeny.
 */
class SelectProgeny implements ActionListener {
	
	/** The controller */
	private Controller controller;
	
	/** The progeny selection dropdown */
	private JComboBox<String> progenySelector;
	
	/** The array of progeny */
	private ArrayList<Progeny> progenyList;
	
	/**
	 * Instantiates the SelectProgeny class.
	 * 
	 * @param the controller
	 * @param the progeny selector
	 * @param the progeny array
	 */
	public SelectProgeny(Controller controller, JComboBox<String> progenySelector, ArrayList<Progeny> progenyList) {
		this.controller = controller;
		this.progenyList = progenyList;
	}
	
	/**
	 * Performs the action on event.
	 * 
	 * @param the action event
	 */
	public void actionPerformed(ActionEvent e) {
		int selection = progenySelector.getSelectedIndex();
		controller.setCurrentProgeny(progenyList.get(selection));
		controller.setScreen(new MainMenu(controller));
	}
}
