package vistasSystem;

public class Doctor {
	private String nombre;
    private String especialidad;
    private String codigoCMP;

    public Doctor(String nombre, String especialidad, String codigoCMP) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigoCMP = codigoCMP;
    }

    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getCodigoCMP() { return codigoCMP; }

}
