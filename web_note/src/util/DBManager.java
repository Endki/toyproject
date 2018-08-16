package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn =null;
		try {
			Context initContext=new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource) envContext.lookup("jdbc/myoracle");
			// jdbc/myoracle이란 이름의 객체를 찾아서 datasource가 받는다.
			// ds 생성
			conn=ds.getConnection();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//리소스해제 용
	public static void close(Connection conn, Statement stmt,ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//DML 수행후 리소스 해제
	public static void close(Connection conn,Statement stmt) {
		try {
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
