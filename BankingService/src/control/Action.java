package control;
import model.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONObject;
public class Action {
	
	private static Account TranformJsonToAccount(String s) {
		Account a=null;
		try {
			JSONObject item=new JSONObject(s);
			a=new Account();
			a.setAccount_no(item.getString("accoun_no"));
			a.setAddress(item.getString("address"));
			a.setBalance(item.getDouble("balance"));
			a.setBirth(item.getString("birth"));
			SimpleDateFormat output=new SimpleDateFormat("dd/MM/Y");
			a.setDateCreate(output.parse(item.getString("date_create")));;
			a.setEmail(item.getString("email"));
			a.setFullName(item.getString("fullname"));
			a.setGender(item.getInt("gender"));
			a.setIden_no(item.getString("iden_no"));
			a.setPhone(item.getString("phone"));
			a.setSta(item.getInt("sta"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	private static Card TranformJsonToCard(String s) {
		Card c=null;
		try {
			JSONObject item=new JSONObject(s);
			c=new Card();
			c.setAccount_no(item.getString("accoun_no"));
			c.setCard_no(item.getString("card_no"));
			SimpleDateFormat output=new SimpleDateFormat("dd/MM/Y");
			c.setDateCreate(output.parse(item.getString("date_create")));
			c.setPass(item.getString("pass"));
			c.setSta(item.getInt("sta"));
			c.setType(item.getInt("type"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	private static Transaction TranformJsonToTransaction(String s) {
		Transaction t=null;
		try {
			JSONObject item=new JSONObject(s);
			t=new Transaction();
			t.setAccount_no(item.getString("account_no"));
			t.setAmount(item.getDouble("amount"));
			t.setBill_no(item.getString("bill_no"));
			t.setCard_no(item.getString("card_no"));
			SimpleDateFormat output=new SimpleDateFormat("dd/MM/Y");
			t.setDateCreate(output.parse(item.getString("date_create")));
			t.setExchange_at(item.getString("at"));
			//t.setId(item.getInt(key));
			t.setNameFrom(item.getString("nameFrom"));
			t.setNameTo(item.getString("nameTo"));
			t.setReceiver(item.getString("receiver"));
			t.setSta(item.getInt("sta"));
			t.setType(item.getInt("type"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public static Vector<Account> Search(String s,int k){
		Vector<Account> accounts=new Vector<Account>();
		try {
			String request="1;{\"s\":\""+s+"\",\"k\":"+k+"}";
			Communication com=new Communication();
			com.SendRequest(request);
			String res=com.ReceiveResponse();
			if(res.equals("empty")) {
				return null;
			}else {
				String [] array=res.split(";");
				Account a=null;
				for(String x:array) {
					a=TranformJsonToAccount(x);
					if(a!=null) {
						accounts.add(a);
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static Account getAccount(String stk) {
		Account a=null;
		try {
			String request="2;"+stk;
			Communication com=new Communication();
			com.SendRequest(request);
			String res=com.ReceiveResponse();
			if(res.equals("empty")) {
				return null;
			}else {
				a=TranformJsonToAccount(res);
			}
		}catch(Exception e) {
			
		}
		return a;
	}
	
	public static Vector<Account> getAllAccount(){
		Vector<Account> accounts=new Vector<Account>();
		try {
			String request="3;getAllAccount";
			Communication com=new Communication();
			com.SendRequest(request);
			String res=com.ReceiveResponse();
			if(res.equals("empty")) {
				return null;
			}else {
				String [] array=res.split(";");
				Account a=null;
				for(String x:array) {
					a=TranformJsonToAccount(x);
					if(a!=null) {
						accounts.add(a);
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public static String updateAccount(String address, String email, String phone, String stk) {
		String res="";
		try {
			String request="4;{\"address\":\""+address+"\",\"email\":\""+email+"\",\"phone\":\""+phone+"\",\"stk\":\""+stk+"\"}";
			Communication com=new Communication();
			com.SendRequest(request);
			res=com.ReceiveResponse();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static String closeAccount(String stk) {
		String res="";
		String request="5;"+stk;
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static String openAccount(String stk) {
		String res="";
		String request="6;"+stk;
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static String insertAccount(String add, double bal, String birth, String email, String name, int gen, String ide, String phone) {
		String res="";
		String request="7;{\"add\":\""+add+"\",\"bal\":"+bal+",\"birth\":\""+birth+"\",\"email\":\""+email+"\",\"name\":\""+name+"\",\"gen\":"+gen+",\"ide\":\""+ide+"\",\"phone\":\""+phone+"\"}";
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static String insertCard(String stk,int type) {
		String res="";
		String request="8;{\"stk\":\""+stk+"\",\"type\":"+type+"}";
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static String closeCard(String card) {
		String res="";
		String request="9;"+card;
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static String openCard(String card) {
		String res="";
		String request="10;"+card;
		Communication com=new Communication();
		com.SendRequest(request);
		res=com.ReceiveResponse();
		return res;
	}
	
	public static Vector<Transaction> getAllBill(){
		Vector<Transaction> bills=new Vector<Transaction>();
		try {
			String request="11;getAllBill";
			Communication com=new Communication();
			com.SendRequest(request);
			String res=com.ReceiveResponse();
			if(!res.equals("empty")) {
				String [] array=res.split(";");
				for(String x:array) {
					Transaction t=TranformJsonToTransaction(x);
					if(t!=null) {
						bills.add(t);
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bills;
	}
	
	public static boolean RutTien(String AccountNo,double amount) {
		String request="12;{\"amount\":"+amount+",\"account_no\":\""+AccountNo+"\",\"at\":\"ATM\"}";
		System.out.println(request);
		Communication com=new Communication();
		com.SendRequest(request);
		String response=com.ReceiveResponse();
		if(response.equals("success")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean NopTien(String cardNo,double amount) {
		String request="13;{\"amount\":"+amount+",\"card_no\":\""+cardNo+"\",\"at\":\"ATM\"}";
		Communication com=new Communication();
		com.SendRequest(request);
		String response=com.ReceiveResponse();
		if(response.equals("success")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean ChuyenTien(String cardNo,double amount,String receiver) {
		String request="14;{\"amount\":"+amount+",\"card_no\":\""+cardNo+"\",\"at\":\"ATM\",\"receiver\":\""+receiver+"\"}";
		Communication com=new Communication(); 
		com.SendRequest("2;"+receiver);
		String res=com.ReceiveResponse();
		if(res.equals("empty")) {
			return false;
		}else {
			com=new Communication();
			com.SendRequest(request);
			String response=com.ReceiveResponse();
			if(response.equals("success")) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static Vector<Card> getCardOfAccount(String stk){
		Vector<Card> cards=new Vector<Card>();
		try {
			String request="15;"+stk;
			Communication com=new Communication();
			com.SendRequest(request);
			String res=com.ReceiveResponse();
			if(!res.equals("empty")) {
				String []array=res.split(";");
				Card c=null;
				for(String x:array) {
					c=TranformJsonToCard(x);
					if(c!=null) {
						cards.add(c);
					}else {
						break;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cards;
	}
}
