package CarMaintenanceSystem.staff.frontDeskStaff;

import CarMaintenanceSystem.customers.Customer;
import CarMaintenanceSystem.customers.IDiscount;
import CarMaintenanceSystem.appointment.Appointment;
import CarMaintenanceSystem.staff.Staff;

import java.util.List;

public class FrontDeskStaff extends Staff implements AppointmentService {
	private final double BASE_COST = 50;

	public FrontDeskStaff(String staffName, int staffId) {
		super(staffName, staffId);
	}
	public void registerCustomer(Customer customer, List<Customer> customers) {
		customers.add(customer);
	}
	public void scheduleAppointment(Appointment appointment, List<Appointment> appointments) {
		int hour = appointment.getHour();
		if((hour < 9 || hour > 17)) {
			System.out.println("Reservation hour " + hour + " is out of working time");
			return;
		}
		appointments.add(appointment);
	}
	public double calculateServiceBill(String NationalId, List<Customer> customers) {
		double cost = BASE_COST;
		for(Customer customer : customers) {
			if(customer.getNationalId().equals(NationalId)) {
				if(customer instanceof IDiscount) {
					cost = ((IDiscount)customer).applyDiscount(cost);
				}
				return cost;
			}
		}
		throw new RuntimeException("Customer not found");
	}
	public void listAppointments(List<Appointment> appointments) {
		if(appointments.isEmpty()) {
			throw new RuntimeException("No appointments scheduled");
		}
		for(Appointment appointment : appointments) {
			System.out.println(appointment.toString());
		}
	}
}
