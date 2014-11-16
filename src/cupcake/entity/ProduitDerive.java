package cupcake.entity;

public class ProduitDerive {
	private String couleur;
	private String taille;
	public ProduitDerive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((taille == null) ? 0 : taille.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduitDerive other = (ProduitDerive) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (taille == null) {
			if (other.taille != null)
				return false;
		} else if (!taille.equals(other.taille))
			return false;
		return true;
	}
	
	
}
