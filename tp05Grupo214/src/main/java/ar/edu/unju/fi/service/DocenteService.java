package ar.edu.unju.fi.service;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.DTO.DocenteDTO;
import java.util.List;

public interface DocenteService {
    public void guardarDocente(Docente docente);
    
    public Docente buscarDocente(String legajo);
    public List<DocenteDTO> mostrarDocentesDTO();
    public void borrarDocente(String legajo);
    public void modificarDocente(Docente docenteMO);
}
