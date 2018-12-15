/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

/**
 *
 * @author johnvithor
 */
public class Location {
    /**
     * posicao x.
     */
    private Integer posX;
    /**
     * posicao Y.
     */
    private Integer posY;
    /**
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Location(final Integer paramPosX,
                    final Integer paramPosY) {
        this.posX = paramPosX;
        this.posY = paramPosY;
    }

    /**
     * @return the posX
     */
    public final Integer getPosX() {
        return posX;
    }

    /**
     * @param paramPosX the posX to set
     */
    public final void setPosX(final Integer paramPosX) {
        this.posX = paramPosX;
    }

    /**
     * @return the posY
     */
    public final Integer getPosY() {
        return posY;
    }

    /**
     * @param paramPosY the posY to set
     */
    public final void setPosY(final Integer paramPosY) {
        this.posY = paramPosY;
    }
    /**
     * @return par (x, y)
     */
    @Override
    public String toString() {
        return "(" + posX + ", " + posY + ")";
    }
}
