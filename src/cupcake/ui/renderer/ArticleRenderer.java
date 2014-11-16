package cupcake.ui.renderer;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cupcake.entity.Article;

public class ArticleRenderer implements ListCellRenderer<Article> {

private DefaultListCellRenderer defaultRenderer=new DefaultListCellRenderer();
private final static Dimension preferredSize=new Dimension(0,15);
	
@Override
	public Component getListCellRendererComponent(JList<? extends Article> listeArticles,
			Article article , int index, boolean isSelected, boolean cellHasFocus) {
		
		JLabel jLabel = (JLabel) defaultRenderer.getListCellRendererComponent(listeArticles, article, 
				index, isSelected, cellHasFocus);			
			jLabel.setText(article.getReference() + " - " + article.getIntitule());
		jLabel.setPreferredSize(preferredSize);
		return jLabel;
			
	}

}
