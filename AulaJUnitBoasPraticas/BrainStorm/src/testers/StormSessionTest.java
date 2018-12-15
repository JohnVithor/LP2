/**
 * 
 */
package testers;

import brainstorm.Idea;
import brainstorm.StormConfig;
import brainstorm.StormSession;
import brainstorm.User;

/**
 * @author JohnVithor
 *
 */
public class StormSessionTest {
	/**
	 * 
	 */
	public StormSessionTest() {
	}

	/**
	 * 
	 */
	public void constructorTest() {
		{
			User owner = new User("JV", "João Vítor", "./photo.png");
			StormSession stormSession = new StormSession("Be Awesome", "Gime Ideas Now!",
					new StormConfig(true, true, 10), owner);
			User user = stormSession.getOwner();
			assert (user.equals(owner));
			String goal = stormSession.getGoal();
			assert (goal.equals("Be Awesome"));
			String description = stormSession.getDescription();
			assert (description.equals("Gime Ideas Now!"));
		}
		{
			try {
				@SuppressWarnings("unused")
				StormSession stormSession = new StormSession("Be Awesome", "Gime Ideas Now!",
						new StormConfig(true, true, 10), null);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			try {
				User owner = new User("JV", "João Vítor", "./photo.png");
				@SuppressWarnings("unused")
				StormSession stormSession = new StormSession("", "Gime Ideas Now!", new StormConfig(true, true, 10),
						owner);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
	}

	/**
	 * 
	 */
	public void IdeasTest() {
		User owner = new User("JV", "João Vítor", "./photo.png");
		StormSession stormSession = new StormSession("Be Awesome", "Gime Ideas Now!", new StormConfig(true, true, 10),
				owner);
		{
			try {
				stormSession.addIdea(null);
				assert (false);
			} catch (Exception e) {
				assert (true);
			}
		}
		{
			try {
				stormSession.getIdeaAt(1);
				assert (false);
			} catch (Exception e) {
				assert (true);
			}
		}
		{
			Idea idea1 = new Idea("A good Idea", owner);
			stormSession.addIdea(idea1);
			Idea ideaRetrieved = stormSession.getIdeaAt(0);
			assert (idea1.equals(ideaRetrieved));
		}
	}

	/**
	 * 
	 */
	public void UsersTest() {
		User owner = new User("JV", "João Vítor", "./photo.png");
		StormSession stormSession = new StormSession("Be Awesome", "Gime Ideas Now!", new StormConfig(true, true, 10),
				owner);
		{
			try {
				stormSession.addUser(null);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			try {
				stormSession.removeUser(owner);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			int usersCount = stormSession.usersCount();
			assert (usersCount == 0);
			stormSession.addUser(owner);
			assert (usersCount == 1);
			try {
				stormSession.addUser(owner);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			
		}
	}
}
