package CarMaintenanceSystem.customers;

import java.util.List;

public class PrivateCarOwner extends Customer{


	public PrivateCarOwner(String fullName, String address,
		                       String nationalID, String contactNumber,
		                       List<Car> cars) {
			super(fullName, address, nationalID, contactNumber, cars);

		}

}
