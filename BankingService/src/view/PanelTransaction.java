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
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Mã hóa đơn", "Người thực hiện", "Người nhận", "Loại giao dịch", "Ngày giao dịch", "Số tiền", "Địa điểm giao dịch", "Trạng thái"
				}
			));
		}
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(113);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
}
