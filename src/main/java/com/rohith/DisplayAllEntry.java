package com.neeraj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayAllEntry")
public class DisplayAllEntry extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con;
    private Statement st;

    public DisplayAllEntry() {
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer uid = (Integer) session.getAttribute("uid");
            if (uid != null) {
                String month = request.getParameter("month");
                
                PrintWriter pw = response.getWriter();
                String query = "SELECT * FROM dairy WHERE uid = " + uid + 
                               " AND MONTH(date) = " + month + 
                               " ORDER BY date ASC";
                ResultSet rs = st.executeQuery(query);

                pw.print("<table border='1' align='center' width='300px'>");
                pw.print("<tr><th>Date</th><th>Description</th></tr>");

                Set<String> displayedEntries = new HashSet<>();
                boolean hasEntries = false;

                while (rs.next()) {
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String entryKey = date + ":" + description;

                    if (!displayedEntries.contains(entryKey)) {
                        hasEntries = true;
                        displayedEntries.add(entryKey);

                        pw.print("<tr>");
                        pw.print("<td>" + date + "</td>");
                        pw.print("<td>" + description + "</td>");
                        pw.print("</tr>");
                    }
                }
                if (!hasEntries) {
                    pw.print("<tr><td colspan='2'>No entries found for the selected month.</td></tr>");
                }
                pw.print("</table>");
             // Adding the button to go to DisplayAllEntry.jsp
                pw.print("<div style='text-align:center; margin-top:20px;'>");
                pw.print("<form action='DisplayAllEntry.jsp' method='get'>");
                pw.print("<input type='submit' value='Back' />");
                pw.print("</form>");
                pw.print("</div>");
            } else {
                // Handle the case where uid is not set in the session
                response.sendRedirect("Login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
