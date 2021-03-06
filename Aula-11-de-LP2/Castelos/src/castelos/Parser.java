package castelos;

import java.util.Scanner;
/**
 * Parser.
 */
public class Parser {
    /**
     * holds all valid command words.
     */
    private final CommandWords commands;
    /**
     * source of command input.
     */
    private final Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public final Command getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                if (tokenizer.hasNext()) {
                    word3 = tokenizer.next();      // get third word
                    if (tokenizer.hasNext()) {
                        word4 = tokenizer.next();      // get fourth word
                    }
                }
                // note: we just ignore the rest of the input line.
            }
        }
        return new Command(commands.getCommandWord(word1), word2, word3, word4);
    }

    /**
     * @return String com os comandos
     */
    public final String showCommands() {
        return commands.getCommands();
    }
}
