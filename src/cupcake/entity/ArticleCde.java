package cupcake.entity;

public class ArticleCde {
private	int  quantite;
private Article article;
private int article_id;



public ArticleCde() {
	
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Article getArticle() {
	return article;
}
public void setArticle(Article article) {
	this.article = article;
}


public int getArticle_id() {
	return article_id;
}
public void setArticle_id(int article_id) {
	this.article_id = article_id;
}
@Override
public String toString() {
	return "ArticleCde [quantite=" + quantite + ", article=" + article + "]";
}
public Object[] toArray() {

	return  new Object[]{this.getArticle().getIntitule(),this.getArticle().getReference(),this.quantite};
}

}
