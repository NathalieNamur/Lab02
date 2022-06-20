package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dizionario {

	//ATTRIBUTI:
	private Map<String,Parola> dizionarioAlieno; 
	
	//ATTENZIONE:
	//Il dizionarioAlieno NON è una mappa <parolaAliena, traduzioni>
	//ma una mappa <parolaAliena, Parola(parolaAliena+traduzioni)>.
	
	//Quindi i tipi sono:
	//<String> -> tipo delle chiavi della mappa (tipo di parolaAliena)
	//<Parola> -> tipo dei valori mappati (tipo Parola) 

	
	
	//COSTRUTTORE VUOTO:
	public Dizionario() {
		this.dizionarioAlieno = new HashMap<>();
	}

	
	
	//METODI:
	
	public void addParola(String parolaAliena, String traduzione) {
		
		//Se esiste già una Parola corrispondente alla chiave parolaAliena 
		//nel dizionarioAlieno, 
		//è sufficiente recuperarla (get) e aggiungervi la traduzione data (addTraduzione).
		
		//Se non vi è alcuna Parola corrispondente alla chiave parolaAliena 
		//nel dizionarioAlieno (!containsKey), 
		//è necessario creare una nuova Parola in corrispondenza (put) 
		//prima di procedere (get + addTraduzione):
		
		
		if(!dizionarioAlieno.containsKey(parolaAliena))
			dizionarioAlieno.put(parolaAliena, new Parola(parolaAliena));
		
		dizionarioAlieno.get(parolaAliena).addTraduzione(traduzione);
				
	}

	
	public String translateParola(String parolaAliena) {
		
		if(dizionarioAlieno.containsKey(parolaAliena))
			return dizionarioAlieno.get(parolaAliena).getTraduzioni();
		
		return null;
	}
	
	
}
