package ar.edu.unju.fi.DTO;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class DocenteDTO {

	private String legajoDTO;
   
	private String nombreDTO;
    
   
	private String apellidoDTO;
    
	private String emailDTO;
  
	private String telefonoDTO;
	//private Boolean estadoDTO;
}
