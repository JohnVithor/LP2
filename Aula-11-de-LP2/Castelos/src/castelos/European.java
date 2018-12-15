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
public class European extends Castle {
    /**
     * DEFAULT_N_SOLDIERS.
     */
    private static final Integer DEFAULT_N_SOLDIERS = 5;
    /**
     * MAX HP.
     */
    private static final Double DEFAULT_HP = 180.0;
    /**
     * DEFAULT_DEF.
     */
    private static final Double DEFAULT_DEF = 60.0;
    /**
     * Atributos padrões de um castelo Europeu.
     *
     * @param x pos x
     * @param y pos y
     */
    public European(final Integer x, final Integer y) {
        super(DEFAULT_N_SOLDIERS, DEFAULT_DEF, "Habsburgo", DEFAULT_HP, x, y);
    }

    /**
     * @return status
     */
    @Override
    public String status() {
        return "Classe: Castelo Europeu\n" + super.status();
    }

    /**
     * @return CE
     */
    @Override
    public final String toString() {
        return "CE";
    }
}
