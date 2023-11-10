package s02_InheritanceAndImpl;

public class Vehicle implements Engine {
	// koltuk ve tekerlek sayisi

	int numberOfSeats;
	int numberOfWheels;

	public void start() {
		System.out.println("Vehic is running");
	}

	@Override
	public void stop() {
		System.out.println("Vehic stoped");

	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfWheels(int numberOfWhells) {
		this.numberOfWheels = numberOfWhells;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

}
