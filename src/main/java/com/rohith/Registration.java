package com.neeraj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt1 = null;
	Statement stmt2 = null;
    public Registration() {
        super();
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?useSSL=false", "root", "root");
        	stmt1=con.createStatement();
        	stmt2=con.createStatement();
        }
        catch(ClassNotFoundException e)
        {
        	System.out.println("Driver Not Found");
        }
        catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String uname=request.getParameter("uname");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			System.out.println("First name: "+fname);
			System.out.println("Last name: "+lname);
			System.out.println("User name: "+uname);
			System.out.println("Password: "+password);
			System.out.println("Email id: "+email);
			System.out.println("Phone Number: "+phone);
			
			
			ResultSet rsm=stmt1.executeQuery("select * from users where email='"+email+"'");
			ResultSet rsp=stmt2.executeQuery("select * from users where phone='"+phone+"'");
	        RequestDispatcher rd=null;
	        if(rsm.next())
	        {
	        	request.setAttribute("msg1", "Email already exist..");
	        	rd=request.getRequestDispatcher("/Registration.jsp");
	        	rd.forward(request, response);
	        }
	        else if(rsp.next()) {
	        	request.setAttribute("msg2", "Phonenumber already exist..");
	        	rd=request.getRequestDispatcher("/Registration.jsp");
	        	rd.forward(request, response);
	        }
	        else
	        {
	        	stmt1.executeUpdate("insert into users(fname,lname,uname,password,email,phone) values('"+fname+"','"+lname+"','"+uname+"','"+password+"','"+email+"','"+phone+"') ");
	        	request.setAttribute("successMessage", "Registration successful. Please login.");
                rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
	        }
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
