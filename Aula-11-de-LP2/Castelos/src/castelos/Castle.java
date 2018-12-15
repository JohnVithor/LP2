/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author johnvithor
 */
public class Castle extends Entity {

    /**
     * randon.
     */
    private final Random random;
    /**
     * numSoldados.
     */
    private Integer numSoldados;
    /**
     * numero máximo de soldados.
     */
    private final Integer maxSoldiers;
    /**
     * defesas.
     */
    private Double defesas;

    /**
     * @param paramNumSoldados paramNumSoldados
     * @param paramDefesas paramDefesas
     * @param paramHitpoints paramPontosVida
     * @param paramNome paramNome
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Castle(final Integer paramNumSoldados, final Double paramDefesas,
                   final String paramNome, final Double paramHitpoints,
                   final Integer paramPosX, final Integer paramPosY) {
        super(paramNome, paramHitpoints, paramPosX, paramPosY);
        this.random = new Random();
        this.maxSoldiers = paramNumSoldados;
        this.numSoldados = 0;
        this.defesas = paramDefesas;
    }

    /**
     * @param p novo soldado a ser contratado
     * @param t tabuleiro
     * @return true se o soldado foi contratado
     */
    public final Boolean hireSoldier(final Character p, final Board t) {
        if (numSoldados <= maxSoldiers) {
            Integer posX = getLocation().getPosX();
            Integer posY = getLocation().getPosY();
            ArrayList<Location> freePos = t.findFreeAdj(posX, posY);
            Integer newPos = random.nextInt(freePos.size());
            p.setLocation(freePos.get(newPos));
            t.posicionarVerificado(p);
            ++numSoldados;
        } else {
            System.out.println("Esse Castelo não tem mais capacidade!");
            return false;
        }
        return true;
    }

    /**
     * Diminui em 1 a contagem de soldados.
     */
    public final void soldierDead() {
        --numSoldados;
    }

    /**
     * Mostra as estatisticas do Castle.
     *
     * @return status
     */
    @Override
    public String status() {
        String status = super.status() + "Defesas: " + defesas;
        if (getHitPoints() <= 0.0) {
            status += "\nO castelo foi destruído.";
        }
        return status;
    }

    /**
     * @param valor valor de exito do attacked
     * @param ataque valor da força do atacante
     */
    @Override
    public final void attacked(final Integer valor, final Double ataque) {
        Double dano = valor * ataque;
        if (dano <= 0) {
            System.out.println("Dano não pode ser negativo ou nulo");
            return;
        }
        if (defesas > 0.0 && valor != 6) {
            defesas -= dano;
        } else {
            setHitPoints(getHitPoints() - dano);
        }
    }

    /**
     * @return C
     */
    @Override
    public String toString() {
        return "C_";
    }
}
