package vistasSystem;

public class Cita {
	
	private Paciente paciente;
	private Doctor doctor;
	private String fecha;
	private String hora;
	
	public Cita(Paciente paciente, Doctor doctor, String fecha, String hora) {
		this.paciente=paciente;
		this.doctor=doctor;
		this.fecha=fecha;
		this.hora=hora;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public String getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
}
