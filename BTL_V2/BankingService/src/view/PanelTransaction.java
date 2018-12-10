package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Display;

import java.util.*;
import model.Transaction;

public class PanelTransaction extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelTransaction(Vector<Transaction> tran) {
		//System.out.println(tran.size()+1);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1461, 661);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1441, 639);
		add(scrollPane);
		
		table = new JTable();
		if(tran!=null) {
			table.setModel(Display.showTransaction(tran));
		}else {
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u01B0\u1EDDi th\u1EF1c hi\u1EC7n", "S\u1ED1 t\u00E0i kho\u1EA3n", "Ng\u01B0\u1EDDi nh\u1EADn", "S\u1ED1 t\u00E0i kho\u1EA3n", "Lo\u1EA1i giao d\u1ECBch", "Ng\u00E0y giao d\u1ECBch", "S\u1ED1 ti\u1EC1n", "\u0110\u1ECBa \u0111i\u1EC3m giao d\u1ECBch", "Tr\u1EA1ng th\u00E1i"
				}
			));
		}
			table.getColumnModel().getColumn(0).setPreferredWidth(200);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(110);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(110);
			table.getColumnModel().getColumn(5).setPreferredWidth(110);
			table.getColumnModel().getColumn(6).setPreferredWidth(125);
			table.getColumnModel().getColumn(7).setPreferredWidth(120);
			table.getColumnModel().getColumn(8).setPreferredWidth(113);
			table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
}
