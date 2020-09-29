package com.yiiqng.DBUtil;


//���ݿ�����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* ���ݿ����ӹ���
* @author Zheng
*
*/
public class DBUtil {
	
	public static String db_url = "jdbc:mysql://localhost:3306/ceshi1?useSSL=false";
	public static String db_user = "root";
	public static String db_pass = "511924";
	
	public static Connection getConn () {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//��������
			conn = DriverManager.getConnection(db_url, db_user, db_pass);//ͨ��������û�����������������һ�������ݿ��������Ҫ�ǵ���connect��������
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ر�����
	 * @param state
	 * @param conn
	 */
	public static void close (Statement state, Connection conn) {
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close (ResultSet rs, Statement state, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
