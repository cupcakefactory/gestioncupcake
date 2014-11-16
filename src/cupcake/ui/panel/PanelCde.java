package cupcake.ui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PanelCde extends JPanel {
	private PanelInfosCde panelInfosCde;
	private PanelTableCde panelTableCde;
	private PanelMajCde panelMajCde;
	private PanelBoutonsRetour panelBoutonsRetour;

	/**
	 * Create the panel.
	 */
	public PanelCde() {
		setLayout(new BorderLayout(0, 0));
		
		panelInfosCde = new PanelInfosCde();
		add(panelInfosCde, BorderLayout.NORTH);
		
		panelTableCde = new PanelTableCde(null);
		add(panelTableCde, BorderLayout.CENTER);
		
		panelMajCde = new PanelMajCde();
		add(panelMajCde, BorderLayout.WEST);
		
		panelBoutonsRetour = new PanelBoutonsRetour();
		add(panelBoutonsRetour, BorderLayout.SOUTH);

	}

	public PanelInfosCde getPanelInfosCde() {
		return panelInfosCde;
	}

	public void setPanelInfosCde(PanelInfosCde panelInfosCde) {
		this.panelInfosCde = panelInfosCde;
	}

	public PanelTableCde getPanelTableCde() {
		return panelTableCde;
	}

	public void setPanelTableCde(PanelTableCde panelTableCde) {
		this.panelTableCde = panelTableCde;
	}

	public PanelMajCde getPanelMajCde() {
		return panelMajCde;
	}

	public void setPanelMajCde(PanelMajCde panelMajCde) {
		this.panelMajCde = panelMajCde;
	}

	public PanelBoutonsRetour getPanelBoutonsRetour() {
		return panelBoutonsRetour;
	}

	public void setPanelBoutonsRetour(PanelBoutonsRetour panelBoutonsRetour) {
		this.panelBoutonsRetour = panelBoutonsRetour;
	}

}
