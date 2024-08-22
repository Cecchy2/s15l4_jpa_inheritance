package dariocecchinato.Dao;

import dariocecchinato.entities.Concerto;
import dariocecchinato.entities.Evento;
import dariocecchinato.entities.GenereConcerto;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventoDao {

    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(evento);
        //4.
        transaction.commit();

        System.out.println("l' evento " + evento.getDescrizione() + " è stato salvato");
    }

    public Evento getById(UUID idEvento) {
        Evento found = em.find(Evento.class, idEvento);
        if (found == null) {
            throw new NotFoundException(idEvento);
        } else {
            return found;
        }
    }

    public void delete(UUID idEvento) {
        Evento found = this.getById(idEvento);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'Evento " + found.getDescrizione() + " è stato rimosso");

    }

    public List<Concerto> getConcertiInStreaming() {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.in_Streaming = true", Concerto.class);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genereConcerto) {
        TypedQuery<Concerto> query = em.createQuery("Select c FROM Concerto c WHERE c.genere_Concerto = :genereConcerto", Concerto.class);
        query.setParameter("genereConcerto", genereConcerto);
        return query.getResultList();
    }
}
