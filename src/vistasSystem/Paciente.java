package vistasSystem;

public class Paciente {
	
	private int dni;
	private String nombre;
	private int telefono;
	private int edad;
	
	public Paciente(int dni, String nombre, int telefono, int edad) {
		this.dni=dni;
		this.nombre=nombre;
		this.telefono = telefono ;
		this.edad = edad;
	}
	
	public int getDni() {
		return dni; 
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	public int getEdad() {
		return edad;
	}
}
