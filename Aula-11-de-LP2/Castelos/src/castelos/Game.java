/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author johnvithor
 */
public class Game {

    /**
     * constante para sincronizar a impressão do tabuleiro com as mensagens do
     * jogo.
     */
    static final Integer WAIT_SHORT = 100;
    /**
     * constante de espera quando um turno for nulo (sem movimentos possiveis).
     */
    static final Integer WAIT_LONG = 1000;
    /**
     * Initial numbers of soldiers per Castle.
     */
    static final Integer INITIAL_SOLDIERS = 2;
    /**
     * Number of turns to create a new soldier.
     */
    static final Integer TURNS_SOLDIER = 5;
    /**
     * random.
     */
    private final Random random;
    /**
     * parser.
     */
    private final Parser parser;
    /**
     * tabuleiro.
     */
    private final Board board;
    /**
     * casteloJapones.
     */
    private Japanese jCastle;
    /**
     * casteloEuropeu.
     */
    private European eCastle;
    /**
     * indica qual o personagem que irá se mover.
     */
    private final ArrayList<Character> characters;
    /**
     * Indica o turno.
     */
    private Integer turns;
    /**
     * indica se o próximo soldado a ser criado é um samurai ou paladino.
     */
    private Boolean jap;

    /**
     * @param size tamanho do tabuleiro
     */
    public Game(final Integer size) {
        this.random = new Random();
        this.board = new Board(size, size);
        this.parser = new Parser();
        this.characters = new ArrayList<>();
        this.turns = 0;
        this.jap = true;
    }

    /**
     * Game Loop.
     */
    public final void play() {
        prepareEntities();
        printWelcome();
        Boolean finished = false;
        Boolean hasSoldier = false;
        while (!finished && !hasWinner()) {
            hasSoldier = manageTurn();
            System.out.println(board);
            if (hasSoldier) {
                Command command = parser.getCommand();
                delay(WAIT_SHORT);
                finished = processCommand(command);
            } else {
                delay(WAIT_LONG);
            }
        }
        JOptionPane.showMessageDialog(null, "Obrigado por jogar, inté.");
    }

    /**
     * Gerencia os turnos.
     * @return true se o turno for valido, false se for nulo
     */
    private Boolean manageTurn() {
        Character p;
        if (Objects.equals(turns % TURNS_SOLDIER, 0) && !jap && turns != 0) {
            jap = true;
            p = new Paladin();
            if (eCastle.hireSoldier(p, board)) {
                characters.add(p);
            }
        } else if (Objects.equals(turns % TURNS_SOLDIER, 0) && jap && turns != 0) {
            jap = false;
            p = new Samurai();
            if (jCastle.hireSoldier(p, board)) {
                characters.add(p);
            }
        }
        if (!characters.isEmpty()) {
            if (characters.get(0) instanceof Samurai) {
                System.out.println(jCastle.status());
            } else {
                System.out.println(eCastle.status());
            }
            System.out.println("Turno de: " + characters.get(0));
        } else {
            System.out.println("Que coisa, não temos nenhum soldado em campo!");
            ++turns;
            return false;
        }
        return true;
    }

    /**
     * prepara as entidades iniciais para o começo do jogo.
     */
    private void prepareEntities() {
        Integer x = random.nextInt(board.getLines());
        Integer y = random.nextInt(board.getColumns());
        jCastle = new Japanese(x, y);
        board.place(jCastle);
        ArrayList<Location> validLoc = board.findLocCastle();
        Integer pos = random.nextInt(validLoc.size());
        Location loc = validLoc.get(pos);
        x = loc.getPosX();
        y = loc.getPosY();
        eCastle = new European(x, y);
        board.place(eCastle);
        Character soldier;
        for (int i = 0; i < INITIAL_SOLDIERS; i++) {
            soldier = new Samurai();
            jCastle.hireSoldier(soldier, board);
            characters.add(soldier);
            soldier = new Paladin();
            eCastle.hireSoldier(soldier, board);
            characters.add(soldier);
        }
    }

    /**
     * @return true se algum time ganhou
     */
    private Boolean hasWinner() {
        Boolean result = false;
        String msg = null;
        if (jCastle.isDefeated()) {
            msg = "Os paladinos destruiram o castelo japones!\n"
                    + "Os Europeus ganharam após " + turns;
            result = true;
        } else if (eCastle.isDefeated()) {
            msg = "Os samurais destruiram o castelo europeu!\n"
                    + "Os Japoneses ganharam após " + turns;
            result = true;
        }
        if (result) {
            JOptionPane.showMessageDialog(null, msg);
        }
        return result;
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        String welcome = "Bem-Vindo ao Combate de Castelos!\n";
        welcome += "Digite '" + CommandWord.HELP + "' se quiser ajuda.";
        JOptionPane.showMessageDialog(null, welcome);
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(final Command command) {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goTo(command);
                break;

            case STATUS:
                showStatus(command);
                break;

            case HEAL:
                heal(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            default:
                System.out.println("I don't know what you mean...");
                break;
        }
        return wantToQuit;
    }

    /**
     * Imprime os possiveis comandos do jogo.
     */
    private void printHelp() {
        JOptionPane.showMessageDialog(null, "Os comando disponíveis são:\n"
                                      + parser.showCommands());
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     *
     * @param command comando
     */
    private void goTo(final Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        Character character = characters.get(0);
        if (!(character instanceof Character)) {
            System.out.println("Esse não é um alvo válido.");
            return;
        }
        String direction = command.getSecondWord();
        Location loc = character.getLocation();
        Integer x = loc.getPosX();
        Integer y = loc.getPosY();
        Position pos = null;
        switch (direction) {
            case "w":
                if (board.isValid(x - 1, y)) {
                    pos = board.access(x - 1, y);
                }
                break;
            case "s":
                if (board.isValid(x + 1, y)) {
                    pos = board.access(x + 1, y);
                }
                break;
            case "d":
                if (board.isValid(x, y + 1)) {
                    pos = board.access(x, y + 1);
                }
                break;
            case "a":
                if (board.isValid(x, y - 1)) {
                    pos = board.access(x, y - 1);
                }
                break;
            default:
                pos = new Position();
                break;
        }
        if (pos == null) {
            JOptionPane.showMessageDialog(null, "Direção inválida!");
            return;
        } else if (!pos.isEmpty()) {
            Entity e = pos.getEntity();
            System.out.println(character + " vai atacar " + e);
            Boolean enemy = character.attack(e);
            if (!enemy) {
                return;
            } else if (e.isDefeated() && e instanceof Character) {
                characters.remove((Character) e);
                System.out.println(e.getName() + " foi derrotado!");
                pos.setEntity(null);
                if (e instanceof Samurai) {
                    jCastle.soldierDead();
                } else if (e instanceof Samurai) {
                    eCastle.soldierDead();
                }
            }
            if (character.isDefeated()) {
                characters.remove(0);
                System.out.println(
                character.getName() + " morreu ao atacar o castelo inimigo.");
                board.access(x, y).setEntity(null);
                if (character instanceof Samurai) {
                    jCastle.soldierDead();
                } else if (character instanceof Samurai) {
                    eCastle.soldierDead();
                }
                ++turns;
                return;
            }
        } else {
            character.move(direction, board);
        }
        ++turns;
        characters.remove(0);
        characters.add(character);
    }

    /**
     * @param command comando
     */
    private void showStatus(final Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Who?");
            return;
        }
        String who = command.getSecondWord();
        for (Character p : characters) {
            if (p.getName().equals(who)) {
                JOptionPane.showMessageDialog(null, p.status());
            }
        }
    }

    /**
     * cura o personagem indicado.
     *
     * @param command comando
     */
    private void heal(final Command command) {
        Character character = characters.get(0);
        if (!command.hasSecondWord()) {
            character.heal();
            ++turns;
            characters.remove(0);
            characters.add(character);
            return;
        }
        String direction = command.getSecondWord();
        Location loc = character.getLocation();
        Integer x = loc.getPosX();
        Integer y = loc.getPosY();
        Position pos = null;
        switch (direction) {
            case "w":
                if (board.isValid(x - 1, y)) {
                    pos = board.access(x - 1, y);
                }
                break;
            case "s":
                if (board.isValid(x + 1, y)) {
                    pos = board.access(x + 1, y);
                }
                break;
            case "d":
                if (board.isValid(x, y + 1)) {
                    pos = board.access(x, y + 1);
                }
                break;
            case "a":
                if (board.isValid(x, y - 1)) {
                    pos = board.access(x, y - 1);
                }
                break;
            default:
                pos = new Position();
                break;
        }
        if (pos == null) {
            JOptionPane.showMessageDialog(null, "Não há ninguem alí...");
        } else if (!pos.isEmpty()) {
            Character target = (Character) pos.getEntity();
            Boolean posIsSamurai = target instanceof Samurai;
            Boolean charIsSamurai = character instanceof Samurai;
            if (posIsSamurai && charIsSamurai || !posIsSamurai && !charIsSamurai) {
                System.out.println(character + " curou " + target
                        + " em: " + target.heal());
                ++turns;
                characters.remove(0);
                characters.add(character);
            } else {
                System.out.println("Esse é um inimigo");
            }
        }
    }

    /**
     * @param command comando
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(final Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * espera o tempo em milisegundos desejados.
     *
     * @param millis tempo em milisegundos
     */
    private void delay(final Integer millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }
    }
}
