package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityConfig {
    public static EntityManager entityOpen(String persistence) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory(persistence);
        return entityManager.createEntityManager();
    }
}
