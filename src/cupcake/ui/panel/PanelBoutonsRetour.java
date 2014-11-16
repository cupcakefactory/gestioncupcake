package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelBoutonsRetour extends JPanel {
	private JButton btnListeCommandes;
	private JButton btnCarteClient;
	private JButton btnListeClients;
	private JButton btnAdresseLivraison;

	/**
	 * Create the panel.
	 */
	public PanelBoutonsRetour() {
		
		btnAdresseLivraison = new JButton("Adresse livraison");
		add(btnAdresseLivraison);
		
		btnListeCommandes = new JButton("Liste commandes");
		add(btnListeCommandes);
		
		btnCarteClient = new JButton("Carte client");
		add(btnCarteClient);
		
		btnListeClients = new JButton("Liste clients");
		add(btnListeClients);

		
	}

	public JButton getBtnListeCommandes() {
		return btnListeCommandes;
	}

	public void setBtnListeCommandes(JButton btnListeCommandes) {
		this.btnListeCommandes = btnListeCommandes;
	}

	public JButton getBtnCarteClient() {
		return btnCarteClient;
	}

	public void setBtnCarteClient(JButton btnCarteClient) {
		this.btnCarteClient = btnCarteClient;
	}

	public JButton getBtnListeClients() {
		return btnListeClients;
	}

	public void setBtnListeClients(JButton btnListeClients) {
		this.btnListeClients = btnListeClients;
	}

	public JButton getBtnAdresseLivraison() {
		return btnAdresseLivraison;
	}

	public void setBtnAdresseLivraison(JButton btnAdresseLivraison) {
		this.btnAdresseLivraison = btnAdresseLivraison;
	}

}
