/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author johnvithor
 */
public class Board {
    /**
     * CASTLE_INFLUENCE.
     */
    static final Integer CASTLE_INFLUENCE = 2;
    /**
     * lines.
     */
    private final Integer lines;
    /**
     * columns.
     */
    private final Integer columns;
    /**
     * tabuleiro.
     */
    private final Position[][] board;

    /**
     * @param paramLinhas lines
     * @param paramColunas columns
     */
    public Board(final int paramLinhas, final int paramColunas) {
        this.board = new Position[paramLinhas][paramColunas];
        this.lines = paramLinhas;
        this.columns = paramColunas;
        for (int x = 0; x < lines; ++x) {
            for (int y = 0; y < columns; ++y) {
                board[x][y] = new Position();
            }
        }
    }

    /**
     * @return lines
     */
    public final Integer getLines() {
        return lines;
    }

    /**
     * @return columns
     */
    public final Integer getColumns() {
        return columns;
    }

    /**
     * @param x posX
     * @param y posY
     * @return ArrayList de posições livres
     */
    public final ArrayList<Location> findFreeAdj(Integer x, Integer y) {
        ArrayList<Location> freePos = new ArrayList<>();
        if (isValid(x - 1, y) && access(x - 1, y).isEmpty()) {
            freePos.add(new Location(x - 1, y));
        }
        x = x - 1;
        if (isValid(x, y + 1) && access(x, y + 1).isEmpty()) {
            freePos.add(new Location(x, y + 1));
        }
        y = y + 1;
        if (isValid(x + 1, y) && access(x + 1, y).isEmpty()) {
            freePos.add(new Location(x + 1, y));
        }
        x = x + 1;
        if (isValid(x + 1, y) && access(x + 1, y).isEmpty()) {
            freePos.add(new Location(x + 1, y));
        }
        x = x + 1;
        if (isValid(x, y - 1) && access(x, y - 1).isEmpty()) {
            freePos.add(new Location(x, y - 1));
        }
        y = y - 1;
        if (isValid(x, y - 1) && access(x, y - 1).isEmpty()) {
            freePos.add(new Location(x, y - 1));
        }
        y = y - 1;
        if (isValid(x - 1, y) && access(x - 1, y).isEmpty()) {
            freePos.add(new Location(x - 1, y));
        }
        x = x - 1;
        if (isValid(x - 1, y) && access(x - 1, y).isEmpty()) {
            freePos.add(new Location(x - 1, y));
        }
        return freePos;
    }

    /**
     * @return lista de posições válidas para um castelo.
     */
    public final ArrayList<Location> findLocCastle() {
        ArrayList<Location> positions = new ArrayList<>();
        ArrayList<Location> castles = new ArrayList<>();
        for (int x = 0; x < lines; x++) {
            for (int y = 0; y < columns; y++) {
                Position pos = board[x][y];
                if (!pos.isEmpty()) {
                    if (pos.getEntity() instanceof Castle) {
                        castles.add(new Location(x, y));
                    }
                } else {
                    positions.add(new Location(x, y));
                }
            }
        }
        Iterator<Location> iterator = positions.iterator();
        for (Location castle : castles) {
            while (iterator.hasNext()) {
                Location next = iterator.next();
                if (inInfluenceCastle(next, castle)) {
                    iterator.remove();
                }
            }
        }

        return positions;
    }

    /**
     * @param loc localização a ser testada
     * @param castle localização do castelo a ser testado
     * @return true se está na area de influencia do castelo, false c.c.
     */
    public final Boolean inInfluenceCastle(final Location loc,
                                           final Location castle) {
        Integer castleX = castle.getPosX();
        Integer castleY = castle.getPosY();
        Integer locX = loc.getPosX();
        Integer locY = loc.getPosY();
        Boolean inX = locX >= (castleX - CASTLE_INFLUENCE) && locX <= (castleX + CASTLE_INFLUENCE);
        Boolean inY = locY >= (castleY - CASTLE_INFLUENCE) && locY <= (castleY + CASTLE_INFLUENCE);
        return inX && inY;
    }

    /**
     * @param x pos x
     * @param y pos y
     * @return true se a posiçao for isValid
     */
    public final Boolean isValid(final Integer x, final Integer y) {
        boolean x0 = x >= 0;
        boolean xlines = x < lines;
        boolean y0 = y >= 0;
        boolean ycols = y < columns;
        return x0 && xlines && y0 && ycols;
    }

    /**
     * @param x posx
     * @param y posy
     * @return a posição indicada por x e y
     */
    public final Position access(final Integer x, final Integer y) {
        return board[x][y];
    }

    /**
     * @param e entidade a ser posisionada.
     */
    public final void place(final Entity e) {
        Integer posX = e.getLocation().getPosX();
        Integer posY = e.getLocation().getPosY();
        if (!isValid(posX, posY)) {
            System.out.println("Posição inválida para entidade: " + e);
        } else if (!board[posX][posY].isEmpty()) {
            System.out.println("Posição já ocupada.");
            System.out.println(board[posX][posY].getEntity());
        } else {
            board[posX][posY].setEntity(e);
        }
    }

    /**
     * @param e entidade a ser posisionada.
     */
    public final void posicionarVerificado(final Entity e) {
        Integer posX = e.getLocation().getPosX();
        Integer posY = e.getLocation().getPosY();
        board[posX][posY].setEntity(e);
    }

    /**
     * @return representação do tabuleiro
     */
    @Override
    public String toString() {
        String tab = "";
        for (int x = 0; x < lines; ++x) {
            for (int y = 0; y < columns; ++y) {
                tab = tab + board[x][y] + " ";
            }
            tab = tab + "\n";
        }
        return tab;
    }
}
