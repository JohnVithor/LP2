package lp.projeto.musicplayer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import lp.projeto.musicplayer.MainApp;
import lp.projeto.musicplayer.model.DataManager;
import lp.projeto.musicplayer.model.UserExistException;

/**
 * Classe de Controle da tela de Registro de novos usuários.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class RegisterOverviewController {

    private MainApp mainApp;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private CheckBox checkBox;

    /**
     * Cancela o registro de um novo usuário e retorna para a tela do Player.
     */
    @FXML
    private void cancel() {
        mainApp.showPlayerOverview();
    }

    /**
     * Inicializa a classe de Controle, é chamado imediatamente após o carregamento do FXML.
     */
    @FXML
    private void initialize() {
        username.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                register();
            }
        });
        password.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                register();
            }
        });
        confirmPassword.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                register();
            }
        });
    }

    /**
     * Método associado ao botão de registro. Verifica se o nome de usuario esta disponivel e se a
     * senha informada confere com a confirmação da senha.
     */
    @FXML
    private void register() {
        final String login = username.getText();
        final String pass = password.getText();
        final String confirmedPass = confirmPassword.getText();
        final boolean vip = checkBox.isSelected();
        if ((login != null) && (pass != null) && (confirmedPass != null)
                        && pass.equals(confirmedPass)) {
            try {
                DataManager.getInstance().registerUser(login, pass,
                                                       DataManager.getInstance().numberOfUsers(),
                                                       vip);
                final Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso!");
                alert.setHeaderText("Usuario disponivel para uso.");
                alert.setContentText("Gostaria de voltar para a tela do Player?");
                alert.showAndWait();
                if (alert.getResult().getButtonData().isDefaultButton()) {
                    cancel();
                }
            } catch (final UserExistException e) {
                final Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText("Nome de usuario já em uso!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
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
}
