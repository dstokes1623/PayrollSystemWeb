/*
 * This class contains the timecards hourly employees use to report hours worked
 */
package domain;

import DataAccess.TimecardDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dante Stokes
 */
public class Timecard {
    private Date date;
    private int employeeID;
    private double hoursWorked;
    private double overtimeHoursWorked;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeHoursWorked() {
        return overtimeHoursWorked;
    }

    public void setOvertimeHoursWorked(double overtimeHoursWorked) {
        this.overtimeHoursWorked = overtimeHoursWorked;
    }

    public Timecard(Date date, int employeeID, double hoursWorked) {
        this.date = date;
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
        if(hoursWorked > 8){
          this.overtimeHoursWorked = hoursWorked - 8; // overtime hours calculated by hours worked past a 8 hour work day
        } else this.overtimeHoursWorked = 0;
        
    }
    
    public static ArrayList<Timecard> getTimecards(){
        return TimecardDA.getTimecards();
    }
    public static ArrayList<Timecard> getTimecardsByID(int empID){
        return TimecardDA.getTimecardsByID(empID);
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Date: " + date +  ", Hours Worked: " + hoursWorked + ", Overtime Hours Worked: " + overtimeHoursWorked;
    }
    
    
}
