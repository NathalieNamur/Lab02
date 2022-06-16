package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dizionario {

	//ATTRIBUTI:
	private Map<String,String> dizionarioAlieno;

	//NB: 
	//Utilizzare l'interfaccia generica Map.
	//Specificare l'implementazione HashMap nel costruttore.

	
	//COSTRUTTORE VUOTO:
	public Dizionario() {
		this.dizionarioAlieno = new HashMap<>();
	}


	//METODI:
	
	public void addParola(String parolaAliena, String traduzione) {
		dizionarioAlieno.put(parolaAliena, traduzione);
	}

	
	public String translateParola(String parolaAliena) {
		
		if(dizionarioAlieno.containsKey(parolaAliena))
			return dizionarioAlieno.get(parolaAliena);
		
		return null;
	}
	
	
}
