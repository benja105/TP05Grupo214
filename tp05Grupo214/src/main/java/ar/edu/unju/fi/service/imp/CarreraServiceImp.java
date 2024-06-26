package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.map.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService {

    @Autowired
    CarreraRepository carreraRepository;

    @Autowired
    CarreraMapDTO carreraMapDTO;

    @Override
    public void guardarCarrera(CarreraDTO carreraDTO) {
        if (!carreraRepository.existsById(carreraDTO.getCodigo())) {
            carreraRepository.save(carreraMapDTO.convertirCarreraDTOACarrera(carreraDTO));
        }
    }

    @Override
    public List<CarreraDTO> mostrarCarreras() {
        return carreraMapDTO.convertirListaCarrerasAListaCarrerasDTO(carreraRepository.findAll());
    }

    @Override
    public void borrarCarrera(String codigo) {
        Carrera carrera = carreraRepository.findById(codigo).orElse(null);
        if (carrera != null) {
            carreraRepository.delete(carrera);
        }
    }

    @Override
    public void modificarCarrera(CarreraDTO carreraModificadaDTO) {
        carreraRepository.save(carreraMapDTO.convertirCarreraDTOACarrera(carreraModificadaDTO));
    }

    @Override
    public CarreraDTO buscarCarrera(String codigo) {
        return carreraMapDTO.convertirCarreraACarreraDTO(carreraRepository.getReferenceById(codigo));
    }
}
