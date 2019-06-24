package service;

public interface UtenteService {
	
	public List<Cliente> visualizzaClienti();
	public List<Cliente> visualizzaClientiInaffidabili();
	public List<Cliente> visualizzaClientiAffidabili();
	public Cliente visualizzaDatiCliente(String username);
	public boolean modificaDatiCliente (Cliente c);
	public boolean marcaInaffidabile(String username);
	public boolean marcaAffidabile(String username);
	public List<Ordine>visualizzaTuttiGliOrdini ();
	
	
	
	
	
	
	

}
