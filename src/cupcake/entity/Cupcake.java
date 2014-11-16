package cupcake.entity;

public class Cupcake {
private String goutGateau;
private String couleurCaissette;
private String couleurCreme;
private String description;


public Cupcake() {
	super();	
}
public String getGoutGateau() {
	return goutGateau;
}
public void setGoutGateau(String goutGateau) {
	this.goutGateau = goutGateau;
}
public String getCouleurCaissette() {
	return couleurCaissette;
}
public void setCouleurCaissette(String couleurCaissette) {
	this.couleurCaissette = couleurCaissette;
}
public String getCouleurCreme() {
	return couleurCreme;
}
public void setCouleurCreme(String couleurCreme) {
	this.couleurCreme = couleurCreme;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((couleurCaissette == null) ? 0 : couleurCaissette.hashCode());
	result = prime * result
			+ ((couleurCreme == null) ? 0 : couleurCreme.hashCode());
	result = prime * result
			+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
			+ ((goutGateau == null) ? 0 : goutGateau.hashCode());
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
	Cupcake other = (Cupcake) obj;
	if (couleurCaissette == null) {
		if (other.couleurCaissette != null)
			return false;
	} else if (!couleurCaissette.equals(other.couleurCaissette))
		return false;
	if (couleurCreme == null) {
		if (other.couleurCreme != null)
			return false;
	} else if (!couleurCreme.equals(other.couleurCreme))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (goutGateau == null) {
		if (other.goutGateau != null)
			return false;
	} else if (!goutGateau.equals(other.goutGateau))
		return false;
	return true;
}


}
