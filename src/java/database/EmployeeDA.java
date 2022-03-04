/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Exceptions.LoginException;
import domain.Employee;
import domain.HourlyEmployee;
import domain.SalaryEmployee;
import java.util.ArrayList;

/**
 *
 * @author stoke
 */
public class EmployeeDA {
    private static ArrayList<Employee> employees = new ArrayList<Employee>();
    
    public static void initialize(){
        //Salary employees
        Employee emp1 = new SalaryEmployee(57000, 101,"Brown", "Bob", 555551234, "User1", "user1");
        Employee emp2 = new SalaryEmployee(59000, 102,"Smith", "Angie", 123456789, "User2", "user2");
        
        Employee emp3 = new HourlyEmployee(18.50, 103,"Robinson", "Alex", 456123456, "User3", "user3");
        Employee emp4 = new HourlyEmployee(18.50, 104,"Madison", "Mikayla", 789015678,"User4", "user4");
        
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
    }
    public static ArrayList<Employee> getEmployees(){
        return employees;
    }
    public static void addEmployee(Employee emp){
        employees.add(emp);
    }
    public static ArrayList<Employee> getEmployeesByID(int empID){
            ArrayList<Employee> employeesByID = new ArrayList<Employee>();
    
            for(Employee employee : employees){
                if(employee.getEmployeeID() == empID){
                    employeesByID.add(employee);
                }
            }
            return employeesByID;
        }
    public static Employee getEmployeeByUserID(String userID) throws LoginException{
        Employee emp = null;
        try {
            for(Employee employee: employees) {
                if(employee.getUserID().equals(userID)){
                emp = employee;
            }
        }
        } catch(Exception e){
            throw new LoginException("Please enter a valid User ID");
        }
        return emp;
    }
    public static boolean validatePassword(Employee emp, String password) throws LoginException{
        try{
            if(emp.getPassword().equals(password)){
                return true;
            }
        }
        catch (Exception e){
            throw new LoginException("The password you entered is invalid");
        }
        return false;
    }
    public static Employee validateLogin(String userID, String password) throws LoginException{
        try{
              Employee emp = getEmployeeByUserID(userID);
              boolean isValidPassword = validatePassword(emp, password);
              if(isValidPassword == true){
                  return emp;
              }
        } catch(Exception e){
            throw new LoginException(e.getMessage());
        }
        return null;
    }
    }

