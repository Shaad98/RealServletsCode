package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
@WebServlet(name = "c1",urlPatterns = {"/c1"})
public class C1 extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "Shaad#98";
        String insert = "INSERT INTO employee (name,email,password) VALUES(?,?,?)";
        String uname = request.getParameter("username");
        String uemail = request.getParameter("useremail");
        String upassword = request.getParameter("userpassword");
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1,uname );
            ps.setString(2,uemail );
            ps.setString(3,upassword );
            int r = ps.executeUpdate();
            System.out.println(r+" row inserted!");
            RequestDispatcher rd = request.getRequestDispatcher("c2");
            rd.forward(request,response);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
