package com.neeraj;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveEntry")
public class SaveEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
    public SaveEntry() {
        super();
        try
 		{
 		  Class.forName("com.mysql.cj.jdbc.Driver");  
 		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
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
        try {
            String date = request.getParameter("date");
            String desc = request.getParameter("desc");
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("SaveSuccess.html");
            rd.forward(request, response);
//            PrintWriter pw = response.getWriter();
            pst = con.prepareStatement("UPDATE dairy SET description=? WHERE date=?");
            pst.setString(1, desc);
            pst.setString(2, date);
            pst.executeUpdate();
//            pw.print("<h1>Description updated successfully.</h1>");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}