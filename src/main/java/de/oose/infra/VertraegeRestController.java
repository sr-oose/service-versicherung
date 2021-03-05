package de.oose.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.oose.adapters.mapping.VertragsMapper;
import de.oose.adapters.versicherung.VertragDto;
import de.oose.domain.versicherung.Vertraege;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VertraegeRestController {

	private Vertraege vertraege;
	private VertragsMapper vertragsMapper;
	
	@GetMapping("/vertraege")
	public ResponseEntity<List<VertragDto>> getVertraege(){
		return ResponseEntity.ok(vertragsMapper.domainToDto(vertraege.holeAlleVertraege()));
		
	}
	
	
}
