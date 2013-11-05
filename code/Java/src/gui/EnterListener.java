package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

/**
 * The listener interface for receiving enter events.
 * The class that is interested in processing a enter
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEnterListener<code> method. When
 * the enter event occurs, that object's appropriate
 * method is invoked.
 *
 * @see EnterEvent
 */
public class EnterListener implements KeyListener {
	
	/** The button. */
	private JButton button;
	
	/**
	 * Instantiates a new enter listener.
	 *
	 * @param button the button
	 */
	public EnterListener(JButton button) {
		super();
		this.button = button;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			button.doClick();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		/*NULL BODY*/
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		/*NULL BODY*/
	}
}
