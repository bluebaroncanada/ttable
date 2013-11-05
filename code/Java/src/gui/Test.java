package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import json.JSONFailureException;

import ttable.User;

/**
 * The Class Test.
 */
public class Test extends JApplet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The outer panel. */
	private JPanel outerpanel;
	
	/** The test label. */
	private JLabel testLabel;
	
	/** The text area. */
	JTextArea textArea;

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init() {

		// Panel layout in absolute form
		outerpanel = new JPanel();

		textArea = new JTextArea();

		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));

		areaScrollPane.setSize(700, 450);

		// Make the panel layout absolute
		outerpanel.setLayout(null);

		testLabel = new JLabel();
		testLabel.setLayout(null);
		testLabel.setBounds(0, 460, 300, 35);
		testLabel.setVerticalAlignment(JLabel.TOP);

		outerpanel.add(testLabel);
		outerpanel.add(areaScrollPane);
		add(outerpanel);

		setSize(new Dimension(700, 500));

		beginTest();

	}

	/**
	 * Append test message.
	 *
	 * @param message the message
	 */
	private void appendTestMessage(String message) {
		textArea.append(message + "\n");
	}

	/**
	 * Append test messages.
	 *
	 * @param messages the messages
	 */
	private void appendTestMessages(ArrayList<String> messages) {

		Iterator<String> messagesIt = messages.iterator();

		while (messagesIt.hasNext()) {
			appendTestMessage((String) messagesIt.next());
		}
	}

	/**
	 * Begin test.
	 */
	public void beginTest() {
		int succeededCount = 0;
		int failedCount = 0;
		boolean succeeded = false;
		ArrayList<String> messages = new ArrayList<String>();

		// TEST AUTH1
		appendTestMessage("AUTH1: Attempting to authenticate with VALID password \"cs2212\"");

		try {
			User.authenticate("cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH1");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH1");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		// blank line
		appendTestMessage("");

		// TEST AUTH2
		appendTestMessage("AUTH2: Attempting to authenticate with INVALID password \"group4\"");

		try {
			User.authenticate("group4");
			++failedCount;
			appendTestMessage("TEST FAILED: AUTH2");
		} catch (JSONFailureException e) {

			if (e.getMessages().get(0).compareTo("Could not authenticate user") == 0) {
				++succeededCount;
				appendTestMessage("TEST PASSED: AUTH2");
			} else {
				++failedCount;
				appendTestMessage("TEST FAILED: AUTH2");
			}

			appendTestMessages(e.getMessages());
		}

		// blank line
		appendTestMessage("");

		// TEST CHPAS1
		appendTestMessage("CHPAS1: Attempting to set the password more than 6 characters.");
		succeeded = false;
		messages = new ArrayList<String>();

		try {
			User.setPassword("cs2212", "something very long");
		} catch (JSONFailureException e) {
			messages = e.getMessages();
			if (messages.get(0).compareTo(
					"The password can have no more than 6 characters") == 0) {
				++succeededCount;
				succeeded = true;
				appendTestMessage("TEST PASSED: CHPAS1");
			}
		}

		if (!succeeded) {
			appendTestMessage("TEST FAILED: CHPAS1");
			++failedCount;
		}

		appendTestMessages(messages);

		appendTestMessage("");

		// TEST CHPAS2
		appendTestMessage("CHPAS2: Attempting to set the password less than 3 characters.");
		succeeded = false;
		messages = new ArrayList<String>();

		try {
			User.setPassword("cs2212", "s");
		} catch (JSONFailureException e) {
			messages = e.getMessages();
			if (messages.get(0).compareTo(
					"The password can have no fewer than 3 characters") == 0) {
				++succeededCount;
				succeeded = true;
				appendTestMessage("TEST PASSED: CHPAS2");
			}
		}

		if (!succeeded) {
			appendTestMessage("TEST FAILED: CHPAS2");
			++failedCount;
		}

		appendTestMessages(messages);

		appendTestMessage("");

		// TEST CHPAS3
		appendTestMessage("CHPAS3: Attempting to set the password to a legal password \"group4\".");
		succeeded = false;
		messages = new ArrayList<String>();

		try {
			User.setPassword("cs2212", "group4");
			succeeded = true;
			++succeededCount;
			appendTestMessage("TEST PASSED: CHPAS3");
		} catch (JSONFailureException e) {
			succeeded = false;
			appendTestMessage("TEST FAILED: CHPAS3");
			++failedCount;
			appendTestMessages(e.getMessages());
		}

		appendTestMessage("");

		// TEST AUTH3
		appendTestMessage("AUTH3: Attempting to authenticate with password \"group4\"");

		try {
			User.authenticate("group4");
			succeeded = true;
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH3");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH3");
			++failedCount;
			appendTestMessages(e.getMessages());
		}

		// blank line
		appendTestMessage("");

		// TEST CHPAS4
		appendTestMessage("CHPAS4: Attempting to set the password to a legal password \"cs2212\".");
		succeeded = false;
		messages = new ArrayList<String>();

		try {
			User.setPassword("group4", "cs2212");
			succeeded = true;
			++succeededCount;
			appendTestMessage("TEST PASSED: CHPAS4");
		} catch (JSONFailureException e) {
			succeeded = false;
			appendTestMessage("TEST FAILED: CHPAS4");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		appendTestMessage("");

		// TEST CHPAS2
		appendTestMessage("CHPAS5: Attempting to set the password with incorrect old password.");
		succeeded = false;
		messages = new ArrayList<String>();

		try {
			User.setPassword("blah", "legal");
			appendTestMessage("TEST FAILED: CHPAS5");
			++failedCount;
		} catch (JSONFailureException e) {
			if (e.getMessages().get(0).compareTo("Password mismatch") == 0) {
				++succeededCount;
				appendTestMessage("TEST PASSED: CHPAS5");
			}
			else
			{
				++failedCount;
				appendTestMessage("TEST FAILED: CHPAS5");
			}

			appendTestMessages(e.getMessages());
		}

		
		appendTestMessage("");

		// TEST AUTH4
		appendTestMessage("AUTH4: Attempting to authenticate with VALID password \"cs2212\"");

		try {
			User.authenticate("cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH4");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH4");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		// blank line
		appendTestMessage("");

		// TEST QUES1
		appendTestMessage("QUES1: Getting questions");

		try {
			ArrayList<String> questions = User.getQuestions();
			++succeededCount;
			appendTestMessage("TEST PASSED: QUES1");
			appendTestMessages(questions);
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: QUES1");
			appendTestMessages(e.getMessages());
			++failedCount;
		}


		// blank line
		appendTestMessage("");

		appendTestMessage("QUES2: Attempting to set the question to INVALID value \"4\"");
		
		try {
			User.setQuestion("4", "cs2212");
			++failedCount;
			appendTestMessage("TEST FAILED: QUES2");
		} catch (JSONFailureException e) {
			
			if(e.getMessages().get(0).compareTo("The input is not between \u00270\u0027 and \u00272\u0027, inclusively") == 0)
			{
				appendTestMessage("TEST PASSED: QUES2");
				++succeededCount;
			}
			else
			{
				appendTestMessage("TEST FAILED: QUES2");
				++failedCount;
			}
			
			appendTestMessages(e.getMessages());
		}

		appendTestMessage("");

		appendTestMessage("QUES3: Attempting to set the question to INVALID value \"-1\"");
		
		try {
			User.setQuestion("-1", "cs2212");
			++failedCount;
			appendTestMessage("TEST FAILED: QUES3");
		} catch (JSONFailureException e) {
			if(e.getMessages().get(0).compareTo("The input is not between \u00270\u0027 and \u00272\u0027, inclusively") == 0)
			{
				appendTestMessage("TEST PASSED: QUES3");
				++succeededCount;
			}
			else
			{
				appendTestMessage("TEST FAILED: QUES3");
				++failedCount;
			}
			
			appendTestMessages(e.getMessages());
		}
		
		appendTestMessage("");

		appendTestMessage("QUES4: Attempting to set the question to VALID value \"1\"");
		
		try {
			User.setQuestion("1", "cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: QUES4");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: QUES4");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		appendTestMessage("");

		appendTestMessage("ANSW1: Attempting to set the answer to INVALID value \"\"");
		
		try {
			User.setAnswer("", "cs2212");
			++failedCount;
			appendTestMessage("TEST FAILED: ANSW1");
		} catch (JSONFailureException e) {
			if (e.getMessages().get(0).compareTo("The input is less than 1 characters long") == 0)
			{
				appendTestMessage("TEST PASSED: ANSW1");
				++succeededCount;
			}
			else
			{
				appendTestMessage("TEST FAILED: ANSW1");
				++failedCount;
			}
			
			appendTestMessages(e.getMessages());
			
		}


		appendTestMessage("");

		appendTestMessage("ANSW2: Attempting to set the answer to INVALID value greater than 30 characters");
		
		try {
			User.setAnswer("abcdefghijklmnopqrstuvwxyz12345", "cs2212");
			++failedCount;
			appendTestMessage("TEST FAILED: ANSW2");
		} catch (JSONFailureException e) {
			if (e.getMessages().get(0).compareTo("The input is more than 30 characters long") == 0)
			{
				appendTestMessage("TEST PASSED: ANSW2");
				++succeededCount;
			}
			else
			{
				appendTestMessage("TEST FAILED: ANSW1");
				++failedCount;
			}
			
			appendTestMessages(e.getMessages());
			
		}

		appendTestMessage("");

		appendTestMessage("ANSW3: Attempting to set the answer to VALID value \"Beer\"");
		
		try {
			User.setAnswer("beer", "cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: ANSW3");
		} catch (JSONFailureException e) {
			++failedCount;
			appendTestMessage("TEST FAILED: ANSW3");
			appendTestMessages(e.getMessages());
		}

		appendTestMessage("");

		appendTestMessage("RES1: Attempting to reset the password with \"whiskey\"");
		
		try {
			User.resetPassword("whiskey", "blah");
			++failedCount;
			appendTestMessage("TEST FAILED: RES1");
		} catch (JSONFailureException e) {
			if(e.getMessages().get(0).compareTo("Could not verify answer") == 0)
			{
				++succeededCount;
				appendTestMessage("TEST PASSED: RES1");
			}
			else
			{
				++failedCount;
				appendTestMessage("TEST FAILED: RES1");
			}
			appendTestMessages(e.getMessages());
		}

		appendTestMessage("");

		appendTestMessage("RES2: Attempting to validate, case insensitively, the answer with \"beer\", set password to \"blah\"");
		
		try {
			User.resetPassword("beer", "blah");
			++succeededCount;
			appendTestMessage("TEST PASSED: RES2");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: RES2");
			appendTestMessages(e.getMessages());
		}

		appendTestMessage("");
		
		// TEST AUTH1
		appendTestMessage("AUTH5: Attempting to authenticate with VALID password \"blah\"");

		try {
			User.authenticate("blah");
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH5");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH5");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		// blank line
		appendTestMessage("");
				
		
		// TEST CHPAS6
		appendTestMessage("CHPAS6: Attempting to set the password to a legal password \"cs2212\".");
		messages = new ArrayList<String>();

		try {
			User.setPassword("blah", "cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: CHPAS6");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: CHPAS6");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		appendTestMessage("");


		// TEST AUTH1
		appendTestMessage("AUTH6: Attempting to authenticate with VALID password \"blah\"");

		try {
			User.authenticate("cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH6");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH6");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		// blank line
		appendTestMessage("");
		

		appendTestMessage("ANSW4: Attempting to reset, case insensitively, the answer with \"beer\"");
		
		try {
			User.resetPassword("beer", "cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: ANSW4");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: ANSW4");
			appendTestMessages(e.getMessages());
		}
		
		appendTestMessage("");

		// TEST AUTH1
		appendTestMessage("AUTH7: Expire passwords.");

		for (int x = 0; x < 4; ++x)
		{
			try {
				User.authenticate("blah");
				++failedCount;
				appendTestMessage("TEST FAILED: AUTH7");
				break;
			} catch (JSONFailureException e) {
				if (x == 3)
				{
					if (e.getMessages().get(0).compareTo("Too many login attempts") == 0)
					{
						appendTestMessage("TEST PASSED: AUTH7");
						++succeededCount;
					}
					else
					{
						appendTestMessage("TEST FAILED: AUTH7");
						++failedCount;
					}
					appendTestMessages(e.getMessages());
				}
			}
		}

		// blank line
		appendTestMessage("");

		appendTestMessage("ANSW7: Attempting to reset");
		
		try {
			User.resetPassword("beer", "cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: ANSW5");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: ANSW5");
			appendTestMessages(e.getMessages());
		}
		
		appendTestMessage("");

		// TEST AUTH1
		appendTestMessage("AUTH8: Attempting to authenticate with VALID password \"cs2212\"");

		try {
			User.authenticate("cs2212");
			++succeededCount;
			appendTestMessage("TEST PASSED: AUTH8");
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: AUTH8");
			appendTestMessages(e.getMessages());
			++failedCount;
		}

		// blank line
		appendTestMessage("");
		
		appendTestMessage("USER1: Attempting to get user information");
		
		try {
			User userInfo = User.getUser();
			if(
					userInfo.getFirstName().length() > 0 &&
					userInfo.getLastName().length() > 0 &&
					userInfo.getFbId().length() > 0)
			{
				++succeededCount;
				appendTestMessage("TEST PASSED: USER1");
				appendTestMessage("First name: " + userInfo.getFirstName());
				appendTestMessage("Last name: " + userInfo.getLastName());
				appendTestMessage("Facebook ID: " + userInfo.getFbId());
			}
			else
			{
				appendTestMessage("TEST FAILED: USER1");
				++failedCount;
			}
		} catch (JSONFailureException e) {
			appendTestMessage("TEST FAILED: USER1");
			appendTestMessages(e.getMessages());
		}
		
		
		

		testLabel.setText("Tests Passed: " + succeededCount
				+ "  Tests Failed: " + failedCount);

	}

}
