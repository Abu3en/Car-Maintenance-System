package CarMaintenanceSystem.customers;

import java.util.List;

public class StaffCustomer extends Customer implements IDiscount {

	public StaffCustomer(String fullName, String address, String nationalId, String contactNumber, List<Car> cars) {
		super(fullName, address, nationalId, contactNumber, cars);
	}

	@Override
	public double applyDiscount(double baseCost) {
		baseCost -= baseCost * 0.5;
		return baseCost;
	}
}
