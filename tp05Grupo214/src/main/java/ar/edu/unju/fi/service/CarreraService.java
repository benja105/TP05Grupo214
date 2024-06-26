package ar.edu.unju.fi.service;

import ar.edu.unju.fi.DTO.CarreraDTO;
import java.util.List;

public interface CarreraService {
    void guardarCarrera(CarreraDTO carreraDTO);
    List<CarreraDTO> mostrarCarreras();
    void borrarCarrera(String codigo);
    void modificarCarrera(CarreraDTO carreraModificadaDTO);
    CarreraDTO buscarCarrera(String codigo);
}
