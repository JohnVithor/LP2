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
public class Samurai extends Character {

    /**
     * MAX HP.
     */
    private static final Double DEFAULT_HP = 54.0;
    /**
     * DEFAULT_STR.
     */
    private static final Double DEFAULT_STR = 10.0;
    /**
     * DEFAULT_DEF.
     */
    private static final Double DEFAULT_DEF = 8.0;
    /**
     * conta o numero de Samurais criados.
     */
    private static Integer samuraiCount = 0;

    /**
     * Atributos básicos de um Samurai.
     */
    public Samurai() {
        super(DEFAULT_STR, DEFAULT_DEF, "S" + samuraiCount, DEFAULT_HP, 0, 0);
        ++samuraiCount;
    }

    /**
     * @param nome nome
     */
    public Samurai(final String nome) {
        super(DEFAULT_STR, DEFAULT_DEF, nome, DEFAULT_HP, 0, 0);
        ++samuraiCount;
    }

    /**
     * @param paramForca paramForca
     * @param paramDefesa paramDefesa
     * @param paramNome paramNome
     * @param paramHitPoints paramHitPoints
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Samurai(final Double paramForca, final Double paramDefesa,
                   final String paramNome, final Double paramHitPoints,
                   final Integer paramPosX, final Integer paramPosY) {
        super(paramForca, paramDefesa, paramNome, paramHitPoints,
              paramPosX, paramPosY);
    }

    /**
     * @param p personagem a ser atacado.
     * @return true se o oponente é um inimigo
     */
    @Override
    public final Boolean attack(final Entity p) {
        if (p instanceof Paladin || p instanceof European) {
            super.attack(p);
            return true;
        } else {
            System.out.println("Esse não é um inimigo!");
            return false;
        }
    }

    /**
     * @return numero de samurais criados.
     */
    public static Integer getSamuraiCount() {
        return samuraiCount;
    }

    /**
     * @return status
     */
    @Override
    public String status() {
        return "Classe: Samurai\n" + super.status();
    }

    /**
     * @return nome
     */
    @Override
    public final String toString() {
        return getName();
    }
}
