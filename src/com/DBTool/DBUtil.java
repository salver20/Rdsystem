package com.DBTool;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/rddatabase";
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "520";
	private static java.sql.Connection conn;
	// װ������
	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static java.sql.Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// �������ݿ�����
	public static void main(String[] args) {
		java.sql.Connection conn = DBUtil.getConnection();
		if (conn == null) {
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}

	// �ر����ݿ�����
	public static void Close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
