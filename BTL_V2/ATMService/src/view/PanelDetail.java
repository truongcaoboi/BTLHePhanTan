package view;

import javax.swing.JPanel;

import control.Action;
import control.ChangePage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Account;
import model.Storage;

public class PanelDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDetail(JPanel parent,Account a) {
		Action.getAccount();
		setBounds(0, 0, 580, 376);
		setLayout(null);
		
		JLabel lblChiTitTi = new JLabel("Chi ti\u1EBFt t\u00E0i kho\u1EA3n");
		lblChiTitTi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiTitTi.setBounds(204, 31, 160, 37);
		add(lblChiTitTi);
		
		JLabel lblSTiKhon = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n: ");
		lblSTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTiKhon.setBounds(10, 109, 108, 27);
		add(lblSTiKhon);
		
		JLabel lblChSHu = new JLabel("Ch\u1EE7 s\u1EDF h\u1EEFu:");
		lblChSHu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChSHu.setBounds(10, 147, 108, 27);
		add(lblChSHu);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(10, 191, 108, 27);
		add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(10, 229, 108, 27);
		add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 273, 108, 27);
		add(lblEmail);
		
		JLabel lblSCmt = new JLabel("S\u1ED1 CMT:");
		lblSCmt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmt.setBounds(10, 311, 108, 27);
		add(lblSCmt);
		
		JLabel lblAccountNo = new JLabel(Storage.user.showAccountNo());
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccountNo.setBounds(128, 109, 154, 27);
		add(lblAccountNo);
		
		JLabel lblName = new JLabel(Storage.user.getFullName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(128, 147, 108, 27);
		add(lblName);
		
		JLabel lblAdd = new JLabel(Storage.user.getAddress());
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdd.setBounds(128, 191, 203, 27);
		add(lblAdd);
		
		JLabel lblPhone = new JLabel(Storage.user.getPhone());
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(128, 229, 108, 27);
		add(lblPhone);
		
		JLabel lblmail = new JLabel(Storage.user.getEmail());
		lblmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmail.setBounds(128, 273, 108, 27);
		add(lblmail);
		
		JLabel lblIden = new JLabel(Storage.user.getIden_no());
		lblIden.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIden.setBounds(128, 311, 108, 27);
		add(lblIden);
		
		JLabel lbl2Gen = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lbl2Gen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2Gen.setBounds(341, 109, 108, 27);
		add(lbl2Gen);
		
		JLabel lblGen = new JLabel(Storage.user.getGender());
		lblGen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGen.setBounds(449, 109, 121, 27);
		add(lblGen);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh:");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmSinh.setBounds(341, 147, 108, 27);
		add(lblNmSinh);
		
		JLabel lblBirth = new JLabel(Storage.user.getBirth());
		lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBirth.setBounds(449, 147, 121, 27);
		add(lblBirth);
		
		JLabel lblSD = new JLabel("S\u1ED1 d\u01B0:");
		lblSD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSD.setBounds(341, 191, 97, 27);
		add(lblSD);
		
		JLabel lblBal = new JLabel(Storage.user.getBalance()/1000+"");
		lblBal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBal.setBounds(449, 191, 121, 27);
		add(lblBal);
		
		JLabel lblnVNghn = new JLabel("(\u0110\u01A1n v\u1ECB ngh\u00ECn \u0111\u1ED3ng)");
		lblnVNghn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnVNghn.setBounds(341, 229, 185, 27);
		add(lblnVNghn);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.GoToMainPage(parent);
			}
		});
		btnNewButton.setBounds(411, 315, 89, 23);
		add(btnNewButton);
		setVisible(true);
	}

}
