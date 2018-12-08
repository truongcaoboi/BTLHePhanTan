package view;

import javax.swing.JPanel;

import control.ChangePage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Account;

public class PanelMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMain(JPanel parent) {
		this.setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWelcome.setBounds(215, 54, 164, 56);
		add(lblWelcome);
		
		JButton btnShowDetail = new JButton("Xem t\u00E0i kho\u1EA3n");
		btnShowDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToDetailPage(parent, new Account());
			}
		});
		btnShowDetail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShowDetail.setBounds(45, 141, 171, 56);
		add(btnShowDetail);
		
		JButton btnRut = new JButton("R\u00FAt ti\u1EC1n");
		btnRut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToRutTienPage(parent);
			}
		});
		btnRut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRut.setBounds(45, 219, 171, 56);
		add(btnRut);
		
		JButton btnChuyen = new JButton("Chuy\u1EC3n ti\u1EC1n");
		btnChuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToChuyenTienPage(parent);
			}
		});
		btnChuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChuyen.setBounds(45, 296, 171, 56);
		add(btnChuyen);
		
		JButton btnChangePass = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToChagePassPage(parent);
			}
		});
		btnChangePass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangePass.setBounds(357, 141, 171, 56);
		add(btnChangePass);
		
		JButton btnNop = new JButton("N\u1ED9p ti\u1EC1n");
		btnNop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToNopTienPage(parent);
			}
		});
		btnNop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNop.setBounds(357, 219, 171, 56);
		add(btnNop);
		
		JButton btnLogout = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.GoToLogPage(parent);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setBounds(357, 296, 171, 56);
		add(btnLogout);
		this.setVisible(true);
	}

}
