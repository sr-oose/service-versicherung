package de.oose.adapters.versicherung;

import javax.persistence.Entity;
import javax.persistence.Id;

import de.oose.domain.versicherung.Fahrzeug.FahrzeugTyp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FahrzeugDto {
	@Id
	private String fahrgestellNr;
	private String kennzeichen;
	private String hersteller;
	private FahrzeugTyp typ;
}
