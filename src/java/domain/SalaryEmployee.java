/*
 * This class is a subclass of Employee and will account for the employees that make an annual salary rather than an hourly rate
 */
package domain;

import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author Dante Stokes
 */
public class SalaryEmployee extends Employee {
    private double annualSalary;

    @Override
    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
    
    @Override
    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String annualSalary = formatter.format(this.annualSalary);
        return super.toString() + ", Annual Salary: " + annualSalary;
    }

    public SalaryEmployee(double annualSalary, int employeeID, String lastName, String firstName, long ssNumber, String userID, String password) {
        super(employeeID, lastName, firstName, ssNumber, userID, password);
        this.annualSalary = annualSalary;
    }
    
    @Override
    public double calculateGrossPay(Date date){
        return this.annualSalary / 52;
    }
}
