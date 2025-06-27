package CarMaintenanceSystem.staff.frontDeskStaff;

import CarMaintenanceSystem.appointment.Appointment;

import java.util.List;

public interface AppointmentService {
	void scheduleAppointment(Appointment appointment, List<Appointment> appointments);
}
