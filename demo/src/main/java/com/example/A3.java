package com.example;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;
@WebServlet(name="a3",urlPatterns = {"/a3"})
public class A3 extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String insert = "INSERT INTO employee (name,email,password) VALUES (?,?,?)";
        String name = request.getParameter("username");
        String email = request.getParameter("useremail");
        String upassword = request.getParameter("userpassword");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "Shaad#98";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, upassword);
            int r = ps.executeUpdate();
            System.out.println(r+" row inserted!");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Http Response</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dear "+name+" Your Account is Created Successfully!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
