package control;

import javax.swing.JPanel;
import view.*;
import model.*;

public class ChangePage {
	public static void GoToMainPage(JPanel parent) {
		parent.removeAll();
		PanelMain pmain=new PanelMain(parent);
		pmain.setBounds(0, 0, 580, 376);
		pmain.setVisible(true);
		parent.add(pmain);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToLogPage(JPanel parent) {
		parent.removeAll();
		PanelLogin plog=new PanelLogin(parent);
		plog.setBounds(0, 0, 580, 376);
		plog.setVisible(true);
		parent.add(plog);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToDetailPage(JPanel parent,Account a) {
		parent.removeAll();
		PanelDetail pdet=new PanelDetail(parent,a);
		pdet.setBounds(0, 0, 580, 376);
		pdet.setVisible(true);
		parent.add(pdet);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToChagePassPage(JPanel parent) {
		parent.removeAll();
		PanelChagePass pch=new PanelChagePass(parent);
		pch.setBounds(0, 0, 580, 376);
		pch.setVisible(true);
		parent.add(pch);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToChuyenTienPage(JPanel parent) {
		parent.removeAll();
		PanelChuyenTien pdet=new PanelChuyenTien(parent);
		pdet.setBounds(0, 0, 580, 376);
		pdet.setVisible(true);
		parent.add(pdet);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToNopTienPage(JPanel parent) {
		parent.removeAll();
		PanelNopTien pdet=new PanelNopTien(parent);
		pdet.setBounds(0, 0, 580, 376);
		pdet.setVisible(true);
		parent.add(pdet);
		parent.revalidate();
		parent.repaint();
	}
	
	public static void GoToRutTienPage(JPanel parent) {
		parent.removeAll();
		PanelRutTien pdet=new PanelRutTien(parent);
		pdet.setBounds(0, 0, 580, 376);
		pdet.setVisible(true);
		parent.add(pdet);
		parent.revalidate();
		parent.repaint();
	}
}
