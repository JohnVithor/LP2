/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castelos;

import java.util.HashMap;

/**
 *
 * @author johnvithor
 */
public class EntityTypes {

    /**
     * A mapping between a string da Entidade and the tipo da Entidade
     * associated with it.
     */
    private final HashMap<String, EntityType> validEntities;

    /**
     * Constructor - initialise the command words.
     */
    public EntityTypes() {
        validEntities = new HashMap<>();
        for (EntityType entidade : EntityType.values()) {
            if (entidade != EntityType.UNKNOWN) {
                validEntities.put(entidade.toString(), entidade);
            }
        }
    }

    /**
     * @param entidadeString The word to look up.
     * @return EntityType
     */
    public final EntityType getType(final String entidadeString) {
        EntityType entidade = validEntities.get(entidadeString);
        if (entidade != null) {
            return entidade;
        } else {
            return EntityType.UNKNOWN;
        }
    }

    /**
     *
     * @param aString aString
     * @return true if it is, false if it isn't.
     */
    public final boolean isType(final String aString) {
        return validEntities.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public final void showAll() {
        for (String command : validEntities.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
