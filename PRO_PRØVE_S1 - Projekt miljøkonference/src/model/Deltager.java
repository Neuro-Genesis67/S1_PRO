package model;

import java.util.ArrayList;

public class Deltager {
    private String navn, by, adresse, land;
    private int alder;
    private String firmaNavn, telefonNr;
    private String firmatlfNr;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Deltager(String navn, int alder, String by, String adresse, String telefonNr) {
        setNavn(navn);
        setAlder(alder);
        setBy(by);
        setAdresse(adresse);
        setLand(land);
        setTelefonNr(telefonNr);
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void setTilmeldinger(ArrayList<Tilmelding> tilmeldinger) {
        this.tilmeldinger = tilmeldinger;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public String getFirmatlfNr() {
        return firmatlfNr;
    }

    public void setFirmatlfNr(String firmatlfNr) {
        this.firmatlfNr = firmatlfNr;
    }

    @Override
    public String toString() {
        return navn;
    }

}
