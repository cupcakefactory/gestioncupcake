package cupcake.ui.panel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cupcake.entity.Client;
import cupcake.service.GestionClient;
import cupcake.ui.model.ClientTableModel;
import cupcake.ui.renderer.CenterTableCellRenderer;

import javax.swing.ListSelectionModel;

public class PanelTable extends JPanel {
	/**
	 * 
	 */

	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelTable(ArrayList<Client> clients) {

		setLayout(new GridLayout(1, 0, 0, 0));
		scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		ClientTableModel model = null;
		try {
			model = new ClientTableModel(clients);
		} catch (Exception e) {

			e.printStackTrace();
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoCreateRowSorter(false);
		table.setDefaultRenderer(Object.class, new CenterTableCellRenderer());
		table.getColumnModel().getColumn(0).setCellRenderer(new CenterTableCellRenderer());
		table.getTableHeader().setResizingAllowed(false);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
