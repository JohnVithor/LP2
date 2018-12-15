/**
 * 
 */
package brainstorm;

import java.util.ArrayList;

/**
 * @author JohnVithor
 *
 */
public class Idea {
	/**
	 * 
	 */
	private String text;
	/**
	 * 
	 */
	private User author;
	/**
	 * 
	 */
	private ArrayList<User> voters;

	/**
	 * @param text
	 * @param author
	 */
	public Idea(String text, User author) {
		this.text = text;
		this.author = author;
	}

	/**
	 * 
	 * @param voter
	 */
	public final void vote(User voter) {

	}

	/**
	 * 
	 * @param voter
	 */
	public final void unVote(User voter) {

	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * 
	 * @return
	 */
	public int getVotes() {
		return voters.size();
	}

}
