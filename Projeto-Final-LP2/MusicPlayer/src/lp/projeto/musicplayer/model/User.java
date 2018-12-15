package lp.projeto.musicplayer.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import lp.projeto.musicplayer.utility.Named;

/**
 * Classe que modela um Usuário Comum.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class User implements Comparable<User>, Named {

    /**
     * Método para encriptar a senha do usuário.
     *
     * @param senha
     *            Senha sem estar criptografada.
     * @return Senha criptografada.
     * @throws UserPasswordInvalidException
     *             Caso ocorra um erro durante a encriptação.
     */
    public static String cryptography(final String senha) throws UserPasswordInvalidException {
        // Tipo do algoritmo da Hash
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            // Transformando a senha em um array de bytes
            final byte[] messageDigestSenha = algorithm.digest(senha.getBytes("UTF-8"));
            // Transformando bytes em valores Hexadecimais
            final StringBuilder hexStringSenha = new StringBuilder();
            for (final byte b : messageDigestSenha) {
                hexStringSenha.append(String.format("%02X", 0xFF & b));
            }
            return hexStringSenha.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        throw new UserPasswordInvalidException();
    }

    private String login;

    private String password;

    private final int id;

    /**
     * Construtor parametrizado de um usuario. utilizando um login, uma senha e um id.
     *
     * @param login
     *            Login do usuario.
     * @param senha
     *            Senha do usuario
     * @param id
     *            Id do usuario.
     */
    public User(final String login, final String senha, final int id) {
        this.login = login;
        password = senha;
        this.id = id;
    }

    @Override
    public int compareTo(final User other) {
        if (equals(other)) {
            return 0;
        }
        if (id < other.id) {
            return -1;
        }
        if (id > other.id) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        final User other = (User) obj;
        final boolean l = login.equals(other.login);
        final boolean p = password.equals(other.password);
        final boolean i = id == other.id;
        return l && p && i;
    }

    /**
     * Informa o Id do usuario.
     *
     * @return O Id do usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Informa o login do usuario.
     *
     * @return O login do usuario.
     */
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return getLogin();
    }

    /**
     * Informa a senha do usuario.
     *
     * @return A senha do usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Altera o login do usuario.
     *
     * @param login
     *            O novo login do usuario.
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * Altera a senha do usuario.
     *
     * @param password
     *            A nova senha do usuario.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Verifica se a senha indicada confere com a senha armazenada.
     *
     * @param passwordTyped
     *            Senha a ser verificada.
     * @return True caso seja a senha armazenada, false caso contrario.
     */
    public boolean validatePassword(final String passwordTyped) {
        String typedCrypt = null;

        try {
            typedCrypt = cryptography(passwordTyped);
        } catch (final UserPasswordInvalidException e) {
            return false;
        }
        return password.equals(typedCrypt);

    }
}
