package backupModel;

import java.util.ArrayList;

public class CarRentalApp {

	public static void main(String[] args) {

		//		String license, int year
		Car c1 = new Car("AB22", 1995);
		Car c2 = new Car("AB23", 1997);
		Car c3 = new Car("AB24", 1992);
		Car c4 = new Car("AB25", 2005);
		Car c5 = new Car("AB26", 2010);
		c1.setDayPrice(20);
		c2.setDayPrice(30);
		c3.setDayPrice(40);
		c4.setDayPrice(50);
		c5.setDayPrice(60);
		
//		int number, String date, int days
		Rental r1 = new Rental(1, "7-5-1991", 30);
		Rental r2 = new Rental(2, "6-7-1995", 60);
		r1.addCar(c1);
		r1.addCar(c2);
		r2.addCar(c3);
		r2.addCar(c4);
		r2.addCar(c5);
		System.out.println(r1.getPrice());
		
		
	}

}
