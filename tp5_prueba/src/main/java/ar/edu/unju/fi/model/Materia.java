package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
@Component
@Entity
public class Materia {
    @Id
    @NotBlank(message = "Debe ingresar un legajo")
    @Size(min = 3, max = 10, message = "El legajo debe contener como mínimo 3 caracteres y 10 como máximo")
    private String legajo;

    @NotBlank(message = "Debe ingresar el nombre de la materia")
    @Size(min = 5, max = 50, message = "El nombre debe contener como mínimo 5 caracteres y 50 como máximo")
    private String nombre;

    @NotBlank(message = "Debe ingresar el curso de la materia")
    @Size(min = 3, max = 10, message = "El curso debe contener como mínimo 3 caracteres y 10 como máximo")
    private String curso;

    private int cantidadHoras;
    private Modalidad modalidad;
    private Boolean estado;

    @ManyToMany(mappedBy = "materias")
    private List<Alumno> alumnos;

    @OneToOne
    @JoinColumn(name = "docente_legajo")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "carrera_codigo")
    private Carrera carrera;
}
