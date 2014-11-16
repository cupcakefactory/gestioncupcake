package cupcake.ui.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class PanelMajCde extends JPanel {
	private JComboBox comboReference;
	private JSpinner spinnerQuantite;
	private JButton btnValider;
	private JButton btnAjouterArticle;
	private JButton btnSupprimerArticle;
	private JButton btnModifierStatut;
	private JButton btnDateDeLivraison;

	/**
	 * Create the panel.
	 */
	public PanelMajCde() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 68, 187, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRference = new JLabel("R\u00E9ference :");
		GridBagConstraints gbc_lblRference = new GridBagConstraints();
		gbc_lblRference.insets = new Insets(0, 0, 5, 5);
		gbc_lblRference.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRference.gridx = 2;
		gbc_lblRference.gridy = 0;
		add(lblRference, gbc_lblRference);
		
		comboReference = new JComboBox();
		GridBagConstraints gbc_comboReference = new GridBagConstraints();
		gbc_comboReference.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboReference.insets = new Insets(0, 0, 5, 0);
		gbc_comboReference.gridx = 3;
		gbc_comboReference.gridy = 0;
		add(comboReference, gbc_comboReference);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		GridBagConstraints gbc_lblQuantit = new GridBagConstraints();
		gbc_lblQuantit.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantit.gridx = 2;
		gbc_lblQuantit.gridy = 1;
		add(lblQuantit, gbc_lblQuantit);
		
		spinnerQuantite = new JSpinner();
		GridBagConstraints gbc_spinnerQuantite = new GridBagConstraints();
		gbc_spinnerQuantite.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerQuantite.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerQuantite.gridx = 3;
		gbc_spinnerQuantite.gridy = 1;
		add(spinnerQuantite, gbc_spinnerQuantite);
		
		btnValider = new JButton("Modifier article");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValider.insets = new Insets(0, 0, 5, 0);
		gbc_btnValider.gridx = 3;
		gbc_btnValider.gridy = 2;
		add(btnValider, gbc_btnValider);
		
		btnAjouterArticle = new JButton("Ajouter article");
		GridBagConstraints gbc_btnAjouterArticle = new GridBagConstraints();
		gbc_btnAjouterArticle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouterArticle.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouterArticle.gridx = 3;
		gbc_btnAjouterArticle.gridy = 3;
		add(btnAjouterArticle, gbc_btnAjouterArticle);
		
		btnSupprimerArticle = new JButton("Supprimer article");
		GridBagConstraints gbc_btnSupprimerArticle = new GridBagConstraints();
		gbc_btnSupprimerArticle.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerArticle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimerArticle.gridx = 3;
		gbc_btnSupprimerArticle.gridy = 4;
		add(btnSupprimerArticle, gbc_btnSupprimerArticle);
		
		btnModifierStatut = new JButton("Modifier statut");
		GridBagConstraints gbc_btnModifierStatut = new GridBagConstraints();
		gbc_btnModifierStatut.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifierStatut.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifierStatut.gridx = 3;
		gbc_btnModifierStatut.gridy = 5;
		add(btnModifierStatut, gbc_btnModifierStatut);
		
		btnDateDeLivraison = new JButton("Date de livraison");
		GridBagConstraints gbc_btnDateDeLivraison = new GridBagConstraints();
		gbc_btnDateDeLivraison.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDateDeLivraison.gridx = 3;
		gbc_btnDateDeLivraison.gridy = 6;
		add(btnDateDeLivraison, gbc_btnDateDeLivraison);

	}

	public JComboBox getComboReference() {
		return comboReference;
	}

	public void setComboReference(JComboBox comboReference) {
		this.comboReference = comboReference;
	}

	public JSpinner getSpinnerQuantite() {
		return spinnerQuantite;
	}

	public void setSpinnerQuantite(JSpinner spinnerQuantite) {
		this.spinnerQuantite = spinnerQuantite;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}

	public JButton getBtnAjouterArticle() {
		return btnAjouterArticle;
	}

	public void setBtnAjouterArticle(JButton btnAjouterArticle) {
		this.btnAjouterArticle = btnAjouterArticle;
	}

	public JButton getBtnSupprimerArticle() {
		return btnSupprimerArticle;
	}

	public void setBtnSupprimerArticle(JButton btnSupprimerArticle) {
		this.btnSupprimerArticle = btnSupprimerArticle;
	}

	public JButton getBtnModifierStatut() {
		return btnModifierStatut;
	}

	public void setBtnModifierStatut(JButton btnModifierStatut) {
		this.btnModifierStatut = btnModifierStatut;
	}

	

}
