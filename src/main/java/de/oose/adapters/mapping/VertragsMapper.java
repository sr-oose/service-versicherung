package de.oose.adapters.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.oose.adapters.versicherung.VertragDto;
import de.oose.domain.versicherung.Vertrag;

@Service
public class VertragsMapper {
	
	private ModelMapper mapper;
	
	@Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public List<Vertrag> dtoToDomain(List<VertragDto> vertragsliste){
		return vertragsliste.stream().map(v -> mapper.map(v, Vertrag.class)).collect(Collectors.toList());
	}
	
	public List<VertragDto> domainToDto(List<Vertrag> vertragsliste){
		return vertragsliste.stream().map(v -> mapper.map(v, VertragDto.class)).collect(Collectors.toList());
	}
	
	public Vertrag dtoToDomain(VertragDto vertragDto){
		return mapper.map(vertragDto, Vertrag.class);
	}
	
	public VertragDto domainToDto(Vertrag vertragDomain){
		return mapper.map(vertragDomain, VertragDto.class);
	}

}
