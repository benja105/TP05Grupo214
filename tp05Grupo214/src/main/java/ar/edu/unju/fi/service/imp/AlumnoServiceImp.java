package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public void guardarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> mostrarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void borrarAlumno(String dni) {
        alumnoRepository.deleteById(dni);
    }

    @Override
    public void modificarAlumno(Alumno alumno) {
        if(alumnoRepository.existsById(alumno.getDni())) {
            alumnoRepository.save(alumno);
        }
    }

    @Override
    public Alumno buscarAlumno(String dni) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(dni);
        return optionalAlumno.orElse(null);
    }
}
