package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.AlumnoMapDTO;
import ar.edu.unju.fi.map.CarreraMapDTO;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private AlumnoMapDTO alumnoMapDTO;

    @Autowired
    private CarreraMapDTO carreraMapDTO;

    @Autowired
    private MateriaMapDTO materiaMapDTO;

    @Override
    public void guardarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoMapDTO.convertirAlumnoDTOAAlumno(alumnoDTO);
        alumnoRepository.save(alumno);
    }

    @Override
    public List<AlumnoDTO> mostrarAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                      .map(alumnoMapDTO::convertirAlumnoAAlumnoDTO)
                      .collect(Collectors.toList());
    }

    @Override
    public void borrarAlumno(String dni) {
        alumnoRepository.deleteById(dni);
    }

    @Override
    public void modificarAlumno(AlumnoDTO alumnoDTO) {
        if(alumnoRepository.existsById(alumnoDTO.getDni())) {
            Alumno alumno = alumnoMapDTO.convertirAlumnoDTOAAlumno(alumnoDTO);
            alumnoRepository.save(alumno);
        }
    }

    @Override
    public AlumnoDTO buscarAlumno(String dni) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(dni);
        return optionalAlumno.map(alumnoMapDTO::convertirAlumnoAAlumnoDTO)
                             .orElse(null);
    }

    @Override
    public List<AlumnoDTO> mostrarAlumnosPorCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = carreraMapDTO.convertirCarreraDTOACarrera(carreraDTO);
        List<Alumno> alumnos = alumnoRepository.findByCarrera(carrera);
        return alumnos.stream()
                      .map(alumnoMapDTO::convertirAlumnoAAlumnoDTO)
                      .collect(Collectors.toList());
    }

    @Override
    public List<AlumnoDTO> mostrarAlumnosPorMateria(MateriaDTO materiaDTO) {
        Materia materia = materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO);
        List<Alumno> alumnos = alumnoRepository.findByMaterias(materia);
        return alumnos.stream()
                      .map(alumnoMapDTO::convertirAlumnoAAlumnoDTO)
                      .collect(Collectors.toList());
    }

    @Override
    public void inscribirAlumnoEnMateria(String dni, MateriaDTO materiaDTO) {
        Alumno alumno = alumnoRepository.findById(dni).orElse(null);
        if (alumno != null) {
            Materia materia = materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO);
            alumno.getMaterias().add(materia);
            alumnoRepository.save(alumno);
        }
    }
    
    public void guardarInscripcion(AlumnoDTO alumnoDTO, MateriaDTO materiaDTO) {
        Alumno alumno = alumnoRepository.findById(alumnoDTO.getDni()).orElse(null);
        Materia materia = materiaRepository.findById(materiaDTO.getLegajo()).orElse(null);

        if (alumno != null && materia != null) {
            alumno.getMaterias().add(materia);
            alumnoRepository.save(alumno);
        }
    }
    
}