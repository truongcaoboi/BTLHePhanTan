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

    //Khai bÄ‚Â¡o thuĂ¡Â»â„¢c tÄ‚Â­nh
    private String account_no;//SĂ¡Â»â€˜ tÄ‚Â i khoĂ¡ÂºÂ£n
    private String address;//Ă„ï¿½Ă¡Â»â€¹a chĂ¡Â»â€°
    private double balance;//SĂ¡Â»â€˜ dĂ†Â° tÄ‚Â i khoĂ¡ÂºÂ£n
    private String birth;//NĂ„Æ’m sinh
    private Date dateCreate;//NgÄ‚Â y tĂ¡ÂºÂ¡o tÄ‚Â i khoĂ¡ÂºÂ£n
    private String email;//Ă„ï¿½Ă¡Â»â€¹a chĂ¡Â»â€° hĂ¡Â»â„¢p thĂ†Â° thoĂ¡ÂºÂ¡i
    private String fullName;//TÄ‚Âªn Ă„â€˜Ă¡ÂºÂ§y Ă„â€˜Ă¡Â»Â§
    private int gender;//GiĂ¡Â»â€ºi tÄ‚Â­nh
    private String iden_no;//SĂ¡Â»â€˜ chĂ¡Â»Â©ng minh thĂ†Â°
    private String phone;//SĂ¡Â»â€˜ Ă„â€˜iĂ¡Â»â€¡n thoĂ¡ÂºÂ¡i
    private int sta;//TrĂ¡ÂºÂ¡ng thÄ‚Â¡i hoĂ¡ÂºÂ¡t Ă„â€˜Ă¡Â»â„¢ng cĂ¡Â»Â§a tÄ‚Â i khoĂ¡ÂºÂ£n

    //Khai bÄ‚Â¡o cÄ‚Â¡c phĂ†Â°Ă†Â¡ng thĂ¡Â»Â©c set vÄ‚Â  get
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
