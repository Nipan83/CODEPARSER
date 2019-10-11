package com.codeParser.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/getInfo")
public class getInfo extends GenericServlet {
	private static Connection con;
	private static Statement stmt;
	public static void connect(ServletRequest request, ServletResponse response)
	{
		String userName=request.getParameter("Name");
		String password=request.getParameter("Password");
		String ipAdd=request.getParameter("IPAdd");
		String dbName=request.getParameter("DBName");
		String queryString=String.format("jdbc:mysql://%s/%s",ipAdd,dbName);
		System.out.println(queryString);
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(queryString.toString(),userName,password);
			out.write("Connection successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ResultSet getTables(String db)
	{
		ResultSet rs=null;
		try {
			stmt=con.createStatement();
			rs= stmt.executeQuery("show tables");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		}
	public static ResultSet getExecute(String query)
	{
		ResultSet rs=null;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String databaseType=request.getParameter("database");
		System.out.println(databaseType);
		if(!databaseType.equals("sql")) {
			out.write("Did not add support for the oracle database ...");
			out.close();
		}
		else {
			getInfo.connect(request,response);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("query.jsp");
			request.setAttribute("db", request.getParameter("DBName"));
			request.setAttribute("message", "connection is successful");

			requestDispatcher.forward(request, response);
			}
		
		
		
	}

}

