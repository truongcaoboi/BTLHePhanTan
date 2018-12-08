/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Xuan Truong PC
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class Account {

    //Khai bĂ¡o thuá»™c tĂ­nh
    private String account_no;//Sá»‘ tĂ i khoáº£n
    private String address;//Ä�á»‹a chá»‰
    private double balance;//Sá»‘ dÆ° tĂ i khoáº£n
    private String birth;//NÄƒm sinh
    private Date dateCreate;//NgĂ y táº¡o tĂ i khoáº£n
    private String email;//Ä�á»‹a chá»‰ há»™p thÆ° thoáº¡i
    private String fullName;//TĂªn Ä‘áº§y Ä‘á»§
    private int gender;//Giá»›i tĂ­nh
    private String iden_no;//Sá»‘ chá»©ng minh thÆ°
    private String phone;//Sá»‘ Ä‘iá»‡n thoáº¡i
    private int sta;//Tráº¡ng thĂ¡i hoáº¡t Ä‘á»™ng cá»§a tĂ i khoáº£n

    //Khai bĂ¡o cĂ¡c phÆ°Æ¡ng thá»©c set vĂ  get
    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDateCreate() {
        String str = "";
        try {
            SimpleDateFormat output = new SimpleDateFormat("dd/MM/Y");
            str = output.format(dateCreate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void setDateCreate(Date dateCreate) {

        this.dateCreate = dateCreate;
    }

    public String getEmail() {
        if(email!=null){
            return email;
        }else{
            return "Chưa cập nhật";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        if(gender==0){
            return "Nữ";
        }else{
            return "Nam";
        }
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIden_no() {
        return iden_no;
    }

    public void setIden_no(String iden_no) {
        this.iden_no = iden_no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSta() {
        if(sta==1){
            return "Hoạt động";
        }else{
            return "Đóng";
        }
    }

    public void setSta(int sta) {
        this.sta = sta;
    }
    
    public String showAccountNo(){
        String result="";
        for(int i=0;i<account_no.length();i++){
            char item=account_no.charAt(i);
            result+=item;
            if((i+1)%3==0){
                result+=" ";
            }
        }
        return result;
    }
}
