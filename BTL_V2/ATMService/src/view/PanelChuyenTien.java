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

public class PanelChuyenTien extends JPanel {
	private JTextField txtAmount;
	private JTextField txtReceiver;

	/**
	 * Create the panel.
	 */
	public PanelChuyenTien(JPanel parent) {
		setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lblChuynTin = new JLabel("Chuy\u1EC3n ti\u1EC1n");
		lblChuynTin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblChuynTin.setBounds(195, 36, 180, 39);
		add(lblChuynTin);
		
		JLabel lblSTin = new JLabel("S\u1ED1 ti\u1EC1n (VN\u0110):");
		lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTin.setBounds(76, 110, 118, 39);
		add(lblSTin);
		
		JLabel lblSTiKhon = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n ng\u01B0\u1EDDi nh\u1EADn:");
		lblSTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTiKhon.setBounds(76, 171, 193, 28);
		add(lblSTiKhon);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setBounds(269, 110, 239, 39);
		add(txtAmount);
		txtAmount.setColumns(10);
		
		txtReceiver = new JTextField();
		txtReceiver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtReceiver.setColumns(10);
		txtReceiver.setBounds(269, 166, 239, 39);
		add(txtReceiver);
		
		JButton btnThcHin = new JButton("Th\u1EF1c hi\u1EC7n");
		btnThcHin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double amount=0;
				try {
					amount=Double.parseDouble(txtAmount.getText());
					if(amount%1000==0) {
						if(Action.ChuyenTien(Storage.card_no, amount, txtReceiver.getText())) {
							JOptionPane.showMessageDialog(parent, "Chuyển tiền thành công", "Thông báo", 1);
						}else {
							JOptionPane.showMessageDialog(parent, "Chuyển tiền không thành công", "Thông báo", 1);
						}
					}else {
						JOptionPane.showMessageDialog(parent, "Số tiền phải chia hết cho 1000");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(parent, "Số tiền nhập vào không hợp lệ", "Thông báo", 1);
				}
			}
		});
		btnThcHin.setBounds(269, 227, 106, 23);
		add(btnThcHin);
		
		JButton btnTrV = new JButton("Tr\u1EDF v\u1EC1");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToMainPage(parent);
			}
		});
		btnTrV.setBounds(269, 271, 106, 23);
		add(btnTrV);
		setVisible(true);
	}

}
