package lp.projeto.musicplayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lp.projeto.musicplayer.model.DataManager;
import lp.projeto.musicplayer.model.User;
import lp.projeto.musicplayer.view.LoginController;
import lp.projeto.musicplayer.view.PlayerOverviewController;
import lp.projeto.musicplayer.view.RegisterOverviewController;

/**
 * Classe Principal que carrega os FXMLs e os prepara para serem mostrados na janela da Aplicação.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class MainApp extends Application {

    /**
     * Função Main para iniciar o programa.
     *
     * @param args
     *            Argumentos de inicio do programa.
     */
    public static void main(final String[] args) {
        launch(args);
    }

    private User user;

    private Stage primaryStage;

    private BorderPane rootLayout;

    /**
     * Informa qual o estagio primario.
     *
     * @return O primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Informa qual o usuário atual do programa.
     *
     * @return O usuário atual do programa.
     */
    public User getUser() {
        return user;
    }

    /**
     * Inicia o FXML onde os outros serão mostrados. A Scene Root.
     */
    public void initRootLayout() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            final Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(600);
            primaryStage.setMinHeight(500);
            primaryStage.show();
        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE, "Erro na inicialização da janela principal.", e);
            System.exit(1);
        }
    }

    /**
     * Altera o usuario atual do programa.
     *
     * @param user
     *            Novo usuario do programa.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Carrega o FXML responsável pela tela de Login.
     */
    public void showLoginOverview() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/UserLogin.fxml"));
            final AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview);

            final LoginController controller = loader.getController();
            controller.setMainApp(this);
        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE, "Erro na inicialização da janela do login.", e);
            System.exit(1);
        }
    }

    /**
     * Carrega o FXML responsável pela tela principal do Player.
     */
    public void showPlayerOverview() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PlayerOverview.fxml"));
            final AnchorPane playerOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(playerOverview);

            final PlayerOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.loadComponents();

        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE, "Erro na inicialização da janela do player.", e);
            System.exit(1);
        }
    }

    /**
     * Carrega o FXML responsável pela tela de Registro.
     */
    public void showRegisterOverview() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/UserRegister.fxml"));
            final AnchorPane userRegister = (AnchorPane) loader.load();

            rootLayout.setCenter(userRegister);

            final RegisterOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE,
                                 "Erro na inicialização da janela de registro de novo usuario.", e);
            System.exit(1);
        }
    }

    @Override
    public void start(final Stage primaryStage) {
        try {
            DataManager.getInstance().loadMusics();
        } catch (final IOException e) {
            DataManager.getInstance().setMusics(new ArrayList<>());
        }
        try {
            DataManager.getInstance().loadUsers();
            DataManager.getInstance().loadPlaylists();
        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE,
                                 "Erro durante a leitura dos usuarios ou nas suas playlists.", e);
            System.exit(1);
        }

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MusicPlayer");

        initRootLayout();
        showLoginOverview();
    }

    @Override
    public void stop() throws Exception {
        DataManager.getInstance().writePlaylistFiles();
        DataManager.getInstance().writeUsersFile();
        DataManager.getInstance().writeMusics();
        super.stop();
    }
}
