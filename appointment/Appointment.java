package CarMaintenanceSystem.appointment;

import CarMaintenanceSystem.customers.Car;
import CarMaintenanceSystem.customers.Customer;

public class Appointment {
	private int appointmentId;
	private Customer customer;
	private Car car;
	private String mechanicReport;
	private String diagnosticResults;
	private String appointmentStatus;
	private int hour;
	public Appointment(int appointmentId, Customer customer, Car car
			  , String mechanicReport
			  , String diagnosticResults, String appointmentStatus
			  , int hour) {
		this.appointmentId = appointmentId;
		this.customer = customer;
		this.car = car;
		this.mechanicReport = mechanicReport;
		this.diagnosticResults = diagnosticResults;
		this.appointmentStatus = appointmentStatus;
		this.hour = hour;
	}

	public Appointment(AppointmentBuilder builder) {
		this.appointmentId = builder.getAppointmentId();
		this.customer = builder.getCustomer();
		this.car = builder.getCar();
		this.mechanicReport = builder.getMechanicReport();
		this.diagnosticResults = builder.getDiagnosticResults();
		this.appointmentStatus = builder.getAppointmentStatus();
		this.hour = builder.getHour();
	}
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getMechanicReport() {
		return mechanicReport;
	}

	public void setMechanicReport(String mechanicReport) {
		this.mechanicReport = mechanicReport;
	}

	public String getDiagnosticResults() {
		return diagnosticResults;
	}
	public void setDiagnosticResults(String diagnosticResults) {
		this.diagnosticResults = diagnosticResults;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}



	@Override
	public String toString() {
		return "Appointment{" +
				  "appointmentId=" + appointmentId +
				  ", customer=" + customer.toString() +
				  ", car=" + car.toString() +
				  ", mechanicReport='" + mechanicReport + '\'' +
				  ", diagnosticResults='" + diagnosticResults + '\'' +
				  ", appointmentStatus='" + appointmentStatus + '\'' +
				  ", hour=" + hour +
				  '}';
	}
}
