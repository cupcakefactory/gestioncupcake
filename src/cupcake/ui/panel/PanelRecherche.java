package cupcake.ui.panel;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelRecherche extends JPanel {
	private JTextField etNom;
	private JTextField etPrenom;
	private JTextField etNumclient;

	/**
	 * Create the panel.
	 */
	public PanelRecherche() {
		
		JLabel lblNom = new JLabel("Nom");
		add(lblNom);
		
		etNom = new JTextField();
		add(etNom);
		etNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		add(lblPrnom);
		
		etPrenom = new JTextField();
		add(etPrenom);
		etPrenom.setColumns(10);
		
		JLabel lblNclient = new JLabel("N\u00B0client");
		add(lblNclient);
		
		etNumclient = new JTextField();
		add(etNumclient);
		etNumclient.setColumns(10);

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

	public JTextField getEtNumclient() {
		return etNumclient;
	}

	public void setEtNumclient(JTextField etNumclient) {
		this.etNumclient = etNumclient;
	}

	public void addKeyListener(ActionListener actionListener) {
		
		
	}
	

}
