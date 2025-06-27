package CarMaintenanceSystem.customers;

import java.util.List;

public class FleetOwnerCustomer extends Customer implements IDiscount {

	String fleetName;

	public FleetOwnerCustomer(String fullName, String address, String nationalId, String contactNumber, List<Car> cars, String fleetName) {
		super(fullName, address, nationalId, contactNumber, cars);
		this.fleetName = fleetName;
	}

	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	@Override
	public double applyDiscount(double baseCost) {
		baseCost -= (baseCost * 0.3);
		return baseCost;
	}
}
