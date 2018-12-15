/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

import java.util.Random;

/**
 *
 * @author johnvithor
 */
public abstract class Character extends Entity {

    /**
     * random.
     */
    private final Random random;
    /**
     * força.
     */
    private final Double strength;
    /**
     * defesa.
     */
    private final Double defense;

    /**
     * @param paramForca paramForca
     * @param paramDefesa paramDefesa
     * @param paramNome paramNome
     * @param paramHitPoints paramHitPoints
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Character(final Double paramForca, final Double paramDefesa,
                     final String paramNome, final Double paramHitPoints,
                     final Integer paramPosX, final Integer paramPosY) {
        super(paramNome, paramHitPoints, paramPosX, paramPosY);
        random = new Random();
        this.strength = paramForca;
        this.defense = paramDefesa;
    }

    /**
     * @param direcao direcao
     * @param tab tabuleiro
     */
    public final void move(final String direcao, final Board tab) {
        Integer posX = getLocation().getPosX();
        Integer posY = getLocation().getPosY();
        tab.access(posX, posY).setEntity(null);
        if (direcao.equalsIgnoreCase("w")) {
            if (posX - 1 < 0 || !tab.access(posX - 1, posY).isEmpty()) {
                System.out.println("Não posso ir para essa direção.");
            } else {
                setLocation(posX - 1, posY);
            }
        } else if (direcao.equalsIgnoreCase("s")) {
            if (posX + 1 >= tab.getLines() || !tab.access(posX + 1, posY).isEmpty()) {
                System.out.println("Não posso ir para essa direção.");
            } else {
                setLocation(posX + 1, posY);
            }
        } else if (direcao.equalsIgnoreCase("d")) {
            if (posY + 1 >= tab.getColumns() || !tab.access(posX, posY + 1).isEmpty()) {
                System.out.println("Não posso ir para essa direção.");
            } else {
                setLocation(posX, posY + 1);
            }
        } else if (direcao.equalsIgnoreCase("a")) {
            if (posY - 1 < 0 || !tab.access(posX, posY - 1).isEmpty()) {
                System.out.println("Não posso ir para essa direção.");
            } else {
                setLocation(posX, posY - 1);
            }
        } else {
            System.out.println("Não entendi qual direção devo ir.");
        }
        tab.place(this);
    }

    /**
     * @param p personagem a ser atacado.
     * @return true
     */
    public Boolean attack(final Entity p) {
        Integer valor = 1 + random.nextInt(6);
        if (valor <= 2) {
            System.out.println("Errou o ataque.");
        } else {
            if (p instanceof Castle) {
                setHitPoints(0.0);
            }
            p.attacked(valor, strength);
        }
        return true;
    }

    /**
     * @param valor do exito do attacked
     * @param ataque força do personagem atacante
     */
    @Override
    public final void attacked(final Integer valor, final Double ataque) {
        Double dano = valor * ataque;
        if (valor != 6) {
             dano -= defense;
        }
        System.out.println(this.toString() + " levou  um dano de: " + dano);
        setHitPoints(getHitPoints() - dano);
    }
    /**
     * Cura o personagem em um valor aleatório entre 7 e 10.
     * @return quantidade que foi curada.
     */
    public final Double heal() {
        Double h = 7 + 3 * random.nextDouble();
        if (getHitPoints() + h > getInitialHitPoints()) {
            setHitPoints(getInitialHitPoints());
        } else {
            setHitPoints(getHitPoints() + h);
        }
        return h;
    }
    /**
     * @return String com os status do personagem
     */
    @Override
    public String status() {
        return super.status() + "Força: " + strength + "\n"
                + "Defesa: " + defense;
    }

    /**
     * @return string do personagem
     */
    @Override
    public abstract String toString();
}
