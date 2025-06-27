package CarMaintenanceSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffFactoryTest {

	@Test
	void createStaff_FrontDeskStaff() {
		Staff staff = StaffFactory.createStaff("Front Desk Staff", "Ahmad", 10);

		assertNotNull(staff);
		assertTrue(staff instanceof FrontDeskStaff);
		assertEquals("Ahmad", staff.getStaffName());
		assertEquals(10, staff.getStaffId());
	}

	@Test
	void testCreateStaff_Mechanic() {
		Staff staff = StaffFactory.createStaff("Mechanic", "Ahmad", 11);

		assertNotNull(staff);
		assertTrue(staff instanceof Mechanic);
		assertEquals("Ahmad", staff.getStaffName());
		assertEquals(11, staff.getStaffId());
	}

	@Test
	void testCreateStaff_InvalidType() {
		Staff staff = StaffFactory.createStaff("Invalid", "Ahmad", 12);
		assertNull(staff);

	}


}