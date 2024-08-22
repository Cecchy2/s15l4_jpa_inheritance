package dariocecchinato.Dao;


import dariocecchinato.entities.PartitaDiCalcio;
import dariocecchinato.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartitaDiCalcioDao {

    private final EntityManager em;

    public PartitaDiCalcioDao(EntityManager em) {
        this.em = em;
    }

    public void save(PartitaDiCalcio partitaDiCalcio) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(partitaDiCalcio);
        //4.
        transaction.commit();

        System.out.println("la partitaDiCalcio " + partitaDiCalcio.getDescrizione() + " è stata salvata");
    }

    public PartitaDiCalcio getById(UUID idPartitaDiCalcio) {
        PartitaDiCalcio found = em.find(PartitaDiCalcio.class, idPartitaDiCalcio);
        if (found == null) {
            throw new NotFoundException(idPartitaDiCalcio);
        } else {
            return found;
        }
    }


}
