package com.attributes;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet(name = "main2",urlPatterns = {"/main2"})
public class Main2 extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int n1 = Integer.parseInt(request.getParameter("number1"));
        int n2 = Integer.parseInt(request.getParameter("number2"));
        int addition = (Integer)request.getAttribute("addition");
        int multiplication = n1*n2;
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+n1+" + "+n2+" = "+addition+"</h1>");
        out.println("<h1>"+n1+" x "+n2+" = "+multiplication+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
