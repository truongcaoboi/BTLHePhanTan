package view;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Communication;

import javax.swing.JLabel;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtmMinibank = new JLabel("ATM MINIBank");
		lblAtmMinibank.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAtmMinibank.setBounds(192, 37, 232, 59);
		contentPane.add(lblAtmMinibank);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(10, 108, 580, 376);
		panelParent.setLayout(null);
		PanelLogin plog=new PanelLogin(panelParent);
		plog.setBounds(0, 0, 580, 376);
		plog.setVisible(true);
		panelParent.add(plog);
		contentPane.add(panelParent);
		
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
