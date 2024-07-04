package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.DTO.MateriaDTO;

public interface AlumnoService {
	
    void guardarAlumno(AlumnoDTO alumnoDTO);
    List<AlumnoDTO> mostrarAlumnos();
    void borrarAlumno(String dni);
    void modificarAlumno(AlumnoDTO alumnoDTO);
    AlumnoDTO buscarAlumno(String dni);
    List<AlumnoDTO> mostrarAlumnosPorCarrera(CarreraDTO carreraDTO);
    List<AlumnoDTO> mostrarAlumnosPorMateria(MateriaDTO materiaDTO);
    void inscribirAlumnoEnMateria(AlumnoDTO alumnoDTO, MateriaDTO materiaDTO);
    void guardarInscripcion(AlumnoDTO alumno, MateriaDTO materia);
}
