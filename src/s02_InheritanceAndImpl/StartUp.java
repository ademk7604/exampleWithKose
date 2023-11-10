package s02_InheritanceAndImpl;

import s02_InheritanceAndImpl.Car;

public class StartUp {
	public static void main(String[] args) {
		Car car = new Car();
		car.numberOfSeats = 5;
		car.numberOfWheels = 4;
		
		Bicycle bicycle = new Bicycle();
		bicycle.numberOfSeats = 1;
		bicycle.numberOfSeats = 2;
		
		
		Vehicle car2 =new Car();
		
		// Car car3 = new Vehicle(); her arac araba degildir :)
		
		car.start();
		bicycle.start();
		car2.start();
		
		car2.stop();
		
		//Pol; cok bicimlilik
		Vehicle[] vehicles = new Vehicle[10];
		vehicles[0] = car;
		vehicles[1] = bicycle;
		vehicles[2] = car2;
		
		
		
	}

}
