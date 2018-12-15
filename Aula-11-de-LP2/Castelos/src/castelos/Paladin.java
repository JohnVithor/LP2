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
public class Paladin extends Character {

    /**
     * MAX HP.
     */
    private static final Double DEFAULT_HP = 60.0;
    /**
     * DEFAULT_STR.
     */
    private static final Double DEFAULT_STR = 8.0;
    /**
     * DEFAULT_DEF.
     */
    private static final Double DEFAULT_DEF = 10.0;
    /**
     * conta o numero de Paladinos criados.
     */
    private static Integer paladinoCount = 0;

    /**
     * Atributos básicos de um Samurai.
     */
    public Paladin() {
        super(DEFAULT_STR, DEFAULT_DEF, "P" + paladinoCount, DEFAULT_HP, 0, 0);
        ++paladinoCount;
    }

    /**
     * @param nome nome
     */
    public Paladin(final String nome) {
        super(DEFAULT_STR, DEFAULT_DEF, nome, DEFAULT_HP, 0, 0);
        ++paladinoCount;
    }

    /**
     * @param paramForca paramForca
     * @param paramDefesa paramDefesa
     * @param paramNome paramNome
     * @param paramHitPoints paramHitPoints
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Paladin(final Double paramForca, final Double paramDefesa,
                    final String paramNome, final Double paramHitPoints,
                    final Integer paramPosX, final Integer paramPosY) {
        super(paramForca, paramDefesa, paramNome, paramHitPoints,
              paramPosX, paramPosY);
    }

    /**
     * @return numero de paladinos criados
     */
    public static Integer getPaladinoCount() {
        return paladinoCount;
    }

    /**
     * @param p personagem a ser atacado.
     * @return true se o oponente é um inimigo
     */
    @Override
    public final Boolean attack(final Entity p) {
        if (p instanceof Samurai || p instanceof Japanese) {
            super.attack(p);
            return true;
        } else {
            System.out.println("Esse não é um inimigo!");
            return false;
        }
    }

    /**
     * @return status
     */
    @Override
    public String status() {
        return "Classe: Paladino\n" + super.status();
    }

    /**
     * @return nome
     */
    @Override
    public final String toString() {
        return getName();
    }
}
