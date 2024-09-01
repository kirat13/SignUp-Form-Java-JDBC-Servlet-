package com.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uemail=req.getParameter("username");
		String upwd=req.getParameter("password");
		HttpSession session=req.getSession();
		RequestDispatcher disp=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","mypass");
			PreparedStatement ps=con.prepareStatement("Select * from user where uemail=? and upwd=?");
			ps.setString(1, uemail);
			ps.setString(2, upwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				session.setAttribute("name",rs.getString("uname"));
				disp=req.getRequestDispatcher("index.jsp");
			}
			else
			{
				req.setAttribute("status","failed");
				disp=req.getRequestDispatcher("login.jsp");
			}
			
			disp.forward(req,res);
		
		}
		catch(Exception e)
		    {
			e.printStackTrace();		
			}
	}
}
