package communication;
import java.net.*;

import Sercurity.Security;

import java.io.*;
public class Communication {
	
	private String _hostAccess;
	private int _portAccess;
	private Socket _server=null;
	private String _data="";
	private Security se=new Security();
	
	public Communication() {
		String dataSource=new ReadAndWrite().ReadFromFile("myProfile.txt");
		System.out.println(dataSource);
		_hostAccess = dataSource.split(",")[0].split(":")[1].trim();
		try {
			_portAccess = Integer.parseInt(dataSource.split(",")[1].split(":")[1].trim());
		}catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(_hostAccess);
//		System.out.println(_portAccess);
	}
	
	public void ExecuteCommunication() {
		try {
			ServerSocket listener=new ServerSocket(_portAccess);
			_server=listener.accept();
			ReadAndWrite raw=new ReadAndWrite();
			raw.WriteToMiddle(_server, se.GetPublicKeyOfMe(),se,0);
			se.SetPublicKeyNotMe(raw.ReadFromMiddle(_server,se,0));
//			_data=raw.ReadFromMiddle(_server,se,1);
//			raw.WriteToMiddle(_server,_data,se,1);
			Thread readThread=new Thread() {
				@Override
				public synchronized void run() {
					ReadAndWrite raw=new ReadAndWrite();
					while(true) {
						try {
							if(_data!="") {
								wait();
							}
						}catch(Exception e) {
							e.printStackTrace();
						}
						_data=raw.ReadFromMiddle(_server,se,0);
						notify();
					}
				}
			};
			Thread writeThread=new Thread() {
				@Override
				public synchronized void run() {
					try {
						ReadAndWrite raw=new ReadAndWrite();
						while(true) {
							if(_data == "") {
								wait();
							}
							raw.WriteToMiddle(_server,_data,se,0);
							_data="";
							notify();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			};
			readThread.setDaemon(true);
			writeThread.setDaemon(true);
			readThread.start();
			writeThread.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
