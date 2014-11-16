package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import cupcake.entity.Commande;

import java.awt.GridLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JTextField;

public class panelListeCommandes extends JPanel {
	private PanelInfos panelInfos;
	private PanelTableCommandes panelTableCommandes;

	/**
	 * Create the panel.
	 */
	public panelListeCommandes() {
		setLayout(new BorderLayout(0, 0));
		
		PanelConsigne panelConsigne = new PanelConsigne();
		add(panelConsigne, BorderLayout.SOUTH);
		
		panelInfos = new PanelInfos();
		add(panelInfos, BorderLayout.NORTH);

		panelTableCommandes = new PanelTableCommandes();
		add(panelTableCommandes, BorderLayout.CENTER);

	}
public void setCommandes(ArrayList<Commande> cdes){
	panelTableCommandes.setCommandes(cdes);
}
	public PanelInfos getPanelInfos() {
		return panelInfos;
	}

	public void setPanelInfos(PanelInfos panelInfos) {
		this.panelInfos = panelInfos;
	}

	public PanelTableCommandes getPanelTableCommandes() {
		return panelTableCommandes;
	}

	public void setPanelTableCommandes(PanelTableCommandes panelTableCommandes) {
		this.panelTableCommandes = panelTableCommandes;
	}

	


}
