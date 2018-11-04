package communication;
import java.io.*;
import java.net.Socket;

import DatabaseControl.Connector;
import Sercurity.Security;
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
	
	public String WriteToMiddle(Socket server,String data,Security se,int enscript) {
		try {
			OutputStream output=server.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(output);
			BufferedWriter writer=new BufferedWriter(osw);
			if(enscript==0) {
				writer.write(data);
			}else {
				data=new Connector().AnalysRequest(data);
				writer.write(se.MaHoa(data));
			}
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String ReadFromMiddle(Socket server,Security se,int enscript) {
		String request="";
		try {
			InputStream input=server.getInputStream();
			InputStreamReader isr=new InputStreamReader(input);
			BufferedReader reader=new BufferedReader(isr);
			if(enscript==0) {
				request=reader.readLine();
			}else {
				request=se.GiaiMa(reader.readLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return request;
	}
	
	public String WriteToOtherDatabase(Socket server,String data,Security se, int not) {
		return null;
	}
}
