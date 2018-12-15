package lp.projeto.musicplayer.view;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import lp.projeto.musicplayer.MainApp;
import lp.projeto.musicplayer.model.DataManager;
import lp.projeto.musicplayer.model.Music;
import lp.projeto.musicplayer.model.NoMusicSelectedException;
import lp.projeto.musicplayer.model.PlayList;
import lp.projeto.musicplayer.model.Player;
import lp.projeto.musicplayer.model.UserVip;
import lp.projeto.musicplayer.utility.Trie;

/**
 * Classe de Controle da tela do Player.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class PlayerOverviewController {
    private static final String AVISO = "Aviso";

    //
    @FXML
    private Label username;
    @FXML
    private Label userType;

    //
    private Player player;
    @FXML
    private Label currentMusicTitle;
    @FXML
    private Slider timeSlider;
    @FXML
    private Label timeLabel;

    //
    private PlayList allMusics;
    private ObservableList<Music> allMusicsData;
    @FXML
    private TableView<Music> allMusicsTable;
    @FXML
    private TableColumn<Music, String> allMusicsColumn;

    //
    private PlayList currentPlayList;
    private ObservableList<Music> currentPlayListData;
    @FXML
    private TableView<Music> currentPlayListTable;
    @FXML
    private TableColumn<Music, String> currentPlayListColumn;
    @FXML
    private Label currentPlayListTitle;

    //
    private ObservableList<PlayList> playListData;
    @FXML
    private TableView<PlayList> playListTable;
    @FXML
    private TableColumn<PlayList, String> playListsColumn;
    @FXML
    private TextField playsListName;

    //
    private Trie trie;
    @FXML
    private TextField searchMusic;
    @FXML
    private ContextMenu entriesPopup;
    //
    private PlayList lastSelectedPlaylist;

    private Music lastSelectedMusic;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * Construtor da Classe de Controle.
     */
    public PlayerOverviewController() {
        /*
         * Não é necessario instaciar nada durante a construção do objeto, todos os seus elementos
         * são gerenciados pelo FXML associado ou são inicializados após a referencia do mainApp ser
         * obtida.
         */
    }

    /**
     * Adiciona todas as musicas de um diretorio escolhido pelo FileChoosser.
     */
    @FXML
    private void addDirectory() {
        final DirectoryChooser fileChooser = new DirectoryChooser();
        final File file = fileChooser.showDialog(mainApp.getPrimaryStage());
        if ((file != null) && file.isDirectory()) {
            final File[] files = file.listFiles();
            Music m;
            for (final File file2 : files) {
                if (file2.getName().endsWith(".mp3")) {
                    try {
                        m = new Music(file2.toURI().toString(),
                                        file2.getName().substring(0, file2.getName().length() - 4));
                        allMusics.add(m);
                        trie.insert(m);
                        allMusicsData = allMusics.getMusics();
                        allMusicsTable.setItems(allMusicsData);
                    } catch (final URISyntaxException e) {
                        final Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle(AVISO);
                        alert.setHeaderText("Não foi possivel adicionar a musica selecionada.");
                        alert.showAndWait();
                    }
                }
            }
        }
    }

    /**
     * Método associado a botão de adicionar uma musica. Adiciona a musica escolhida pelo
     * FileChooser
     */
    @FXML
    private void addMusic() {
        final FileChooser fileChooser = new FileChooser();
        final FileChooser.ExtensionFilter extFilter =
                        new FileChooser.ExtensionFilter("MP3 files (*.mp3)", "*.mp3");
        fileChooser.getExtensionFilters().add(extFilter);

        final File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file != null) {
            Music m;
            try {
                m = new Music(file.toURI().toString(),
                                file.getName().substring(0, file.getName().length() - 4));
                allMusics.add(m);
                trie.insert(m);
                allMusicsData = allMusics.getMusics();
                allMusicsTable.setItems(allMusicsData);
            } catch (final URISyntaxException e) {
                final Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(AVISO);
                alert.setHeaderText("Não foi possivel adicionar a musica selecionada.");
                alert.showAndWait();
            }

        }
    }

    /**
     * Adiciona a musica selecionada para a playlist atual.
     */
    @FXML
    private void addToPlaylist() {
        if (verificateVipAccess() && (currentPlayList != null)) {
            currentPlayList.add(lastSelectedMusic);
        }
    }

    /**
     * Avança ou volta para um instante de tempo da reprodução da musica atual.
     */
    @FXML
    private void changePlayTime() {
        if (!timeSlider.isValueChanging()) {
            player.setPlayTime(timeSlider.getValue());
        }
    }

    /**
     * Inicializa a classe de Controle, é chamado imediatamente após o carregamento do FXML.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        playListsColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());

        allMusicsColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        currentPlayListColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
    }

    /**
     * Carrega os componentes necesarios para o funcionamento da tela do player.
     */
    public void loadComponents() {
        allMusics = new PlayList("All Musics", "Everybody", DataManager.getInstance().getMusics());

        trie = new Trie();
        player = new Player(allMusics);
        allMusicsData = allMusics.getMusics();
        DataManager.getInstance().setMusics(allMusicsData);
        for (final Music music : allMusicsData) {
            trie.insert(music);
        }

        if (mainApp.getUser() instanceof UserVip) {
            playListData = ((UserVip) mainApp.getUser()).getPlaylists();
            playListTable.setItems(playListData);
        }

        allMusicsTable.setItems(allMusicsData);

        currentMusicTitle.setText("No music Selected");
        currentPlayListTable.setItems(currentPlayListData);

        username.setText(mainApp.getUser().getLogin());
        if (mainApp.getUser() instanceof UserVip) {
            userType.setText("VIP");
        } else {
            userType.setText("");
        }
    }

    /**
     * Realiza o logoff do usuario e salva os dados da sessão. Volta para a tela de Login depois.
     */
    @FXML
    private void logoff() {
        stop();
        try {
            DataManager.getInstance().writePlaylistFiles();
            DataManager.getInstance().writeUsersFile();
            DataManager.getInstance().writeMusics();
        } catch (final IOException e) {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(AVISO);
            alert.setHeaderText("Ocorreu um erro durante o logoff");
            alert.setContentText("Algum dos dados da sessão podem não ter sido salvos.");
            alert.showAndWait();
        }
        mainApp.setUser(null);
        mainApp.showLoginOverview();
    }

    /**
     * Adiciona uma nova playlist a lista de playlists do usuario logado.
     */
    @FXML
    private void newPlayList() {
        if (verificateVipAccess()) {
            final String title = playsListName.getText();
            if ((title != null) && !title.equals("")) {
                for (final PlayList list : playListData) {
                    if (list.getTitle().equals(title)) {
                        final Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Nome de PlayList Inválido!");
                        alert.setHeaderText("Por favor, escolha outro nome.");
                        alert.setContentText("O nome '" + title
                                        + "' já foi atribuido a outra PlayList");
                        alert.showAndWait();
                        return;
                    }
                }
                playListData.add(new PlayList(title, mainApp.getUser().getLogin()));
            }
        }
    }

    /**
     * Método associado ao botão de Registro, verifica se o usuario é VIP, trocando para a tela de
     * registro caso tudo esteja certo.
     */
    @FXML
    private void newUser() {
        if (verificateVipAccess()) {
            mainApp.showRegisterOverview();
        }
    }

    /**
     * Avança para a proxima musica na playlist atual do player.
     */
    @FXML
    private void next() {
        if (player != null) {
            player.next();
            lastSelectedMusic = player.getPlaying();
            currentMusicTitle.setText(lastSelectedMusic.getTitle());
            player.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                if (!timeSlider.isValueChanging()) {
                    timeSlider.setValue(newTime.toMillis());
                    timeSlider.setMax(player.getTotalDuration().toMillis());
                    timeLabel.setText(player.formatTime());
                }
            });
        }
    }

    /**
     * Pausa a reprodução da musica atual.
     */
    @FXML
    private void pause() {
        if ((player != null) && (player.getPlaying() != null)) {
            player.pause();
        }
    }

    /**
     * Inicia a reprodução da musica selecionada. Ou continua a reprodução a partir de onde foi
     * pausada.
     */
    @FXML
    private void play() {
        try {
            player.setCurrent(lastSelectedMusic);
        } catch (final NoMusicSelectedException nmse) {
            return;
        }
        if (player.getPlaying() != null) {
            currentMusicTitle.setText(lastSelectedMusic.getTitle());

            player.play();

            player.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                if (!timeSlider.isValueChanging()) {
                    timeSlider.setValue(newTime.toMillis());
                    timeSlider.setMax(player.getTotalDuration().toMillis());
                    timeLabel.setText(player.formatTime());
                }
            });
        }
    }

    /**
     * Preenche o popup das possiveis musicas a serem pesquisadas.
     *
     * @param searchResult
     *            Lista com as possiveis pesquisas a serem mostradas.
     */
    private void populatePopup(final List<String> searchResult) {
        final List<CustomMenuItem> menuItems = new LinkedList<>();
        final int maxEntries = 10;
        final int count = Math.min(searchResult.size(), maxEntries);
        for (int i = 0; i < count; i++) {
            final String result = searchResult.get(i);
            final Label entryLabel = new Label(result);
            final CustomMenuItem item = new CustomMenuItem(entryLabel, true);
            item.setOnAction(actionEvent -> {
                searchMusic.setText(result);
                entriesPopup.hide();
            });
            menuItems.add(item);
        }
        entriesPopup.getItems().clear();
        entriesPopup.getItems().addAll(menuItems);
    }

    /**
     * Volta para a musica anterior na playlist atual do player.
     */
    @FXML
    private void previous() {
        if (player != null) {
            player.previous();
            lastSelectedMusic = player.getPlaying();
            currentMusicTitle.setText(lastSelectedMusic.getTitle());
            player.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                if (!timeSlider.isValueChanging()) {
                    timeSlider.setValue(newTime.toMillis());
                    timeSlider.setMax(player.getTotalDuration().toMillis());
                    timeLabel.setText(player.formatTime());
                }
            });
        }
    }

    /**
     * Remove todas as musicas do diretorio selecionado da biblioteca de musicas.
     */
    @FXML
    private void removeFolder() {
        if (verificateVipAccess()) {
            if (!allMusicsData.isEmpty()) {
                final DirectoryChooser fileChooser = new DirectoryChooser();
                final File file = fileChooser.showDialog(mainApp.getPrimaryStage());
                final Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(AVISO);
                alert.setHeaderText("Tem certeza que quer excluir as musicas desse diretorio ?");
                alert.setContentText("Pode causar problemas nas playlists cadastradas.");
                alert.showAndWait();
                if (alert.getResult().getButtonData().isDefaultButton() && (file != null)
                                && file.isDirectory()) {
                    final File[] files = file.listFiles();
                    removeMusicsFromFolder(files);
                    return;
                }
            }
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(AVISO);
            alert.setHeaderText("Não existe musica alguma cadastrada.");
            alert.showAndWait();
        }
    }

    /**
     * Remove a musica selecionada da playlist atual.
     */
    @FXML
    private void removeFromPlaylist() {
        if (verificateVipAccess() && (currentPlayList != null)) {
            currentPlayList.remove(lastSelectedMusic);
        }
    }

    /**
     * Remove a musica atualmente selecionada da biblioteca de musicas.
     */
    @FXML
    private void removeMusic() {
        if (verificateVipAccess()) {
            if (!allMusicsData.isEmpty() && (lastSelectedMusic != null)) {
                final Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(AVISO);
                alert.setHeaderText("Tem certeza que quer excluir a musica"
                                + lastSelectedMusic.getTitle() + "?");
                alert.setContentText("Pode causar problemas nas playlists cadastradas.");
                alert.showAndWait();
                if (alert.getResult().getButtonData().isDefaultButton()) {
                    allMusics.remove(lastSelectedMusic);
                    trie.remove(lastSelectedMusic.getTitle());
                    allMusicsData = allMusics.getMusics();
                    return;
                }
            }
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(AVISO);
            alert.setHeaderText("Não existe musica alguma cadastrada.");
            alert.showAndWait();
        }
    }

    /**
     * Remove todas as musicas cadastradas que estiverem na lista de arquivos informados.
     *
     * @param files
     *            Lista de arquivos que podem conter as musicas a serem removidas.
     */
    private void removeMusicsFromFolder(final File[] files) {
        for (final File file2 : files) {
            try {
                final String name = file2.getName().substring(0, file2.getName().length() - 4);
                allMusics.remove(name);
                trie.remove(name);
                allMusicsData = allMusics.getMusics();
            } catch (final Exception e) {
                Logger.getLogger(PlayerOverviewController.class.getName())
                                .log(Level.SEVERE,
                                     "'" + file2.getName() + "' não pode ser excluido.", e);
            }
        }
    }

    /*
     * Remove a playlist selecionada da lista de playlists associada ao usuario logado.
     */
    @FXML
    private void removePlayList() {
        if (verificateVipAccess() && (currentPlayList != null)) {
            playListData.remove(lastSelectedPlaylist);
        }
    }

    /**
     * Metodo associado ao botão de realizar pesquisa. Pesquisa as musicas a partir do nome
     * informado no campo de busca e mostra os resultados na tabela de playlists.
     */
    @FXML
    private void searchMusic() {
        final String title = searchMusic.getText();
        if (title != null) {
            currentPlayList = new PlayList("Search for '" + title + "'", "temp",
                            trie.recoverMusics(title));
            currentPlayListData = currentPlayList.getMusics();
            currentPlayListTable.setItems(currentPlayListData);
            currentPlayListTitle.setText(currentPlayList.getTitle());
        }
    }

    /**
     * Pesquisa as possiveis musicas que podem estar sendo pesquisadas e as mostra num popup abaixo
     * do campo de pesquisa.
     */
    @FXML
    private void searchMusicText() {
        final String enteredText = searchMusic.getText();
        if ((enteredText == null) || enteredText.isEmpty()) {
            entriesPopup.hide();
        } else {
            final List<String> filteredEntries = trie.recoverWords(enteredText);
            if (!filteredEntries.isEmpty()) {
                populatePopup(filteredEntries);
                if (!entriesPopup.isShowing()) {
                    entriesPopup.show(searchMusic, Side.BOTTOM, 10, 10);
                }
            } else {
                entriesPopup.hide();
            }
        }
    }

    /**
     * Altera a musica selecionada por uma musica da biblioteca de musicas.
     */
    @FXML
    private void selectedMusicAll() {
        if (allMusicsData.isEmpty()) {
            return;
        }
        selectedMusicAt(allMusicsTable);
        player.setPlayList(allMusics);
    }

    /**
     * Seleciona uma musica a partir de uma TableView.
     *
     * @param table
     *            TableView onde a musica foi selecionada.
     */
    private void selectedMusicAt(final TableView<Music> table) {
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                if ((lastSelectedMusic == table.getSelectionModel().getSelectedItem())
                                && (lastSelectedMusic != null)) {
                    play();
                }
            } else if (event.getClickCount() == 1) {
                lastSelectedMusic = table.getSelectionModel().getSelectedItem();
            }
        });
    }

    /**
     * Altera a musica selecionada por uma musica da playlist atualmente mostrada.
     */
    @FXML
    private void selectedMusicPlaylist() {
        if ((currentPlayListData == null) || currentPlayListData.isEmpty()) {
            return;
        }
        selectedMusicAt(currentPlayListTable);
        player.setPlayList(currentPlayList);
    }

    /**
     * Seleciona uma playlists a partir dos cliques do mouse.
     */
    @FXML
    private void selectedPlaylist() {
        playListTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                if (lastSelectedPlaylist == playListTable.getSelectionModel().getSelectedItem()) {
                    currentPlayList = lastSelectedPlaylist;
                    currentPlayListData = currentPlayList.getMusics();
                    currentPlayListTable.setItems(currentPlayListData);
                    currentPlayListTitle.setText(currentPlayList.toString());
                }
            } else if (event.getClickCount() == 1) {
                lastSelectedPlaylist = playListTable.getSelectionModel().getSelectedItem();
            }
        });
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
     * Interrompe a reprodução da musica atual.
     */
    @FXML
    private void stop() {
        if ((player != null) && (player.getPlaying() != null)) {
            player.stop();
        }
    }

    /**
     * Verifica se o usuario logado é um vip. Serve para realizar o controle de acesso das
     * funcionalidades.
     *
     * @return
     */
    private boolean verificateVipAccess() {
        if (!(mainApp.getUser() instanceof UserVip)) {
            final Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle(AVISO);
            alert.setHeaderText("Recurso disponivel apenas para VIPs");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
