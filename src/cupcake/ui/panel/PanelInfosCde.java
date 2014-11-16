package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelInfosCde extends JPanel {
	private JTextField etNumCde;
	private JTextField etNom;
	private JTextField etPrenom;
	private JLabel lblStatut;
	private JTextField etStatut;

	/**
	 * Create the panel.
	 */
	public PanelInfosCde() {
		
		JLabel lblNCommande = new JLabel("N\u00B0 commande");
		add(lblNCommande);
		
		etNumCde = new JTextField();
		etNumCde.setEditable(false);
		add(etNumCde);
		etNumCde.setColumns(10);
		
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
		
		lblStatut = new JLabel("Statut");
		add(lblStatut);
		
		etStatut = new JTextField();
		etStatut.setEditable(false);
		add(etStatut);
		etStatut.setColumns(10);

	}

	public JTextField getEtNumCde() {
		return etNumCde;
	}

	public void setEtNumCde(JTextField etNumCde) {
		this.etNumCde = etNumCde;
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

	public JTextField getEtStatut() {
		return etStatut;
	}

	public void setEtStatut(JTextField etStatut) {
		this.etStatut = etStatut;
	}

	public JLabel getLblStatut() {
		return lblStatut;
	}

	public void setLblStatut(JLabel lblStatut) {
		this.lblStatut = lblStatut;
	}

	

}
