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

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection con = null;
    Statement st = null;

    public DeleteEntry() {
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("uid") == null) {
                response.sendRedirect("Login.jsp"); // Redirect to login if user is not logged in
                return;
            }

            Integer uid = (Integer) session.getAttribute("uid"); // Retrieve uid as Integer
            String ddate = request.getParameter("date");
            System.out.println(ddate);

            String query = "SELECT * FROM dairy WHERE date = ? AND uid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, ddate);
            pstmt.setInt(2, uid); // Set uid as Integer

            ResultSet rs = pstmt.executeQuery();
            RequestDispatcher rd = null;

            if (rs.next()) {
                pstmt = con.prepareStatement("DELETE FROM dairy WHERE date = ? AND uid = ?");
                pstmt.setString(1, ddate);
                pstmt.setInt(2, uid); // Set uid as Integer
                pstmt.executeUpdate();

                rd = request.getRequestDispatcher("DeleteEntry.html");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "No record found for the given date or you do not have permission to delete this entry.");
                rd = request.getRequestDispatcher("DeleteSearch.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
