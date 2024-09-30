package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(name="b1",urlPatterns = {"/b1"})
public class B1 extends HttpServlet{
    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String email = request.getParameter("useremail");
        String password = request.getParameter("userpassword");
        if(name.isEmpty() || email.isEmpty() || password.isEmpty())
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request Include</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Please Fill Your Complete Details! </h1>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd = request.getRequestDispatcher("reqIn.html");
            rd.include(request,response);
        }
        else{
            out.println("<h1>Dear "+name+" Welcome To Our Web Application!</h1>");
        }
    }
}
