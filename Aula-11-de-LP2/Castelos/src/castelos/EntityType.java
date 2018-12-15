/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;
/**
 * @author johnvithor
 */
public enum EntityType {
    /**
     * Tipos de Entidade.
     *
     *//**
     * Tipos de Entidade.
     *
     */
    CASTLE("castle"), SAMURAI("samurai"), PALADIN("paladin"), UNKNOWN("?");

    /**
     * The command string.
     */
    private final String entityString;

    /**
     * @param paramEntidadeString A string da Entidade .
     */
    EntityType(final String paramEntidadeString) {
        this.entityString = paramEntidadeString;
    }

    /**
     * @return A Entidade como uma string.
     */
    @Override
    public String toString() {
        return entityString;
    }
}
