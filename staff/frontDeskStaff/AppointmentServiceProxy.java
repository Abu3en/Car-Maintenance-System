package CarMaintenanceSystem.staff.frontDeskStaff;

import CarMaintenanceSystem.appointment.Appointment;

import java.util.List;

public class AppointmentServiceProxy implements AppointmentService {
	private AppointmentService realRegistrationStaff;
	public AppointmentServiceProxy(AppointmentService realRegistrationStaff) {
		this.realRegistrationStaff = realRegistrationStaff;
	}

	@Override
	public void scheduleAppointment(Appointment appointment, List<Appointment> appointments) {
		int requestedHour = appointment.getHour();

		for (Appointment ap : appointments) {
			if (ap.getHour() == requestedHour) {
				System.out.println("Appointment can’t be reserved at " + requestedHour);
				return;
			}
		}
		realRegistrationStaff.scheduleAppointment(appointment, appointments);
	}
}
