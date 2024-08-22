package dariocecchinato.Dao;

import dariocecchinato.entities.Location;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDao {

    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();

        System.out.println("La location " + location.getNome() + " è stata salvata");
    }

    public Location getById(UUID idLocation) {
        Location found = em.find(Location.class, idLocation);
        if (found == null) {
            throw new NotFoundException(idLocation);
        } else {
            return found;
        }
    }
}
