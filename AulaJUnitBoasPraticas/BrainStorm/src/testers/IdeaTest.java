/**
 * 
 */
package testers;

import brainstorm.Idea;
import brainstorm.User;

/**
 * @author JohnVithor
 *
 */
public class IdeaTest {
	/**
	 * 
	 */
	public IdeaTest() {
	}

	public void constructorTest() {
		{
			try {
				@SuppressWarnings("unused")
				Idea idea = new Idea("Ideia brilhante", null);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			try {
				User user = new User("JV", "João Vítor", "./photo.png");
				@SuppressWarnings("unused")
				Idea idea = new Idea(null, user);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			try {
				User user = new User("JV", "João Vítor", "./photo.png");
				@SuppressWarnings("unused")
				Idea idea = new Idea("", user);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
		{
			User user = new User("JV", "João Vítor", "./photo.png");
			Idea idea = new Idea("Ideia brilhante", user);
			String texto = idea.getText();
			User userReturned = idea.getAuthor();
			assert (texto.equals("Ideia brilhante"));
			assert (userReturned.equals(user));
		}
	}

	/**
	 * 
	 */
	public void voteAndUnVoteTest() {
		{
			User author = new User("JV", "João Vítor", "./photo.png");
			User voter1 = new User("Alguém", "Alguém da Silva", "./photo1.png");
			User voter2 = new User("Ninguém", "Ninguém de Souza", "./photo1.png");
			Idea idea = new Idea("Ideia brilhante", author);
			try {
				idea.vote(voter1);
				assert (true);
			} catch (RuntimeException e) {
				assert (false);
			}
			try {
				idea.vote(voter1);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
			try {
				idea.vote(voter2);
				assert (true);
			} catch (RuntimeException e) {
				assert (false);
			}
			try {
				idea.unVote(voter1);
				assert (true);
			} catch (RuntimeException e) {
				assert (false);
			}
			try {
				idea.unVote(voter2);
				assert (true);
			} catch (RuntimeException e) {
				assert (false);
			}
			try {
				idea.unVote(voter1);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
			try {
				idea.unVote(null);
				assert (false);
			} catch (RuntimeException e) {
				assert (true);
			}
		}
	}

	public void getVotesTest() {
		{
			User author = new User("JV", "João Vítor", "./photo.png");
			User voter1 = new User("Alguém", "Alguém da Silva", "./photo1.png");
			User voter2 = new User("Ninguém", "Ninguém de Souza", "./photo1.png");
			Idea idea = new Idea("Ideia brilhante", author);
			int votes = idea.getVotes();
			assert (votes == 0);

			idea.vote(voter1);
			votes = idea.getVotes();
			assert (votes == 1);

			idea.vote(voter2);
			votes = idea.getVotes();
			assert (votes == 2);

			idea.unVote(voter2);
			votes = idea.getVotes();
			assert (votes == 1);

			idea.unVote(voter1);
			votes = idea.getVotes();
			assert (votes == 0);
		}
	}
}
