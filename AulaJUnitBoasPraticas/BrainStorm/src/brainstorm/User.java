/**
 * 
 */
package brainstorm;

/**
 * @author JohnVithor
 *
 */
public class User {
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String fullname;
	/**
	 * 
	 */
	private String photoUri;

	/**
	 * @param username
	 * @param fullname
	 * @param photoUri
	 */
	public User(String username, String fullname, String photoUri) throws RuntimeException{
		if (username == null || fullname == null || photoUri == null) {
			throw new RuntimeException();
		}
		this.username = username;
		this.fullname = fullname;
		this.photoUri = photoUri;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @return the photoUri
	 */
	public String getPhotoUri() {
		return photoUri;
	}

}
