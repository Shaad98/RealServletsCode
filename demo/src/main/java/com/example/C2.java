package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet(name = "c2",urlPatterns = {"/c2"})
public class C2 extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Include</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dear "+name+" Your Account is Created Successfully!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
