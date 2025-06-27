package CarMaintenanceSystem.staff;

public abstract class Staff {
	protected String staffName;
	protected int staffId;
	public Staff(String staffName, int staffId) {
		this.staffName = staffName;
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
}
