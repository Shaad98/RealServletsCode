package com.state;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet(name = "a02",urlPatterns = {"/a02"})
public class A2 extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = "";
        Cookie []cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("username"))
            {
                name = cookie.getValue();
            }
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response 2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dear "+name+" Welcome Back To Servlet 2");
        out.println("</body>");
        out.println("</html>");
       
    }
}
