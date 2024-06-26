package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Service
public interface AlumnoService {
	
	public void guardarAlumno(AlumnoDTO alumnoDTO);
	public List<Alumno> mostrarAlumno();
	public void borrarAlumno(String codigo);
	public void modificarAlumno(AlumnoDTO alumnoDTO);
	public AlumnoDTO buscarAlumno(String codigo);
}