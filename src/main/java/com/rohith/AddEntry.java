package com.neeraj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/AddEntry")
public class AddEntry extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection con = null;
    Statement st = null;

    public AddEntry() {
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String date = request.getParameter("date");
            String description = request.getParameter("desc");
            System.out.println("Date: " + date);
            System.out.println("Description: " + description);
            
            HttpSession session = request.getSession();
            String uname = (String) session.getAttribute("uname");

            String query = "SELECT uid FROM users WHERE uname = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            
            int uid = 0;
            if (rs.next()) {
                uid = rs.getInt("uid");

                // Insert values into diary table
                String insertQuery = "INSERT INTO dairy (uid, date, description) VALUES (?, ?, ?)";
                PreparedStatement psInsert = con.prepareStatement(insertQuery);
                psInsert.setInt(1, uid);
                psInsert.setString(2, date);
                psInsert.setString(3, description);
                psInsert.executeUpdate();
                
//                PrintWriter pw = response.getWriter();
//                pw.print("<h1>Record Inserted Successfully</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("/AddSuccess.html");
            	rd.forward(request, response);
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("/AddEntry.jsp");
            	rd.forward(request, response);
            }

           
        }catch (Exception e) {
            e.printStackTrace(); 
           
        }
    

    }
}





