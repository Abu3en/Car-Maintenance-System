package CarMaintenanceSystem.appointment;

import CarMaintenanceSystem.customers.Car;
import CarMaintenanceSystem.customers.Customer;

public class AppointmentBuilder {
	private int appointmentId;
	private Customer customer;
	private Car car;
	private String mechanicReport;
	private String diagnosticResults;
	private String appointmentStatus;
	private int hour;

	public int getAppointmentId() {
		return appointmentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public String getMechanicReport() {
		return mechanicReport;
	}

	public String getDiagnosticResults() {
		return diagnosticResults;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public int getHour() {
		return hour;
	}

	public AppointmentBuilder withAppointmentId(int id) {
		this.appointmentId = id;
		return this;
	}

	public AppointmentBuilder withCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}
	public AppointmentBuilder withCar(Car car) {
		this.car = car;
		return this;
	}
	public AppointmentBuilder withMechanicReport(String mechanicReport) {
		this.mechanicReport = mechanicReport;
		return this;
	}
	public AppointmentBuilder withDiagnosticResults(String diagnosticResults) {
		this.diagnosticResults = diagnosticResults;
		return this;
	}
	public AppointmentBuilder withAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
		return this;
	}
	public AppointmentBuilder withHour(int hour) {
		this.hour = hour;
		return this;
	}
	public Appointment build() {
		return new Appointment(this);
	}
}
