package dariocecchinato;

import dariocecchinato.Dao.ConcertoDao;
import dariocecchinato.Dao.EventoDao;
import dariocecchinato.Dao.LocationDao;
import dariocecchinato.entities.Concerto;
import dariocecchinato.entities.GenereConcerto;
import dariocecchinato.entities.Location;
import dariocecchinato.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s15l4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ConcertoDao cd = new ConcertoDao(em);
        LocationDao ld = new LocationDao(em);
        EventoDao ed = new EventoDao(em);

        Location location1 = new Location("Chase Center", "San Francisco");
        Location location2 = new Location("Fiera Milano Live", "Milano");
        Location location3 = new Location("Cava", "Grosseto");

        //ld.save(location1);
        //ld.save(location2);
        //ld.save(location3);

        Concerto concerto1 = new Concerto(
                "Madonna",
                LocalDateTime.of(2024, 9, 25, 23, 0),
                "The Celebration World Tour, Madonna",
                location1,
                TipoEvento.PUBBLICO,
                50000,
                GenereConcerto.POP,
                true
        );

        Concerto concerto2 = new Concerto(
                "SMASHING PUMPKINS",
                LocalDateTime.of(2024, 10, 15, 22, 0),
                "SMASHING PUMPKINS + Tom MORELLO",
                location2,
                TipoEvento.PUBBLICO,
                35000,
                GenereConcerto.ROCK,
                true

        );
        Concerto concerto3 = new Concerto(
                "GIOVANNI ALLEVI",
                LocalDateTime.of(2024, 9, 5, 19, 0),
                "PIANO SOLO TOUR",
                location3,
                TipoEvento.PRIVATO,
                2000,
                GenereConcerto.CLASSICO,
                false
        );

        //cd.save(concerto1);
        //cd.save(concerto2);
        //cd.save(concerto3);

        List<Concerto> concertiInStreaming = ed.getConcertiInStreaming();
        concertiInStreaming.forEach(System.out::println);

        List<Concerto> concertiRock = ed.getConcertiPerGenere(GenereConcerto.ROCK);
        concertiRock.forEach(System.out::println);


    }
}
