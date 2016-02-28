package ua.prom.core;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Denys Lytvinyuk
 */
public class EntityConfig {

    private static EntityManager eManager;

    public static EntityManager getInstance() {

        if (eManager == null) {
            eManager = Persistence.createEntityManagerFactory("EntityManager").createEntityManager();
        }
        return eManager;
    }

}
