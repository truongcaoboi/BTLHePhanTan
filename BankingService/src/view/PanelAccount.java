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

import control.Action;
import control.Display;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.*;
import model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAccount extends JPanel {
	private JTextField txtSearch;
	private JTextField txtAmount;
	private JTextField txtSender;
	private JTable tableAccount;
	private JTable tableCard;
	private JTextField txtReceiver;

	/**
	 * Create the panel.
	 */
	public PanelAccount(Vector<Account> a) {
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
		Vector<Account> accs=Action.getAllAccount();
		
		if(a==null) {
			tableAccount.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null},
					},
					new String[] {
						"S\u1ED1 t\u00E0i kho\u1EA3n", "Ch\u1EE7 s\u1EDF h\u1EEFu", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 ch\u1EE9ng minh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "S\u1ED1 d\u01B0", "Tr\u1EA1ng th\u00E1i"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		}else {
			tableAccount.setModel(Display.ShowAccount(a));
		}
		
		tableAccount.getColumnModel().getColumn(0).setPreferredWidth(130);
		tableAccount.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableAccount.getColumnModel().getColumn(2).setPreferredWidth(210);
		tableAccount.getColumnModel().getColumn(3).setPreferredWidth(110);
		tableAccount.getColumnModel().getColumn(4).setPreferredWidth(110);
		tableAccount.getColumnModel().getColumn(5).setPreferredWidth(125);
		tableAccount.getColumnModel().getColumn(6).setPreferredWidth(100);
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
				"Số thẻ", "Số tài khoản", "Ngày tạo", "Loại", "Trạng thái"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCard.getColumnModel().getColumn(0).setPreferredWidth(140);
		tableCard.getColumnModel().getColumn(1).setPreferredWidth(110);
		tableCard.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableCard.setRowHeight(30);
		scrollPane_1.setViewportView(tableCard);
		
		JButton btnCloseCard = new JButton("Đóng");
		btnCloseCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCard.getSelectedRows().length==0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn thẻ để thao tác");
				}else {
					DefaultTableModel model=(DefaultTableModel)tableCard.getModel();
					for(int x:tableCard.getSelectedRows()) {
						String cardNo=model.getValueAt(x, 0).toString();
						if(Action.closeCard(cardNo).equals("success")) {
							model.setValueAt("Đóng", x, 4);
						}
					}
				}
			}
		});
		btnCloseCard.setBounds(885, 401, 89, 23);
		add(btnCloseCard);
		
		JButton btnOpenCard = new JButton("Mở");
		btnOpenCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCard.getSelectedRows().length==0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn thẻ để thao tác");
				}else {
					DefaultTableModel model=(DefaultTableModel)tableCard.getModel();
					for(int x:tableCard.getSelectedRows()) {
						String cardNo=model.getValueAt(x, 0).toString();
						if(Action.openCard(cardNo).equals("success")) {
							model.setValueAt("Hoạt động", x, 4);
						}
					}
				}
			}
		});
		btnOpenCard.setBounds(992, 401, 89, 23);
		add(btnOpenCard);
		
		JButton btnInsert1 = new JButton("Thêm thẻ chính");
		btnInsert1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=tableAccount.getSelectedRow();
				if(x==-1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản để thêm");
				}else {
					DefaultTableModel model=(DefaultTableModel)tableAccount.getModel();
					String stk=model.getValueAt(x, 0).toString();
					
					String card=Action.insertCard(stk, 1);
					if(!card.equals("")) {
						JOptionPane.showMessageDialog(null, "Đã tạo một thẻ chinh cho tài khoản \""+stk+"\" có mã số thẻ là \""+card+"\"");
						Vector<Card> cards=Action.getCardOfAccount(stk);
						tableCard.setModel(Display.showCardOfAccount(cards));
						tableCard.getColumnModel().getColumn(0).setPreferredWidth(140);
						tableCard.getColumnModel().getColumn(1).setPreferredWidth(110);
						tableCard.getColumnModel().getColumn(2).setPreferredWidth(90);
						tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
						tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
					}
				}	
			}
		});
		btnInsert1.setBounds(1091, 401, 140, 23);
		add(btnInsert1);
		
		JButton btnThmThPh = new JButton("Thêm thẻ phụ");
		btnThmThPh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=tableAccount.getSelectedRow();
				if(x==-1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản để thêm");
				}else {
					DefaultTableModel model=(DefaultTableModel)tableAccount.getModel();
					String stk=model.getValueAt(x, 0).toString();
					
					String card=Action.insertCard(stk, 0);
					if(!card.equals("")) {
						JOptionPane.showMessageDialog(null, "Đã tạo một thẻ phụ cho tài khoản \""+stk+"\" có mã số thẻ là \""+card+"\"");
						Vector<Card> cards=Action.getCardOfAccount(stk);
						tableCard.setModel(Display.showCardOfAccount(cards));
						tableCard.getColumnModel().getColumn(0).setPreferredWidth(140);
						tableCard.getColumnModel().getColumn(1).setPreferredWidth(110);
						tableCard.getColumnModel().getColumn(2).setPreferredWidth(90);
						tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
						tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
					}
				}	
			}
		});
		btnThmThPh.setBounds(1262, 401, 127, 23);
		add(btnThmThPh);
		
		JPanel panelParent = new JPanel();
		
		JButton btnCloseAccount = new JButton("Đóng");
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableAccount.getSelectedRows().length==0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản để đóng");
				}else {
					for(int x:tableAccount.getSelectedRows()) {
						DefaultTableModel model=(DefaultTableModel)tableAccount.getModel();
						String stk=model.getValueAt(x, 0).toString();
						if(Action.closeAccount(stk).equals("success")) {
							model.setValueAt("Đóng", x, 6);
						}
					}
				}
			}
		});
		btnCloseAccount.setBounds(27, 401, 89, 23);
		add(btnCloseAccount);
		
		JButton btnOpenAccount = new JButton("Mở");
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableAccount.getSelectedRows().length==0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản để mở");
				}else {
					for(int x:tableAccount.getSelectedRows()) {
						DefaultTableModel model=(DefaultTableModel)tableAccount.getModel();
						String stk=model.getValueAt(x, 0).toString();
						if(Action.openAccount(stk).equals("success")) {
							model.setValueAt("Hoạt động", x, 6);
						}
					}
				}
			}
		});
		btnOpenAccount.setBounds(131, 401, 89, 23);
		add(btnOpenAccount);
		
		JButton btnDetail = new JButton("Chi tiết");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=tableAccount.getSelectedRow();
				if(x==-1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản để mở");
				}else {
					DefaultTableModel model=(DefaultTableModel)tableAccount.getModel();
					String stk=model.getValueAt(x, 0).toString();
					Account a=Action.getAccount(stk);
					panelParent.removeAll();
					PanelShowDetail sd=new PanelShowDetail(a);
					sd.setBounds(0, 0, 838, 201);
					sd.setVisible(true);
					panelParent.add(sd);
					panelParent.revalidate();
					panelParent.repaint();
					
					Vector<Card> cards=Action.getCardOfAccount(stk);
					tableCard.setModel(Display.showCardOfAccount(cards));
					tableCard.getColumnModel().getColumn(0).setPreferredWidth(140);
					tableCard.getColumnModel().getColumn(1).setPreferredWidth(110);
					tableCard.getColumnModel().getColumn(2).setPreferredWidth(90);
					tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
					tableCard.getColumnModel().getColumn(3).setPreferredWidth(70);
				}	
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
		lblNewLabel_2.setBounds(898, 483, 66, 23);
		add(lblNewLabel_2);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(1003, 483, 249, 22);
		add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("(VNĐ)");
		lblNewLabel_3.setBounds(1272, 487, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Người gửi");
		lblNewLabel_4.setBounds(898, 530, 95, 14);
		add(lblNewLabel_4);
		
		txtSender = new JTextField();
		txtSender.setBounds(1003, 527, 249, 20);
		add(txtSender);
		txtSender.setColumns(10);
		
		JButton btnRutTien = new JButton("Rút tiền");
		btnRutTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = 0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ");
					return;
				}
				
				String sender=txtReceiver.getText();
				if(sender.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Không được để trống tài khoản người rút");
					return;
				}
				
				JOptionPane.showMessageDialog(null, Action.RutTien(Action.getCardOfAccount(sender).get(0).getCard_no(), amount));
			}
		});
		btnRutTien.setBounds(918, 605, 89, 23);
		add(btnRutTien);
		
		JButton btnNopTien = new JButton("Nộp tiền");
		btnNopTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = 0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ");
					return;
				}
				
				String sender=txtSender.getText();
				if(sender.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Không được để trống tài khoản người gửi");
					return;
				}
				
				JOptionPane.showMessageDialog(null, Action.NopTien(Action.getCardOfAccount(sender).get(0).getCard_no(), amount));
			}
		});
		btnNopTien.setBounds(1034, 605, 89, 23);
		add(btnNopTien);
		
		JButton btnChuyenTien = new JButton("Chuyển tiền");
		btnChuyenTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = 0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ");
					return;
				}
				
				String sender=txtSender.getText();
				if(sender.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Không được để trống tài khoản người gửi");
					return;
				}
				
				String receiver=txtReceiver.getText();
				if(sender.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Không được để trống tài khoản người nhận");
					return;
				}
				
				JOptionPane.showMessageDialog(null, Action.ChuyenTien(Action.getCardOfAccount(sender).get(0).getCard_no(), amount,receiver));
			}
		});
		btnChuyenTien.setBounds(1155, 605, 113, 23);
		add(btnChuyenTien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(875, 447, 2, 203);
		add(panel_2);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=tableAccount.getSelectedRow();
				if(x==-1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản thực hiện");
				}else {
					String stk=tableAccount.getModel().getValueAt(x, 0).toString();
					panelParent.removeAll();
					PanelUpdate sd=new PanelUpdate(stk);
					sd.setBounds(0, 0, 838, 201);
					sd.setVisible(true);
					panelParent.add(sd);
					panelParent.revalidate();
					panelParent.repaint();
				}
			}
		});
		btnUpdate.setBounds(447, 401, 103, 23);
		add(btnUpdate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo số tài khoản", "Tìm theo tên", "Tìm theo số điện thoại", "Tìm theo số chứng minh", "Tìm theo số thể"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(351, 22, 249, 36);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=txtSearch.getText();
				int type=comboBox.getSelectedIndex();
				Vector<Account> accounts=new Vector<Account>();
				accounts=Action.Search(str, type);
				if(accounts==null) {
					JOptionPane.showMessageDialog(null, "Không có tài khoản thỏa mãn yêu cầu");
					accounts=Action.getAllAccount();
				}
				tableAccount.setModel(Display.ShowAccount(accounts));
				tableAccount.getColumnModel().getColumn(0).setPreferredWidth(130);
				tableAccount.getColumnModel().getColumn(1).setPreferredWidth(160);
				tableAccount.getColumnModel().getColumn(2).setPreferredWidth(210);
				tableAccount.getColumnModel().getColumn(3).setPreferredWidth(110);
				tableAccount.getColumnModel().getColumn(4).setPreferredWidth(110);
				tableAccount.getColumnModel().getColumn(5).setPreferredWidth(125);
				tableAccount.getColumnModel().getColumn(6).setPreferredWidth(100);
				txtSearch.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(614, 22, 89, 36);
		add(btnNewButton);
		
		JLabel label = new JLabel("Người nhận");
		label.setBounds(898, 568, 95, 14);
		add(label);
		
		txtReceiver = new JTextField();
		txtReceiver.setColumns(10);
		txtReceiver.setBounds(1003, 565, 249, 20);
		add(txtReceiver);
		this.setVisible(true);
	}
}
