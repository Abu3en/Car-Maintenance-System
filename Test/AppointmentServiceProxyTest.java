package CarMaintenanceSystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceProxyTest {

	@Test
	void testScheduleAppointment_SlotAvailable_AddsToList() {
		Appointment appointment = new AppointmentBuilder()
				  .withAppointmentId(1)
				  .withHour(10)
				  .build();
		List<Appointment> appointments = new ArrayList<>();

		FrontDeskStaff registrationStaff = new FrontDeskStaff("Name", 1);
		AppointmentServiceProxy registrationProxy = new AppointmentServiceProxy(registrationStaff);
		registrationProxy.scheduleAppointment(appointment, appointments);

		assertTrue(appointments.contains(appointment));
	}

	@Test
	void testScheduleAppointment_HourTaken_DoesNotAdd() {
		
		FrontDeskStaff registrationStaff  = new FrontDeskStaff("Name", 1);
		AppointmentServiceProxy proxy = new AppointmentServiceProxy(registrationStaff);


		List<Appointment> appointments = new ArrayList<>();
		Appointment existing = new AppointmentBuilder()
				  .withAppointmentId(1)
				  .withHour(12)
				  .build();
		appointments.add(existing);


		Appointment conflict = new AppointmentBuilder()
				  .withAppointmentId(2)
				  .withHour(12)
				  .build();


		proxy.scheduleAppointment(conflict, appointments);

		assertFalse(appointments.contains(conflict));

	}

	@Test
	void testScheduleAppointment_HourOutOfWorkingTime_DoesNotAdd() {

		FrontDeskStaff realStaff = new FrontDeskStaff("Name", 1);
		AppointmentServiceProxy proxy = new AppointmentServiceProxy(realStaff);

		List<Appointment> appointments = new ArrayList<>();

		Appointment earlyAppointment = new AppointmentBuilder()
				  .withAppointmentId(1)
				  .withHour(8)
				  .build();

		proxy.scheduleAppointment(earlyAppointment, appointments);

		assertTrue(appointments.isEmpty());
	}

}