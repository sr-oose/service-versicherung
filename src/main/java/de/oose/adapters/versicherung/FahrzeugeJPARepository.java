package de.oose.adapters.versicherung;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrzeugeJPARepository extends JpaRepository<FahrzeugDto, String>{
	List<FahrzeugDto> findByKennzeichen(String kennzeichen);
}
