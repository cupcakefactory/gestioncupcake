package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class PanelConsigne extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelConsigne() {
		
		JTextPane txtpnRcuperationDe = new JTextPane();
		txtpnRcuperationDe.setText("* R\u00E9cuperation de la commande en double cliquant sur la ligne correspondante");
		add(txtpnRcuperationDe);

	}

}
