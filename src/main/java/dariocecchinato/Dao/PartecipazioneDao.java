package dariocecchinato.Dao;

import dariocecchinato.entities.Partecipazione;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDao {

    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(partecipazione);
        //4.
        transaction.commit();

        System.out.println("la partecipazione " + partecipazione.getEvento() + " è stata creata");
    }

    public Partecipazione getById(UUID idPartecipazione) {
        Partecipazione found = em.find(Partecipazione.class, idPartecipazione);
        if (found == null) {
            throw new NotFoundException(idPartecipazione);
        } else {
            return found;
        }
    }
}
