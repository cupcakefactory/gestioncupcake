package cupcake.ui.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAdresseLivraison extends JPanel {
	private JTextField etInfosComplementaires;
	private JTextField etNom;
	private JTextField etPrenom;
	private JTextField etTelFixe;
	private JTextField etTelMobile;
	private JTextField etRue;
	private JTextField etNum;
	private JTextField etcp;
	private JTextField etVille;
	private PanelBoutonValider panelBoutonValider;
	private JTextField etNumCde;
	private JButton btnListeClients;
	private JButton btnCarteClient;
	private JButton btnCommande;
	private JLabel lblCodeporte;
	private JTextField etCodePorte;
	private JLabel lblEtage;
	private JTextField etEtage;
	private JButton btnListeCommande;

	/**
	 * Create the panel.
	 */
	public PanelAdresseLivraison() {
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 73, 46, 14);
		add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(10, 98, 55, 14);
		add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(441, 73, 60, 14);
		add(lblAdresse);
		
		JLabel lblLibellVoie = new JLabel("Libell\u00E9 voie :");
		lblLibellVoie.setBounds(365, 98, 78, 14);
		add(lblLibellVoie);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro :");
		lblNumro.setBounds(365, 123, 65, 14);
		add(lblNumro);
		
		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setBounds(365, 145, 88, 14);
		add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(365, 173, 99, 14);
		add(lblVille);
		
		JLabel lblTlFixe = new JLabel("T\u00E9l Fixe :");
		lblTlFixe.setBounds(6, 219, 59, 14);
		add(lblTlFixe);
		
		JLabel lblTlMobile = new JLabel("T\u00E9l mobile :");
		lblTlMobile.setBounds(6, 244, 65, 14);
		add(lblTlMobile);
		
		etInfosComplementaires = new JTextField();
		etInfosComplementaires.setBounds(387, 196, 189, 60);
		add(etInfosComplementaires);
		etInfosComplementaires.setColumns(10);
		
		JLabel lblInfosComplmentaires = new JLabel("Infos compl\u00E9mentaires :");
		lblInfosComplmentaires.setBounds(245, 200, 166, 14);
		add(lblInfosComplmentaires);
		
		etNom = new JTextField();
		etNom.setBounds(75, 70, 86, 20);
		add(etNom);
		etNom.setColumns(10);
		
		etPrenom = new JTextField();
		etPrenom.setBounds(75, 95, 86, 20);
		add(etPrenom);
		etPrenom.setColumns(10);
		
		etTelFixe = new JTextField();
		etTelFixe.setBounds(75, 210, 86, 20);
		add(etTelFixe);
		etTelFixe.setColumns(10);
		
		etTelMobile = new JTextField();
		etTelMobile.setBounds(75, 241, 86, 20);
		add(etTelMobile);
		etTelMobile.setColumns(10);
		
		etRue = new JTextField();
		etRue.setBounds(474, 95, 133, 20);
		add(etRue);
		etRue.setColumns(10);
		
		etNum = new JTextField();
		etNum.setBounds(474, 117, 133, 20);
		add(etNum);
		etNum.setColumns(10);
		
		etcp = new JTextField();
		etcp.setBounds(474, 142, 133, 20);
		add(etcp);
		etcp.setColumns(10);
		
		etVille = new JTextField();
		etVille.setBounds(474, 170, 133, 20);
		add(etVille);
		etVille.setColumns(10);
		
		panelBoutonValider = new PanelBoutonValider();
		panelBoutonValider.setBounds(25, 291, 113, 35);
		add(panelBoutonValider);
		
		JLabel lblNcommande = new JLabel("N\u00B0Commande :");
		lblNcommande.setBounds(39, 11, 113, 14);
		add(lblNcommande);
		
		etNumCde = new JTextField();
		etNumCde.setEditable(false);
		etNumCde.setBounds(129, 8, 86, 20);
		add(etNumCde);
		etNumCde.setColumns(10);
		
		btnListeCommande = new JButton("Liste commandes");
		btnListeCommande.setBounds(289, 281, 122, 23);
		add(btnListeCommande);
		
		btnListeClients = new JButton("Liste clients");
		btnListeClients.setBounds(148, 281, 113, 23);
		add(btnListeClients);
		
		btnCarteClient = new JButton("Carte Client");
		btnCarteClient.setBounds(148, 315, 113, 23);
		add(btnCarteClient);
		
		btnCommande = new JButton("Commande");
		btnCommande.setBounds(289, 315, 122, 23);
		add(btnCommande);
		
		lblCodeporte = new JLabel("codeporte :");
		lblCodeporte.setBounds(6, 123, 60, 14);
		add(lblCodeporte);
		
		etCodePorte = new JTextField();
		etCodePorte.setBounds(75, 123, 86, 20);
		add(etCodePorte);
		etCodePorte.setColumns(10);
		
		lblEtage = new JLabel("etage :");
		lblEtage.setBounds(10, 155, 60, 14);
		add(lblEtage);
		
		etEtage = new JTextField();
		etEtage.setBounds(75, 152, 86, 20);
		add(etEtage);
		etEtage.setColumns(10);

	}

	public JTextField getEtInfosComplementaires() {
		return etInfosComplementaires;
	}

	public void setEtInfosComplementaires(JTextField etInfosComplementaires) {
		this.etInfosComplementaires = etInfosComplementaires;
	}

	public JTextField getTextField() {
		return etNom;
	}

	public void setTextField(JTextField textField) {
		this.etNom = textField;
	}

	public JTextField getTextField_1() {
		return etPrenom;
	}

	public void setTextField_1(JTextField textField_1) {
		this.etPrenom = textField_1;
	}

	public JTextField getTextField_2() {
		return etTelFixe;
	}

	public void setTextField_2(JTextField textField_2) {
		this.etTelFixe = textField_2;
	}

	public JTextField getTextField_3() {
		return etTelMobile;
	}

	public void setTextField_3(JTextField textField_3) {
		this.etTelMobile = textField_3;
	}

	public JTextField getTextField_4() {
		return etRue;
	}

	public void setTextField_4(JTextField textField_4) {
		this.etRue = textField_4;
	}

	public JTextField getTextField_5() {
		return etNum;
	}

	public void setTextField_5(JTextField textField_5) {
		this.etNum = textField_5;
	}

	public JTextField getTextField_6() {
		return etcp;
	}

	public void setTextField_6(JTextField textField_6) {
		this.etcp = textField_6;
	}

	public JTextField getTextField_7() {
		return etVille;
	}

	public void setTextField_7(JTextField textField_7) {
		this.etVille = textField_7;
	}

	public PanelBoutonValider getPanelBoutonValider() {
		return panelBoutonValider;
	}

	public void setPanelBoutonValider(PanelBoutonValider panelBoutonValider) {
		this.panelBoutonValider = panelBoutonValider;
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

	public JTextField getEtRue() {
		return etRue;
	}

	public void setEtRue(JTextField etRue) {
		this.etRue = etRue;
	}

	public JTextField getEtNum() {
		return etNum;
	}

	public void setEtNum(JTextField etNum) {
		this.etNum = etNum;
	}

	public JTextField getEtcp() {
		return etcp;
	}

	public void setEtcp(JTextField etcp) {
		this.etcp = etcp;
	}

	public JTextField getEtVille() {
		return etVille;
	}

	public void setEtVille(JTextField etVille) {
		this.etVille = etVille;
	}

	public JTextField getEtNumCde() {
		return etNumCde;
	}

	public void setEtNumCde(JTextField etNumCde) {
		this.etNumCde = etNumCde;
	}

	public JButton getBtnListeClients() {
		return btnListeClients;
	}

	public void setBtnListeClients(JButton btnListeClients) {
		this.btnListeClients = btnListeClients;
	}

	public JButton getBtnCarteClient() {
		return btnCarteClient;
	}

	public void setBtnCarteClient(JButton btnCarteClient) {
		this.btnCarteClient = btnCarteClient;
	}

	public JButton getBtnCommande() {
		return btnCommande;
	}

	public void setBtnCommande(JButton btnCommande) {
		this.btnCommande = btnCommande;
	}

	public JTextField getEtCodePorte() {
		return etCodePorte;
	}

	public void setEtCodePorte(JTextField etCodePorte) {
		this.etCodePorte = etCodePorte;
	}

	public JTextField getEtEtage() {
		return etEtage;
	}

	public void setEtEtage(JTextField etEtage) {
		this.etEtage = etEtage;
	}

	public JButton getBtnListeCommande() {
		return btnListeCommande;
	}

	public void setBtnListeCommande(JButton btnListeCommande) {
		this.btnListeCommande = btnListeCommande;
	}
	
}
