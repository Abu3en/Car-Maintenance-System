package CarMaintenanceSystem.handler;

import CarMaintenanceSystem.appointment.Appointment;

public class ServiceRequest {

	private Appointment appointment;
	private String serviceType;
	private String assignedHandler;

	public ServiceRequest(Appointment appointment, String serviceType) {
		this.appointment = appointment;
		this.serviceType = serviceType;
	}

	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getAssignedHandler() {
		return assignedHandler;
	}

	public void setAssignedHandler(String assignedHandler) {
		this.assignedHandler = assignedHandler;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}
