package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "user", value = "Divya"),
                @WebInitParam(name = "password", value = "Divya@19")
        }
)

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameRegex="^[A-Z]{1}[a-z]{3,}$";
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");


        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if((userID.equals(user) && password.equals(pwd)&&Pattern.matches(nameRegex,userID))) {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out  = resp.getWriter();
            out.println("<font color = red> Either username or password is wrong</font>");
            rd.include(req, resp);
        }

    }

}