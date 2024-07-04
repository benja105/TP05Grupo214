package ar.edu.unju.fi.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Modalidad;

@Getter
@Setter
@NoArgsConstructor
@Component
public class MateriaDTO {
    private String legajo;
    private String nombre;
    private String curso;
    private int cantidadHoras;
    private Modalidad modalidad;
    private Boolean estado;
}
