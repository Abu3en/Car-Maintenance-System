package CarMaintenanceSystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillingCalculationTest {

	@Test
	void testCalculateServiceBill_ForPrivateCarOwner_ReturnsBaseCost() {

		FrontDeskStaff staff = new FrontDeskStaff("Name", 1);
		List<Customer> customers = new ArrayList<>();

		PrivateCarOwner privateOwner = new PrivateCarOwner("Ahmad"
				  , "Amman, Jordan"
				  , "1"
				  , "00123123"
				  , new ArrayList<>());

		customers.add(privateOwner);

		double bill = staff.calculateServiceBill("1", customers);

		assertEquals(50.0, bill);
	}

	@Test
	void testCalculateServiceBill_ForStaffCustomer() {

		FrontDeskStaff staff = new FrontDeskStaff("Alice", 1);
		List<Customer> customers = new ArrayList<>();

		StaffCustomer staffCustomer = new StaffCustomer("Ahmad"
				  , "Amman, Jordan"
				  , "1"
				  , "00123123"
				  , new ArrayList<>());

		customers.add(staffCustomer);

		double bill = staff.calculateServiceBill("1", customers);

		assertEquals(25.0, bill);
	}

	@Test
	void testCalculateServiceBill_ForFleetOwnerCustomer() {

		FrontDeskStaff staff = new FrontDeskStaff("Alice", 1);
		List<Customer> customers = new ArrayList<>();

		FleetOwnerCustomer fleetOwner = new FleetOwnerCustomer("Ahmad"
				  , "Amman, Jordan"
				  , "1"
				  , "00123123"
				  , new ArrayList<>()
				  , "Fleet");

		customers.add(fleetOwner);

		double bill = staff.calculateServiceBill("1", customers);

		assertEquals(35.0, bill);
	}

}