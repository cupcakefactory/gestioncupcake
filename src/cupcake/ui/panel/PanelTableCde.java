package cupcake.ui.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import cupcake.entity.ArticleCde;
import cupcake.ui.model.CdeTableModel;
import cupcake.ui.model.ClientTableModel;
import cupcake.ui.renderer.CenterTableCellRenderer;

import java.awt.GridLayout;
import java.util.ArrayList;

public class PanelTableCde extends JPanel {
	private JTable tableCde;

	/**
	 * Create the panel.
	 */
	public PanelTableCde(ArrayList<ArticleCde>articlesCdes) {
		setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		tableCde = new JTable();
		tableCde.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableCde);
		CdeTableModel model = null;
		try {
			model = new CdeTableModel(articlesCdes);
		} catch (Exception e) {

			e.printStackTrace();
		}
		tableCde.setModel(model);
		tableCde.getTableHeader().setReorderingAllowed(false);
		tableCde.setAutoCreateRowSorter(true);
		tableCde.setDefaultRenderer(Object.class, new CenterTableCellRenderer());
		tableCde.getColumnModel().getColumn(2).setCellRenderer(new CenterTableCellRenderer());
		
		tableCde.getTableHeader().setResizingAllowed(false);
	}
	

	public JTable getTable() {
		return tableCde;
	}

	public void setTable(JTable table) {
		this.tableCde = table;
	}

}
