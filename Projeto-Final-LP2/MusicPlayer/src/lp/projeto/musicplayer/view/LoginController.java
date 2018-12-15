package lp.projeto.musicplayer.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import lp.projeto.musicplayer.MainApp;
import lp.projeto.musicplayer.model.DataManager;
import lp.projeto.musicplayer.model.IncorrectPasswordException;
import lp.projeto.musicplayer.model.User;
import lp.projeto.musicplayer.model.UserNotRegisteredException;

/**
 * Classe para controle da tela de Login.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class LoginController {

    private static final String ERRO = "Erro!";

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    // Referencia para a aplicação principal.
    private MainApp mainApp;

    /**
     * Construtor da Classe de Controle.
     */
    public LoginController() {
        /*
         * Não é necessário iniciar nada no construtor. O FXML cria os objetos necessários, e os
         * dados são carregados apos a referencia do mainApp ser obtida.
         */
    }

    /**
     * Inicializa a classe de Controle, é chamado imediatamente após o carregamento do FXML.
     */
    @FXML
    private void initialize() {
        username.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });
        password.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });
    }

    /**
     * Método associado ao botão de Login, verifica se o usuario ja está cadastrado e se a senha
     * digitada confere com a senha armazenada. Se tudo estiver certo, troca para a tela do player.
     */
    @FXML
    private void login() {
        try {
            final User user = validateUser(username.getText(), password.getText());
            mainApp.setUser(user);
            mainApp.showPlayerOverview();
        } catch (UserNotRegisteredException | IncorrectPasswordException unre) {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(ERRO);
            alert.setHeaderText("Não foi possivel realizar o login");
            alert.setContentText(unre.getMessage());
            alert.showAndWait();
        } catch (final NullPointerException e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,
                                                                  "Erro durante o Login", e);
        }
    }

    /**
     * Adiciona uma referencia de volta para a aplicação principal, permitindo a troca de tela.
     *
     * @param mainApp
     *            Referencia para a aplicação principal.
     */
    public void setMainApp(final MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Valida o usuario, fazendo as devidas verificações, em relação a senha e existencia do login.
     *
     * @param login
     *            Login do usuario a ser buscado.
     * @param pass
     *            Senha digitada para a realização do login,
     * @return Usuario que corresponde ao login e senha informados.
     * @throws UserNotRegisteredException
     *             Caso o login não seja encontrado.
     * @throws IncorrectPasswordException
     *             Caso a senha informada esteja diferente da registrada.
     */
    private User validateUser(final String login, final String pass)
                    throws UserNotRegisteredException, IncorrectPasswordException {
        if ((login == null) || (pass == null)) {
            throw new NullPointerException();
        }
        final User user = DataManager.getInstance().getUser(login);
        if (user == null) {
            throw new UserNotRegisteredException();
        }
        if (user.validatePassword(pass)) {
            return user;
        }
        throw new IncorrectPasswordException();
    }
}
