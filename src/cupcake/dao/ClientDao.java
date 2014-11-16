package cupcake.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import cupcake.entity.AdresseLivraison;
import cupcake.entity.Article;
import cupcake.entity.Client;
import cupcake.entity.AdresseFacturation;
import cupcake.entity.Commande;

public interface ClientDao {
	ArrayList<Client> getClient(int ident) throws Exception;

	ArrayList<Client> getClients(String nom, String prenom) throws Exception;

	Client getCarteClient(int ident) throws Exception;

	void updateClient(Client client) throws Exception;

	ArrayList<Commande> getCdes(int ident) throws Exception;

	public ArrayList<Article> getArticles() throws Exception;

	public Commande getCde(int numCde) throws Exception;
	
	void updateCommande(int numCde, String newReference,
			String oldReference, int quantite) throws Exception;
	
	void deleteArticleCde(int numCde, String reference) throws Exception;
	
	void addArticleCde(int numCde, String reference, int quantite)
			throws Exception;
	void updateStatut(int numCde) throws Exception;
	
	public AdresseLivraison getAdrLivraison(int numCde) throws Exception;
	
	void UpdateAdrLivraison(int numCde, AdresseLivraison adrLiv) throws Exception;
}
