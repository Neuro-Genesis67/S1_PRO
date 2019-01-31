package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn, sted;

    private LocalDate startDato, slutDato;
    private double konferencePris;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Konference(String sted, String navn, LocalDate startDato, LocalDate slutDato, double konferencePris) {
        setSted(sted);
        this.navn = navn;
        setStartDato(startDato);
        setSlutDato(slutDato);
        this.konferencePris = konferencePris;
    }

    // Opretter en udflugt
    public Udflugt opretUdflugt(String navn, String sted, LocalDate tidspunkt, double udflugtsPris) {
        Udflugt udflugt = new Udflugt(navn, sted, tidspunkt, udflugtsPris);
        return udflugt;
    }

    // Opretter en tilmelding
    public Tilmelding opretTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager,
            Konference konference) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejseDato, deltager, konference);

        return tilmelding;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        this.hoteller.remove(hotel);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.remove(tilmelding);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public double getKonferencePris() {
        return konferencePris;
    }

    @Override
    public String toString() {
        return navn + dateFormat();
    }

    private String dateFormat() {
        return " (" + startDato.getDayOfMonth() + "/" + startDato.getMonthValue() + " - " + slutDato.getDayOfMonth()
                + "/" + slutDato.getMonthValue() + ")";
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setKonferencePris(double konferencePris) {
        this.konferencePris = konferencePris;
    }

}
