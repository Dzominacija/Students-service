package rs.leadit.learinig.nikola.students.database.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {
    private static final long serialVersionUID = 4832434995027128007L;

    @PersistenceContext(unitName = "students")
    private EntityManager entityManager;

    @Produces
    public EntityManager create() {
        return entityManager;
    }
}