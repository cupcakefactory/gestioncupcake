package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelBouton extends JPanel {
	private JButton btnCarteClient;

	/**
	 * Create the panel.
	 */
	public PanelBouton() {
		
		btnCarteClient = new JButton("Carte client");
		add(btnCarteClient);

	}

	public JButton getBtnCarteClient() {
		return btnCarteClient;
	}

	public void setBtnCarteClient(JButton btnCarteClient) {
		this.btnCarteClient = btnCarteClient;
	}

}
