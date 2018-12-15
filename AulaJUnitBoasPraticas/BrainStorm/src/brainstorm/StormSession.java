/**
 * 
 */
package brainstorm;

import java.util.ArrayList;

/**
 * @author JohnVithor
 *
 */
public class StormSession {
	/**
	 * 
	 */
	private String goal;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private StormConfig stormConfig;
	/**
	 * 
	 */
	private User owner;
	/**
	 * 
	 */
	private ArrayList<User> participants;
	/**
	 * 
	 */
	private ArrayList<Idea> ideas;

	/**
	 * @param goal
	 * @param description
	 * @param stormConfig
	 * @param owner
	 */
	public StormSession(String goal, String description, StormConfig stormConfig, User owner) {
		this.goal = goal;
		this.description = description;
		this.stormConfig = stormConfig;
		this.owner = owner;
		this.participants = new ArrayList<>();
		this.ideas = new ArrayList<>();
	}

	/**
	 * 
	 * @param pos
	 * @return
	 */
	public Idea getIdeaAt(int pos) {
		return null;
	}

	/**
	 * 
	 * @param idea
	 */
	public void addIdea(Idea idea) {

	}

	/**
	 * 
	 * @param user
	 */
	public void addUser(User user) {

	}

	/**
	 * 
	 * @param user
	 */
	public void removeUser(User user) {

	}

	/**
	 * @return the goal
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the stormConfig
	 */
	public StormConfig getStormConfig() {
		return stormConfig;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @return the participants
	 */
	public ArrayList<User> getParticipants() {
		return participants;
	}

	/**
	 * @return the ideas
	 */
	public ArrayList<Idea> getIdeas() {
		return ideas;
	}

	/**
	 * 
	 * @return
	 */
	public int usersCount() {
		return participants.size();
	}
}
