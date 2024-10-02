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


@WebServlet("/UpdateEntry")
public class UpdateEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement st=null;
	
    public UpdateEntry() {
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
        try {
            String ddate = request.getParameter("date");
            ResultSet rs = st.executeQuery("SELECT * FROM dairy WHERE Date = '" + ddate + "'");
            RequestDispatcher rd = null;
            
            if (rs.next()) {
                System.out.println(rs.getString(2) + " - " + rs.getString(3));
                request.setAttribute("Date", rs.getString(2));
                request.setAttribute("Description", rs.getString(3));
                rd = request.getRequestDispatcher("UpdateEntry.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid date, please try again");
                rd = request.getRequestDispatcher("UpdateSearch.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}
