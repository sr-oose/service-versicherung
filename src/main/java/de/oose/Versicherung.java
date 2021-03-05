package de.oose;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.oose.domain.versicherung.Vertraege;
import de.oose.domain.versicherung.Vertrag;
import de.oose.domain.versicherung.Vertrag.Typ;
import de.oose.domain.versicherung.Vertragskonditionen;

@SpringBootApplication
public class Versicherung {

	public static void main(String[] args) {
		SpringApplication.run(Versicherung.class, args);
	}

	

	@Bean
	public ApplicationRunner createRunner(Vertraege vertraege) {
		return x -> {
		
			Vertrag vertrag = vertraege.neuenVertragAufsetzen();
			vertrag.vertragspartnerFestlegen("Allianz");
			vertrag.versicherungsTypFestlegen(Typ.VOLLKASKO);
			Vertragskonditionen konditionen = Vertragskonditionen.builder()
					.jahresbeitrag(400.0)
					.jahreskilometer(30000)
					.schadensfreiheitsklasse(0.5).build();
			vertrag.konditionenFestlegen(konditionen);
			vertrag.abschliessen();
			
			vertrag = vertraege.neuenVertragAufsetzen();
			vertrag.vertragspartnerFestlegen("Capitol");
			vertrag.versicherungsTypFestlegen(Typ.HAFTPFLICHT);
			konditionen = Vertragskonditionen.builder()
					.jahresbeitrag(275.90)
					.jahreskilometer(20000)
					.schadensfreiheitsklasse(0.4).build();
			vertrag.konditionenFestlegen(konditionen);
			vertrag.abschliessen();
			
			List<Vertrag> alleVertraege = vertraege.holeAlleVertraege();
			alleVertraege.forEach(System.out::println);
		};
	}
}
