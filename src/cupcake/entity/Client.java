package cupcake.entity;

import java.awt.List;
import java.util.ArrayList;

public class Client extends Personne{

private String email;
private String mdp;
private String telFixe;
private String telMobile;
private AdresseFacturation adresseFacturation;
private ArrayList<Commande> commandes;
private int nbcdes;


public Client() {
	super();
	
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getMdp() {
	return mdp;
}


public void setMdp(String mdp) {
	this.mdp = mdp;
}


public String getTelFixe() {
	return telFixe;
}


public void setTelFixe(String telFixe) {
	this.telFixe = telFixe;
}


public String getTelMobile() {
	return telMobile;
}


public void setTelMobile(String telMobile) {
	this.telMobile = telMobile;
}


public AdresseFacturation getAdresseFacturation() {
	return adresseFacturation;
}


public void setAdresseFacturation(AdresseFacturation adresseFacturation) {
	this.adresseFacturation = adresseFacturation;
}


public ArrayList<Commande> getCommandes() {
	return commandes;
}


public void setCommandes(ArrayList<Commande> commandes) {
	this.commandes = commandes;
}


public int getNbcdes() {
	return nbcdes;
}


public void setNbcdes(int nbcdes) {
	this.nbcdes = nbcdes;
}


@Override
public String toString() {
	return "Client [Personne= " +super.toString()+ "  email=" + email + ", mdp=" + mdp + ", telFixe=" + telFixe
			+ ", telMobile=" + telMobile + ", adresseFacturation="
			+ adresseFacturation + ", commandes=" + commandes + "]";
}


public Object[] toArray() {
	// TODO Auto-generated method stub
	
		 return  new Object[]{this.id,this.nom,this.prenom};
	 
}


}
