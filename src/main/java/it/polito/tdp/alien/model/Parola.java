package it.polito.tdp.alien.model;


public class Parola {

	//ATTRIBUTI:
	private String parolaAliena;
	private String traduzione;
	
	
	//COSTRUTTORE:
	public Parola(String parolaAliena, String traduzione) {
		
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}
	
	
	//METODI:
	
	public String getParolaAliena() {
		return parolaAliena;
	}

	public void setParolaAliena(String p) {
		this.parolaAliena = p;
	}
	
	
	public String getTraduzione() {
		return traduzione;
	}

	public void setTraduzione(String t) {
		this.traduzione = t;
	}
	
	
}
