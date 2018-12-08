package control;
import java.net.*;
import java.util.Base64;
import java.io.*;
import javax.swing.JOptionPane;
public class Communication {
	public static String host;
	public static int port=10000;
	
	private Socket client=null;
	
	public Communication() {
		try {
			client=new Socket(host,port);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi kết nối");
		}
	}
	
	public void SendRequest(String request) {
		try {
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write(Base64.getEncoder().encodeToString(request.getBytes("UTF-8")));
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String ReceiveResponse() {
		String res="";
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			res=reader.readLine();
			res=new String(Base64.getDecoder().decode(res),"UTF-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
