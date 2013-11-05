package ttable;

/**
 * The Class Level.
 */
public class Level{
	
	// Instance Variables
	
	/** The level from 1 to 12. */
	private int level;
	
	/** The mistakes allowed. */
	private int mistakesAllowed;

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets the mistakes allowed.
	 *
	 * @return the mistakes allowed
	 */
	public int getMistakesAllowed() {
		return mistakesAllowed;
	}

	/**
	 * Sets the mistakes allowed.
	 *
	 * @param mistakesAllowed the new mistakes allowed
	 */
	public void setMistakesAllowed(int mistakesAllowed) {
		this.mistakesAllowed = mistakesAllowed;
	}
}