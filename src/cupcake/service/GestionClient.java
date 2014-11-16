package cupcake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cupcake.dao.ClientDao;
import cupcake.dao.MysqlDao;
import cupcake.entity.AdresseLivraison;
import cupcake.entity.Article;
import cupcake.entity.Client;
import cupcake.entity.Commande;

public class GestionClient {

	private ClientDao dao;

	public GestionClient() throws Exception {

		dao = new MysqlDao();
	}

	public List<Client> getClients(String nom, String prenom) throws Exception {
		List<Client> clients = null;
		clients = dao.getClients(nom, prenom);
		return clients;

	}

	public List<Client> getClient(int ident) throws Exception {
		List<Client> clients = null;
		clients = dao.getClient(ident);
		return clients;
	}

	public Client getCarteClient(int ident) throws Exception {
		Client client = null;
		client = dao.getCarteClient(ident);
		return client;
	}

	public void updateClient(Client client) throws Exception {
		dao.updateClient(client);
	}

	public ArrayList<Commande> getCdes(int ident) throws Exception{
		return dao.getCdes(ident);
	}
	public ArrayList<Article> getArticles() throws Exception{
		return dao.getArticles();
	}
	public Commande getCde(int numCde) throws Exception{
		return dao.getCde(numCde);
	}
	public void updateCommande (int numCde, String newReference,
			String oldReference, int quantite)throws Exception{
		dao.updateCommande( numCde, newReference,
				 oldReference,  quantite);
	}
	public void deleteArticleCde(int numCde, String reference) throws Exception{
		dao.deleteArticleCde(numCde, reference);
	}
	public void addArticleCde(int numCde, String reference, int quantite)
			throws Exception {
		dao.addArticleCde(numCde, reference, quantite);
	}
	public void updateStatut(int numCde) throws Exception{
		dao.updateStatut(numCde);
	}
	public AdresseLivraison getAdrLivraison(int numCde) throws Exception{
		return dao.getAdrLivraison(numCde);
	}
	public void UpdateAdrLivraison(int numCde, AdresseLivraison adrLiv) throws Exception{
		dao.UpdateAdrLivraison(numCde, adrLiv);
	}
}