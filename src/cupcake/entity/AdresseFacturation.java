package cupcake.entity;

import java.util.ArrayList;

public class AdresseFacturation {

	protected int numero;
	protected  String libelleVoie;
	protected  int cp;
	protected  String localite;
	protected  ArrayList<Client> clients;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelleVoie() {
		return libelleVoie;
	}
	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "AdresseFacturation [numero=" + numero + ", libelleVoie="
				+ libelleVoie + ", cp=" + cp + ", localite=" + localite
				+ ", clients=" + clients + "]";
	}
	
	
}
