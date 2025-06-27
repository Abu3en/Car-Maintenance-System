package CarMaintenanceSystem.customers;

import java.util.List;

public abstract class Customer {
	protected String fullName;
	protected String address;
	protected String nationalId;
	protected String contactNumber;
	protected List<Car> cars;


	public Customer(String fullName, String address, String nationalId, String contactNumber, List<Car> cars) {
		this.fullName = fullName;
		this.address = address;
		this.nationalId = nationalId;
		this.contactNumber = contactNumber;
		this.cars = cars;
	}
	public Customer(){}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Customer{" +
				  "fullName='" + fullName + '\'' +
				  ", address='" + address + '\'' +
				  ", nationalId='" + nationalId + '\'' +
				  ", contactNumber='" + contactNumber + '\'';
	}
}
