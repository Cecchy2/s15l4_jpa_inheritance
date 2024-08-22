package dariocecchinato.entities;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class PartitaDiCalcio extends Evento {
    private String squadra_di_casa;
    private String squadra_ospite;
    private String squadra_vincente;
    private byte Gol_squadra_di_casa;
    private byte Gol_squadra_ospite;

    public PartitaDiCalcio(String titolo, LocalDateTime dataEvento, String descrizione, Location location, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadra_di_casa, String squadra_ospite, String squadra_vincente, byte gol_squadra_di_casa, byte gol_squadra_ospite) {
        super(titolo, dataEvento, descrizione, location, tipoEvento, numeroMassimoPartecipanti);
        this.squadra_di_casa = squadra_di_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        Gol_squadra_di_casa = gol_squadra_di_casa;
        Gol_squadra_ospite = gol_squadra_ospite;
    }

    public PartitaDiCalcio() {
    }


    public PartitaDiCalcio(String squadra_di_casa, String squadra_ospite, String squadra_vincente, byte gol_squadra_di_casa, byte gol_squadra_ospite) {
        this.squadra_di_casa = squadra_di_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        Gol_squadra_di_casa = gol_squadra_di_casa;
        Gol_squadra_ospite = gol_squadra_ospite;
    }

    public String getSquadra_di_casa() {
        return squadra_di_casa;
    }

    public void setSquadra_di_casa(String squadra_di_casa) {
        this.squadra_di_casa = squadra_di_casa;
    }

    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }

    public String getSquadra_vincente() {
        return squadra_vincente;
    }

    public void setSquadra_vincente(String squadra_vincente) {
        this.squadra_vincente = squadra_vincente;
    }

    public byte getGol_squadra_di_casa() {
        return Gol_squadra_di_casa;
    }

    public void setGol_squadra_di_casa(byte gol_squadra_di_casa) {
        Gol_squadra_di_casa = gol_squadra_di_casa;
    }

    public byte getGol_squadra_ospite() {
        return Gol_squadra_ospite;
    }

    public void setGol_squadra_ospite(byte gol_squadra_ospite) {
        Gol_squadra_ospite = gol_squadra_ospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadra_di_casa='" + squadra_di_casa + '\'' +
                ", squadra_ospite='" + squadra_ospite + '\'' +
                ", squadra_vincente='" + squadra_vincente + '\'' +
                ", Gol_squadra_di_casa=" + Gol_squadra_di_casa +
                ", Gol_squadra_ospite=" + Gol_squadra_ospite +
                '}';
    }
}
