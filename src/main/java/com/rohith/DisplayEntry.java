package com.neeraj;

import java.io.IOException;
//import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayEntry")
public class DisplayEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con=null;
	Statement st=null;
    public DisplayEntry() {
        super();
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?allowPublicKeyRetrieval=true&useSSL=false","root","root");
            st=con.createStatement();
        }
        catch(ClassNotFoundException e)
        {
        	System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	HttpSession session = request.getSession();
            Integer uid = (Integer) session.getAttribute("uid");
            
            if (uid == null) {
                response.sendRedirect("Login.jsp");
                return;
            }

            String ddate = request.getParameter("date");
            ResultSet rs = st.executeQuery("SELECT * FROM dairy WHERE Date = '" + ddate + "' AND uid = " + uid);
            RequestDispatcher rd=null;
            
            if (rs.next()) {
            	request.setAttribute("uid", rs.getString(1));
                request.setAttribute("date", rs.getString(2));
                request.setAttribute("description", rs.getString(3));
                rd = request.getRequestDispatcher("DisplayEntry.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid date, please try again");
                rd = request.getRequestDispatcher("DisplaySearch.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

