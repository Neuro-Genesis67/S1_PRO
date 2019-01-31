package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Booking {

	private Hotel hotel;

	private LocalDate tilHotel;
	private LocalDate fraHotel;
	private boolean isDoubleRoom;
	private Tilmelding tilmelding;
	private ArrayList<HotelService> hotelServicesValgt = new ArrayList<>();

	public Booking(LocalDate fra, LocalDate til, Hotel hotel) {
		this.fraHotel = fra;
		this.tilHotel = til;
		this.hotel = hotel;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		this.tilmelding = tilmelding;
	}

	public void addServiceToBooking(HotelService hotelService) {
		this.hotelServicesValgt.add(hotelService);
	}

	public ArrayList<HotelService> getHotelServicesValgt() {
		return hotelServicesValgt;
	}

	public double beregnTotalPris() {
		double totalPris = 0;
		if (tilmelding.getLedsager() == null) {
			isDoubleRoom = false;
		} else {
			isDoubleRoom = true;
		}
		totalPris += hotel.getHotelPris(isDoubleRoom);
		for (HotelService hotelservice : hotelServicesValgt) {
			totalPris += hotelservice.getTillægsPris();

		}
		int antalDage = 0;
		if (fraHotel.getDayOfMonth() > tilHotel.getDayOfMonth()) {
			antalDage = (int) ChronoUnit.DAYS.between(tilHotel, fraHotel);

		} else {
			antalDage = tilHotel.getDayOfMonth() - fraHotel.getDayOfMonth();
		}

		return totalPris * antalDage;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public int getAntalDage() {
		int antalDage = 0;
		if (fraHotel.getDayOfMonth() > tilHotel.getDayOfMonth()) {
			antalDage = (int) ChronoUnit.DAYS.between(tilHotel, fraHotel);

		} else {
			antalDage = tilHotel.getDayOfMonth() - fraHotel.getDayOfMonth();
		}
		return antalDage;
	}

	public LocalDate getTil() {
		return tilHotel;
	}

	public void setTil(LocalDate til) {
		this.tilHotel = til;
	}

	public LocalDate getFra() {
		return fraHotel;
	}

	public void setFra(LocalDate fra) {
		this.fraHotel = fra;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void clearList() {
		this.hotelServicesValgt.clear();
	}

}
