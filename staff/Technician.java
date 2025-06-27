package CarMaintenanceSystem.staff;

import CarMaintenanceSystem.appointment.Appointment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Technician extends Staff {
	public Technician(String staffName, int staffId) {
		super(staffName, staffId);
	}

	public void addDiagnosticReport(Appointment appointment, String issuesFound, String partsUsed) {
		appointment.setDiagnosticResults(issuesFound + " " + partsUsed);
	}
	public void generateDailyReport(List<Appointment> appointments) {

			for(Appointment appointment : appointments) {

				String nationalId = appointment.getCustomer().getNationalId();
				String plateNumber = appointment.getCar().getPlateNumber();
				String repairNotes = appointment.getMechanicReport();
				String diagnosticNotes = appointment.getDiagnosticResults();
				int time = appointment.getHour();

				String line = nationalId
						  + " " + plateNumber
						  + " " + repairNotes
						  + " " + diagnosticNotes
						  + " " + time
						  + "\n";

				try (FileWriter writer = new FileWriter("src/main/java/CarMaintenanceSystem/DailyReport.txt", true)) {
					writer.write(line);
				}
				catch (IOException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Daily Report Generated");


	}
}
