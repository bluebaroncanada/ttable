package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import json.JSONFailureException;
import ttable.User;

/**
 * The Class SecurityQ.
 */
public class SecurityQ extends BackgroundPanel {

	/**
	 * Instantiates a new security q.
	 * 
	 * @param controller
	 *            the controller
	 */
	public SecurityQ(Controller controller) {

		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 100, 0);
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 3;

		JLabel q1, q2, q3;
		
		try {
			ArrayList<String> questions = User.getQuestions();
			q1 = new JLabel (questions.get(0));
			q2 = new JLabel (questions.get(1));
			q3 = new JLabel (questions.get(2));
		} 
		catch (JSONFailureException e) {
			q1 = new JLabel ("Opps!");
			q2 = new JLabel ("We couldn't retrieve your security questions.");
			q3 = new JLabel (":(");
		}

		c.weightx = 0;
		c.weighty = 0;
		c.gridy = 0;

		c.insets = new Insets(15,15,15,15);
		add(q1, c);
		
		c.gridy = 1;
		
		JTextField answer1 = new JTextField();
		answer1.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer1, c);
		
		c.gridy = 2;
		add(q2, c);

		c.gridy = 3;
		
		JTextField answer2 = new JTextField();
		answer2.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer2, c);
		
		c.gridy = 4;
		add(q3, c);
		
		c.gridy = 5;
		
		JTextField answer3 = new JTextField();
		answer3.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer3, c);

		q1.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		q2.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		q3.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		

		c.gridy = 6;
		
		c.weightx = 0.2;

		c.insets = new Insets(15,200,15,200);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new OkPress(controller, answer1, answer2, answer3));
		add(ok, c);
		
	}
}

class OkPress implements ActionListener {
	
	private Controller controller;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	
	public OkPress(Controller controller, JTextField answer1, JTextField answer2, JTextField answer3) {
		this.controller = controller;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
