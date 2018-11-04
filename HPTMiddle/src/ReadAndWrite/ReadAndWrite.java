package ReadAndWrite;

import java.io.*;
import java.net.*;

import security.Security;

public class ReadAndWrite {
	public String ReadFromFile(String fileName) {
		String result="";
		try {
			FileInputStream input=new FileInputStream(fileName);
			DataInputStream reader=new DataInputStream(input);
			String data="";
			int k=reader.read();
			while(k!=-1) {
				char c=(char)k;
				if(c=='\n') {
					result += data+",";
					data="";
					k=reader.read();
				}else {
					data +=c;
					k=reader.read();
				}
			}
			result+=data;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String ReadFromServer(Socket server,int decrypt,Security se) {
		String result="";
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(server.getInputStream()));
			if(decrypt==0) {
				result=reader.readLine();
			}else {
				result=se.GiaiMa(reader.readLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String ReadFromClient(Socket client,int decrypt,Security se) {
		String result="";
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			if(decrypt==0) {
				result=reader.readLine();
			}else {
				result=se.GiaiMa(reader.readLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void WriteToServer(Socket server,String data,int encrypt,Security se) {
		try {
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
			if(encrypt==0) {
				writer.write(data);
			}else {
				writer.write(se.MaHoa(data));
			}
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void WriteToClient(Socket client, String data,int encrypt,Security se) {
		try {
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			if(encrypt==0) {
				writer.write(data);
			}else {
				writer.write(se.MaHoa(data));
			}
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
