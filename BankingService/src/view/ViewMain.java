package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Communication;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain frame = new ViewMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewMain() {
		this.setTitle("Mini Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1526, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelParent.setBounds(25, 84, 1461, 661);
		PanelAccount a=new PanelAccount();
		a.setBounds(0,0,1461,661);
		a.setVisible(true);
		panelParent.add(a);
		contentPane.add(panelParent);
		panelParent.setLayout(null);
		
		JButton btnTransaction = new JButton("Giao dịch");
		
		JButton btnAccount = new JButton("Tài khoản");
		btnAccount.setEnabled(false);
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelParent.removeAll();
				PanelAccount a=new PanelAccount();
				a.setBounds(0,0,1461,661);
				a.setVisible(true);
				panelParent.add(a);
				panelParent.revalidate();
				panelParent.repaint();
				btnAccount.setEnabled(false);
				btnTransaction.setEnabled(true);
			}
		});
		btnAccount.setBounds(25, 33, 154, 51);
		contentPane.add(btnAccount);
		
		
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				panelParent.removeAll();
				PanelTransaction t=new PanelTransaction();
				t.setBounds(0, 0, 1461, 661);
				t.setVisible(true);
				panelParent.add(t);
				panelParent.revalidate();
				panelParent.repaint();
				btnTransaction.setEnabled(false);
				btnAccount.setEnabled(true);
			}
		});
		btnTransaction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTransaction.setBounds(181, 33, 154, 51);
		contentPane.add(btnTransaction);
		
		
		try {
			File file=new File("config.txt");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			Communication.host=reader.readLine().split(":")[1];
			Communication.port=Integer.parseInt(reader.readLine().split(":")[1]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
