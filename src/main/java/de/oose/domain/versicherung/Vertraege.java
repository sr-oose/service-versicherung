package de.oose.domain.versicherung;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import de.oose.domain.ddd.DDD_Repository;

@DDD_Repository
public interface Vertraege {
	void ablegen(Vertrag vertrag);
	
	Optional<Vertrag> suche(String vertragsnummer);
	
	List<Vertrag> holeAlleVertraege();
	
	default Vertrag neuenVertragAufsetzen() { 		
		return new Vertrag(UUID.randomUUID().toString(), this);
	}
}
