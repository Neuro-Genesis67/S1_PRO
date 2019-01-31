package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private String sted;
    private LocalDate tidspunkt;
    private double udflugtPris;
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Udflugt(String navn, String sted, LocalDate tidspunkt, double udflugtsPris) {
        this.navn = navn;
        this.sted = sted;
        this.tidspunkt = tidspunkt;
        this.udflugtPris = udflugtsPris;
    }

    public double getUdflugtsPris() {
        return udflugtPris;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public String toStringMedDato() {
        return (navn + " (" + tidspunkt.getDayOfMonth() + "/" + tidspunkt.getMonthValue() + ")");
    }

    public void addLedsager(Ledsager ledsager) {
        this.ledsagere.add(ledsager);

    }

}
