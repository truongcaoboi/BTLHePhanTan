package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Action;
import control.ChangePage;
import model.Storage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRutTien extends JPanel {
	private JTextField txtAmount;

	/**
	 * Create the panel.
	 */
	public PanelRutTien(JPanel parent) {
		setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lblRtTin = new JLabel("R\u00FAt ti\u1EC1n");
		lblRtTin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRtTin.setBounds(238, 28, 122, 39);
		add(lblRtTin);
		
		JLabel lblSTinMun = new JLabel("S\u1ED1 ti\u1EC1n:");
		lblSTinMun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTinMun.setBounds(107, 112, 68, 31);
		add(lblSTinMun);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setBounds(197, 112, 239, 31);
		add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblvn = new JLabel("(VN\u0110)");
		lblvn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblvn.setBounds(446, 112, 68, 31);
		add(lblvn);
		
		JButton btnRt = new JButton("R\u00FAt");
		btnRt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount=0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
					if(amount%1000==0) {
						if(Action.RutTien(Storage.card_no, amount)) {
							JOptionPane.showMessageDialog(parent, "Rút tiền thành công", "Thông báo", 1);
						}else {
							JOptionPane.showMessageDialog(parent, "Rút tiền không thành công", "Thông báo", 1);
						}
					}else {
						JOptionPane.showMessageDialog(parent, "Số tiền phải chia hết cho 1000");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(parent, "Số tiền nhập vào không hợp lệ", "Thông báo", 1);
				}
			}
		});
		btnRt.setBounds(250, 154, 89, 23);
		add(btnRt);
		
		JButton btnvn = new JButton("100,000 (VN\u0110)");
		btnvn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("100000");
			}
		});
		btnvn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn.setBounds(60, 199, 171, 39);
		add(btnvn);
		
		JButton btnvn_1 = new JButton("200,000 (VN\u0110)");
		btnvn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("200000");
			}
		});
		btnvn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn_1.setBounds(60, 249, 171, 39);
		add(btnvn_1);
		
		JButton btnvn_2 = new JButton("500,000 (VN\u0110)");
		btnvn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("500000");
			}
		});
		btnvn_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn_2.setBounds(60, 299, 171, 39);
		add(btnvn_2);
		
		JButton btnvn_3 = new JButton("1,000,000(VN\u0110)");
		btnvn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("1000000");
			}
		});
		btnvn_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn_3.setBounds(355, 199, 171, 39);
		add(btnvn_3);
		
		JButton btnvn_4 = new JButton("2,000,000(VN\u0110)");
		btnvn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("2000000");
			}
		});
		btnvn_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn_4.setBounds(355, 249, 171, 39);
		add(btnvn_4);
		
		JButton btnvn_5 = new JButton("5,000,000(VN\u0110)");
		btnvn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAmount.setText("5000000");
			}
		});
		btnvn_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnvn_5.setBounds(355, 299, 171, 39);
		add(btnvn_5);
		
		JButton btnTrV = new JButton("Tr\u1EDF v\u1EC1");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToMainPage(parent);
			}
		});
		btnTrV.setBounds(250, 319, 89, 23);
		add(btnTrV);
		setVisible(true);
	}

}
