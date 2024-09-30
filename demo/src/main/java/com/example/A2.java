package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
@WebServlet(name="a2",urlPatterns = {"/a2"})
public class A2 extends GenericServlet{
    public void service(ServletRequest request , ServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("userid"));
        String select = "SELECT * FROM student WHERE id = ?";
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "Shaad#98";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Generic Response</title>");
            out.println("</head>");
            out.println("<body>");
            while(rs.next())
            {
                out.println("<h1>Name : "+rs.getString("name")+"</h1>");
            }
            out.println("</body>");
            out.println("</html>");
            connection.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
