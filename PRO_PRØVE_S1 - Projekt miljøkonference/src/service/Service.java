package service;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Booking;
import model.Deltager;
import model.Hotel;
import model.HotelService;
import model.Konference;
import model.Ledsager;
import model.Tilmelding;
import model.Udflugt;
import storage.Storage;

public class Service {

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette en tilmelding til konferencen
	public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager,
			Konference konference) {

		Tilmelding tilmelding = konference.opretTilmelding(ankomstDato, afrejseDato, deltager, konference);
		konference.addTilmelding(tilmelding);
		deltager.addTilmelding(tilmelding);

		return tilmelding;
	}

	public static void deleteTilmelding(Tilmelding tilmelding) {
		Konference konference = tilmelding.getKonference();
		if (konference != null) {
			konference.removeTilmelding(tilmelding);
			tilmelding.setKonference(null);
			Service.deleteBooking(tilmelding);
			Service.deleteLedsager(tilmelding);

		}
	}

	public static void updateTilmelding(Tilmelding tilmelding, Deltager deltager, LocalDate afrejseDato,
			LocalDate ankomstDato) {
		tilmelding.setAfrejseDato(afrejseDato);
		tilmelding.setAnkomstDato(ankomstDato);

	}

	public static void deleteLedsager(Tilmelding tilmelding) {
		Ledsager ledsager = tilmelding.getLedsager();
		if (ledsager != null) {
			tilmelding.setLedsager(null);
			ledsager.clearList();
			ledsager.setTilmelding(null);
			for (Udflugt udflugt : ledsager.getUdflugter()) {
				udflugt.getLedsagere().remove(ledsager);
			}

		}
	}

	public static void deleteBooking(Tilmelding tilmelding) {
		Booking booking = tilmelding.getBooking();
		if (booking != null) {
			tilmelding.setBooking(null);
			booking.getHotel().getBookings().remove(booking);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette en til en konferencen
	public static Udflugt createUdflugt(String navn, String sted, LocalDate tidspunkt, double udflugtsPris,
			Konference konference) {
		Udflugt udflugt = konference.opretUdflugt(navn, sted, tidspunkt, udflugtsPris);
		konference.addUdflugt(udflugt);
		return udflugt;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at forbinde et hotel til en konference
	public static void connectHotelToKonference(Konference konference, Hotel hotel) {
		if (!konference.getHoteller().contains(hotel)) {
			konference.addHotel(hotel);
		}
	}
	// ---------------------------------------------------------------------------------------------------------------

	public static void setDeltagerAsForedragsholder(boolean isForedragsholder, Tilmelding tilmelding) {
		tilmelding.setForedragsholder(isForedragsholder);
	}

	// Service metode til at forbinde en ledsager til en udflugt
	public static void connectLedsagerToUdflugt(Tilmelding tilmelding, Udflugt udflugt) {
		if (!tilmelding.getLedsager().getUdflugter().contains(udflugt)) {
			tilmelding.addUdflugt(udflugt);
			udflugt.addLedsager(tilmelding.getLedsager());
		}
	}

	// ---------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------

	// Service metode til at forbinde et hotel service til et hotel
	public static HotelService addHotelServiceToHotel(String navn, double tillægsPris, Hotel hotel) {
		HotelService hs = hotel.opretHotelService(navn, tillægsPris);
		if (!hotel.getHotelServices().contains(hs)) {
			hotel.addHotelServices(hs);
		}
		return hs;
	}

	public static void removeHotelServiceFromHotel(HotelService hotelService, Hotel hotel) {
		for (Booking booking : hotel.getBookings()) {
			if (booking.getHotelServicesValgt().contains(hotelService)) {
				booking.getHotelServicesValgt().remove(hotelService);
			}
		}
		hotel.getHotelServices().remove(hotelService);
	}

	public static HotelService connectHotelServiceToHotel(HotelService hotelService, Hotel hotel) {
		if (!hotel.getHotelServices().contains(hotelService)) {
			hotel.addHotelServices(hotelService);
		}
		return hotelService;
	}

	public static void connectHotelServiceToBooking(HotelService hotelservice, Tilmelding tilmelding) {
		if (hotelservice != null) {
			if (!tilmelding.getBooking().getHotelServicesValgt().contains(hotelservice)) {
				tilmelding.getBooking().addServiceToBooking(hotelservice);

			}

		}
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette en ledsager
	public static Ledsager createLedsager(String navn, Tilmelding tilmelding) {
		Ledsager ledsager = tilmelding.opretLedsager(navn);
		ledsager.setTilmelding(tilmelding);
		return ledsager;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette en booking
	public static Booking createBooking(LocalDate til, LocalDate fra, Hotel hotel, Tilmelding tilmelding) {
		Booking booking = tilmelding.opretBooking(til, fra, hotel);
		booking.setTilmelding(tilmelding);
		tilmelding.setBooking(booking);
		hotel.addToBooking(booking);
		return booking;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Servicemetoder for at oprette, fjerne og hente en konference
	public static Konference createKonference(String navn, String sted, LocalDate startDato, LocalDate slutDato,
			double konferencePris) {
		Konference konference = new Konference(sted, navn, startDato, slutDato, konferencePris);
		Storage.addKonference(konference);
		return konference;
	}

	public static void removeKonference(Konference konference) {
		for (Hotel hotel : konference.getHoteller()) {
			for (Tilmelding tilmelding : konference.getTilmeldinger()) {
				if (tilmelding.getBooking() != null) {
					hotel.getBookings().remove(tilmelding.getBooking());
				}
			}
		}

		Storage.removeKonference(konference);

	}

	public static ArrayList<Konference> getKonference() {
		return Storage.getKonference();
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette, fjerne og hente en deltager
	public static Deltager createDeltager(String navn, int alder, String by, String adresse, String telefonNr) {
		Deltager deltager = new Deltager(navn, alder, by, adresse, telefonNr);
		Storage.addDeltager(deltager);
		return deltager;
	}

	public static void updateDeltager(Deltager deltager, String navn, int alder, String by, String adresse,
			String telefonNr) {
		deltager.setNavn(navn);
		deltager.setAlder(alder);
		deltager.setBy(by);
		deltager.setTelefonNr(telefonNr);

	}

	public static void removeDeltager(Deltager deltager) {
		for (Tilmelding tilmelding : deltager.getTilmeldinger()) {
			Service.deleteTilmelding(tilmelding);

		}
		Storage.removeDeltager(deltager);
	}

	public static ArrayList<Deltager> getDeltager() {
		return Storage.getDeltager();
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Service metoder til at oprette, fjerne og hente et hotel
	public static Hotel createHotel(String navn, String adresse, double prisEknelt, double prisDobbelt) {
		Hotel hotel = new Hotel(navn, adresse, prisEknelt, prisDobbelt);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static void removeHotel(Hotel hotel) {
		for (Booking booking : hotel.getBookings()) {
			booking.getTilmelding().getKonference().removeHotel(hotel);
			booking.setHotel(null);
			booking.getTilmelding().setBooking(null);
			Service.deleteBooking(booking.getTilmelding());
		}
		Storage.removeHotel(hotel);
	}

	public static ArrayList<Hotel> getHotel() {
		return Storage.getHotel();
	}

	public static ArrayList<Tilmelding> getTilmeldinger(Konference konference) {
		ArrayList<Tilmelding> til = konference.getTilmeldinger();
		return til;
	}

	public static void initStorage() {
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
		Konference k2 = Service.createKonference("Fiske huset", "Odense Universitet", date1, date2, 1500.00);

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

		Hotel h2 = Service.createHotel("Abe Huset", "adresse", 500.00, 750.00);

		// ---------------------------------------------------------

		Service.connectHotelToKonference(k1, h1);
		Service.connectHotelToKonference(k1, h2);

		Service.createBooking(date1, date2, h1, t2);
		Service.createBooking(date1, date2, h1, t3);
		Service.createBooking(date1, date2, h1, t4);
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

	}
}
