package service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import bean.Utente;

public class UtenteServiceFake implements UtenteService {

	private static Map<String, Utente> utenti = new HashMap<String, Utente>();
	
	@Override
	public void registraUtente(Utente u) throws Exception {
		if(utenti.containsKey(u.getUsername()))
			throw new Exception("utente già presente");
		
		utenti.put(u.getUsername(), u);
	}

}
