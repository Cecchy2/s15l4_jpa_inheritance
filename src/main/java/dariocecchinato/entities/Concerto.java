package dariocecchinato.entities;


import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Concerto extends Evento {
    private GenereConcerto genere_Concerto;
    private boolean in_Streaming;

    public Concerto(String titolo, LocalDateTime dataEvento, String descrizione, Location location, TipoEvento tipoEvento, int numeroMassimoPartecipanti, GenereConcerto genere_Concerto, boolean in_Streaming) {
        super(titolo, dataEvento, descrizione, location, tipoEvento, numeroMassimoPartecipanti);
        this.genere_Concerto = genere_Concerto;
        this.in_Streaming = in_Streaming;
    }

    public Concerto() {
    }

    public Concerto(GenereConcerto genere_Concerto, boolean in_Streaming) {
        this.genere_Concerto = genere_Concerto;
        this.in_Streaming = in_Streaming;
    }

    public GenereConcerto getGenere_Concerto() {
        return genere_Concerto;
    }

    public void setGenere_Concerto(GenereConcerto genere_Concerto) {
        this.genere_Concerto = genere_Concerto;
    }

    public boolean isIn_Streaming() {
        return in_Streaming;
    }

    public void setIn_Streaming(boolean in_Streaming) {
        this.in_Streaming = in_Streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere_Concerto=" + genere_Concerto +
                ", in_Streaming=" + in_Streaming +
                '}';
    }
}
