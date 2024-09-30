package com.initParameters;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ExampleXml extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = getServletConfig().getInitParameter("message");
        String secondMessage = getServletConfig().getInitParameter("secondMessage");
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
