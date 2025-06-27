package CarMaintenanceSystem.staff.frontDeskStaff;

import CarMaintenanceSystem.staff.Mechanic;
import CarMaintenanceSystem.staff.Staff;
import CarMaintenanceSystem.staff.Technician;

public class StaffFactory {
	public static Staff createStaff(String staff, String staffName, int staffId) {
		if(staff.equalsIgnoreCase("Front Desk Staff")) {
			return new FrontDeskStaff(staffName, staffId);
		}
		if(staff.equalsIgnoreCase("Mechanic")) {
			return new Mechanic(staffName, staffId);
		}
		if(staff.equalsIgnoreCase("Technician")) {
			return new Technician(staffName, staffId);
		}
		System.out.println("Invalid Staff Name: " + staffName);
		return null;
	}

}
