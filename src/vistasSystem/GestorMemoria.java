package vistasSystem;

import java.util.ArrayList;

public class GestorMemoria {
	private ArrayList<Doctor> listaDoctores;
	private ArrayList<Cita> listaCitas;
	
	public GestorMemoria() {
		this.listaDoctores= new ArrayList<Doctor>();
		this.listaCitas=new ArrayList<Cita>();
		
		listaDoctores.add(new Doctor("Dr. Jaime Espinoza", "Medicina General", "12345"));
        listaDoctores.add(new Doctor("Dra. María Raquel", "Pediatría", "67890"));
        listaDoctores.add(new Doctor("Dr. Alex Atuncar", "Odontología", "11223"));
		listaDoctores.add(new Doctor("Dr. Yadhira Pinedo", "Ginecologa", "12345"));
        listaDoctores.add(new Doctor("Dra. Geraldine Atuncar", "Obstetricia", "67890"));
        listaDoctores.add(new Doctor("Dr. Jonatan Enrique", "Enfermeria ", "11223"));
		listaDoctores.add(new Doctor("Dr. Alvaro Ayasta", "Pediatria", "12345"));
        listaDoctores.add(new Doctor("Dra. Amelia Ferrer", "Enfermeria", "67890"));
        listaDoctores.add(new Doctor("Dr. Melanie Gallegos", "Psicologia", "11223"));
	}
	
	public void registrarCita(Cita cita) {
		listaCitas.add(cita);
	}
	
	public boolean anularCita(int dniPaciente) {
		for (int i=0; i<listaCitas.size(); i++) {
			if (listaCitas.get(i).getPaciente().getDni()==dniPaciente) {
				listaCitas.remove(i);
				return true; 
			}
		}
		return false ;
	}
	public ArrayList<Doctor> obtenerDoctores() {
        return listaDoctores;
    }
	
	public ArrayList<Cita> obtenerCitas() {
	    return listaCitas;
	}
	
	

}
