
package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.MateriaDTO;

@Service
public interface MateriaService {
    public void guardarMateria(MateriaDTO materia);
    public List<MateriaDTO> mostrarMaterias();
    public void borrarMateria(String legajo);
    public void modificarMateria(MateriaDTO materiaMO);
    public MateriaDTO buscarMateria(String legajo);	
}
