package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PanelInfos extends JPanel {
	private JLabel lblNclient;
	private JTextField etNumClient;
	private JTextField etNom;
	private JTextField etPrenom;
	private JButton btnCarteClient;
	private JButton btnListeDesClients;

	/**
	 * Create the panel.
	 */
	public PanelInfos() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnListeDesClients = new JButton("Liste des clients");
		add(btnListeDesClients);
		
		btnCarteClient = new JButton("Carte client");
		add(btnCarteClient);
		
		lblNclient = new JLabel("N\u00B0client");
		add(lblNclient);
		
		etNumClient = new JTextField();
		etNumClient.setEditable(false);
		add(etNumClient);
		etNumClient.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		add(lblNom);
		
		etNom = new JTextField();
		etNom.setEditable(false);
		add(etNom);
		etNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		add(lblPrnom);
		
		etPrenom = new JTextField();
		etPrenom.setEditable(false);
		add(etPrenom);
		etPrenom.setColumns(10);

	}

	public JTextField getEtNumClient() {
		return etNumClient;
	}

	public void setEtNumClient(JTextField etNumClient) {
		this.etNumClient = etNumClient;
	}

	public JTextField getEtNom() {
		return etNom;
	}

	public void setEtNom(JTextField etNom) {
		this.etNom = etNom;
	}

	public JTextField getEtPrenom() {
		return etPrenom;
	}

	public void setEtPrenom(JTextField etPrenom) {
		this.etPrenom = etPrenom;
	}

	public JButton getBtnCarteClient() {
		return btnCarteClient;
	}

	public void setBtnCarteClient(JButton btnCarteClient) {
		this.btnCarteClient = btnCarteClient;
	}

	public JButton getBtnListeDesClients() {
		return btnListeDesClients;
	}

	public void setBtnListeDesClients(JButton btnListeDesClients) {
		this.btnListeDesClients = btnListeDesClients;
	}

}
