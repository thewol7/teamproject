package server.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpBean {
	private Context initContext;
	private Context envContext;
	private DataSource ds;

	public DbcpBean (){
		try{
		initContext = new InitialContext();
		envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(Exception e){
			
		}
	}

	public Connection getConn() throws SQLException{
		return ds.getConnection();
	}
}