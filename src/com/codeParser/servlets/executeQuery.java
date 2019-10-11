package com.codeParser.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class executeQuery
 */
@WebServlet("/execute")
public class executeQuery extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String query =request.getParameter("query");
		System.out.println(query);
		String db = (String) request.getAttribute("db");
		String msg = (String) request.getAttribute("message");

		ResultSet rs=getInfo.getTables(db);
		try {
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs1=getInfo.getExecute(query);
		try {
			while(rs1.next())
			{
			System.out.println(rs1.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
