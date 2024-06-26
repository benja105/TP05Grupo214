package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.model.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, String> {
    List<Carrera> findCarreraByNombre(String nombre);
}
