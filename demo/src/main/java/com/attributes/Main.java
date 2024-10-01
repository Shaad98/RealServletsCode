package com.attributes;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet(name="main",urlPatterns = {"/main"},
            initParams = {
                @WebInitParam(name="message",value = "firstServlet"),
                @WebInitParam(name="secondMessage",value="secondServlet")
            })
public class Main extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException 
    {
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        int addition = num1+num2;
        request.setAttribute("addition",addition);
        RequestDispatcher rd = request.getRequestDispatcher("main2");
        rd.forward(request, response);
    }
}
