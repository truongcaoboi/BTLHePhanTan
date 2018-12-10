package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;

import control.Action;
import control.ChangePage;
import model.Storage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelChagePass extends JPanel {
	private JPasswordField txtNewPass;
	private JPasswordField txtConfirm;
	private JPasswordField txtOldPass;

	/**
	 * Create the panel.
	 */
	public PanelChagePass(JPanel parent) {
		setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lbliMtKhu = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		lbliMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbliMtKhu.setBounds(195, 49, 201, 53);
		add(lbliMtKhu);
		
		JLabel lblMtKhuMi = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi:");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhuMi.setBounds(57, 139, 112, 32);
		add(lblMtKhuMi);
		
		JLabel lblXcNhnMt = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u:");
		lblXcNhnMt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXcNhnMt.setBounds(57, 182, 158, 32);
		add(lblXcNhnMt);
		
		JLabel lblMtKhuC = new JLabel("M\u1EADt kh\u1EA9u c\u0169:");
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhuC.setBounds(57, 231, 112, 32);
		add(lblMtKhuC);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPass.setBounds(221, 139, 273, 32);
		add(txtNewPass);
		
		txtConfirm = new JPasswordField();
		txtConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirm.setBounds(221, 182, 273, 32);
		add(txtConfirm);
		
		txtOldPass = new JPasswordField();
		txtOldPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOldPass.setBounds(221, 231, 273, 32);
		add(txtOldPass);
		
		JButton btnThcHin = new JButton("Th\u1EF1c hi\u1EC7n");
		btnThcHin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=new String(txtNewPass.getPassword()).toString();
				String repass=new String(txtConfirm.getPassword()).toString();
				String oldpass=new String(txtOldPass.getPassword()).toString();
				if(pass.equals(repass)) {
					if(oldpass.equals(Storage.pass)) {
						if(Action.changePass(pass, Storage.card_no)) {
							JOptionPane.showMessageDialog(parent, "Đổi mật khẩu thành công");
						}else {
							JOptionPane.showMessageDialog(parent, "Đổi mật khẩu không thành công");
						}
					}else {
						JOptionPane.showMessageDialog(parent, "mật khẩu cũ không đúng");
					}
				}else {
					JOptionPane.showMessageDialog(parent, "mật khẩu xác nhận không đúng");
				}
			}
		});
		btnThcHin.setBounds(221, 290, 112, 23);
		add(btnThcHin);
		
		JButton btnTrV = new JButton("Tr\u1EDF v\u1EC1");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToMainPage(parent);
			}
		});
		btnTrV.setBounds(382, 290, 112, 23);
		add(btnTrV);
		setVisible(true);
	}

}
