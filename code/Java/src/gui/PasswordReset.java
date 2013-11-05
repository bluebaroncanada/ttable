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
public class PasswordReset extends BackgroundPanel {

	/**
	 * Instantiates a new security q.
	 * 
	 * @param controller
	 *            the controller
	 */
	public PasswordReset(Controller controller) {

		super("http://jbaron6.cs2212.ca/img/default_background.png",
				new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 100, 0);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;

		c.weightx = 0;
		c.weighty = 0;

		final JLabel instruct1 = new JLabel(
				"Please enter your old password and desired new password.");
		instruct1.setFont(controller.getFont().deriveFont(Font.BOLD, 35));

		JLabel instruct2 = new JLabel(
				"Passwords must be 3-6 characters long and are case sensitive. ");
		instruct2.setFont(controller.getFont().deriveFont(Font.BOLD, 35));

		JLabel instruct3 = new JLabel("Old Password: ");
		instruct3.setFont(controller.getFont().deriveFont(Font.BOLD, 20));

		JLabel instruct4 = new JLabel("New Password: ");
		instruct4.setFont(controller.getFont().deriveFont(Font.BOLD, 20));

		JLabel instruct5 = new JLabel("Confirm New Password: ");
		instruct5.setFont(controller.getFont().deriveFont(Font.BOLD, 20));

		c.insets = new Insets(15, 15, 15, 15);
		add(instruct1, c);

		c.gridy = 1;

		add(instruct2, c);

		c.insets = new Insets(5, 25, 5, 25);
		c.gridy = 2;

		add(instruct3, c);

		c.gridy = 3;

		JPasswordField answer = new JPasswordField();
		answer.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer, c);

		c.gridy = 5;
		add(instruct4, c);

		c.gridy = 6;
		JPasswordField answer2 = new JPasswordField();
		answer2.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer2, c);

		c.gridy = 7;
		add(instruct5, c);

		c.gridy = 8;
		JPasswordField answer3 = new JPasswordField();
		answer3.setFont(controller.getFont().deriveFont(Font.BOLD, 30));
		add(answer3, c);

		c.gridy = 9;
		c.insets = new Insets(15, 225, 15, 225);

		JButton ok = new JButton("Ok");
		ok.addActionListener(new PressOkReset(controller, answer, answer2, answer3));
		add(ok, c);

	}
}

class PressOkReset implements ActionListener {
	private int errors;
	private Controller controller;
	private JPasswordField pwdfNew;
	private JPasswordField pwdfNew2;
	private JPasswordField pwdfOld;

	public PressOkReset(Controller control, JPasswordField old,
			JPasswordField new1, JPasswordField new2) {
		super();
		controller = control;
		pwdfNew = new1;
		pwdfNew2 = new2;
		pwdfOld = old;
	}

	public void actionPerformed(ActionEvent evt) {
		// String newPwd = null;
		String oldPwd = new String(pwdfOld.getPassword());
		String newPwd = new String(pwdfNew.getPassword());
		String newPwd2 = new String(pwdfNew2.getPassword());

		if (newPwd.equals(newPwd2)) {
			try {
				User.setPassword(oldPwd, newPwd);
				MainMenu screen = new MainMenu(controller);
				controller.setScreen(screen);
			} catch (JSONFailureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			
			//JOptionPane.showMessageDialog(this, "The Passwords did not match");
		}
	}

}
