package ttable;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import json.Json;
import json.JSONFailureException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import ttable.Level;
import ttable.Progeny;

/**
 * The Class Progeny.
 */
public class Progeny {

	/** The first name. */
	private String firstName;
	
	/** The age. */
	private String age;
	
	/** The id. */
	private String id;
	
	/**
	 * Adds the progeny.
	 *
	 * @param firstName the first name
	 * @param age the age
	 * @return the progeny
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static Progeny addProgeny(String firstName, String age) throws JSONFailureException
	{
		Progeny progeny = new Progeny();
		
		Json json = new Json();
		JSONObject jsonUser = (JSONObject)json.sendRequest("https://jbaron6.cs2212.ca/addchild?first_name=" + firstName + "&age=" + age);
	
		// TODO: parse the array of the new progeny
		jsonUser.get("");
		
		return progeny;
	}
	
	/**
	 * Change age.
	 *
	 * @param progeny the progeny
	 * @param age the age
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean changeAge(Progeny progeny, String age) throws JSONFailureException 
	{
		// TODO: Make server call

		return true;
	}

	/**
	 * Change time allowed.
	 *
	 * @param progeny the progeny
	 * @param timeAllowed the time allowed
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean changeTimeAllowed(Progeny progeny, String timeAllowed) throws JSONFailureException
	{
		// TODO: Make server call
		
		return true;
	}

	/**
	 * Gets the levels.
	 *
	 * @param progeny the progeny
	 * @return the levels
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static ArrayList<Level> getLevels(Progeny progeny) throws JSONFailureException
	{
		ArrayList<Level> levels;
		
		// TODO: delete this line
		levels = new ArrayList<>();
		
		//TODO: make server call
		
		//TODO: parse the array
		
		return levels;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the level
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public static boolean setLevel(Integer level) throws JSONFailureException
	{
		// TODO: Make server call
		
		return true;
	}

	/**
	 * Delete progeny.
	 *
	 * @param progeny the progeny
	 * @return true, if successful
	 * @throws JSONFailureException the jSON failure exception
	 */
	public boolean deleteProgeny(Progeny progeny) throws JSONFailureException
	{
		// TODO: Make server call
		
		return true;
	}

	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
