package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBTool.DBUtil;
import com.mysql.jdbc.ResultSet;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID"); // ���ڽ���ǰ�������IDֵ���˴��������input�ؼ���nameֵһ��
		String PW = request.getParameter("PW");// ���ڽ���ǰ�������PWֵ���˴��������input�ؼ���nameֵһ��
		boolean type = false;// �����ж��˺ź������Ƿ������ݿ��в�ѯ���һ��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			java.sql.Connection con = DBUtil.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String sql = "select * from rddatabase.USER where uid=" + ID
					+ " and pwd=" + PW;
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next()) {
				type = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.Close();
			out.print(type);
			out.flush();
			out.close();
		}
	}
}
