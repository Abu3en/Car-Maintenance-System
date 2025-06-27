package CarMaintenanceSystem.handler;

public class BodyHandler implements Handler {
	private Handler next;

	@Override
	public void setNextHandler(Handler next) {
		this.next = next;
	}

	@Override
	public void handleService(ServiceRequest request) {
		if(request.getServiceType().equalsIgnoreCase("BodyIssue")) {
			request.setAssignedHandler("BodySpecialist");
		} else if(next != null) {
			next.handleService(request);
		} else {
			throw new RuntimeException("Request Type is unhandled or no next handler is set");
		}
	}
}
