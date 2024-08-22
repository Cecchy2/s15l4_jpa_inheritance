package dariocecchinato;

import dariocecchinato.Dao.ConcertoDao;
import dariocecchinato.Dao.EventoDao;
import dariocecchinato.Dao.LocationDao;
import dariocecchinato.Dao.PartitaDiCalcioDao;
import dariocecchinato.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s15l4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ConcertoDao cd = new ConcertoDao(em);
        LocationDao ld = new LocationDao(em);
        EventoDao ed = new EventoDao(em);
        PartitaDiCalcioDao pdc = new PartitaDiCalcioDao(em);

        Location location1 = new Location("Chase Center", "San Francisco");
        Location location2 = new Location("Fiera Milano Live", "Milano");
        Location location3 = new Location("Cava", "Grosseto");
        Location location4 = new Location("Stadio Olimpico", "Roma");
        Location location5 = new Location("Santiago Bernabeu", "Madrid");
        Location location6 = new Location("San Siro", "Milano");
        Location location7 = new Location("Lusail Stadium", "Lusail, Qatar");


        //ld.save(location1);
        //ld.save(location2);
        //ld.save(location3);
        //ld.save(location4);
        //ld.save(location5);
        //ld.save(location6);
        //ld.save(location7);

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

        System.out.println("******************  CONCERTI IN STREAMING  ****************************");

        List<Concerto> concertiInStreaming = ed.getConcertiInStreaming();
        concertiInStreaming.forEach(System.out::println);


        System.out.println("******************  CONCERTI ROCK  ****************************");

        List<Concerto> concertiRock = ed.getConcertiPerGenere(GenereConcerto.ROCK);
        concertiRock.forEach(System.out::println);

        Location locationA = ld.getById(UUID.fromString("bbeb3bcf-c5e0-4244-ab5e-02329bd57d3e"));
        Location locationB = ld.getById(UUID.fromString("85768017-cf88-4b26-b11c-eaf45be8efa0"));
        Location locationC = ld.getById(UUID.fromString("10ba2495-5811-4857-8ed0-366bc0324029"));
        Location locationD = ld.getById(UUID.fromString("88eda812-11d4-4bb6-a914-d0fc0fd69147"));

        PartitaDiCalcio partita1 = new PartitaDiCalcio(
                "Finale di Champions League",
                LocalDateTime.of(2024, 5, 25, 21, 0),
                "La finale tra due grandi squadre europee.",
                locationA,
                TipoEvento.PUBBLICO,
                70000,
                "Real Madrid",
                "Liverpool",
                "Real Madrid",
                (byte) 3,
                (byte) 1
        );

        PartitaDiCalcio partita2 = new PartitaDiCalcio(
                "Derby di Milano",
                LocalDateTime.of(2024, 10, 15, 20, 45),
                "Il derby tra Milan e Inter.",
                locationB,
                TipoEvento.PUBBLICO,
                80000,
                "AC Milan",
                "Inter",
                "AC Milan",
                (byte) 2,
                (byte) 1
        );

        PartitaDiCalcio partita3 = new PartitaDiCalcio(
                "Finale di Coppa Italia",
                LocalDateTime.of(2024, 5, 15, 21, 0),
                "La finale tra Juventus e Napoli.",
                locationA,
                TipoEvento.PUBBLICO,
                70000,
                "Juventus",
                "Napoli",
                "Juventus",
                (byte) 1,
                (byte) 0
        );

        PartitaDiCalcio partita4 = new PartitaDiCalcio(
                "Finale Coppa Spagnola",
                LocalDateTime.of(2024, 3, 1, 20, 45),
                "Finale tra Real Madrid e Barcelona.",
                locationC,
                TipoEvento.PUBBLICO,
                81000,
                "Real Madrid",
                "Barcelona",
                "Barcelona",
                (byte) 2,
                (byte) 3
        );

        PartitaDiCalcio partita5 = new PartitaDiCalcio(
                "Finale Mondiale",
                LocalDateTime.of(2024, 12, 18, 18, 0),
                "La finale della Coppa del Mondo FIFA.",
                locationD,
                TipoEvento.PUBBLICO,
                88000,
                "Argentina",
                "Francia",
                "Argentina",
                (byte) 3,
                (byte) 3 // Vittoria ai rigori
        );

        PartitaDiCalcio partita6 = new PartitaDiCalcio(
                "Supercoppa Italiana",
                LocalDateTime.of(2024, 8, 12, 21, 0),
                "La sfida tra i vincitori della Serie A e della Coppa Italia.",
                locationA,
                TipoEvento.PUBBLICO,
                68000,
                "Inter",
                "Juventus",
                "Inter",
                (byte) 2,
                (byte) 0
        );

        //pdc.save(partita1);
        //pdc.save(partita2);
        //pdc.save(partita3);
        //pdc.save(partita4);
        //pdc.save(partita5);
        //pdc.save(partita6);

        System.out.println("****************  PARTITE VINTE IN CASA  *********************************");

        List<PartitaDiCalcio> partiteVinteInCasa = ed.findPartiteVinteInCasa();
        partiteVinteInCasa.forEach(System.out::println);

        System.out.println("****************  PARTITE VINTE IN Trasferta  *********************************");

        List<PartitaDiCalcio> getPartiteVinteInTrasferta = ed.findPartiteVinteInTrasferta();
        getPartiteVinteInTrasferta.forEach(System.out::println);


    }
}
