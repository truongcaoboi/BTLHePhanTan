package control;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.*;
import model.*;

public class Display {
	public static DefaultTableModel ShowAccount(Vector<Account> accounts) {
		String [] column=new String[] {
				"Số tài khoản", "Chủ sở hữu", "Địa chỉ", "Số chứng minh", "Số điện thoại", "Số dư", "Trạng thái"
			};
		DefaultTableModel model=new DefaultTableModel(new Object[][] {},column);
		if(accounts!=null) {
			for(Account a:accounts) {
				String [] row= {a.getAccount_no(),a.getFullName(),a.getAddress(),a.getIden_no(),a.getPhone(),a.getBalance()+"",a.getSta()};
				model.addRow(row);
			}
		}
		return model;
	}
	
	public static DefaultTableModel showCardOfAccount(Vector<Card> cards) {
		String [] column= {"Số thẻ", "Số tài khoản", "Ngày tạo", "Loại", "Trạng thái"};
		DefaultTableModel model=new DefaultTableModel(new Object [][] {},column);
		for(Card c:cards) {
			String [] row= {c.getCard_no(),c.getAccount_no(),c.getDateCreate(),c.getType(),c.getSta()};
			model.addRow(row);
		}
		return model;
	}
	
	public static DefaultTableModel showTransaction(Vector<Transaction> tran) {
		System.out.println(tran.size());
		String [] column= {"Mã hóa đơn", "Người thực hiện", "Người nhận", "Loại giao dịch", "Ngày giao dịch", "Số tiền", "Địa điểm giao dịch", "Trạng thái"};
		DefaultTableModel model=new DefaultTableModel(new Object[][] {},column);
		for(Transaction t:tran) {
			String [] row= {t.getBill_no(),t.getNameFrom(),t.getNameTo(),t.getType(),t.getDateCreate(),t.getAmount()+"",t.getExchange_at(),t.getSta()};
			model.addRow(row);
		}
		return model;
	}
}
