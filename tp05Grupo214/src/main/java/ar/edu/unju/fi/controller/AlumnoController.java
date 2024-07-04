package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.MateriaService;

@Controller
public class AlumnoController {

    @Autowired
    AlumnoDTO nuevoAlumnoDTO;

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    MateriaService materiaService;

    @GetMapping("/formularioAlumno")
    public ModelAndView getFormAlumno() {
        ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", nuevoAlumnoDTO);
        modelView.addObject("flag", false); // false indica que es una creación
        return modelView;
    }

    @PostMapping("/guardarAlumno")
    public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumno) {
        alumnoService.guardarAlumno(alumno);
        return new ModelAndView("redirect:/listadoAlumnos");
    }

    @GetMapping("/listadoAlumnos")
    public ModelAndView listarAlumnos() {
        ModelAndView modelView = new ModelAndView("listaAlumnos");
        modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());
        return modelView;
    }

    @GetMapping("/borrarAlumno/{dni}")
    public ModelAndView borrarAlumno(@PathVariable(name="dni") String dni) {
        alumnoService.borrarAlumno(dni);
        return new ModelAndView("redirect:/listadoAlumnos");
    }

    @GetMapping("/modificarAlumno/{dni}")
    public ModelAndView mostrarFormularioModificarAlumno(@PathVariable(name="dni") String dni) {
        AlumnoDTO alumnoDTO = alumnoService.buscarAlumno(dni);
        ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", alumnoDTO);
        modelView.addObject("flag", true);
        return modelView;
    }

    @PostMapping("/guardarModificacionAlumno")
    public ModelAndView guardarModificacionAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumno) {
        alumnoService.modificarAlumno(alumno);
        return new ModelAndView("redirect:/listadoAlumnos");
    }

    @GetMapping("/inscribirAlumno")
    public ModelAndView getFormInscripcion() {
        ModelAndView modelView = new ModelAndView("formInscripcion");
        modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @PostMapping("/guardarInscripcion")
    public ModelAndView saveInscripcion(@RequestParam("alumnoDni") String alumnoDni, @RequestParam("materiaCodigo") String materiaCodigo) {
        AlumnoDTO alumno = alumnoService.buscarAlumno(alumnoDni);
        MateriaDTO materia = materiaService.buscarMateria(materiaCodigo);
        alumnoService.guardarInscripcion(alumno, materia);
        return new ModelAndView("redirect:/listadoAlumnos");
    }
    
}