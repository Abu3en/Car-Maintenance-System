package CarMaintenanceSystem.handler;

public interface Handler {
	void setNextHandler(Handler next);
	void handleService(ServiceRequest request);
}
