package dariocecchinato.Dao;

import dariocecchinato.entities.Persona;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDao {

    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(persona);
        //4.
        transaction.commit();

        System.out.println("la persona " + persona.getNome() + " è stata creata");
    }

    public Persona getById(UUID idPersona) {
        Persona found = em.find(Persona.class, idPersona);
        if (found == null) {
            throw new NotFoundException(idPersona);
        } else {
            return found;
        }
    }
}
