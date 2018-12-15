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
public abstract class Entity {

    /**
     * name da entidade.
     */
    private String name;
    /**
     * location.
     */
    private Location location;
    /**
     * Hitpoints - pontos de vida - HP.
     */
    private Double hitPoints;
    /**
     * Hitpoints - pontos de vida - HP.
     */
    private final Double initialHitPoints;

    /**
     * @param paramNome paramNome
     * @param paramHitpoints paramHitpoints
     * @param paramPosX paramPosX
     * @param paramPosY paramPosY
     */
    public Entity(final String paramNome, final Double paramHitpoints,
                  final Integer paramPosX, final Integer paramPosY) {
        this.name = paramNome;
        this.hitPoints = paramHitpoints;
        this.initialHitPoints = paramHitpoints;
        this.location = new Location(paramPosX, paramPosY);
    }

    /**
     * @return o name.
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the hitPoints
     */
    public final Double getHitPoints() {
        return hitPoints;
    }

    /**
     * @return initialHitPoints.
     */
    public final Double getInitialHitPoints() {
        return initialHitPoints;
    }

    /**
     * @return the location
     */
    public final Location getLocation() {
        return location;
    }

    /**
     * @param paramName paramNome
     */
    public final void setName(final String paramName) {
        this.name = paramName;
    }

    /**
     * @param paramHitPoints paramHitPoints
     */
    public final void setHitPoints(final Double paramHitPoints) {
        this.hitPoints = paramHitPoints;
    }

    /**
     * @param paramLocation the location to set
     */
    public final void setLocation(final Location paramLocation) {
        this.location = paramLocation;
    }

    /**
     * @param posX posX
     * @param posY posY
     */
    public final void setLocation(final Integer posX, final Integer posY) {
        this.location.setPosX(posX);
        this.location.setPosY(posY);
    }

    /**
     * @param valor valor do exito do attacked
     * @param ataque força do atacante
     */
    public abstract void attacked(final Integer valor, final Double ataque);

    /**
     * @return true se a entidade perdeu todos os pontos de vida
     */
    public final Boolean isDefeated() {
        return hitPoints <= 0;
    }

    /**
     * @return status.
     */
    public String status() {
        return "Nome: " + name + "\n"
                + "HitPoints: " + hitPoints + " / " + initialHitPoints + "\n"
                + "Localizacao: " + location + "\n";
    }

    /**
     * @return 0
     */
    @Override
    public abstract String toString();

}
