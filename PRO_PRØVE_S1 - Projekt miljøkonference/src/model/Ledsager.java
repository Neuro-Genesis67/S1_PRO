package model;

import java.util.ArrayList;

public class Ledsager {
    private String navn;
    private Tilmelding tilmelding;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Ledsager(String navn) {
        this.navn = navn;
    }

    public double beregnTotalUdflugtPris() {
        double udflugtsPris = 0;
        for (Udflugt udflugt : udflugter) {
            udflugtsPris += udflugt.getUdflugtsPris();
        }
        return udflugtsPris;
    }

    public Tilmelding getTilmelding() {
        return tilmelding;
    }

    public void setUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = udflugter;
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public void setTilmelding(Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public void clearList() {
        udflugter.clear();
    }

    @Override
    public String toString() {
        return navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
