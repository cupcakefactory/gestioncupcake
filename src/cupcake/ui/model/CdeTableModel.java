package cupcake.ui.model;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import cupcake.entity.ArticleCde;
import cupcake.entity.Client;
import cupcake.entity.Commande;

public class CdeTableModel extends AbstractTableModel {

	private ArrayList<Object[]> data;
	private String[] headers = { "Référence", "Intitulé", "Quantité" };
	private ArrayList<ArticleCde> articlesCdes;

	public CdeTableModel(ArrayList<ArticleCde> articlesCdes) throws Exception {
		data = new ArrayList<Object[]>();
		this.articlesCdes = articlesCdes;
		

	}

	public void addRowCde(ArticleCde articleCde) throws IllegalArgumentException {
		if (articleCde == null) {
			throw new IllegalArgumentException("The row data cannot be null");
		}

		data.add(new Object[] { articleCde.getArticle().getReference(),
				articleCde.getArticle().getIntitule(), articleCde.getQuantite() });
		this.fireTableRowsInserted(data.size() - 1, data.size() - 1);
	}
	public void clearCde()
	{
		if ( data == null || ( data != null && data.size() == 0 ) )
		{
			return;
		}
		
		int size =getRowCount();
		data.clear();
		this.fireTableRowsDeleted(0, size - 1);
		
	}
	@Override
	public int getColumnCount() {

		return headers.length;
	}

	@Override
	public int getRowCount() {

		return data.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		if ( row > ( data.size() - 1 )  )
		{
			return null;
		}
		
		return data.get(row)[column];
	}

	

	@Override
	public String getColumnName(int arg0) {

		return headers[arg0];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		if (data.size() == 0)
		{
			return null;
		}
		
		return data.get(0)[columnIndex].getClass();
	}



}
