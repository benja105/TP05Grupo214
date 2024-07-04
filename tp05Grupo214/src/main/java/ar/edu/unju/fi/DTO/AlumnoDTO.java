package ar.edu.unju.fi.DTO;

import java.sql.Date;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class AlumnoDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private String domicilio;
    private String LU;
    private CarreraDTO carrera;
    private List<MateriaDTO> materias;
}
