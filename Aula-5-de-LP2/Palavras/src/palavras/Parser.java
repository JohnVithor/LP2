/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palavras;

import java.util.HashMap;

/**
 *
 * @author johnvithor
 */
public class Parser {
    /**
     * HashMap with the words of the phrase.
     */
    private final HashMap<String, Integer> words;

    /**
     * Constructor.
     */
    public Parser() {
        this.words = new HashMap<>();
    }
    /**
     * @param phrase phrase to be parsed.
     * @return the HashMap with the count of each word in the phrase.
     */
    public final HashMap<String, Integer> parsePhrase(final String phrase) {
        words.clear();
        String[] wordArray = phrase.split(" ");
        for (String word : wordArray) {
            if (words.containsKey(word)) {
                words.replace(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        return words;
    }
    /**
     * Print all the pairs (word, count).
     */
    public final void printCountWords() {
        words.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}
