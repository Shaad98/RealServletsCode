package com.example;
import jakarta.servlet.*;
// import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
public class A1 implements Servlet{
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        this.config = config;
    }
    @Override
    public void destroy()
    {
        System.out.println("Destroying.....");
    }
    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }
    @Override
    public String getServletInfo()
    {
        return "This Servlet is Created by Shaad";
    }
    @Override
    public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("userid"));
        String insert = "INSERT INTO student (id,name) VALUES (?,?)";
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "Shaad#98";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, id);
            ps.setString(2, name);
            int r = ps.executeUpdate();
            System.out.println(r+" row inserted!");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.println("<h1>Dear "+name+" Your Data id Stored Successfully!</h1>");
    }
}
