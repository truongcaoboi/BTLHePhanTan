package communicate;
import java.net.*;
import ReadAndWrite.ReadAndWrite;
import security.Security;
public class Communication {
	private Socket _server=null;
	private Socket _client=null;
	private int _portToServer;
	private String _ipHostServer;
	private int _portForClient;
	private Security se=new Security();
	
	public void SetServer(Socket server) {
		_server=server;
	}
	
	public String getIpHostServer() {
		return this._ipHostServer;
	}
	
	public int getPortServer() {
		return this._portToServer;
	}
	
	public void setSecurity(Security se) {
		this.se=se;
	}
	
	public Communication() {
		String infor=new ReadAndWrite().ReadFromFile("proFile.txt");
		String [] sp=infor.split(",");
		try {
			_ipHostServer=sp[0].split(":")[1];
			_portToServer=Integer.parseInt(sp[1].split(":")[1]);
			_portForClient=Integer.parseInt(sp[2].split(":")[1]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CommunicateToClient() {
		ReadAndWrite raw=new ReadAndWrite();
		try {
			ServerSocket listener=new ServerSocket(_portForClient);
			_client = listener.accept();
			raw.WriteToClient(_client, se.GetPublicKeyOfMe(), 0, se);
			se.SetPublicKeyOfClient(raw.ReadFromClient(_client, 0, se));
			String request=raw.ReadFromClient(_client, 1, se);
			raw.WriteToServer(_server, request, 1, se);
			String respond=raw.ReadFromServer(_server, 1, se);
			raw.WriteToClient(_client, respond, 1, se);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
