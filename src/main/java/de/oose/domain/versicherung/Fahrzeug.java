package de.oose.domain.versicherung;

import de.oose.domain.ddd.DDD_Entity;
import de.oose.domain.fehler.UngueltigeFahrzeugdaten;

@DDD_Entity
public class Fahrzeug {
	private String fahrgestellNr;
	private String kennzeichen;
	private String hersteller;
	private FahrzeugTyp typ;
	
	private Fahrzeuge repository;
	
	public enum FahrzeugTyp {
		KLEIN, MITTEL, PREMIUM, KOMBI, TRANSPORTER, LKW;
	}
	
	protected Fahrzeug(String fahrgestellNr, FahrzeugTyp typ, Fahrzeuge repository) {
		this.fahrgestellNr = fahrgestellNr;
		this.repository = repository;
	}

	@SuppressWarnings("unused")
	private Fahrzeug() {
		
	}
	
	public void speichern() throws UngueltigeFahrzeugdaten {
		if (repository.sucheNachKennzeichen(kennzeichen).isPresent()) {
			throw new UngueltigeFahrzeugdaten();
		}
		repository.speichern(this);
	}

	public void kennzeichenAendern(String kennzeichen) throws UngueltigeFahrzeugdaten {
		if (repository.sucheNachKennzeichen(kennzeichen).isPresent()) {
			throw new UngueltigeFahrzeugdaten();
		}
		this.kennzeichen = kennzeichen;
	}

	public String getFahrgestellNr() {
		return fahrgestellNr;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public FahrzeugTyp getTyp() {
		return typ;
	}

}
