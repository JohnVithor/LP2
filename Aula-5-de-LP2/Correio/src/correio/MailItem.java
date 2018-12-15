package correio;

/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MailItem {

    /**
     * The sender of the item.
     */
    private final String from;
    /**
     * The intended recipient.
     */
    private final String to;
    /**
     * The subject of the message.
     */
    private final String subject;
    /**
     * The text of the message.
     */
    private final String message;

    /**
     * Create a mail item from sender to the given recipient, containing the
     * given message.
     *
     * @param paramFrom The sender of this item.
     * @param paramTo The intended recipient of this item.
     * @param paramSubject The subject of the message to be sent.
     * @param paramMessage The text of the message to be sent.
     */
    public MailItem(final String paramFrom, final String paramTo,
                    final String paramSubject, final String paramMessage) {
        this.from = paramFrom;
        this.to = paramTo;
        this.subject = paramSubject;
        this.message = paramMessage;
    }

    /**
     * @return The sender of this message.
     */
    public final String getFrom() {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public final String getTo() {
        return to;
    }

    /**
     * @return The subject of the message.
     */
    public final String getSubject() {
        return subject;
    }

    /**
     * @return The text of the message.
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Print this mail message to the text terminal.
     */
    public final void print() {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
