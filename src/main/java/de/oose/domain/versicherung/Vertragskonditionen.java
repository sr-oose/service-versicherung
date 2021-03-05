package de.oose.domain.versicherung;

import de.oose.domain.ddd.DDD_ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@DDD_ValueObject
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Vertragskonditionen {
	public final double schadensfreiheitsklasse;
	public final double jahresbeitrag;
	public final int jahreskilometer;
	
	@SuppressWarnings("unused")
	private Vertragskonditionen() {
		schadensfreiheitsklasse = 0.0;
		jahresbeitrag = 0.0;
		jahreskilometer = 0;		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Schadensfreiheitsklasse: %.0f%%\n", schadensfreiheitsklasse * 100));
		sb.append(String.format("Jahresbeitrag: %.2f EUR\n", jahresbeitrag));
		sb.append(String.format("Jahreskilometer: %d\n", jahreskilometer));
		return sb.toString();
	}

}
