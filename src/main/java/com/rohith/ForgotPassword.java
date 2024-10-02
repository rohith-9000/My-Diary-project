package com.neeraj;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con=null;
	Statement st=null;
	public ForgotPassword() {
        super();
        try
     		{
     		  Class.forName("com.mysql.cj.jdbc.Driver");  
     		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?useSSL=false","root","root");
     		  st=con.createStatement();
     		}
         	catch(ClassNotFoundException e)
         	{
         	System.out.println("driver not found");
         	}
     		catch(SQLException e)
         	{	
         		System.out.println(e.getMessage());
           	}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

			String phno=request.getParameter("phone");
			//PrintWriter pw=response.getWriter();
			ResultSet rs=st.executeQuery("select * from users where phone='"+phno+"'");
	        RequestDispatcher rd=null;
	        if(rs.next())
	        {
	        	System.out.println(rs.getString(4)+" : "+rs.getString(5));
	        	request.setAttribute("uname", rs.getString(4));
	        	request.setAttribute("password", rs.getString(5));
	        	rd =request.getRequestDispatcher("ForgotPassword.jsp");
	        	rd.forward(request, response);
	        }
	        else
			{
				request.setAttribute("msg", "Invalid Phone Number Please Try Again");
				rd=request.getRequestDispatcher("ForgotSearch.jsp");
				rd.forward(request, response);
			}
			}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

	}
}
