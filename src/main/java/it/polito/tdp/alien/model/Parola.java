package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Set;

public class Parola {

	//ATTRIBUTI:
	private String parolaAliena;
	private Set<String> traduzioni;
	
	
	
	//COSTRUTTORE:
	public Parola(String parolaAliena) {
		
		this.parolaAliena = parolaAliena;
		this.traduzioni = new HashSet<>();
	}
	
	
	
	//METODI:
	
	public String getParolaAliena() {
		return parolaAliena;
	}

	
	public void setParolaAliena(String p) {
		this.parolaAliena = p;
	}
	
	
	public String getTraduzioni() {
		
		String s = "";
			
		for (String t : traduzioni)
			s = s + t + "\n";
			
		return s;
	}
	

	public void addTraduzione(String t) {
		traduzioni.add(t);
	}


}
