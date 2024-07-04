package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Component
@Entity
public class Docente {
    @Id
    @NotBlank(message = "Debe ingresar un legajo")
    @Pattern(regexp = "^LEG_\\d{2}$", message = "El legajo debe ser 'LEG_XX'.")
	private String legajo;
    
    @NotBlank(message = "Debe ingresar el nombre del Docente")
    @Size(min = 5, max = 25, message = "El nombre debe contener como mínimo 5 caracteres y 25 como máximo")
    @Pattern(regexp = "[a-zA-Z]*", message = "Solo se deben ingresar letras")
    private String nombre;
    
    @NotBlank(message = "Debe ingresar el apellido del Docente")
    @Size(min = 3, max = 15, message = "El apellido debe contener como mínimo 3 caracteres y 15 como máximo")
    @Pattern(regexp = "[a-zA-Z]*", message = "Solo se deben ingresar letras")
	private String apellido;
    
    @Email(message = "Debe ingresar el email del Docente")
	private String email;
    
    @Column(nullable =false)
    @NotBlank(message = "Debe ingresar el teléfono del Docente")
    @Pattern(regexp = "^388\\d{7}$", message = "El teléfono debe comenzar con '388' seguido de 7 dígitos.")
	private String telefono;
    
	private Boolean estado;
}
