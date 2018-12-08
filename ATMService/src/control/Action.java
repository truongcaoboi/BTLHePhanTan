package control;

import model.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONObject;

public class Action {
	public static boolean checkLogin(String cardNo,String pass) {
		try {
			String request="16;{\"card_no\":\""+cardNo+"\",\"pass\":\""+pass+"\"}";
			Communication com=new Communication();
			com.SendRequest(request);
			String response=com.ReceiverResponse();
			if(!response.equals("failure")) {
				Storage.card_no=cardNo;
				Storage.pass=pass;
				JSONObject item=new JSONObject(response);
				Account a=new Account();
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
				Storage.user=a;
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void getAccount() {
		try {
			String request="2;"+Storage.user.getAccount_no();
			Communication com=new Communication();
			com.SendRequest(request);
			String response=com.ReceiverResponse();
			if(!response.equals("failure")) {
				JSONObject item=new JSONObject(response);
				Account a=new Account();
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
				Storage.user=a;
			}else {
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean changePass(String pass,String cardNo) {
		String request="17;{\"card_no\":\""+cardNo+"\",\"pass\":\""+pass+"\"}";
		Communication com=new Communication();
		com.SendRequest(request);
		String res=com.ReceiverResponse();
		if(res.equals("success")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean RutTien(String cardNo,double amount) {
		String request="12;{\"amount\":"+amount+",\"card_no\":\""+cardNo+"\",\"at\":\"ATM\"}";
		System.out.println(request);
		Communication com=new Communication();
		com.SendRequest(request);
		String response=com.ReceiverResponse();
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
		String response=com.ReceiverResponse();
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
		String res=com.ReceiverResponse();
		if(res.equals("empty")) {
			return false;
		}else {
			com=new Communication();
			com.SendRequest(request);
			String response=com.ReceiverResponse();
			if(response.equals("success")) {
				return true;
			}else {
				return false;
			}
		}
	}
}
