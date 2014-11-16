package cupcake.ui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCarteClient extends JPanel {
	private JTextField etId;
	private JTextField etNom;
	private JTextField etPrenom;
	private JTextField etEmail;
	private JTextField etNum;
	private JTextField etRue;
	private JTextField etCp;
	private JTextField etVille;
	private JTextField etTelFixe;
	private JTextField etTelMobile;
	private PanelBoutonValider panelBoutonValider;
	private JLabel lblNumClient;
	private PanelBoutonCommande panelBoutonCommande;
	private PanelBoutonRetourListeClients panelBoutonListeClients;

	/**
	 * Create the panel.
	 */
	public PanelCarteClient() {
		setLayout(null);
		lblNumClient = new JLabel("Num Client");
		lblNumClient.setBounds(11, 14, 83, 14);
		add(lblNumClient);
		
		etId = new JTextField();
		etId.setBounds(104, 11, 86, 20);
		add(etId);
		etId.setEditable(false);
		etId.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(39, 94, 28, 14);
		add(lblNom);
		
		etEmail = new JTextField();
		etEmail.setBounds(101, 231, 117, 20);
		add(etEmail);
		etEmail.setColumns(10);
		
		etTelMobile = new JTextField();
		etTelMobile.setBounds(569, 262, 126, 20);
		add(etTelMobile);
		etTelMobile.setColumns(10);
		
		JLabel lblTlFixe = new JLabel("T\u00E9l fixe :");
		lblTlFixe.setBounds(481, 234, 42, 14);
		add(lblTlFixe);
		
		etNum = new JTextField();
		etNum.setBounds(569, 91, 126, 20);
		add(etNum);
		etNum.setColumns(10);
		
		JLabel lblAdresseDeFacturation = new JLabel("Adresse de facturation :");
		lblAdresseDeFacturation.setBounds(538, 66, 117, 14);
		add(lblAdresseDeFacturation);
		
		panelBoutonValider = new PanelBoutonValider();
		panelBoutonValider.getBtnValider().setBounds(37, 33, 99, 23);
		panelBoutonValider.setBounds(74, 261, 163, 73);
		add(panelBoutonValider);
		panelBoutonValider.setLayout(null);
		
		JLabel lblTlMobile = new JLabel("T\u00E9l mobile :");
		lblTlMobile.setBounds(481, 265, 54, 14);
		add(lblTlMobile);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(481, 179, 25, 14);
		add(lblVille);
		
		JLabel lblCp = new JLabel("Code postal :");
		lblCp.setBounds(480, 154, 83, 14);
		add(lblCp);
		
		JLabel lblLibellVoie = new JLabel("Libell\u00E9 voie :");
		lblLibellVoie.setBounds(480, 119, 81, 14);
		add(lblLibellVoie);
		
		etTelFixe = new JTextField();
		etTelFixe.setBounds(569, 231, 126, 20);
		add(etTelFixe);
		etTelFixe.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(39, 119, 43, 14);
		add(lblPrnom);
		
		etNom = new JTextField();
		etNom.setBounds(104, 91, 86, 20);
		add(etNom);
		etNom.setColumns(10);
		
		etPrenom = new JTextField();
		etPrenom.setBounds(104, 116, 86, 20);
		add(etPrenom);
		etPrenom.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0 :");
		lblN.setBounds(481, 94, 19, 14);
		add(lblN);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(39, 231, 31, 14);
		add(lblEmail);
		
		etRue = new JTextField();
		etRue.setBounds(569, 122, 126, 20);
		add(etRue);
		etRue.setColumns(10);
		
		etVille = new JTextField();
		etVille.setBounds(569, 179, 126, 20);
		add(etVille);
		etVille.setColumns(10);
		
		etCp = new JTextField();
		etCp.setBounds(569, 151, 126, 20);
		add(etCp);
		etCp.setColumns(10);
		
		panelBoutonCommande = new PanelBoutonCommande();
		panelBoutonCommande.setBounds(534, 13, 180, 42);
		add(panelBoutonCommande);
		
		panelBoutonListeClients = new PanelBoutonRetourListeClients();
		panelBoutonListeClients.setBounds(406, 14, 117, 55);
		add(panelBoutonListeClients);

	}

	

	public JLabel getLblNumClient() {
		return lblNumClient;
	}

	public void setLblNumClient(JLabel lblNumClient) {
		this.lblNumClient = lblNumClient;
	}

	public JTextField getEtId() {
		return etId;
	}

	public void setEtId(JTextField etId) {
		this.etId = etId;
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

	public JTextField getEtEmail() {
		return etEmail;
	}

	public void setEtEmail(JTextField etEmail) {
		this.etEmail = etEmail;
	}

	public JTextField getEtNum() {
		return etNum;
	}

	public void setEtNum(JTextField etNum) {
		this.etNum = etNum;
	}

	public JTextField getEtRue() {
		return etRue;
	}

	public void setEtRue(JTextField etRue) {
		this.etRue = etRue;
	}

	public JTextField getEtCp() {
		return etCp;
	}

	public void setEtCp(JTextField etCp) {
		this.etCp = etCp;
	}

	public JTextField getEtVille() {
		return etVille;
	}

	public void setEtVille(JTextField etVille) {
		this.etVille = etVille;
	}

	public JTextField getEtTelFixe() {
		return etTelFixe;
	}

	public void setEtTelFixe(JTextField etTelFixe) {
		this.etTelFixe = etTelFixe;
	}

	public JTextField getEtTelMobile() {
		return etTelMobile;
	}

	public void setEtTelMobile(JTextField etTelMobile) {
		this.etTelMobile = etTelMobile;
	}

	public PanelBoutonValider getPanelBoutonValider() {
		return panelBoutonValider;
	}

	public void setPanelBoutonValider(PanelBoutonValider panelBoutonValider) {
		this.panelBoutonValider = panelBoutonValider;
	}



	public PanelBoutonCommande getPanelBoutonCommande() {
		return panelBoutonCommande;
	}



	public void setPanelBoutonCommande(PanelBoutonCommande panelBoutonCommande) {
		this.panelBoutonCommande = panelBoutonCommande;
	}



	public PanelBoutonRetourListeClients getPanelBoutonListeClients() {
		return panelBoutonListeClients;
	}



	public void setPanelBoutonListeClients(
			PanelBoutonRetourListeClients panelBoutonListeClients) {
		this.panelBoutonListeClients = panelBoutonListeClients;
	}
	
	
}
