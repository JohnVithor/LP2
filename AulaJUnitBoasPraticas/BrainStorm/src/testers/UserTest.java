/**
 * 
 */
package testers;

import brainstorm.User;

/**
 * @author JohnVithor
 *
 */
public class UserTest {
	/**
	 * 
	 */
	public UserTest() {
	}

	/**
	 * 
	 */
	public void constructorTest() {
		{
			try {
				@SuppressWarnings("unused")
				User user = new User(null, null, null);
				assert (false);
			} catch (RuntimeException re) {
				assert (true);
			}
		}
		{
			User user = new User("JV", "João Vítor", "./photo.png");
			String nick = user.getUsername();
			assert (nick.equals("JV"));
			String fullname = user.getFullname();
			assert (fullname.equals("João Vítor"));
			String photo = user.getPhotoUri();
			assert (photo.equals("./photo.png"));
		}
		{
			try {
				@SuppressWarnings("unused")
				User user = new User("", "", "");
				assert (false);
			} catch (RuntimeException re) {
				assert (true);
			}
		}
	}

}
