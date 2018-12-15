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
public class Position {
    /**
     * entity.
     */
    private Entity entity;
    /**
     * ocupada.
     */
    private Boolean empty;
    /**
     * construtor padrão.
     */
    public Position() {
        entity = null;
        empty = true;
    }
    /**
     * @param paramEntity paramEntidade
     * @param paramEmpty paramOcupada
     */
    public Position(final Entity paramEntity,
                    final Boolean paramEmpty) {
        this.entity = paramEntity;
        this.empty = paramEmpty;
    }
    /**
     * @param paramEntity paramEntidade
     */
    public final void setEntity(final Entity paramEntity) {
        this.entity = paramEntity;
        empty = entity == null;
    }

    /**
     * @return the entity
     */
    public final Entity getEntity() {
        return entity;
    }

    /**
     * @return the ocupada
     */
    public final Boolean isEmpty() {
        return empty;
    }
    /**
     * @return entity
     */
    @Override
    public final String toString() {
        if (entity == null) {
            return "__";
        } else {
            return entity.toString();
        }
    }
}
