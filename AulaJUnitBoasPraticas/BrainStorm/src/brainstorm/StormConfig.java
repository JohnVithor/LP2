/**
 * 
 */
package brainstorm;

/**
 * @author JohnVithor
 *
 */
public class StormConfig {
	/**
	 * 
	 */
	public boolean isAnonymous;
	/**
	 * 
	 */
	public boolean hasVoting;
	/**
	 * 
	 */
	public int votingLimit;

	/**
	 * @param isAnonymous
	 * @param hasVoting
	 * @param votingLimit
	 */
	public StormConfig(boolean isAnonymous, boolean hasVoting, int votingLimit) {
		this.isAnonymous = isAnonymous;
		this.hasVoting = hasVoting;
		this.votingLimit = votingLimit;
	}

}
