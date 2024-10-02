package com.state;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet(name = "a01",urlPatterns = {"/a01"})
public class A1 extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        String name = request.getParameter("username");
        PrintWriter out = response.getWriter();
        Cookie c = new Cookie("username", name);
        response.addCookie(c);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response 1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dear"+name+" Go To Servlet 2 </h1>");
        out.println("<form action='a02' method='post'><input type='submit' value='submit'></form>");
        out.println("</body>");
        out.println("</html>");
    }
}
