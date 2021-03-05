package de.oose.domain.versicherung;

import de.oose.domain.ddd.DDD_RootEntity;
import de.oose.domain.fehler.UngueltigeVertragsdaten;

@DDD_RootEntity
public class Vertrag {

	private String vertragsnummer;
	private String vertragspartner;
	private Typ versicherungsTyp;
	private Vertragskonditionen konditionen;

	private Vertraege repository;

	public enum Typ {
		VOLLKASKO, TEILKASKO, HAFTPFLICHT;
	}

	protected Vertrag(String vertragsnummer, Vertraege repository) {
		this.vertragsnummer = vertragsnummer;
		this.repository = repository;
	}

	public void vertragspartnerFestlegen(String vertragspartner) {
		this.vertragspartner = vertragspartner;
	}

	public void versicherungsTypFestlegen(Typ versicherungsTyp) {
		this.versicherungsTyp = versicherungsTyp;
	}

	public void konditionenFestlegen(Vertragskonditionen konditionen) {
		this.konditionen = konditionen;
	}

	public void abschliessen() throws UngueltigeVertragsdaten {
		vertragsdatenPruefen();
		repository.ablegen(this);
	}

	private void vertragsdatenPruefen() throws UngueltigeVertragsdaten {
		if (vertragspartner == null 
				|| vertragspartner.isBlank() 
				|| versicherungsTyp == null 
				|| vertragsnummer == null
				|| vertragsnummer.isBlank())
			throw new UngueltigeVertragsdaten();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Nummer: %s\n", vertragsnummer));
		sb.append(String.format("Vertragspartner: %s\n", vertragspartner));
		sb.append(String.format("Versicherungstyp: %s\n", versicherungsTyp.toString()));
		sb.append(konditionen.toString());
		return sb.toString();
	}
}
