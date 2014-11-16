package cupcake.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cupcake.entity.Client;
import cupcake.service.GestionClient;

public class ClientTableModel extends AbstractTableModel {
	
	private ArrayList<Object[]> data;
	private String[] headers = { "Numéro client", "Nom", "Prenom"
			 };
	private ArrayList<Client> clients;

	public ClientTableModel(ArrayList<Client> clients)
			throws Exception {		
		data = new ArrayList<Object[]>();
		this.clients = clients;
		
		
				  
				  
	}
	
	public void clear()
	{
		if (data.size()>0){
			int size = getRowCount();
			data.clear();
			this.fireTableRowsDeleted(0,size  - 1);
		}
	}
	
	public void addRow( Client client ) throws IllegalArgumentException 
	{
		if ( client == null )
		{
			throw new IllegalArgumentException( "The row data cannot be null" );
		}

		data.add(new Object[] { client.getId(), client.getNom(), client.getPrenom() } );
		this.fireTableRowsInserted( data.size() - 1, data.size() - 1);
	}



	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	public int getRowCount() {
		
		return data.size();
	}

	public Object getValueAt(int row, int column) {
		
		return data.get(row)[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return data.get(0)[columnIndex].getClass();
	}

	@Override
	public String getColumnName(int arg0) {

		return headers[arg0];
	}

}
