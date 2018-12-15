package castelos;

/**
 *
 * Classe baseada na classe com mesmo nome do jogo ZuulWord do livro do Bluej.
 */
public enum CommandWord {
    /**
     * A value for each command word along with its corresponding user interface
     * string.
     */
    GO("go"), QUIT("quit"), HELP("help"), STATUS("status"), HEAL("heal"),
    UNKNOWN("?");

    /**
     * The command string.
     */
    private final String commandString;

    /**
     * Initialise with the corresponding command string.
     *
     * @param paramCommandString The command string.
     */
    CommandWord(final String paramCommandString) {
        this.commandString = paramCommandString;
    }

    /**
     * @return The command word as a string.
     */
    @Override
    public String toString() {
        return commandString;
    }
}
