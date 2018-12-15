/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palavras;

import java.util.Scanner;

/**
 *
 * @author johnvithor
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Scanner reader = new Scanner(System.in);
        Parser parser = new Parser();
        parser.parsePhrase("eu tenho um barco vermelho e um carro vermelho");
        parser.printCountWords();
        System.out.println("Digite um frase para contar suas palavras: ");
        String inputLine = reader.nextLine().trim().toLowerCase();
        parser.parsePhrase(inputLine);
        parser.printCountWords();
    }
}
