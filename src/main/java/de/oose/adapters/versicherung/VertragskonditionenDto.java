package de.oose.adapters.versicherung;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class VertragskonditionenDto {

	private Double schadensfreiheitsklasse;
	private Double jahresbeitrag;
	private Integer jahreskilometer;

}
