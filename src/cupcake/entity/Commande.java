package cupcake.entity;

import java.util.ArrayList;
import java.util.Date;

public class Commande {
private int id ;
private String statut;
private Date date;
private float fraisDeLivraison;
private ArrayList<ArticleCde> articlesCde;
private AdresseLivraison adresseLivraison;
private Client client;


public Commande() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatut() {
	return statut;
}
public void setStatut(String statut) {
	this.statut = statut;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public float getFraisDeLivraison() {
	return fraisDeLivraison;
}
public void setFraisDeLivraison(float fraisDeLivraison) {
	this.fraisDeLivraison = fraisDeLivraison;
}
public ArrayList<ArticleCde> getArticlesCde() {
	return articlesCde;
}
public void setArticlesCde(ArrayList<ArticleCde> articlesCde) {
	this.articlesCde = articlesCde;
}
public AdresseLivraison getAdresseLivraison() {
	return adresseLivraison;
}
public void setAdresseLivraison(AdresseLivraison adresseLivraison) {
	this.adresseLivraison = adresseLivraison;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Object[] toArray() {

	return  new Object[]{this.id,this.date,this.statut};
}


}
