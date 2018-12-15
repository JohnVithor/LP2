package castelos;

/**
 * Command.
 */
public class Command {

    /**
     * commandWord.
     */
    private final CommandWord commandWord;
    /**
     * secondWord.
     */
    private final String secondWord;
    /**
     * thirdWord.
     */
    private final String thirdWord;
    /**
     * thirdWord.
     */
    private final String fourthWord;

    /**
     * Create a command object. First and second words must be supplied, but the
     * second may be null.
     *
     * @param paramCommandWord The CommandWord. UNKNOWN if the command word was
     * not recognised.
     * @param paramSecondWord The second word of the command. May be null.
     * @param paramThirdWord The third word of the command. May be null.
     * @param paramFourthWord The fourth word of the command. May be null.
     */
    public Command(final CommandWord paramCommandWord,
                   final String paramSecondWord,
                   final String paramThirdWord,
                   final String paramFourthWord) {
        this.commandWord = paramCommandWord;
        this.secondWord = paramSecondWord;
        this.thirdWord = paramThirdWord;
        this.fourthWord = paramFourthWord;
    }

    /**
     * Return the command word (the first word) of this command.
     *
     * @return The command word.
     */
    public final CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public final String getSecondWord() {
        return secondWord;
    }

    /**
     * @return The third word of this command. Returns null if there was no
     * second word.
     */
    public final String getThirdWord() {
        return thirdWord;
    }

    /**
     * @return The third word of this command. Returns null if there was no
     * second word.
     */
    public final String getFourthWord() {
        return fourthWord;
    }
    /**
     * @return true if this command was not understood.
     */
    public final boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return true if the command has a second word.
     */
    public final boolean hasSecondWord() {
        return (secondWord != null);
    }

    /**
     * @return true if the command has a third word.
     */
    public final boolean hasThirdWord() {
        return (thirdWord != null);
    }

    /**
     * @return true if the command has a fourth word.
     */
    public final boolean hasFourthWord() {
        return (fourthWord != null);
    }
}
