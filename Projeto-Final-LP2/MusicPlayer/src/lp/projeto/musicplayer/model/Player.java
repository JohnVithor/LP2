package lp.projeto.musicplayer.model;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 * Classe que modela um Player que toca uma PlayList de Musics.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class Player {

    private PlayList playList;

    private MediaPlayer mediaPlayer;

    private Music current;

    /**
     * Construtor padrão para um Player.
     */
    public Player() {
        playList = new PlayList();
        mediaPlayer = null;
        current = null;
    }

    /**
     * Construtor parametrizado para um Player a partir de uma PlayList.
     *
     * @param playList
     *            PlayList com as musicas iniciais inicial.
     */
    public Player(final PlayList playList) {
        this.playList = playList;
        mediaPlayer = null;
        current = null;
    }

    /**
     * Indica a currentTimeProperty do player.
     *
     * @return CurrentTimeProperty do player.
     */
    public ReadOnlyObjectProperty<Duration> currentTimeProperty() {
        return mediaPlayer.currentTimeProperty();
    }

    /**
     * Formata o tempo atual da reprodução do player em conjunto com o tempo total da musica.
     *
     * @return String que representa o tempo atual juntamente com o tempo total da musica.
     */
    public String formatTime() {
        final Duration elapsed = mediaPlayer.getCurrentTime();
        final Duration duration = mediaPlayer.getTotalDuration();
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        final int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        final int elapsedMinutes = intElapsed / 60;
        final int elapsedSeconds = intElapsed - (elapsedHours * 60 * 60) - (elapsedMinutes * 60);

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            final int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            final int durationMinutes = intDuration / 60;
            final int durationSeconds =
                            intDuration - (durationHours * 60 * 60) - (durationMinutes * 60);
            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d", elapsedHours, elapsedMinutes,
                                     elapsedSeconds,
                                     durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d", elapsedMinutes, elapsedSeconds,
                                     durationMinutes,
                                     durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d", elapsedMinutes, elapsedSeconds);
            }
        }
    }

    /**
     * Indica qual a musica que esta sendo reproduzida atualmente no player.
     *
     * @return A musica que esta sendo reproduzida atualmente no player.
     */
    public Music getPlaying() {
        return current;
    }

    /**
     * Indica o Progresso atual da musica em relação ao tempo total da musica.
     *
     * @return O Progresso atual da musica em relação ao tempo total da musica.
     */
    public Duration getProgress() {
        return mediaPlayer.getCurrentTime();
    }

    /**
     * Indica a duração total da musica.
     *
     * @return A duração total da musica.
     */
    public Duration getTotalDuration() {
        return mediaPlayer.getTotalDuration();
    }

    /**
     * Avança para a proxima musica na sequencia da playlist.
     */
    public void next() {
        try {
            current = playList.next();
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer(current.getMedia());
        } catch (final NoMoreMusicException e) {
            final Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso!");
            alert.setHeaderText("Não há proxima musica nesta playlist");
            alert.showAndWait();
        }
    }

    /**
     * Pausa a reprodução da musica.
     */
    public void pause() {
        mediaPlayer.pause();
    }

    /**
     * Inicia a reprodução da musica atualmente selecionada pelo Player.
     */
    public void play() {
        if ((mediaPlayer == null) || !current.getMedia().getSource()
                        .equals(mediaPlayer.getMedia().getSource())) {
            if (mediaPlayer != null) {
                mediaPlayer.dispose();
            }
            mediaPlayer = new MediaPlayer(current.getMedia());
            mediaPlayer.play();
            return;
        }
        if (mediaPlayer.getStatus() != Status.PLAYING) {
            mediaPlayer.play();
        }
    }

    /**
     * Avança para a musica anterior na sequencia da playlist.
     */
    public void previous() {
        try {
            current = playList.previous();
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer(current.getMedia());
        } catch (final NoMoreMusicException e) {
            final Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso!");
            alert.setHeaderText("Não há musica anterior nesta playlist");
            alert.showAndWait();
        }
    }

    /**
     * Altera a musica atual a parir de um indice para a proxima musica na playlist.
     *
     * @param index
     *            indice para a proxima musica
     * @throws NoMusicSelectedException
     *             Caso o indice seja invalido.
     */
    public void setCurrent(final int index) throws NoMusicSelectedException {
        playList.setCurrent(index);
        current = playList.getMusic();
    }

    /**
     * Altera a musica atual a parir de uma outra musica.
     *
     * @param music
     *            Musica que vai servir para alterar a musica a playlist.
     * @throws NoMusicSelectedException
     *             Caso a musica selecionada seja invalida.
     */
    public void setCurrent(final Music music) throws NoMusicSelectedException {
        playList.setCurrent(music);
        current = playList.getMusic();
    }

    /**
     * Altera a PlayList de musicas do Player.
     *
     * @param playList
     *            Nova PlayList.
     */
    public void setPlayList(final PlayList playList) {
        this.playList = playList;
    }

    /**
     * Altera o instante em que a musica está sendo reproduzida.
     *
     * @param time
     *            Novo tempo atual da musica.
     */
    public void setPlayTime(final Double time) {
        mediaPlayer.seek(Duration.millis(time));
    }

    /**
     * Interrompe a reprodução da musica.
     */
    public void stop() {
        mediaPlayer.stop();
    }

    /**
     * Indica a durationProperty da musica atual.
     *
     * @return durationProperty da musica atual.
     */
    public ReadOnlyObjectProperty<Duration> totalDurationProperty() {
        return current.getMedia().durationProperty();
    }
}
