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
public class Japanese extends Castle {
    /**
     * DEFAULT_N_SOLDIERS.
     */
    private static final Integer DEFAULT_N_SOLDIERS = 5;
    /**
     * MAX HP.
     */
    private static final Double DEFAULT_HP = 144.0;
    /**
     * DEFAULT_DEF.
     */
    private static final Double DEFAULT_DEF = 48.0;
    /**
     * Atributos padrões de um castelo Japonês.
     *
     * @param x pos x
     * @param y pos y
     */
    public Japanese(final Integer x, final Integer y) {
        super(DEFAULT_N_SOLDIERS, DEFAULT_DEF, "Okinawa", DEFAULT_HP, x, y);
    }

    /**
     * @return status
     */
    @Override
    public String status() {
        return "Classe: Castelo Japonês\n" + super.status();
    }

    /**
     * @return CJ
     */
    @Override
    public final String toString() {
        return "CJ";
    }
}
