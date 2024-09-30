package com.initParameters;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(name = "eow" , urlPatterns = {"/eow"},
            initParams = {
                @WebInitParam(name="message",value = "Welcome To Our Web Application!"),
                @WebInitParam(name = "secondMessage",value = "How We Can Help You?")
            }
    )
public class ExampleXml extends HttpServlet{
    ServletConfig config;
    public void init(ServletConfig config) throws ServletException
    {
        this.config = config;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = config.getInitParameter("message");
        String secondMessage = config.getInitParameter("secondMessage");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+message+"</h1>");
        out.println("<h1>"+secondMessage+"</h1>");
        out.println("</body>");
        out.println("<html>");
    }
}
