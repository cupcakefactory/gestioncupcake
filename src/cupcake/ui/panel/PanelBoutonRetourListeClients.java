package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelBoutonRetourListeClients extends JPanel {
	private JButton btnListeClients;

	/**
	 * Create the panel.
	 */
	public PanelBoutonRetourListeClients() {
		
		btnListeClients = new JButton("Liste clients");
		add(btnListeClients);

	}

	public JButton getBtnListeClients() {
		return btnListeClients;
	}

	public void setBtnListeClients(JButton btnListeClients) {
		this.btnListeClients = btnListeClients;
	}

}
