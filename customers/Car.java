package CarMaintenanceSystem.customers;

public class Car {
	private String made;
	private String model;
	private String plateNumber;

	Car(String made, String model, String plateNumber) {
		this.made = made;
		this.model = model;
		this.plateNumber = plateNumber;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return "Car{" +
				  "made='" + made + '\'' +
				  ", model='" + model + '\'' +
				  ", plateNumber='" + plateNumber + '\'' +
				  '}';
	}
}
