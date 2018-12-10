package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Action;
import control.ChangePage;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel {
	private JTextField txtCardNo;
	private JPasswordField txtPass;

	/**
	 * Create the panel.
	 */
	public PanelLogin(JPanel parent) {
		setLayout(null);
		
		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblngNhp.setBounds(201, 49, 156, 39);
		add(lblngNhp);
		
		JLabel lblMSTh = new JLabel("Mã số thẻ:");
		lblMSTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMSTh.setBounds(99, 156, 106, 30);
		add(lblMSTh);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(99, 219, 106, 30);
		add(lblMtKhu);
		
		txtCardNo = new JTextField();
		txtCardNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCardNo.setBounds(215, 156, 253, 43);
		add(txtCardNo);
		txtCardNo.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(215, 219, 253, 39);
		add(txtPass);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String card_no=txtCardNo.getText();
				String pass=new String(txtPass.getPassword()).toString();
				if(Action.checkLogin(card_no, pass)) {
					ChangePage.GoToMainPage(parent);
				}else {
					JOptionPane.showMessageDialog(parent, "Mã số thẻ hoặc mật khẩu không hợp lệ", "Lõi đăng nhập", 1);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(215, 284, 156, 43);
		
		
		add(btnLogin);
		setBounds(0, 0, 580, 376);
		setVisible(true);

	}
}
