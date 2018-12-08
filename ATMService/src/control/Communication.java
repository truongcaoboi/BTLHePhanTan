package control;
import java.net.*;
import java.util.Base64;
import java.io.*;
public class Communication {
	public static String host="";
	public static int port=10000;
	
	private Socket client=null;
	
	public void SendRequest(String request) {
		try {
			request=Base64.getEncoder().encodeToString(request.getBytes("UTF-8"));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write(request);
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String ReceiverResponse() {
		String response="";
		 try {
			 BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			 response=reader.readLine();
			 response=new String(Base64.getDecoder().decode(response),"UTF-8");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return response;
	}
	
	public Communication() {
		try {
			client=new Socket(host,port);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
