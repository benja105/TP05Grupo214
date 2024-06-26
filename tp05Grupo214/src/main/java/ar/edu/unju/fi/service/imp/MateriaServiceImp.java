package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService{

	@Autowired
	MateriaRepository MateriaRepository;
	@Autowired
	MateriaMapDTO MateriaMapDTO;
	
	@Override
	public void guardarMateria(MateriaDTO MateriaDTO) {
		MateriaMapDTO.convertirMateriaDTOAMateria(MateriaDTO);
		if(!MateriaRepository.existsById(MateriaDTO.getLegajo())) {
		MateriaRepository.save
		(MateriaMapDTO.convertirMateriaDTOAMateria(MateriaDTO));
		}
	}

	@Override
	public List<MateriaDTO> mostrarMaterias() {
		return MateriaMapDTO.convertirListaMateriasAListaMateriasDTO(MateriaRepository.findMateriaByEstado(true)); 
	}

	 @Override
	    public void borrarMateria(String codigo) {
	        List<MateriaDTO> todasLasMateriasDTO = MateriaMapDTO.convertirListaMateriasAListaMateriasDTO(MateriaRepository.findAll());

	        todasLasMateriasDTO.stream()
	            .filter(materia -> materia.getLegajo().equals(codigo))
	            .forEach(materia -> {
	                materia.setEstado(false);
	                MateriaRepository.save(MateriaMapDTO.convertirMateriaDTOAMateria(materia));
	            });
	    }

	  @Override
	    public void modificarMateria(MateriaDTO materiaModificadaDTO) {
	        MateriaRepository.save(MateriaMapDTO.convertirMateriaDTOAMateria(materiaModificadaDTO));
	    }

	    @Override
	    public MateriaDTO buscarMateria(String codigo) {
	        return MateriaMapDTO.convertirMateriaAMateriaDTO(MateriaRepository.getReferenceById(codigo));
	    }
	}