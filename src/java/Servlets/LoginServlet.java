/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import database.EmployeeDA;
import Exceptions.LoginException;
import database.PayrollSystemDA;
import domain.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stoke
 */
public class LoginServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
       PayrollSystemDA.initialize();
        String url = "/success.jsp";
        // get current action
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        Employee user = null;
        
        if (userID == null || password == null) {
            request.setAttribute("errorMessage", "Please enter a Username and Password");  // default action
            url = "/login.jsp";
        }
       try {
           user = Employee.validateLogin(userID, password);
           request.setAttribute("user", user);
           if(user == (null)){
               request.setAttribute("errorMessage", "The password you have entered is invalid");
               url = "/login.jsp";
               
           }
       } catch (LoginException ex) {
           request.setAttribute("errorMessage", ex.getMessage());
           url = "/login.jsp";
       }
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }  
}
