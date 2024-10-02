package com.neeraj;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con=null;
	Statement st=null;
    public Login() {
        super();
        try
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");  
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?useSSL=false","root","root");
		  st=con.createStatement();
		}
    	catch(ClassNotFoundException e)
    	{
    	System.out.println("Driver not found");
    	}
		catch(SQLException e)
    	{	
    		System.out.println(e.getMessage());
      	}
		
        
    }

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
		try
		{
        // read form fields
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("uname",uname);
        ResultSet rs=st.executeQuery("select * from users where uname='"+uname+"' and password='"+password+"'");
        RequestDispatcher rd=null;
        if(rs.next())
        {
        			session.setAttribute("uid", rs.getInt("uid"));
                	rd=request.getRequestDispatcher("/Welcome.html");
                	rd.forward(request, response);
        }
        else
        {
        	request.setAttribute("msg", "Invalid login.. please login again");
        	rd=request.getRequestDispatcher("/Login.jsp");
        	rd.forward(request, response);
        }
        	
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
    }


}