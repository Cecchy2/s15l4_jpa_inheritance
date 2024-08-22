package dariocecchinato.Dao;

import dariocecchinato.entities.Concerto;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ConcertoDao {

    private final EntityManager em;

    public ConcertoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Concerto concerto) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(concerto);
        //4.
        transaction.commit();

        System.out.println("il concerto " + concerto.getDescrizione() + concerto.getTitolo() + " è stato salvato");
    }

    public Concerto getById(UUID idConcerto) {
        Concerto found = em.find(Concerto.class, idConcerto);
        if (found == null) {
            throw new NotFoundException(idConcerto);
        } else {
            return found;
        }
    }

    public void delete(UUID idConcerto) {
        Concerto found = this.getById(idConcerto);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("L'Concerto " + found.getDescrizione() + " è stato rimosso");

    }
}
