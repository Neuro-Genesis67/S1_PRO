package model;

import java.time.LocalDate;

import service.Service;

public class TestApp {

    public static void main(String[] args) {
        Deltager d1 = Service.createDeltager("Finn Madsen", 98, "by", "adresse", "45778963");

        Deltager d2 = Service.createDeltager("Nield Petersen", 1, "by", "adresse", "45887896");

        Deltager d3 = Service.createDeltager("Peter Sommer", 1, "by", "adresse", "45887896");

        Deltager d4 = Service.createDeltager("Lone Jensen", 18, "by", "adresse", "342546135");
        // ---------------------------------------------------------

        LocalDate date1 = LocalDate.of(2018, 05, 18);
        LocalDate date2 = LocalDate.of(2018, 05, 20);
        LocalDate date3 = LocalDate.of(2018, 05, 19);
        LocalDate date4 = LocalDate.of(2018, 05, 20);

        // ---------------------------------------------------------

        Konference k1 = Service.createKonference("Hav og Himmel", "Odense Universitet", date1, date2, 1500.00);

        // ---------------------------------------------------------

        Tilmelding t1 = Service.createTilmelding(date1, date2, d1, k1);
        Tilmelding t2 = Service.createTilmelding(date1, date2, d2, k1);
        Tilmelding t3 = Service.createTilmelding(date1, date2, d3, k1);
        Tilmelding t4 = Service.createTilmelding(date1, date2, d4, k1);
        // ---------------------------------------------------------

        Service.createLedsager("Mie Sommer", t3);
        Service.createLedsager("Jan Madsen", t4);

        // ---------------------------------------------------------

        Udflugt u1 = Service.createUdflugt("Bytur", "Odense", date3, 125.00, k1);
        Udflugt u2 = Service.createUdflugt("Egeskov", "Odense", date3, 75.00, k1);
        Udflugt u3 = Service.createUdflugt("Trapholt Museum", "Kolding", date4, 200.00, k1);

        // ---------------------------------------------------------

        Hotel h1 = Service.createHotel("Den Hvide Svane", "adresse", 1050.00, 1250.00);

        // ---------------------------------------------------------
        /*
         * Service.opretBooking(2, h1, t2); Service.opretBooking(2, h1, t3);
         * Service.opretBooking(2, h1, t4);
         */
        // ---------------------------------------------------------

        HotelService hs1 = Service.addHotelServiceToHotel("WiFi", 50, h1);

        // ---------------------------------------------------------

        Service.connectHotelServiceToBooking(hs1, t3);
        Service.connectHotelServiceToBooking(hs1, t4);

        Service.connectLedsagerToUdflugt(t3, u3);
        Service.connectLedsagerToUdflugt(t3, u2);
        Service.connectLedsagerToUdflugt(t4, u1);
        Service.connectLedsagerToUdflugt(t4, u2);

        Service.setDeltagerAsForedragsholder(true, t4);

        // ---------------------------------------------------------

        System.out.println("Prisen for Finn Madsen er: " + t1.udregnTotalPris());
        System.out.println("Prisen for Niels Petersen er: " + t2.udregnTotalPris());
        System.out.println("Prisen for Peter Sommer er: " + t3.udregnTotalPris());
        System.out.println("Prisen for Lone Jensen og Jan Madsen er: " + t4.udregnTotalPris());
    }
}
