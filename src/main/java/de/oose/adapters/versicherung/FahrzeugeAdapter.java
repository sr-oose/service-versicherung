package de.oose.adapters.versicherung;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.oose.domain.versicherung.Fahrzeug;
import de.oose.domain.versicherung.Fahrzeuge;

@Service
public class FahrzeugeAdapter implements Fahrzeuge {

	private FahrzeugeJPARepository jpaRepository;
	private ModelMapper mapper;
	
	@Autowired
	public void setFahrzeugeJPARepository(FahrzeugeJPARepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Autowired
	public void setModelMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	

	@Override
	public boolean istVorhanden(String fahrgestellNr) {
		return jpaRepository.existsById(fahrgestellNr);
	}

	@Override
	public Optional<Fahrzeug> sucheNachFahrgestellNr(String fahrgestellNr) {
		var result = jpaRepository.findById(fahrgestellNr);
	    if (result.isPresent())
	    	return Optional.of(mapper.map(result.get(), Fahrzeug.class)); 
	    else 
	    	return Optional.empty();
	}

	@Override
	public Optional<Fahrzeug> sucheNachKennzeichen(String kennzeichen) {
		var result = jpaRepository.findByKennzeichen(kennzeichen);
		if (result.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(mapper.map(result.get(0), Fahrzeug.class));
	}

	@Override
	public List<Fahrzeug> holeAlleFahrzeuge() {
		return jpaRepository.findAll().stream().map(v -> mapper.map(v, Fahrzeug.class)).collect(Collectors.toList());
	}

	@Override
	public void speichern(Fahrzeug fahrzeug) {
		jpaRepository.save(mapper.map(fahrzeug, FahrzeugDto.class));
	}

}
