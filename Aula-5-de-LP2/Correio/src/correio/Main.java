/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio;

/**
 *
 * @author johnvithor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        MailServer server = new MailServer();
        MailClient client1 = new MailClient(server, "client1");
        MailClient client2 = new MailClient(server, "client2");
        client1.sendMailItem("client2", "test", "this is a test.");
        client2.printNextMailItem();
        client2.sendMailItem("client1", "test(reply)", "this is a test too.");
        client1.printNextMailItem();
    }
}
