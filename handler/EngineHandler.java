package CarMaintenanceSystem.handler;

public class EngineHandler implements Handler {
	private Handler next;

	@Override
	public void setNextHandler(Handler next) {
		this.next = next;
	}

	@Override
	public void handleService(ServiceRequest request) {
		if(request.getServiceType().equalsIgnoreCase("EngineIssue")) {
			System.out.println("Request for Engine Repair");
			request.setAssignedHandler("Engineer");
		} else if(next != null) {
			System.out.println("Engine Handler is unable to handle request");
			next.handleService(request);
		} else {
			throw new RuntimeException("Request Type is unhandled or no next handler is set");
		}
	}
}
