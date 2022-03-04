/*
 * This class is a subclass of Employee and will account for the employees that make an hourly rate rather than an annual salary
 */
package domain;

import java.text.NumberFormat;

/**
 *
 * @author Dante Stokes
 */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double overtimeRate;

    public HourlyEmployee(double hourlyRate, int employeeID, String lastName, String firstName, long ssNumber, String userID, String password) {
        super(employeeID, lastName, firstName, ssNumber, userID, password);
        this.hourlyRate = hourlyRate;
        this.overtimeRate = hourlyRate * 1.5; 
        //instead of taking in overtime rate as a arg, set it mathematically so 
        //that the user doesn't have to do the math themselves. If they need to override default, setOvertimeRate can be used.
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }
    
    @Override
    public double calculateGrossPay(double hoursWorked, double overtimeHours){
        double regularHours = hoursWorked - overtimeHours;
        return (regularHours * this.hourlyRate) + (overtimeHours * this.overtimeRate);
    }
    
    @Override
    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String hourlyRate = formatter.format(this.hourlyRate);
        String overtimeRate = formatter.format(this.overtimeRate);
        return super.toString() + ", Hourly Rate: " + hourlyRate + ", Overtime Rate: " + overtimeRate;
    }
}
