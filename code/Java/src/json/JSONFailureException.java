package json;

import java.util.ArrayList;

/**
 * The Class JSONFailureException.
 */
public class JSONFailureException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The messages. */
	private ArrayList<String> messages;

	/**
	 * Instantiates a new jSON failure exception.
	 *
	 * @param messages the messages
	 */
	public JSONFailureException(ArrayList<String> messages) {
		super("JSON failure message occurred.");
		this.messages = messages;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public ArrayList<String> getMessages() {
		return messages;
	}

}
