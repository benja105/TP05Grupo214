package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.service.CarreraService;

@Controller
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping("/formularioCarrera")
    public ModelAndView getFormCarrera() {
        ModelAndView modelView = new ModelAndView("formCarrera");
        modelView.addObject("nuevaCarrera", new CarreraDTO());
        modelView.addObject("flag", false);
        return modelView;
    }

    @PostMapping("/guardarCarrera")
    public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carrera) {
        carreraService.guardarCarrera(carrera);
        return new ModelAndView("redirect:/listadoCarreras");
    }

    @GetMapping("/listadoCarreras")
    public ModelAndView getFormListaCarrera() {
        ModelAndView modelView = new ModelAndView("listaCarreras");
        modelView.addObject("listadoCarreras", carreraService.mostrarCarreras());
        return modelView;
    }

    @GetMapping("/borrarCarrera/{codigo}")
    public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
        carreraService.borrarCarrera(codigo);
        return new ModelAndView("redirect:/listadoCarreras");
    }

    @GetMapping("/modificarCarrera/{codigo}")
    public ModelAndView getFormModificarCarrera(@PathVariable(name="codigo") String codigo) {
        CarreraDTO carreraDTO = carreraService.buscarCarrera(codigo);
        ModelAndView modelView = new ModelAndView("formCarrera");
        modelView.addObject("nuevaCarrera", carreraDTO);
        modelView.addObject("flag", true);
        return modelView;
    }

    @PostMapping("/modificarCarrera")
    public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carreraMO) {
        carreraService.modificarCarrera(carreraMO);
        return new ModelAndView("redirect:/listadoCarreras");
    }
}
