package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import model.Account;
public class PanelShowDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelShowDetail(Account a) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 838, 201);
		setLayout(null);
		
		JLabel lblSTiKhon = new JLabel("Số tài khoản");
		lblSTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTiKhon.setBounds(10, 24, 112, 24);
		add(lblSTiKhon);
		
		JLabel lblChSHu = new JLabel("Chủ sở hữu");
		lblChSHu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChSHu.setBounds(10, 59, 112, 24);
		add(lblChSHu);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmSinh.setBounds(10, 94, 112, 24);
		add(lblNmSinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(10, 129, 112, 24);
		add(lblaCh);
		
		JLabel lblAccountNo = new JLabel(a.showAccountNo());
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNo.setBounds(147, 24, 240, 24);
		add(lblAccountNo);
		
		JLabel lblFullName = new JLabel(a.getFullName());
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(147, 59, 240, 24);
		add(lblFullName);
		
		JLabel lblBirth = new JLabel(a.getBirth());
		lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirth.setBounds(147, 94, 240, 24);
		add(lblBirth);
		
		JLabel lblAddress = new JLabel(a.getAddress());
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(147, 129, 240, 24);
		add(lblAddress);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(429, 24, 112, 24);
		add(lblSinThoi);
		
		JLabel lblNgyTo = new JLabel("Ngày tạo");
		lblNgyTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyTo.setBounds(429, 59, 112, 24);
		add(lblNgyTo);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiiTnh.setBounds(429, 94, 112, 24);
		add(lblGiiTnh);
		
		JLabel lblSChngMinh = new JLabel("Số chứng minh");
		lblSChngMinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSChngMinh.setBounds(429, 129, 112, 24);
		add(lblSChngMinh);
		
		JLabel lblPhone = new JLabel(a.getPhone());
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(551, 24, 259, 24);
		add(lblPhone);
		
		JLabel lblDate_create = new JLabel(a.getDateCreate());
		lblDate_create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate_create.setBounds(551, 59, 259, 24);
		add(lblDate_create);
		
		JLabel lblGender = new JLabel(a.getGender());
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(551, 94, 259, 24);
		add(lblGender);
		
		JLabel lblIdenNo = new JLabel(a.getIden_no());
		lblIdenNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdenNo.setBounds(551, 129, 259, 24);
		add(lblIdenNo);
		
		JLabel lblEmailer = new JLabel("Email");
		lblEmailer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailer.setBounds(10, 164, 112, 24);
		add(lblEmailer);
		
		JLabel lblEmail = new JLabel(a.getEmail());
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(147, 164, 240, 24);
		add(lblEmail);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrngThi.setBounds(429, 164, 112, 24);
		add(lblTrngThi);
		
		JLabel lblSta = new JLabel(a.getSta());
		lblSta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSta.setBounds(551, 164, 259, 24);
		add(lblSta);
		this.setVisible(true);
	}
}
