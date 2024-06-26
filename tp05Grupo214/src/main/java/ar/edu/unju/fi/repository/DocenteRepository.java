package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.model.Docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DocenteRepository extends JpaRepository<Docente, String> {
	List<Docente> findDocenteByEstado(boolean estado);
}