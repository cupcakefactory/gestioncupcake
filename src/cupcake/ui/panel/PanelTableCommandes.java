package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import cupcake.entity.Commande;
import cupcake.ui.model.ClientTableModel;
import cupcake.ui.model.CommandesTableModel;
import cupcake.ui.renderer.CenterTableCellRenderer;

import java.awt.GridLayout;
import java.util.ArrayList;

public class PanelTableCommandes extends JPanel {
	private JTable tableCommandes;
private ArrayList<Commande>cdes;
private CommandesTableModel model;
	/**
	 * Create the panel.
	 */
	public PanelTableCommandes() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		tableCommandes = new JTable();
		tableCommandes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableCommandes);
	this.model = null ;
		//insertion de la methode setCommandes();
		
	
	}
	
	public void setCommandes(ArrayList<Commande> cdes){
		try {
			model = new CommandesTableModel(cdes);
		} catch (Exception e) {

			e.printStackTrace();
		}
		tableCommandes.setModel(model);
		tableCommandes.getTableHeader().setReorderingAllowed(false);
		tableCommandes.setAutoCreateRowSorter(true);
		tableCommandes.setDefaultRenderer(Object.class, new CenterTableCellRenderer());
		tableCommandes.getColumnModel().getColumn(0).setCellRenderer(new CenterTableCellRenderer());
		tableCommandes.getColumnModel().getColumn(1).setCellRenderer(new CenterTableCellRenderer());
		tableCommandes.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTableCommandes() {
		return tableCommandes;
	}

	public void setTableCommandes(JTable tableCommandes) {
		this.tableCommandes = tableCommandes;
	}

}
