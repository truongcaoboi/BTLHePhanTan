package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelShowDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelShowDetail() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 838, 201);
		setLayout(null);
		
		JLabel lblSTiKhon = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblSTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTiKhon.setBounds(10, 24, 112, 24);
		add(lblSTiKhon);
		
		JLabel lblChSHu = new JLabel("Ch\u1EE7 s\u1EDF h\u1EEFu");
		lblChSHu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChSHu.setBounds(10, 59, 112, 24);
		add(lblChSHu);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmSinh.setBounds(10, 94, 112, 24);
		add(lblNmSinh);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(10, 129, 112, 24);
		add(lblaCh);
		
		JLabel lblAccountNo = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNo.setBounds(147, 24, 240, 24);
		add(lblAccountNo);
		
		JLabel lblFullName = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(147, 59, 240, 24);
		add(lblFullName);
		
		JLabel lblBirth = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirth.setBounds(147, 94, 240, 24);
		add(lblBirth);
		
		JLabel lblAddress = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(147, 129, 240, 24);
		add(lblAddress);
		
		JLabel lblSinThoi = new JLabel("S\u00F4 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(429, 24, 112, 24);
		add(lblSinThoi);
		
		JLabel lblNgyTo = new JLabel("Ng\u00E0y t\u1EA1o");
		lblNgyTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyTo.setBounds(429, 59, 112, 24);
		add(lblNgyTo);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiiTnh.setBounds(429, 94, 112, 24);
		add(lblGiiTnh);
		
		JLabel lblSChngMinh = new JLabel("S\u1ED1 ch\u1EE9ng minh");
		lblSChngMinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSChngMinh.setBounds(429, 129, 112, 24);
		add(lblSChngMinh);
		
		JLabel lblPhone = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(551, 24, 259, 24);
		add(lblPhone);
		
		JLabel lblDate_create = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblDate_create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate_create.setBounds(551, 59, 259, 24);
		add(lblDate_create);
		
		JLabel lblGender = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(551, 94, 259, 24);
		add(lblGender);
		
		JLabel lblIdenNo = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblIdenNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdenNo.setBounds(551, 129, 259, 24);
		add(lblIdenNo);
		
		JLabel lblEmailer = new JLabel("Email");
		lblEmailer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailer.setBounds(10, 164, 112, 24);
		add(lblEmailer);
		
		JLabel lblEmail = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(147, 164, 240, 24);
		add(lblEmail);
		
		JLabel lblTrngThi = new JLabel("Tr\u1EA1ng th\u00E1i");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrngThi.setBounds(429, 164, 112, 24);
		add(lblTrngThi);
		
		JLabel lblSta = new JLabel("S\u1ED1 t\u00E0i kho\u1EA3n");
		lblSta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSta.setBounds(551, 164, 259, 24);
		add(lblSta);
		this.setVisible(true);
	}
}
