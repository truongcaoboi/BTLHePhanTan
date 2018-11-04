package DatabaseControl;
import java.sql.*;
import java.text.SimpleDateFormat;
public class Connector {
	private Connection _conn=null;
	private Statement _state=null;
	private ResultSet _rs=null;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/Y");
	
	public Connector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			_conn=DriverManager.getConnection("jdbc:mysql://localhost/nganhang");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String SelectUser(String sql) {
		String result="";
		try {
			_state=_conn.createStatement();
			_rs=_state.executeQuery(sql);
			while(_rs.next()) {
				result+=_rs.getString("id")+","+_rs.getString("name")+",";
				result+=sdf.format(_rs.getDate("birth"))+",";
				result+=_rs.getString("address")+","+_rs.getString("iden_no")+","+_rs.getString("Phone")+",";
				result+= _rs.getString("Job")+","+sdf.format(_rs.getDate("create_date"))+",";
				result+= _rs.getInt("status");
				result+= ";";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(_state!=null) {
					_state.close();
				}
				if(_rs!=null) {
					_rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String SelectCard(String sql) {
		String result="";
		try {
			_state=_conn.createStatement();
			_rs=_state.executeQuery(sql);
			while(_rs.next()) {
				result+=_rs.getString("id")+","+_rs.getString("uid")+",";
				result+= sdf.format(_rs.getDate("create_date"))+",";
				result+= _rs.getInt("status")+",";
				result+=";";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(_state!=null) {
					_state.close();
				}
				if(_rs!=null) {
					_rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String SelectLog(String sql) {
		String result="";
		try {
			_state=_conn.createStatement();
			_rs=_state.executeQuery(sql);
			while(_rs.next()) {
				result+= _rs.getString("id")+",";
				result+= _rs.getString("uid")+","+_rs.getString("cid")+",";
				result+= _rs.getInt("type")+",";
				result+= _rs.getFloat("amount")+",";
				result+= _rs.getInt("status")+",";
				result+= _rs.getString("reason")+",";
				result+=";";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean Execute(String sql) {
		try {
			_state=_conn.createStatement();
			return _state.execute(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(_state!=null) {
					_state.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int AddBalance(String id,String cid,float amount,String reason) {
		String sql="select balance from account where id=\'"+id+"\'";
		try {
			_state=_conn.createStatement();
			_rs=_state.executeQuery(sql);
			if(_rs.next()) {
				float k=_rs.getFloat("balance");
				sql="update account set balance="+(k+amount)+" where id=\'"+id+"\'";
				if(_state.execute(sql)) {
					sql="insert into giaodich(uid,cid,type,amount,status,reason) values(\'"+id+"\',\'"+cid+"\',2,"+amount+",1,\'"+reason+")";
					_state.execute(sql);
				}
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(_state!=null) {
					_state.close();
				}
				if(_rs!=null) {
					_rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int SubBalance(String id,String cid,float amount) {
		String sql="select balance from account where id=\'"+id+"\' and balance >"+(amount+50);
		try {
			_state=_conn.createStatement();
			_rs=_state.executeQuery(sql);
			if(_rs.next()) {
				float k=_rs.getFloat("balance");
				sql="update account set balance="+(k-amount)+" where id=\'"+id+"\'";
				if(_state.execute(sql)) {
					sql="insert into giaodich(uid,cid,type,amount,status) values(\'"+id+"\',\'"+cid+"\',2,"+amount+",1)";
					_state.execute(sql);
				}
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(_state!=null) {
					_state.close();
				}
				if(_rs!=null) {
					_rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public String AnalysRequest(String request){
		String [] req=request.split(":");
		switch (req[0]) {
			case "select":
				if(req[1].equals("user")) {
					String sql="";
					if(req[2].equals("all")) {
						sql="select * from account";
					}else {
						sql="select * from account where id=\'"+req[2]+"\'";
					}
					return SelectUser(sql);
				}else if(req[1].equals("card")) {
					String sql="select * from card";
					return SelectCard(sql);
				}else if(req[1].equals("log")) {
					String sql="select * from giaodich";
					return SelectLog(sql);
				}
			case "insert":
				return Execute(req[1])+"";
			case "delete":
				return Execute(req[1])+"";
			case "update":
				if(req[1].equals("add")) {
					try {
						float x=Float.parseFloat(req[4]);
						return AddBalance(req[2],req[3],x,req[5])+"";
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						float x=Float.parseFloat(req[4]);
						return SubBalance(req[2],req[3],x)+"";
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		}
		return null;
	}
}
