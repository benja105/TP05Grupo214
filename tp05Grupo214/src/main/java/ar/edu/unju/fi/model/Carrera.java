package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
@Component
@Entity
public class Carrera {
    @Id
    @NotBlank(message = "Debe ingresar un código")
    @Size(min = 3, max = 10, message = "El código debe contener como mínimo 3 caracteres y 10 como máximo")
    private String codigo;

    @NotBlank(message = "Debe ingresar el nombre de la carrera")
    @Size(min = 5, max = 50, message = "El nombre debe contener como mínimo 5 caracteres y 50 como máximo")
    private String nombre;

    private int cantidadAnios;

    @NotBlank(message = "Debe ingresar el estado de la carrera")
    private String estado;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Materia> materias;
}
