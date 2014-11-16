package cupcake.ui.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import cupcake.entity.Client;
import cupcake.entity.Commande;

public class CommandesTableModel extends AbstractTableModel {

	private Object[][] data;
	private String[] headers = { "N° commande", "Date", "Statut" };
	private ArrayList<Commande> commandes;

	
	public CommandesTableModel(ArrayList<Commande> commandes) throws Exception {
		data = new Object[commandes.size()][];
		this.commandes = commandes;
		for (int i = 0; i < commandes.size(); i++) {
			data[i] = commandes.get(i).toArray();

		}

	}

	@Override
	public int getColumnCount() {
		
		return headers.length;
	}

	@Override
	public int getRowCount() {
		
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int column ) {
		
		return data[row][column];
	}
	
	@Override
	public String getColumnName(int arg0) {
		
		return headers[arg0];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return data[0][columnIndex].getClass();
	}
}
