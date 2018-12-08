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

public class PanelNopTien extends JPanel {
	private JTextField txtAmount;

	/**
	 * Create the panel.
	 */
	public PanelNopTien(JPanel parent) {
		setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lblNpTin = new JLabel("N\u1ED9p ti\u1EC1n");
		lblNpTin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNpTin.setBounds(223, 40, 130, 39);
		add(lblNpTin);
		
		JLabel lblSTin = new JLabel("S\u1ED1 ti\u1EC1n:");
		lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTin.setBounds(82, 132, 84, 27);
		add(lblSTin);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setBounds(151, 126, 301, 39);
		add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblvn = new JLabel("(VN\u0110)");
		lblvn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblvn.setBounds(462, 132, 64, 27);
		add(lblvn);
		
		JButton btnNp = new JButton("N\u1ED9p");
		btnNp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount=0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
					if(amount%1000==0) {
						if(Action.NopTien(Storage.card_no, amount)) {
							JOptionPane.showMessageDialog(parent, "Nộp tiền thành công", "Thông báo", 1);
						}else {
							JOptionPane.showMessageDialog(parent, "Nộp tiền không thành công", "Thông báo", 1);
						}
					}else {
						JOptionPane.showMessageDialog(parent, "Số tiền phải chia hết cho 1000");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(parent, "Số tiền nhập vào không hợp lệ", "Thông báo", 1);
				}
			}
		});
		btnNp.setBounds(151, 198, 89, 23);
		add(btnNp);
		
		JButton btnTrV = new JButton("Tr\u1EDF v\u1EC1");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToMainPage(parent);
			}
		});
		btnTrV.setBounds(308, 198, 89, 23);
		add(btnTrV);
		setVisible(true);
	}

}
