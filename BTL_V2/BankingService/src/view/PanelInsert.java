package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.Action;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInsert extends JPanel {
	private JTextField txtName;
	private JTextField txtBirth;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtIdenNo;
	private JTextField txtAmount;

	/**
	 * Create the panel.
	 */
	public PanelInsert() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 838, 201);
		setLayout(null);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHTn.setBounds(10, 11, 70, 22);
		add(lblHTn);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmSinh.setBounds(10, 44, 70, 22);
		add(lblNmSinh);
		
		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinThoi.setBounds(10, 77, 70, 22);
		add(lblinThoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 110, 70, 22);
		add(lblEmail);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiiTnh.setBounds(419, 11, 70, 22);
		add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(419, 44, 70, 22);
		add(lblaCh);
		
		JLabel lblSChngMinh = new JLabel("S\u1ED1 ch\u1EE9ng minh");
		lblSChngMinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSChngMinh.setBounds(419, 77, 114, 22);
		add(lblSChngMinh);
		
		JLabel lblSTin = new JLabel("S\u1ED1 ti\u1EC1n");
		lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTin.setBounds(419, 110, 70, 22);
		add(lblSTin);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setBounds(91, 11, 264, 22);
		add(txtName);
		txtName.setColumns(10);
		
		txtBirth = new JTextField();
		txtBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBirth.setColumns(10);
		txtBirth.setBounds(91, 47, 264, 22);
		add(txtBirth);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPhone.setColumns(10);
		txtPhone.setBounds(91, 80, 264, 22);
		add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(91, 113, 264, 22);
		add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(530, 47, 264, 22);
		add(txtAddress);
		
		txtIdenNo = new JTextField();
		txtIdenNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIdenNo.setColumns(10);
		txtIdenNo.setBounds(530, 80, 264, 22);
		add(txtIdenNo);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAmount.setColumns(10);
		txtAmount.setBounds(530, 113, 264, 22);
		add(txtAmount);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"N\u1EEF", "Nam"}));
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbGender.setBounds(530, 11, 264, 22);
		add(cbGender);
		
		JButton btnThm = new JButton("Ho\u00E0n t\u1EA5t");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				if(name.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "không được để trống họ tên");
					return;
				}
				String birth=txtBirth.getText();
				if(birth.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "không được để trống năm sinh");
					return;
				}
				String phone=txtPhone.getText();
				if(phone.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "không được để trống số điện thoại");
					return;
				}
				String email=txtEmail.getText();
				String address=txtAddress.getText();
				if(address.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "không được để trống địa chỉ");
					return;
				}
				String idenNo=txtIdenNo.getText();
				if(idenNo.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "không được để trống số chứng minh");
					return;
				}
				String amount=txtAmount.getText();
				double am=0;
				try {
					am=Double.parseDouble(amount);
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Số tiền nhập vào không hợp lệ");
				}
				int gender=cbGender.getSelectedIndex();
				JOptionPane.showMessageDialog(null, Action.insertAccount(address, am, birth, email, name, gender, idenNo, phone));
			}
		});
		btnThm.setBounds(328, 167, 89, 23);
		add(btnThm);
		this.setVisible(true);
	}
}
