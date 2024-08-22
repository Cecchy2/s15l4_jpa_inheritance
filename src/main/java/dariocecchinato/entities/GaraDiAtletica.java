package dariocecchinato.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class GaraDiAtletica extends Evento {

    @ManyToMany
    private List<Persona> set_atleti;

    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDateTime dataEvento, String descrizione, Location location, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Persona> set_atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, location, tipoEvento, numeroMassimoPartecipanti);
        this.set_atleti = set_atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(List<Persona> set_atleti, Persona vincitore) {
        this.set_atleti = set_atleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getSet_atleti() {
        return set_atleti;
    }

    public void setSet_atleti(List<Persona> set_atleti) {
        this.set_atleti = set_atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "set_atleti=" + set_atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
