package de.oose.adapters.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.oose.adapters.versicherung.VertragDto;
import de.oose.domain.versicherung.Vertraege;
import de.oose.domain.versicherung.Vertrag;

@Configuration
public class ModelMapperConfig {
	
	private Vertraege vertraege;
	
	@Bean
	public ModelMapper createDefaultModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel(AccessLevel.PRIVATE);
		mapper.typeMap(VertragDto.class, Vertrag.class)
		  .setProvider(req -> vertraege.neuenVertragAufsetzen());
		return mapper;
	}

	@Autowired
	public void setVertraege(Vertraege vertraege) {
		this.vertraege = vertraege;
	}
	
}
