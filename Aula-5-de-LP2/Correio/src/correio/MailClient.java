package correio;

/**
 * A class to model a simple email client. The client is run by a particular
 * user, and sends and retrieves mail via a particular server.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MailClient {

    /**
     * The server used for sending and receiving.
     */
    private final MailServer server;
    /**
     * The user running this client.
     */
    private final String user;

    /**
     * Create a mail client run by user and attached to the given server.
     *
     * @param paramServer paramServer
     * @param paramUser paramUser
     */
    public MailClient(final MailServer paramServer, final String paramUser) {
        this.server = paramServer;
        this.user = paramUser;
    }

    /**
     * @return the next mail item (if any) for this user.
     */
    public final MailItem getNextMailItem() {
        return server.getNextMailItem(user);
    }

    /**
     * Print the next mail item (if any) for this user to the text terminal.
     */
    public final void printNextMailItem() {
        MailItem item = server.getNextMailItem(user);
        if (item == null) {
            System.out.println("No new mail.");
        } else {
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via the attached mail
     * server.
     *
     * @param to The intended recipient.
     * @param subject The subject of the message to be sent.
     * @param message The text of the message to be sent.
     */
    public final void sendMailItem(final String to, final String subject,
                                   final String message) {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
    }
}
