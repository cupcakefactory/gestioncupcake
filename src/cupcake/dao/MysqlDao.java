package cupcake.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import cupcake.entity.AdresseFacturation;
import cupcake.entity.AdresseLivraison;
import cupcake.entity.Article;
import cupcake.entity.ArticleCde;
import cupcake.entity.Client;
import cupcake.entity.Commande;
import cupcake.entity.Personne;

public class MysqlDao implements ClientDao {

	private Connection dbcon;
	private String user = "root";
	private String dsn = "jdbc:mysql://localhost:3306/cupcakefactory";
	private String password = "root";

	public MysqlDao() throws Exception {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		this.dbcon = DriverManager.getConnection(dsn, user, password);

	}

	// methode qui recupere un client d'après le numero de client
	public ArrayList<Client> getClient(int ident) throws Exception {
		String sql = "select nom,prenom,id from personne where id=? ";
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, ident);
		ResultSet result = stmt.executeQuery();
		Client cli = null;
		ArrayList<Client> clients = new ArrayList<Client>();
		while (result.next()) {
			int id = result.getInt("id");
			String nom = result.getString("nom");
			String prenom = result.getString("prenom");
			cli = new Client();
			cli.setNom(nom);
			cli.setPrenom(prenom);
			cli.setId(id);
			clients.add(cli);
		}
		result.close();
		stmt.close();
		return clients;
	}

	// methode qui recupere tous les clients
	public ArrayList<Client> getClients(String nom, String prenom)
			throws Exception {
		String sql = "select nom,prenom,id from personne where nom like ? and prenom like ?";
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, nom + '%');
		stmt.setString(2, prenom + '%');
		ResultSet result = stmt.executeQuery();
		ArrayList<Client> clients = new ArrayList<Client>();
		Client cli = null;
		while (result.next()) {

			String nomClient = result.getString("nom");
			String prenomClient = result.getString("prenom");
			int numClient = result.getInt("id");
			cli = new Client();
			cli.setNom(nomClient);
			cli.setPrenom(prenomClient);
			cli.setId(numClient);
			clients.add(cli);

		}

		result.close();
		stmt.close();
		return clients;

	}

	// methode qui recupere les infos de la carte client
	public Client getCarteClient(int ident) throws Exception {
		String sql = "select count(cdes.client_id) as nb,nom,prenom,p.id,email,"
				+ "numero,libellevoie,codepostal,localite,telfixe,telmobile "
				+ "from commande cdes right  join personne p  on p.id=cdes.client_id "
				+ " inner join client c on c.id=p.id "
				+ "inner join adressefacturation af on af.id=p.id "
				+ "where p.id= ? group by cdes.client_id";
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, ident);

		ResultSet result = stmt.executeQuery();
		Client cli = null;
		AdresseFacturation adr = null;
		while (result.next()) {
			int nbcdes = result.getInt("nb");
			String nomClient = result.getString("nom");
			String prenomClient = result.getString("prenom");
			int numClient = result.getInt("id");
			int numero = result.getInt("numero");
			String rue = result.getString("libellevoie");
			int cp = result.getInt("codepostal");
			String ville = result.getString("localite");
			String telFixe = result.getString("telfixe");
			String telMobile = result.getString("telmobile");
			String email = result.getString("email");

			adr = new AdresseFacturation();
			adr.setCp(cp);
			adr.setLibelleVoie(rue);
			adr.setLocalite(ville);
			adr.setNumero(numero);
			cli = new Client();
			cli.setNom(nomClient);
			cli.setPrenom(prenomClient);
			cli.setId(numClient);
			cli.setAdresseFacturation(adr);
			cli.setEmail(email);
			cli.setTelFixe(telFixe);
			cli.setTelMobile(telMobile);
			cli.setNbcdes(nbcdes);

		}

		result.close();
		stmt.close();
		return cli;

	}

	// methode qui met à jour le client dans la base
	public void updateClient(Client client) throws Exception {

		String sql = "update personne set nom = ?,prenom = ? where id= ?";
		PreparedStatement stmt = dbcon.prepareStatement(sql);

		stmt.setString(1, client.getNom());
		stmt.setString(2, client.getPrenom());
		stmt.setInt(3, client.getId());
		stmt.executeUpdate();
		stmt.close();

		sql = "update adressefacturation set numero = ? ,libellevoie = ?,codepostal = ? ,"
				+ " localite = ? where id= ?";
		stmt = dbcon.prepareStatement(sql);

		stmt.setInt(1, client.getAdresseFacturation().getNumero());
		stmt.setString(2, client.getAdresseFacturation().getLibelleVoie());
		stmt.setInt(3, client.getAdresseFacturation().getCp());
		stmt.setString(4, client.getAdresseFacturation().getLocalite());
		stmt.setInt(5, client.getId());
		stmt.executeUpdate();
		stmt.close();

		sql = "update client set email = ?,telfixe=?,telmobile=? where id= ?";
		stmt = dbcon.prepareStatement(sql);

		stmt.setString(1, client.getEmail());
		stmt.setString(2, client.getTelFixe());
		stmt.setString(3, client.getTelMobile());
		stmt.setInt(4, client.getId());
		stmt.executeUpdate();
		stmt.close();
	}

	// methodes qui recupere toutes les commandes d'un client
	public ArrayList<Commande> getCdes(int ident) throws Exception {
		String sql = "select nom,prenom,c.id,client_id,statut,date "
				+ "from personne p inner join commande c on p.id=c.client_id  "
				+ "where p.id= ?";
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, ident);

		ResultSet result = stmt.executeQuery();
		ArrayList<Commande> cdes = new ArrayList<Commande>();
		Commande cde = null;

		while (result.next()) {

			String nomClient = result.getString("nom");
			String prenomClient = result.getString("prenom");
			int cdeId = result.getInt("id");
			int id = result.getInt("client_id");
			String statut = result.getString("statut");
			Date date = result.getDate("date");
			Client cli = new Client();
			cli.setNom(nomClient);
			cli.setPrenom(prenomClient);
			cli.setId(id);
			cde = new Commande();
			cde.setClient(cli);
			cde.setDate(date);
			cde.setId(cdeId);
			cde.setStatut(statut);
			cdes.add(cde);
		}
		result.close();
		stmt.close();
		return cdes;

	}

	// methode qui recupere le contenu d'une commande
	public Commande getCde(int numCde) throws Exception {
		String sql = "select a.intitule,a.reference,ac.quantite,c.id,p.nom,p.prenom,c.statut "
				+ "from commande c "
				+ "inner join personne p on p.id = c.client_id "
				+ "inner join commande_articlecde cacd on cacd.commande_fk=c.id "
				+ "inner join articlecde ac on ac.id=cacd.articlecde_fk "
				+ "inner join article a on a.id = ac.article_id " + "where c.id= ?";

		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, numCde);
		ResultSet result = stmt.executeQuery();
		ArrayList<ArticleCde> articlesCdes = new ArrayList<ArticleCde>();

		boolean condition = true;
		Client cli = new Client();
		Commande cde = new Commande();

		while (result.next()) {
			if (condition) {
				String nomClient = result.getString("nom");
				String prenomClient = result.getString("prenom");
				cli.setNom(nomClient);
				cli.setPrenom(prenomClient);
				int cdeId = result.getInt("id");
				cde.setId(cdeId);
				String statut = result.getString("statut");
				cde.setStatut(statut);
				cde.setClient(cli);
			}
			condition = false;

			Article article = new Article();
			String intitule = result.getString("intitule");
			String reference = result.getString("reference");
			int quantite = result.getInt("quantite");
			article.setIntitule(intitule);
			article.setReference(reference);

			ArticleCde ac = new ArticleCde();
			ac.setArticle(article);
			ac.setQuantite(quantite);

			articlesCdes.add(ac);

		}
		cde.setArticlesCde(articlesCdes);
		result.close();
		stmt.close();
		return cde;

	}

	// methode qui recupere toutes les references et tous les intitulés des
	// articles dans la base

	public ArrayList<Article> getArticles() throws Exception {
		String sql = "select reference,intitule from article ORDER BY intitule ASC ";
		PreparedStatement stmt = dbcon.prepareStatement(sql);

		ResultSet result = stmt.executeQuery();

		ArrayList<Article> refIntitules = new ArrayList<Article>();
		while (result.next()) {
			Article art = new Article();
			String reference = result.getString("reference");
			String intitule = result.getString("intitule");

			art.setIntitule(intitule);
			art.setReference(reference);

			refIntitules.add(art);

		}
		result.close();
		stmt.close();
		return refIntitules;
	}

	public void updateStatut(int numCde) throws Exception {
		String sql = "update commande c set statut = 'fermé' where c.id =?";
		PreparedStatement stmt = dbcon.prepareStatement(sql);

		stmt.setInt(1, numCde);
		stmt.executeUpdate();
		stmt.close();
	}

	// methode qui met à jour le contenu de la commande
	public void updateCommande(int numCde, String newReference,
			String oldReference, int quantite) throws Exception {

		if (newReference.equals(oldReference)) {
			String sql = "update articlecde  ac  "
					+ "inner join article a on a.id = ac.article_id and a.reference=?"
					+ "inner join commande_articlecde cac on ac.id=cac.articlecde_fk "
					+ "inner join commande c on c.id=cac.commande_fk "
					+ " set ac.quantite=? " + " where c.id=? ";
			PreparedStatement stmt = dbcon.prepareStatement(sql);

			stmt.setString(1, oldReference);
			stmt.setInt(2, quantite);
			stmt.setInt(3, numCde);
			stmt.executeUpdate();
			stmt.close();

		} else {
			String sql = "update articlecde  ac "
					+ "	inner join commande_articlecde cac on ac.id=cac.articlecde_fk "
					+ "inner join commande c on c.id=cac.commande_fk "
					+ "inner join article olda on olda.id = ac.article_id and olda.reference=? "
					+ "set ac.article_id =(select newa.id from article newa where newa.reference=?), "
					+ "ac.quantite=?  " + "where c.id=?  ";

			PreparedStatement stmt = dbcon.prepareStatement(sql);
			stmt.setString(1, oldReference);
			stmt.setString(2, newReference);
			stmt.setInt(3, quantite);
			stmt.setInt(4, numCde);
			stmt.executeUpdate();
			stmt.close();
		}

	}

	// methode qui efface une ligne d'article commandé
	public void deleteArticleCde(int numCde, String reference) throws Exception {
		// selection des identifiants des differentes tables concernées par le
		// delete
		// à cause de la non mise en place de "on delete cascade"
		String sql = "select  ac.id,cac.commande_fk,cac.articleCde_fk from articlecde ac"
				+ " inner join article a on a.id = ac.article_id and a.reference=?"
				+ " inner join commande_articlecde cac on ac.id=cac.articlecde_fk"
				+ " inner join commande c on c.id=cac.commande_fk where c.id=?";

		PreparedStatement stmt = dbcon.prepareStatement(sql);

		stmt.setString(1, reference);
		stmt.setInt(2, numCde);
		ResultSet result = stmt.executeQuery();

		int id_artcde = 0;
		int cde_fk = 0;
		int artcde_fk = 0;

		while (result.next()) {
			id_artcde = result.getInt("id");
			cde_fk = result.getInt("commande_fk");
			artcde_fk = result.getInt("articleCde_fk");
		}
		stmt.close();
		// suppression de la ligne commande_fk dont l'identifiant est
		// (commande_fk,articlecde_fk)
		sql = " delete from commande_articlecde where commande_fk=? and ArticleCde_fk=?";
		stmt = dbcon.prepareStatement(sql);

		stmt.setInt(1, cde_fk);
		stmt.setInt(2, artcde_fk);
		stmt.executeUpdate();
		stmt.close();
		// suppression de la ligne id dans la table articlecde

		sql = "delete from articlecde where id=?";
		stmt = dbcon.prepareStatement(sql);

		stmt.setInt(1, id_artcde);
		stmt.executeUpdate();
		stmt.close();

		int nb = 0;
		sql = "select count(*) as nb  from commande_articlecde where commande_fk=?";
		stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, cde_fk);
		result = stmt.executeQuery();
		while (result.next()) {
			nb = result.getInt("nb");
		}
		stmt.close();

		if (nb == 0) {
			sql = "delete from livraison_commande where commande_fk=?";
			stmt = dbcon.prepareStatement(sql);
			stmt.setInt(1, cde_fk);
			stmt.executeUpdate();
			stmt.close();

			sql = "delete from commande where id=?";
			stmt = dbcon.prepareStatement(sql);
			stmt.setInt(1, cde_fk);
			stmt.executeUpdate();
			stmt.close();
		}
	}

	public void addArticleCde(int numCde, String reference, int quantite)
			throws Exception {
		String sql = "select id from article where reference=?";
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, reference);
		ResultSet result = stmt.executeQuery();

		int idArticle = 0;
		while (result.next()) {
			idArticle = result.getInt("id");
		}
		stmt.close();
		sql = "insert into articlecde (article_id,quantite) values (?,?)";
		stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, idArticle);
		stmt.setInt(2, quantite);
		stmt.executeUpdate();
		stmt.close();
		sql = "select last_insert_id() as id";
		stmt = dbcon.prepareStatement(sql);
		result = stmt.executeQuery();
		int id = 0;
		while (result.next()) {
			id = result.getInt("id");
		}
		stmt.close();
		sql = "insert into commande_articlecde (commande_fk,articlecde_fk)values(?,?)";
		stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, numCde);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		stmt.close();
	}

	public AdresseLivraison getAdrLivraison(int numCde) throws Exception {
		String sql = "select al.nom,al.prenom,al.codeporte,al.etage,al.telfixe,al.telmobile, "
				+ "al.infocomplementaires,af.numero,af.libellevoie,af.localite,af.codepostal "
				+ "from commande c "
				+ "inner join adresselivraison al on al.id = c.adresselivraison_id "
				+ " inner join adressefacturation af on af.id = al.id "
				+ "where c.id=?";

		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, numCde);

		ResultSet result = stmt.executeQuery();
		AdresseLivraison adrliv = null;
		while (result.next()) {
			String nomClient = result.getString("nom");
			String prenomClient = result.getString("prenom");
			int numero = result.getInt("numero");
			String rue = result.getString("libellevoie");
			int cp = result.getInt("codepostal");
			String ville = result.getString("localite");
			String codePorte = result.getString("codeporte");
			String infos = result.getString("infocomplementaires");
			int etage = result.getInt("etage");
			String telFixe = result.getString("telfixe");
			String telMobile = result.getString("telmobile");

			adrliv = new AdresseLivraison();
			adrliv.setCodePorte(codePorte);
			adrliv.setCp(cp);
			adrliv.setEtage(etage);
			adrliv.setInfoComplementaires(infos);
			adrliv.setLocalite(ville);
			adrliv.setLibelleVoie(rue);
			adrliv.setNom(nomClient);
			adrliv.setPrenom(prenomClient);
			adrliv.setNumero(numero);
			adrliv.setTelFixe(telFixe);
			adrliv.setTelMobile(telMobile);

		}
		result.close();
		stmt.close();
		return adrliv;
	}

	public void UpdateAdrLivraison(int numCde, AdresseLivraison adrLiv ) throws Exception {

		String sql = "select adresselivraison_id from commande where id=?";

		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setInt(1, numCde);

		ResultSet result = stmt.executeQuery();
		int adrLiv_id = 0;
		while (result.next()) {
			adrLiv_id = result.getInt("adresselivraison_id");
		}
		result.close();
		stmt.close();

		sql = "update adresselivraison set nom=?,prenom=?,etage=?,codeporte=?,infocomplementaires=?,telfixe=?,telmobile=? "
				+ "where id=?";
		
		stmt = dbcon.prepareStatement(sql);
		
		stmt.setString(1, adrLiv.getNom());
		stmt.setString(2, adrLiv.getPrenom());
		stmt.setInt(3, adrLiv.getEtage());
		stmt.setString(4, adrLiv.getCodePorte());
		stmt.setString(5, adrLiv.getInfoComplementaires());
		stmt.setString(6, adrLiv.getTelFixe());
		stmt.setString(7, adrLiv.getTelMobile());
		stmt.setInt(8, adrLiv_id);
		
		stmt.executeUpdate();
		stmt.close();
		
		sql = "update adressefacturation set libellevoie=?,codepostal=?,localite=?,numero=? "
				+ "where id=?";
		
		stmt = dbcon.prepareStatement(sql);
		
		stmt.setString(1, adrLiv.getLibelleVoie());
		stmt.setInt(2, adrLiv.getCp());
		stmt.setString(3, adrLiv.getLocalite());
		stmt.setInt(4, adrLiv.getNumero());
		stmt.setInt(5, adrLiv_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
}
