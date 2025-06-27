package CarMaintenanceSystem.staff;

import CarMaintenanceSystem.appointment.Appointment;

import java.util.List;

public class Mechanic extends Staff {

	public Mechanic(String staffName, int staffId) {
		super(staffName, staffId);
	}
	public void listAppointments(List<Appointment> appointments) {
		for(Appointment appointment : appointments) {
			System.out.println(appointment.getAppointmentId() + " " + appointment.getHour() + " "
					  + appointment.getCar().toString());
		}
	}
	public void addServiceReport(Appointment appointment, String repairsPerformed, String partsUsed) {
		appointment.setMechanicReport("Repairs Performed: " + repairsPerformed
				  + " Parts Used: " + partsUsed);
	}
}
