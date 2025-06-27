package CarMaintenanceSystem.handler;

public class ElectricalHandler implements Handler {

	private Handler next;

	@Override
	public void setNextHandler(Handler next) {
		this.next = next;
	}

	@Override
	public void handleService(ServiceRequest request) {
		if(request.getServiceType().equalsIgnoreCase("ElectricalIssue")) {
			request.setAssignedHandler("Electrician");
		} else if(next != null) {
			next.handleService(request);
		} else {
			throw new RuntimeException("Request Type is unhandled or no next handler is set");
		}
	}

}
