package CarMaintenanceSystem;

import CarMaintenanceSystem.appointment.Appointment;
import CarMaintenanceSystem.appointment.AppointmentBuilder;
import CarMaintenanceSystem.customers.*;
import CarMaintenanceSystem.handler.*;
import CarMaintenanceSystem.staff.Mechanic;
import CarMaintenanceSystem.staff.Technician;
import CarMaintenanceSystem.staff.frontDeskStaff.AppointmentService;
import CarMaintenanceSystem.staff.frontDeskStaff.AppointmentServiceProxy;
import CarMaintenanceSystem.staff.frontDeskStaff.FrontDeskStaff;
import CarMaintenanceSystem.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// central lists
		List<Customer> customers = new ArrayList<Customer>();
		List<Staff> employees = new ArrayList<>();
		List<Appointment> appointments = new ArrayList<>();

		// Create customers
		Customer c1 = new FleetOwnerCustomer(
				  "ZainZoon",
				  "Amman, Jordan",
				  "111",
				  "0987",
				  new ArrayList<Car>(),
				  "Careem"
		);
		Customer c2 = new StaffCustomer(
				  "AhmadAli",
				  "Amman, Jordan",
				  "333",
				  "0123",
				  new ArrayList<Car>()
		);
		Customer c3 = new PrivateCarOwner(
				  "alilali",
				  "Irbid, Jordan",
				  "222",
				  "0122",
				  new ArrayList<Car>()
		);

		// Adding cars
		c1.getCars().add(new Car("Toyota", "Camry", "123.123"));
		c2.getCars().add(new Car("Honda", "Civic", "456.456"));
		c3.getCars().add(new Car("Toyota", "Civic", "789.789"));

		// Build appointments
		Appointment a1 = new AppointmentBuilder()
				  .withAppointmentId(1)
				  .withCustomer(c1)
				  .withCar(c1.getCars().get(0))
				  .withAppointmentStatus("Done")
				  .withHour(14)
				  .build();

		Appointment a2 = new AppointmentBuilder()
				  .withAppointmentId(2)
				  .withCustomer(c2)
				  .withCar(c2.getCars().get(0))
				  .withAppointmentStatus("ToDo")
				  .withHour(15)
				  .build();

		Appointment a3 = new AppointmentBuilder()
				  .withAppointmentId(3)
				  .withCustomer(c3)
				  .withCar(c3.getCars().get(0))
				  .withAppointmentStatus("ToDo")
				  .withHour(16)
				  .build();

		// Create staff
		FrontDeskStaff s1 = new FrontDeskStaff("MohammadZaid", 1);
		FrontDeskStaff s2 = new FrontDeskStaff("Alex", 2);
		Technician t1    = new Technician("zainnn",    3);
		Mechanic m1      = new Mechanic("Khalid",      4);

		employees.add(s1);
		employees.add(t1);
		employees.add(m1);
		employees.add(s2);

		// registering all customers
		s1.registerCustomer(c1, customers);
		s1.registerCustomer(c2, customers);
		s1.registerCustomer(c3, customers);

		// schedule appointment
		AppointmentService appointmentProxy = new AppointmentServiceProxy(s2);
		appointmentProxy.scheduleAppointment(a1, appointments);
		appointmentProxy.scheduleAppointment(a2, appointments);
		appointmentProxy.scheduleAppointment(a3, appointments);

		// Calculate service bills
		double bill1 = s1.calculateServiceBill("333", customers);
		double bill2 = s2.calculateServiceBill("111", customers);
		double bill3 = s1.calculateServiceBill("222", customers);

		System.out.println("Bill for staff customer: " + bill1);
		System.out.println("Bill for fleet owner customer: " + bill2);
		System.out.println("Bill for private car owner customer: " + bill3);
		System.out.println();

		// List scheduled appointments
		System.out.println("Front Desk Staff Appointments Listing ");
		s1.listAppointments(appointments);
		System.out.println();

		System.out.println("Mechanic Appointments Listing ");
		m1.listAppointments(appointments);
		System.out.println();

		// Mechanic adds service report
		m1.addServiceReport(a1,"Changed oil and filter","Oil filter, ABC Oil");

		// Technician adds diagnostic report
		t1.addDiagnosticReport(a1,"Battery voltage low", "Recharged battery");

		// Technician generates a daily report
		t1.generateDailyReport(appointments);
		System.out.println();

		// send a ServiceRequest CoR
		ServiceRequest sr1 = new ServiceRequest(a1, "EngineIssue");
		Handler h1 = new EngineHandler();
		Handler h2 = new ElectricalHandler();
		Handler h3 = new BodyHandler();
		h1.setNextHandler(h2);
		h2.setNextHandler(h3);
		h1.handleService(sr1);

		// Print assigned handler
		System.out.println("Assigned handler for service request: " + sr1.getAssignedHandler());
	}
}
