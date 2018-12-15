package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lp.projeto.musicplayer.model.User;
import lp.projeto.musicplayer.model.UserPasswordInvalidException;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes do User.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class UserTest {

    @Test
    void testCompareTo() {
        final User user2 = new User("2", "2", 2);
        int result = user2.compareTo(user2);
        assertEquals(0, result);
        final User user1 = new User("1", "1", 1);
        result = user2.compareTo(user1);
        assertEquals(1, result);
        final User user3 = new User("3", "3", 3);
        result = user2.compareTo(user3);
        assertEquals(-1, result);
        final User user1copy = new User("1", "1", 1);
        result = user1.compareTo(user1copy);
        assertEquals(0, result);
    }

    @Test
    void testGetName() {
        final User named = new User("named", "named", 1);
        assertEquals("named", named.getName());
    }

    @Test
    void testUser() throws UserPasswordInvalidException {
        final User user = new User(null, null, 0);
        assertEquals(null, user.getLogin());
        assertEquals(null, user.getPassword());
        assertEquals(0, user.getId());
        user.setLogin("user");
        user.setPassword(User.cryptography("password"));
        assertEquals("user", user.getLogin());
        assertEquals(User.cryptography("password"), user.getPassword());
    }

}
