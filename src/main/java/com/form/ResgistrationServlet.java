package com.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ResgistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("name");
		String uemail=req.getParameter("email");
		String upwd=req.getParameter("pass");
		String umobile=req.getParameter("contact");
		RequestDispatcher disp=null;
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     con =DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","mypass");
			PreparedStatement ps= con.prepareStatement("insert into user(uname,upwd,uemail,umobile)values(?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,upwd);
			ps.setString(3,uemail);
			ps.setString(4,umobile);
			int rowcount=ps.executeUpdate();
			disp=req.getRequestDispatcher("registration.jsp");
			if(rowcount>0)
			{
				req.setAttribute("status","success");
			}
			else
			{
				req.setAttribute("status","failed");
			}
			disp.forward(req,res);
				
			
		}catch(Exception e)
		{
			e.printStackTrace()	;
		}
		finally {
			try {
				con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
