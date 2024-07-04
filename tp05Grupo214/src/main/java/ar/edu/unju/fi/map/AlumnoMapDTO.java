package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapDTO {
    
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "domicilio", target = "domicilio")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "LU", target = "LU")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(target = "materias", ignore = true) // Ignorar mapeo de materias para evitar el error
    @Mapping(target = "carrera", ignore = true) // Ignorar mapeo de carrera para evitar el error
    
    Alumno convertirAlumnoDTOAAlumno(AlumnoDTO adto);
    
    @InheritInverseConfiguration(name = "convertirAlumnoDTOAAlumno")
    AlumnoDTO convertirAlumnoAAlumnoDTO(Alumno a);

    List<AlumnoDTO> convertirListaAlumnoAListaAlumnoDTO(List<Alumno> listaA);
    List<Alumno> convertirListaAlumnoDTOAListaAlumno(List<AlumnoDTO> listaADTO);
}
