package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.Action;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUpdate extends JPanel {
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtName;

	/**
	 * Create the panel.
	 */
	public PanelUpdate(String stk) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 838, 201);
		setLayout(null);
		
		JLabel lblaChMi = new JLabel("\u0110\u1ECBa ch\u1EC9 m\u1EDBi");
		lblaChMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaChMi.setBounds(10, 11, 108, 33);
		add(lblaChMi);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i m\u1EDBi");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(10, 65, 154, 33);
		add(lblSinThoi);
		
		JLabel lblEmailMi = new JLabel("Email m\u1EDBi");
		lblEmailMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailMi.setBounds(10, 115, 108, 33);
		add(lblEmailMi);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(184, 11, 612, 33);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(184, 65, 212, 33);
		add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(184, 115, 612, 33);
		add(txtEmail);
		
		JButton btnHonTt = new JButton("Ho\u00E0n t\u1EA5t");
		btnHonTt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone=txtPhone.getText();
//				if(phone.trim().length()==0) {
//					JOptionPane.showMessageDialog(null, "không được để trống số điện thoại");
//					return;
//				}
				String email=txtEmail.getText();
				String address=txtAddress.getText();
//				if(address.trim().length()==0) {
//					JOptionPane.showMessageDialog(null, "không được để trống địa chỉ");
//					return;
//				}
				String name=txtName.getText();
				JOptionPane.showMessageDialog(null, Action.updateAccount(address, email, phone,name, stk));
			}
		});
		btnHonTt.setBounds(349, 159, 89, 23);
		add(btnHonTt);
		
		JLabel lblChSHu = new JLabel("Chủ sở hữu mới");
		lblChSHu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChSHu.setBounds(425, 65, 154, 33);
		add(lblChSHu);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(557, 65, 239, 33);
		add(txtName);
		this.setVisible(true);
	}
}
