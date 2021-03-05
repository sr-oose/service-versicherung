package de.oose.adapters.versicherung;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VertragDto {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;
	
	@Column(unique = true)
	private String vertragsnummer;
	private String vertragspartner;
	private Typ    versicherungsTyp;
	private VertragskonditionenDto konditionen;
	
	public enum Typ {
		VOLLKASKO, TEILKASKO, HAFTPFLICHT;
	}
}
