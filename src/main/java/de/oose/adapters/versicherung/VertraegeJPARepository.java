package de.oose.adapters.versicherung;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VertraegeJPARepository extends JpaRepository<VertragDto, Integer> {
	List<VertragDto> findByVertragsnummer(String vertragsnummer);
}
