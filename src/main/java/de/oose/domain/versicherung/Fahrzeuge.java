package de.oose.domain.versicherung;

import java.util.List;
import java.util.Optional;

import de.oose.domain.ddd.DDD_Repository;
import de.oose.domain.fehler.UngueltigeFahrzeugdaten;

@DDD_Repository
public interface Fahrzeuge {
	boolean istVorhanden(String fahrgestellNr);
	Optional<Fahrzeug> sucheNachFahrgestellNr(String fahrgestellNr);
	Optional<Fahrzeug> sucheNachKennzeichen(String fahrgestellNr);
	List<Fahrzeug> holeAlleFahrzeuge();
	void speichern(Fahrzeug fahrzeug);
	
	default Fahrzeug neuesFahrzeug(String fahrgestellNr, Fahrzeug.FahrzeugTyp typ) throws UngueltigeFahrzeugdaten {
		if (istVorhanden(fahrgestellNr)) {
			throw new UngueltigeFahrzeugdaten();
		}
		return new Fahrzeug(fahrgestellNr, typ, this);
	}
}
