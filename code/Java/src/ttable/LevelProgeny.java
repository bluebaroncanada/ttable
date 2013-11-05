/**
 * 
 * 
 * Description: Handles a many-to-many join between Level and Progeny and provides settings for the game logic.
 * @author james
 * 
 */

package ttable;

import json.JSONFailureException;

/**
 * The Class LevelProgeny.
 */
public class LevelProgeny {

	/** The mistake count. */
	private String mistakes;
	
	/** The attempt count. */
	private String attempts;
	
	/** The final game high score. */
	private String finalGameHighScore;
	
	/** The final completion time. */
	private String finalCompletionTime;
	
	/** The age. */
	private String age;
	
	/** The progeny. */
	private Progeny progeny;
	
	/** The level. */
	private Level level;
	
	/** The id. */
	private String id;


	/**
	 * Delete a level progeny instance.
	 *
	 * @param levelProgeny the level progeny
	 */
	public static boolean deleteLevelProgeny(LevelProgeny levelProgeny) throws JSONFailureException
	{
		// TODO: make server call
		
		return true;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param level progeny the new age
	 */
	public static boolean changeAge(LevelProgeny levelProgeny) throws JSONFailureException
	{
		// TODO: make server call
		
		return true;
	}

	/**
	 * Gets the mistakes.
	 *
	 * @return the mistakes
	 */
	public String getMistakes() throws JSONFailureException
	{ 
		// TODO: make server call
		
		return "0";
	}

	/**
	 * Sets the mistakes.
	 *
	 * @param mistakes the new mistakes
	 */
	private boolean setMistakes(String mistakes) throws JSONFailureException 
	{
		// TODO: make server call
		
		return true;
	}

	/**
	 * Gets the attempts.
	 *
	 * @return the attempts
	 */
	public String getAttempts() throws JSONFailureException 
	{ 
		// TODO: make server call
		
		return "";
	}

	/**
	 * Sets the attempts.
	 *
	 * @param attempts the new attempts
	 */
	private boolean setAttempts(String attempts) throws JSONFailureException 
	{ 
		// TODO: make server call
		
		return true;
	}

	/**
	 * Gets the final game high score.
	 *
	 * @return the final game high score
	 */
	public String getFinalGameHighScore() throws JSONFailureException
	{ 
		// TODO: make server call
		
		return "";
	}

	/**
	 * Sets the final game high score.
	 *
	 * @param finalGameHighScore the new final game high score
	 */
	private boolean setFinalGameHighScore(String finalGameHighScore) throws JSONFailureException
	{
		// TODO: make server call
		
		return true;
	}

	/**
	 * Gets the final completion time.
	 *
	 * @return the final completion time
	 */
	public String getFinalCompletionTime() throws JSONFailureException
	{
		// TODO: make server call
		
		return "";
	}

	/**
	 * Sets the final completion time.
	 *
	 * @param finalCompletionTime the new final completion time
	 */
	private boolean setFinalCompletionTime(String finalCompletionTime) throws JSONFailureException
	{
		// TODO: make server call
		
		return true;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public String getAge() { return this.age; }

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	private void setAge(String age) { this.age = age; }
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() { return this.id; }

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) { this.id = id; }
	
	/**
	 * Gets the progeny.
	 *
	 * @return the progeny
	 */
	public Progeny getProgeny() { return this.progeny; }

	/**
	 * Sets the progeny.
	 *
	 * @param progeny the new progeny
	 */
	public void setProgeny(Progeny progeny) { this.progeny = progeny; }

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() { return this.level; }

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(Level level) { this.level = level; }
}
