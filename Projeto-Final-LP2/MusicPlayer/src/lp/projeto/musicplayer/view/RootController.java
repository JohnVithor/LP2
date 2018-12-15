package lp.projeto.musicplayer.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import lp.projeto.musicplayer.MainApp;
import lp.projeto.musicplayer.model.DataManager;

/**
 * Classe de Controle da Tela Raiz da aplicação.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class RootController {

    /**
     * Salva os dados da aplicação e sai do programa.
     */
    @FXML
    private void exitAndSaveData() {
        saveData();
        System.exit(0);
    }

    /**
     * Permite o salvamento dos dados sem realizar o logoff ou encerrar a aplicação.
     */
    @FXML
    private void saveData() {
        try {
            DataManager.getInstance().writePlaylistFiles();
            DataManager.getInstance().writeUsersFile();
            DataManager.getInstance().writeMusics();
        } catch (final IOException e) {
            Logger.getLogger(MainApp.class.getName())
                            .log(Level.SEVERE, "Erro no salvamento dos dados do player.", e);
        }
    }
}
