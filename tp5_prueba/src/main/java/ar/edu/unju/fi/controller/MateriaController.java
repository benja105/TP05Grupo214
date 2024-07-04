package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.service.MateriaService;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
public class MateriaController {

    @Autowired
    MateriaDTO nuevaMateriaDTO;

    @Autowired
    MateriaService materiaService;

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/formularioMateria")
    public ModelAndView getFormMateria() {
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("nuevaMateria", nuevaMateriaDTO);
        modelView.addObject("flag", false);
        return modelView;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") MateriaDTO materia) {
        materiaService.guardarMateria(materia);
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @GetMapping("/listadoMaterias")
    public ModelAndView getFormListaMateria() {
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @GetMapping("/borrarMateria/{codigo}")
    public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
        materiaService.borrarMateria(codigo);
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @GetMapping("/modificarMateria/{codigo}")
    public ModelAndView getFormModificarMateria(@PathVariable(name="codigo") String codigo) {
        MateriaDTO materiaDTO = materiaService.buscarMateria(codigo);
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("nuevaMateria", materiaDTO);
        modelView.addObject("flag", true);
        return modelView;
    }

    @PostMapping("/modificarMateria")
    public ModelAndView modificarMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaMO) {
        materiaService.modificarMateria(materiaMO);
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @GetMapping("/consultarAlumnosMateria")
    public ModelAndView getFormConsultaMateria() {
        ModelAndView modelView = new ModelAndView("consultaMateria");
        modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());
        return modelView;
    }

    @PostMapping("/filtrarAlumnosMateria")
    public ModelAndView filtrarAlumnosMateria(@RequestParam("materiaCodigo") String materiaCodigo) {
        MateriaDTO materia = materiaService.buscarMateria(materiaCodigo);
        ModelAndView modelView = new ModelAndView("listaAlumnosMateria");
        modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnosPorMateria(materia));
        return modelView;
    }
}
