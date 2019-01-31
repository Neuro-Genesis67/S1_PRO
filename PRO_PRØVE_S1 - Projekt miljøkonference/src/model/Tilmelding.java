package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tilmelding {
    private LocalDate ankomstDato, afrejseDato;

    private Deltager deltager;
    private Ledsager ledsager;
    private static int idStatic = 3865;
    private int id;
    private boolean isForedragsholder;
    private Booking booking;
    private Konference konference;

    public Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.deltager = deltager;
        setLedsager(ledsager);
        this.konference = konference;
        setBooking(booking);
        id += idStatic++;
    }

    public boolean isForedragsholder() {
        return isForedragsholder;
    }

    public void setId(int id) {
        this.id = id;
    }

    // tæller hvor mange dage man har tilmeldt sig konferencen
    public int antalDage() {
        int dage = 0;
        if (ankomstDato.getDayOfMonth() > afrejseDato.getDayOfMonth()) {
            dage = (int) ChronoUnit.DAYS.between(ankomstDato, afrejseDato);

        } else {
            dage = afrejseDato.getDayOfMonth() - ankomstDato.getDayOfMonth();
        }
        return dage + 1; // For den excluter den sidste dato
    }

    // Udregningen af totalPris for udflugter + konferencen + hotel
    public double udregnTotalPris() {
        double totalPris = 0;
        if (ledsager == null) {

        } else {
            totalPris += ledsager.beregnTotalUdflugtPris();

        }
        if (booking == null) {

        } else {
            totalPris += booking.beregnTotalPris();
        }
        if (isForedragsholder == true) {
            totalPris += 0;
        } else {
            totalPris += konference.getKonferencePris() * antalDage();
        }
        return totalPris;
    }

    // Opretter en booking
    public Booking opretBooking(LocalDate til, LocalDate fra, Hotel hotel) {
        Booking booking = new Booking(til, fra, hotel);
        return booking;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    // Get, set og add metoder
    public Ledsager getLedsager() {
        return this.ledsager;
    }

    public Ledsager opretLedsager(String navn) {
        this.ledsager = new Ledsager(navn);
        return ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void addService(HotelService hotelservice) {
        booking.addServiceToBooking(hotelservice);
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public void addUdflugt(Udflugt udflugt) {
        ledsager.addUdflugt(udflugt);
    }

    public void setForedragsholder(boolean isForedragsholder) {
        this.isForedragsholder = isForedragsholder;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    @Override
    public String toString() {
        return deltager.getNavn();
    }

    public int getId() {
        return id;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

}
