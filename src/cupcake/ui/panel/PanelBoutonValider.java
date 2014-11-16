package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelBoutonValider extends JPanel {
	private JButton btnValider;

	/**
	 * Create the panel.
	 */
	public PanelBoutonValider() {
		
		btnValider = new JButton("Valider");
		add(btnValider);

	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}
	
	

}
