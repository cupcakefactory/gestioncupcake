package cupcake.entity;

public class AdresseLivraison extends AdresseFacturation{
	private String nom;
	private String prenom;
	private String codePorte;
	private int etage;
	private String infoComplementaires;
	private String telFixe;
	private String telMobile;
	
	public AdresseLivraison() {

	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCodePorte() {
		return codePorte;
	}


	public void setCodePorte(String codePorte) {
		this.codePorte = codePorte;
	}


	public int getEtage() {
		return etage;
	}


	public void setEtage(int etage) {
		this.etage = etage;
	}


	public String getInfoComplementaires() {
		return infoComplementaires;
	}


	public void setInfoComplementaires(String infoComplementaires) {
		this.infoComplementaires = infoComplementaires;
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


	@Override
	public String toString() {
		return "AdresseLivraison [nom=" + nom + ", prenom=" + prenom
				+ ", codePorte=" + codePorte + ", etage=" + etage
				+ ", infoComplementaires=" + infoComplementaires + ", telFixe="
				+ telFixe + ", telMobile=" + telMobile + ", numero=" + numero
				+ ", libelleVoie=" + libelleVoie + ", cp=" + cp + ", localite="
				+ localite +"]";
	}


	


	
	
}
