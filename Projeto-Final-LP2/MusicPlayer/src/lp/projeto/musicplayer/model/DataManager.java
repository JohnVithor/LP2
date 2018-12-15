package lp.projeto.musicplayer.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lp.projeto.musicplayer.utility.AvlTree;

/**
 * Classe que gerencia a persistência dos dados do Player, tanto de Usuários como de Músicas e
 * Playlists.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class DataManager {

    private static final String DEFAULT =
                    "0;true;ADMIN;8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918;";

    private static DataManager instance;

    /**
     * Método de acesso a única instancia do DataManager permitida. De acordo com o pattern do
     * Singleton.
     *
     * @return A única instancia do DataManager.
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private final AvlTree<User> users;

    private List<Music> musics;

    /*
     * Construtor padrão, inicializa a lista de músicas e a árvore de usuários
     */
    private DataManager() {
        musics = new ArrayList<>();
        users = new AvlTree<>();
    }

    /**
     * Retorna a Lista de musicas carregadas.
     *
     * @return A Lista de musicas carregadas.
     */
    public List<Music> getMusics() {
        return musics;
    }

    /**
     * Recupera um usuario apartir de seu login.
     *
     * @param login
     *            Login do usuario buscado.
     * @return Usuario buscado. Ou null caso não seja encontrado.
     */
    public User getUser(final String login) {
        return users.searchByName(login);
    }

    /**
     * Permite o acesso a uma lista dos usuarios armazenados na arvore de usuarios.
     *
     * @return Uma lista de usuários obtida a partir da árvore.
     */
    public List<User> getUsers() {
        return users.inorder();
    }

    /**
     * Carrega as musicas presentes na biblioteca a partir de um arquivo.
     *
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileReader ou o BufferedReader
     */
    public void loadMusics() throws IOException {
        final FileReader archive = new FileReader("Musicas.txt");
        final ArrayList<String> fileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(archive)) {
            String line = reader.readLine();
            while (line != null) {
                fileLines.add(line);
                line = reader.readLine();
            }
        } catch (final Exception e) {
            Logger.getLogger(DataManager.class.getName())
                            .log(Level.SEVERE,
                                 "Erro durante o carregamento da biblioteca de musicas", e);
        }
        archive.close();

        if (!fileLines.isEmpty()) {
            for (final String fileLine : fileLines) {
                try {
                    final int separatorTitlePath = fileLine.indexOf(';');
                    final int lastSeparator = fileLine.indexOf(';', separatorTitlePath + 1);
                    final String currentTitle = fileLine.substring(0, separatorTitlePath);
                    final String currentPath =
                                    fileLine.substring(separatorTitlePath + 1, lastSeparator);
                    musics.add(new Music(currentPath, currentTitle));
                } catch (final URISyntaxException e) {
                    Logger.getLogger(DataManager.class.getName())
                                    .log(Level.SEVERE, fileLines + "não foi adicionado", e);
                } catch (final StringIndexOutOfBoundsException ex) {
                    Logger.getLogger(DataManager.class.getName())
                                    .log(Level.SEVERE, "'" + fileLine + "' não foi compreendido",
                                         ex);
                }
            }
        }
    }

    /**
     * Metodo para carregar todas as Playlists no sistema de cada Usuario.
     *
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileWriter ou o PrintWriter
     */
    public void loadPlaylists() throws IOException {
        for (final User user : users.inorder()) {
            if (user instanceof UserVip) {
                final ArrayList<String> currentPlaylists = readPlayListsUser((UserVip) user);
                for (final String currentPlaylist : currentPlaylists) {
                    final FileReader archive = new FileReader(currentPlaylist);
                    final ArrayList<String> fileLines = new ArrayList<>();
                    try (BufferedReader reader = new BufferedReader(archive)) {
                        String line = reader.readLine();
                        while (line != null) {
                            fileLines.add(line);
                            line = reader.readLine();
                        }
                    } catch (final Exception e) {
                        Logger.getLogger(DataManager.class.getName())
                                        .log(Level.SEVERE,
                                             "Erro durante o carregamento de uma playlist", e);
                        System.exit(1);
                    }

                    archive.close();

                    final int separatorOwnerTitle = fileLines.get(0).indexOf(';');
                    final int lastSeparator =
                                    fileLines.get(0).indexOf(';', separatorOwnerTitle + 1);

                    final String currentOwner = fileLines.get(0).substring(0, separatorOwnerTitle);
                    final String currentTitle = fileLines.get(0).substring(separatorOwnerTitle + 1,
                                                                           lastSeparator);
                    final ArrayList<Music> currentMusics = recoverMusicsFromLibray(fileLines);
                    ((UserVip) user).getPlaylists()
                                    .add(new PlayList(currentTitle, currentOwner, currentMusics));
                }
            }
        }
    }

    /**
     * Metodo para criar os Usuarios a partir do arquivo Users.txt
     */
    public void loadUsers() {
        final ArrayList<String> fileLines = new ArrayList<>();
        try (FileReader archive = new FileReader("Users.txt")) {
            final BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();
            while (line != null) {
                fileLines.add(line);
                line = reader.readLine();
            }
        } catch (final Exception e) {
            fileLines.add(DEFAULT);
        }
        if (fileLines.isEmpty()) {
            fileLines.add(DEFAULT);
        }
        for (final String fileLine : fileLines) {
            final int separatorIdVip = fileLine.indexOf(';');
            final int separatorVipLogin = fileLine.indexOf(';', separatorIdVip + 1);
            final int separatorLoginPassword = fileLine.indexOf(';', separatorVipLogin + 1);
            final int lastSeparator = fileLine.lastIndexOf(';');

            final int currentId = Integer.parseInt(fileLine.substring(0, separatorIdVip));
            final boolean currentVip = (fileLine.substring(separatorIdVip + 1, separatorVipLogin)
                            .equals("true"));
            final String currentLogin =
                            fileLine.substring(separatorVipLogin + 1, separatorLoginPassword);
            final String currentSenha =
                            fileLine.substring(separatorLoginPassword + 1, lastSeparator);

            if (currentVip) {
                users.insert(new UserVip(currentLogin, currentSenha, currentId));
            } else {
                users.insert(new User(currentLogin, currentSenha, currentId));
            }
        }
    }

    /**
     * Informa o numero de usuarios cadastrados.
     *
     * @return O numero de usuarios cadastrados.
     */
    public int numberOfUsers() {
        return users.size();
    }

    /**
     * Lê o arquivo que contem as playlists associadas a esse usuario.
     *
     * @param user
     *            Usuario a ter as playlists identificadas.
     * @return Lista com os nomes das playlists a serem carregadas.
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileReader ou o BufferedReader
     */
    private ArrayList<String> readPlayListsUser(final UserVip user) {
        final ArrayList<String> currentPlaylists = new ArrayList<>();
        try (FileReader archive =
                        new FileReader("PlayLists/Playlists_" + user.getLogin() + ".txt")) {
            final BufferedReader reader = new BufferedReader(archive);
            String line2 = reader.readLine();
            while (line2 != null) {
                currentPlaylists.add(line2);
                line2 = reader.readLine();
            }
        } catch (final Exception e) {
            // Não foi possivel recuperar as informações das playlists do usuario indicado.
            // inicia o programa sem as playlists do usuario indicado.
        }

        return currentPlaylists;
    }

    /**
     * Recupera as musicas com os nomes guardados na lista apartir das musicas atualmente
     * cadastradas.
     *
     * @param musicsNames
     *            Lista com os nomes das musicas a serem recuperadas.
     * @return Lista com as musicas recuperadas.
     */
    private ArrayList<Music> recoverMusicsFromLibray(final ArrayList<String> musicsNames) {
        String currentMusicTitle;
        final ArrayList<Music> currentMusics = new ArrayList<>();
        for (int i = 1; i < musicsNames.size(); ++i) {
            currentMusicTitle = musicsNames.get(i);
            for (final Music music : musics) {
                if (music.getTitle().equals(currentMusicTitle)) {
                    currentMusics.add(music);
                    break;
                }
            }
        }
        return currentMusics;
    }

    /**
     * Registra um novo usuario com as informações fornecidas.
     *
     * @param login
     *            Nome de usuario a ser utilizado.
     * @param password
     *            Senha a ser usada e salva depois de criptografada.
     * @param id
     *            numero de identificação do usuario
     * @param vip
     *            Indica se é o cadastro de um VIP
     * @throws UserExistException
     *             Caso o nome de usuario já esteja em uso.
     */
    public void registerUser(final String login, final String password, final int id,
                    final boolean vip)
                    throws UserExistException {
        for (final User user : users.inorder()) {
            if (user.getLogin().equals(login)) {
                throw new UserExistException();
            }
        }
        try {
            if (vip) {
                users.insert(new UserVip(login, User.cryptography(password), id));
            } else {
                users.insert(new User(login, User.cryptography(password), id));
            }
        } catch (final UserPasswordInvalidException e) {
            Logger.getLogger(DataManager.class.getName())
                            .log(Level.SEVERE, "Erro durante o registro de um novo usuaruio.", e);
        }

    }

    /**
     * Modifica a Lista de musicas da biblioteca.
     *
     * @param allMusicsData
     *            Nova Lista com as musicas da biblioteca.
     */
    public void setMusics(final List<Music> allMusicsData) {
        musics = allMusicsData;
    }

    /**
     * Salva as musicas presentes na biblioteca em um arquivo.
     *
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileWriter ou o PrintWriter
     */
    public void writeMusics() throws IOException {
        final FileWriter archive = new FileWriter("Musicas.txt");
        try (PrintWriter writer = new PrintWriter(archive)) {
            if (!musics.isEmpty()) {
                for (final Music music : musics) {
                    writer.print(music.getTitle() + ";" + music.getPath() + ";");
                    if (!music.equals(musics.get(musics.size() - 1))) {
                        writer.printf("%n");
                    }
                }
            }
        } catch (final Exception e) {
            Logger.getLogger(DataManager.class.getName())
                            .log(Level.SEVERE, "Erro durante a escrita da biblioteca de musicas",
                                 e);
        }
        archive.close();
    }

    /**
     * Percorre todas as playlists de um usuario gravando os dados das playlists em um arquivo e o
     * caminho utilizado em uma lista para uso futuro.
     *
     * @param playlists
     *            Lista para salvar os caminhos das playlists.
     * @param user
     *            Usuario a ter as playlists salvas.
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileWriter ou o PrintWriter
     */
    private void writePlaylistdata(final List<String> playlists, final User user)
                    throws IOException {
        for (final PlayList playlist : ((UserVip) user).getPlaylists()) {
            playlists.add("PlayLists/Playlist_" + playlist.getTitle() + ".txt");
            final FileWriter archive =
                            new FileWriter("PlayLists/Playlist_" + playlist.getTitle() + ".txt");
            try (PrintWriter writer = new PrintWriter(archive);) {
                writer.print(playlist.getOwner() + ";" + playlist.getTitle() + ";\n");
                for (final Music music : playlist.getMusics()) {
                    writer.print(music.getTitle());
                    if (!music.getTitle().equals(playlist.getMusics().get(playlist.size() - 1)
                                    .getTitle())) {
                        writer.print("\n");
                    }
                }
            } catch (final Exception e) {
                Logger.getLogger(DataManager.class.getName())
                                .log(Level.SEVERE,
                                     "Erro durante a escrita das musicas de uma playlist", e);
            }
            archive.close();
        }
    }

    /**
     * Metodo para guardar as Playlists dos usuarios do sistema.
     *
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileWriter ou o PrintWriter
     */
    public void writePlaylistFiles() throws IOException {
        new File("PlayLists").mkdir();
        for (final User user : users.inorder()) {
            final List<String> playlists = new ArrayList<>();
            if (user instanceof UserVip) {
                writePlaylistdata(playlists, user);
                final FileWriter archive =
                                new FileWriter("PlayLists/Playlists_" + user.getLogin() + ".txt");
                try (PrintWriter writer = new PrintWriter(archive)) {
                    for (final String string : playlists) {
                        writer.printf(string);
                        if (!string.equals(playlists.get(playlists.size() - 1))) {
                            writer.printf("%n");
                        }
                    }
                } catch (final Exception e) {
                    Logger.getLogger(DataManager.class.getName())
                                    .log(Level.SEVERE,
                                         "Erro durante a escrita das playlist de um usuario", e);
                }
                archive.close();
            }
        }
    }

    /**
     * Metodo para guardar a lista de usuarios do sistema, em um arquivo Users.txt
     *
     * @throws IOException
     *             Caso ocorra algum imprevisto com o FileWriter ou o PrintWriter
     */
    public void writeUsersFile() throws IOException {
        final FileWriter archive = new FileWriter("Users.txt");
        try (PrintWriter writer = new PrintWriter(archive)) {
            final List<User> list = users.inorder();
            boolean vip = false;
            for (final User user : list) {
                if (user instanceof UserVip) {
                    vip = true;
                }
                writer.print(user.getId() + ";" + vip + ";" + user.getLogin() + ";"
                                + user.getPassword() + ";");
                if ((user.getId() != list.get(users.size() - 1).getId())) {
                    writer.printf("%n");
                }
            }
        } catch (final Exception e) {
            Logger.getLogger(DataManager.class.getName())
                            .log(Level.SEVERE, "Erro durante a gravação dos usuarios.", e);
        }
        archive.close();
    }
}
