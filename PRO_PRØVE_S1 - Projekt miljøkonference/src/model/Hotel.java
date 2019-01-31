package model;

import java.util.ArrayList;

public class Hotel {
	private String navn;

	private String adresse;
	private double prisEnkelt;
	private double prisDobbelt;

	private ArrayList<Booking> bookings = new ArrayList<>();
	private ArrayList<HotelService> hotelServices = new ArrayList<>();

	public Hotel(String navn, String adresse, double prisEknelt, double prisDobbelt) {
		this.navn = navn;
		setAdresse(adresse);
		this.prisEnkelt = prisEknelt;
		this.prisDobbelt = prisDobbelt;
	}

	// Henter prisen for et hotel
	public double getHotelPris(boolean isDoubleRoom) {
		if (isDoubleRoom) {
			return prisDobbelt;
		} else {
			return prisEnkelt;
		}
	}

	// Opretter et hotel service
	public HotelService opretHotelService(String navn, double tillægsPris) {
		HotelService hotelService = new HotelService(navn, tillægsPris);

		return hotelService;
	}

	public void addToBooking(Booking booking) {
		bookings.add(booking);
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public ArrayList<HotelService> getHotelServices() {
		return hotelServices;
	}

	public void addHotelServices(HotelService hotelService) {
		hotelServices.add(hotelService);
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getPrisEnkelt() {
		return prisEnkelt;
	}

	public void setPrisEnkelt(double prisEnkelt) {
		this.prisEnkelt = prisEnkelt;
	}

	public double getPrisDobbelt() {
		return prisDobbelt;
	}

	public void setPrisDobbelt(double prisDobbelt) {
		this.prisDobbelt = prisDobbelt;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

}
