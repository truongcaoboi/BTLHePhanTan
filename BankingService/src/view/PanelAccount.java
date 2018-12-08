package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelAccount extends JPanel {
	private JTextField txtSearch;
	private JTextField txtAmount;
	private JTextField txtReceiver;
	private JTable tableAccount;
	private JTable tableCard;

	/**
	 * Create the panel.
	 */
	public PanelAccount() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1461, 661);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00ECm ki\u1EBFm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 22, 78, 36);
		add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearch.setBounds(127, 22, 214, 36);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 72, 838, 308);
		add(scrollPane);
		
		tableAccount = new JTable();
		tableAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableAccount.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 t\u00E0i kho\u1EA3n", "Ch\u1EE7 s\u1EDF h\u1EEFu", "\u0110\u1ECBa ch\u1EC9", "S\u00F4 ch\u1EE9ng minh", "S\u1ED1 d\u01B0", "Tr\u1EA1ng th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableAccount.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableAccount.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableAccount.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableAccount.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableAccount.getColumnModel().getColumn(4).setPreferredWidth(110);
		tableAccount.getColumnModel().getColumn(5).setPreferredWidth(90);
		tableAccount.setRowHeight(30);
		scrollPane.setViewportView(tableAccount);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(875, 72, 556, 308);
		add(scrollPane_1);
		
		tableCard = new JTable();
		tableCard.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 th\u1EBB", "S\u1ED1 t\u00E0i kho\u1EA3n", "Ng\u00E0y t\u1EA1o", "Lo\u1EA1i th\u1EBB", "Tr\u1EA1ng th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCard.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableCard.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableCard.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableCard.getColumnModel().getColumn(3).setPreferredWidth(79);
		tableCard.setRowHeight(30);
		scrollPane_1.setViewportView(tableCard);
		
		JButton btnCloseCard = new JButton("Đóng");
		btnCloseCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Đóng thẻ");
			}
		});
		btnCloseCard.setBounds(885, 401, 89, 23);
		add(btnCloseCard);
		
		JButton btnOpenCard = new JButton("Mở");
		btnOpenCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mở thẻ");
			}
		});
		btnOpenCard.setBounds(992, 401, 89, 23);
		add(btnOpenCard);
		
		JButton btnInsert1 = new JButton("Thêm thẻ chính");
		btnInsert1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thêm thẻ chính");
			}
		});
		btnInsert1.setBounds(1091, 401, 140, 23);
		add(btnInsert1);
		
		JButton btnThmThPh = new JButton("Thêm thẻ phụ");
		btnThmThPh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thêm thẻ phụ");
			}
		});
		btnThmThPh.setBounds(1262, 401, 127, 23);
		add(btnThmThPh);
		
		JPanel panelParent = new JPanel();
		
		JButton btnCloseAccount = new JButton("Đóng");
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Đóng tài khoản");
			}
		});
		btnCloseAccount.setBounds(27, 401, 89, 23);
		add(btnCloseAccount);
		
		JButton btnOpenAccount = new JButton("Mở");
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mở tài khoản tài khoản");
			}
		});
		btnOpenAccount.setBounds(131, 401, 89, 23);
		add(btnOpenAccount);
		
		JButton btnDetail = new JButton("Chi tiết");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelParent.removeAll();
				PanelShowDetail sd=new PanelShowDetail();
				sd.setBounds(0, 0, 838, 201);
				sd.setVisible(true);
				panelParent.add(sd);
				panelParent.revalidate();
				panelParent.repaint();
			}
		});
		btnDetail.setBounds(230, 401, 89, 23);
		add(btnDetail);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(875, 435, 556, 3);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(27, 435, 838, 3);
		add(panel_1);
		
		JButton btnInsertAccount = new JButton("Thêm mới");
		btnInsertAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelParent.removeAll();
				PanelInsert sd=new PanelInsert();
				sd.setBounds(0, 0, 838, 201);
				sd.setVisible(true);
				panelParent.add(sd);
				panelParent.revalidate();
				panelParent.repaint();
			}
		});
		btnInsertAccount.setBounds(329, 401, 103, 23);
		add(btnInsertAccount);
		
		JLabel lblNewLabel_1 = new JLabel("Giao dịch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(898, 449, 76, 23);
		add(lblNewLabel_1);
		
		
		panelParent.setBounds(27, 449, 838, 201);
		add(panelParent);
		panelParent.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Số tiền");
		lblNewLabel_2.setBounds(894, 483, 66, 23);
		add(lblNewLabel_2);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(1003, 483, 249, 22);
		add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("(VNĐ)");
		lblNewLabel_3.setBounds(1272, 487, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Người nhận");
		lblNewLabel_4.setBounds(898, 530, 95, 14);
		add(lblNewLabel_4);
		
		txtReceiver = new JTextField();
		txtReceiver.setBounds(1003, 527, 249, 20);
		add(txtReceiver);
		txtReceiver.setColumns(10);
		
		JButton btnRutTien = new JButton("Rút tiền");
		btnRutTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Rút tiền");
			}
		});
		btnRutTien.setBounds(918, 574, 89, 23);
		add(btnRutTien);
		
		JButton btnNopTien = new JButton("Nộp tiền");
		btnNopTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nộp tiền");
			}
		});
		btnNopTien.setBounds(1033, 574, 89, 23);
		add(btnNopTien);
		
		JButton btnChuyenTien = new JButton("Chuyển tiền");
		btnChuyenTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chuyển tiền");
			}
		});
		btnChuyenTien.setBounds(1153, 574, 113, 23);
		add(btnChuyenTien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(875, 447, 2, 203);
		add(panel_2);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelParent.removeAll();
				PanelUpdate sd=new PanelUpdate();
				sd.setBounds(0, 0, 838, 201);
				sd.setVisible(true);
				panelParent.add(sd);
				panelParent.revalidate();
				panelParent.repaint();
			}
		});
		btnUpdate.setBounds(447, 401, 103, 23);
		add(btnUpdate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo tên", "Tìm theo số tài khoản", "Tìm theo số thẻ", "Tìm theo số chứng minh"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(351, 22, 249, 36);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tìm");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(614, 22, 89, 36);
		add(btnNewButton);
		this.setVisible(true);
	}
}
