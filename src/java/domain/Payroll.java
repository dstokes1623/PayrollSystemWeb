/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import DataAccess.PayrollDA;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author stoke
 */
public class Payroll {
    private Date date;
    private int employeeID;
    private double grossPay;
    private double totalDeductions;
    private double netPay;

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

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }
    public static ArrayList<Payroll> getPayroll(){
        return PayrollDA.getPayroll();
    }
    public void calculatePayroll(Date weekEnding, Employee emp){
        double grossPay = 0;
        
        if(emp instanceof SalaryEmployee){
                grossPay = emp.calculateGrossPay();
          }
        this.date = weekEnding;
        this.employeeID = emp.getEmployeeID();
        this.grossPay = grossPay;
        this.totalDeductions = WithholdingType.calculateWithholding(grossPay);
        this.netPay = this.grossPay - this.totalDeductions;
        
    }
    public void calculatePayroll(Date weekEnding, Employee emp, Timecard timecard){
        
        double grossPay = 0;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(weekEnding);
        //Get date a week before date entered
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)-6);
        Date weekBefore = calendar.getTime();
        if(emp instanceof SalaryEmployee){
                grossPay = emp.calculateGrossPay();
          }
        if(timecard.getDate().compareTo(weekEnding) < 0 && timecard.getDate().compareTo(weekBefore) > 0){
            if(emp instanceof HourlyEmployee && timecard.getEmployeeID() == emp.getEmployeeID()){
                grossPay = emp.calculateGrossPay(timecard.getHoursWorked(), timecard.getOvertimeHoursWorked());
            } 
        }
        this.date = weekEnding;
        this.employeeID = emp.getEmployeeID();
        this.grossPay = grossPay;
        this.totalDeductions = WithholdingType.calculateWithholding(grossPay);
        this.netPay = this.grossPay - this.totalDeductions;
        
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String grossPay = formatter.format(this.grossPay);
        String totalDeductions = formatter.format(this.totalDeductions);
        String netPay = formatter.format(this.netPay);
        return "Date: " + date + ", Employee ID: " + employeeID + ", Gross Pay: " + grossPay + ", Total Deductions: " + totalDeductions + ", Net Pay: " + netPay;
    }
    
    
}
