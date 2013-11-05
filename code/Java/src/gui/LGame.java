package gui;

import java.awt.GridBagLayout;

/**
 * The Class LGame.
 */
public class LGame extends BackgroundPanel {
	
	/** The level. */
	private int level;
	
	/**
	 * Instantiates a new l game.
	 *
	 * @param controller the controller
	 * @param level the level
	 */
	public LGame(Controller controller, int level) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		this.level = level;
	}
}
