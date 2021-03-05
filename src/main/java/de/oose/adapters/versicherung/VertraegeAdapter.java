package de.oose.adapters.versicherung;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.oose.adapters.mapping.VertragsMapper;
import de.oose.domain.versicherung.Vertraege;
import de.oose.domain.versicherung.Vertrag;

@Service
public class VertraegeAdapter implements Vertraege {

	private VertraegeJPARepository jpaRepository;
	private VertragsMapper vertragsMapper;
	
	@Autowired
	public void setVertraegeJPARepository(VertraegeJPARepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	
	@Autowired
	public void setVertragsMapper(VertragsMapper mapper) {
		this.vertragsMapper = mapper;
	}
	
	@Override
	public void ablegen(Vertrag vertrag) {
		jpaRepository.save(vertragsMapper.domainToDto(vertrag));
	}

	@Override
	public List<Vertrag> holeAlleVertraege() {
		return vertragsMapper.dtoToDomain(jpaRepository.findAll());
	}
	

	@Override
	public Optional<Vertrag> suche(String vertragsnummer) {
		var result = jpaRepository.findByVertragsnummer(vertragsnummer);
		if (result.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(vertragsMapper.dtoToDomain(result.get(0)));
	}

}
