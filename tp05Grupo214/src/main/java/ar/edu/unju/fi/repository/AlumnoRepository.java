package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno,String>{
	
	List<Alumno> findByCarrera(Carrera carrera);
    List<Alumno> findByMaterias(Materia materia);
	
}