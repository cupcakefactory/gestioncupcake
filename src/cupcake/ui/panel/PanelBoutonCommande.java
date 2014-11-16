package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelBoutonCommande extends JPanel {
	private JButton btnListeDesCommandes;

	/**
	 * Create the panel.
	 */
	public PanelBoutonCommande() {
		
		btnListeDesCommandes = new JButton("Liste des commandes");
		add(btnListeDesCommandes);

	}

	public JButton getBtnListeDesCommandes() {
		return btnListeDesCommandes;
	}

	public void setBtnListeDesCommandes(JButton btnListeDesCommandes) {
		this.btnListeDesCommandes = btnListeDesCommandes;
	}

}
