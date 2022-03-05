/*
 * This class is a subclass of Employee and will account for the employees that make an hourly rate rather than an annual salary
 */
package domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    public double calculateGrossPay(Date date){
        ArrayList<Timecard> timecards;
        Timecard timecard;
        Date beginDate, endDate, timecardDate;
        Calendar calendar = Calendar.getInstance();
        
        endDate = date;
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -6);
        beginDate = calendar.getTime();
         double grossPay = 0;
        
        
        timecards = Timecard.getTimecardsByID(this.getEmployeeID(), beginDate, endDate);
            for(int i = 0; i < timecards.size(); i++) {
            timecard = timecards.get(i);
            timecardDate = timecard.getDate();
            if(timecardDate.compareTo(beginDate) >= 0 && timecardDate.compareTo(endDate) <= 0 ){
                grossPay += timecard.getHoursWorked() * this.getHourlyRate();
                grossPay += timecard.getOvertimeHoursWorked() * this.getHourlyRate() * this.getOvertimeRate();
            }
        }
        return grossPay;
        
    }
    
    @Override
    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String hourlyRate = formatter.format(this.hourlyRate);
        String overtimeRate = formatter.format(this.overtimeRate);
        return super.toString() + ", Hourly Rate: " + hourlyRate + ", Overtime Rate: " + overtimeRate;
    }
}
