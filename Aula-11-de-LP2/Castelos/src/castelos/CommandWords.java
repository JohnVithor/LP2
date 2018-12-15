package castelos;

import java.util.HashMap;
/**
 * CommandWords.
 */
public class CommandWords {

    /**
     * A mapping between a command word and the CommandWord associated with it.
     */
    private final HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validCommands = new HashMap<>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     *
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN if it is
     * not a valid command word.
     */
    public final CommandWord getCommandWord(final String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Check whether a given String is a valid command word.
     * @param aString aString
     * @return true if it is, false if it isn't.
     */
    public final boolean isCommand(final String aString) {
        return validCommands.containsKey(aString);
    }

    /**
     * @return String com os comandos
     */
    public final String getCommands() {
        String comands = "";
        for (String command : validCommands.keySet()) {
            comands = comands + command + "  ";
        }
        return comands;
    }
}
