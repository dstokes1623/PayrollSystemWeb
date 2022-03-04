/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataAccess.EmployeeDA;
import Exceptions.LoginException;
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
       } catch (LoginException ex) {
           request.setAttribute("errorMessage", ex.getMessage());
       }
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }  
}
