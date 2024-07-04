package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Component
@Entity
public class Alumno {
    @Id
    @NotBlank(message = "Debe ingresar un DNI")
    @Pattern(regexp = "^\\d{8}$", message = "El DNI debe contener 8 dígitos")
    private String dni;

    @NotBlank(message = "Debe ingresar el nombre del Alumno")
    @Size(min = 3, max = 25, message = "El nombre debe contener como mínimo 3 caracteres y 25 como máximo")
    private String nombre;

    @NotBlank(message = "Debe ingresar el apellido del Alumno")
    @Size(min = 3, max = 25, message = "El apellido debe contener como mínimo 3 caracteres y 25 como máximo")
    private String apellido;

    @NotBlank(message = "Debe ingresar el email del Alumno")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "Debe ingresar el teléfono del Alumno")
    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe contener 10 dígitos")
    private String telefono;

    private Date fechaNacimiento;

    @NotBlank(message = "Debe ingresar el domicilio del Alumno")
    @Size(min = 5, max = 50, message = "El domicilio debe contener como mínimo 5 caracteres y 50 como máximo")
    private String domicilio;

    @NotBlank(message = "Debe ingresar la LU del Alumno")
    @Pattern(regexp = "^\\d{6}$", message = "La LU debe contener 6 dígitos")
    private String LU;

    @ManyToOne
    @JoinColumn(name = "carrera_codigo")
    private Carrera carrera;

    @ManyToMany
    @JoinTable(name = "alumno_materia",
        joinColumns = @JoinColumn(name = "alumno_dni"),
        inverseJoinColumns = @JoinColumn(name = "materia_legajo"))
    private List<Materia> materias;
}