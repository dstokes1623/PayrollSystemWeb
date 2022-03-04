/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import domain.Payroll;
import java.util.ArrayList;

/**
 *
 * @author stoke
 */
public class PayrollDA {
     private static ArrayList<Payroll> payroll = new ArrayList<Payroll>();
     
      public static void initialize(){
       Payroll payroll1 = new Payroll();
       Payroll payroll2 = new Payroll();
       Payroll payroll3 = new Payroll();
       Payroll payroll4 = new Payroll();
       
       payroll.add(payroll1);
       payroll.add(payroll2);
       payroll.add(payroll3);
       payroll.add(payroll4);
    }
    public static ArrayList<Payroll> getPayroll(){
        return payroll;
    }
}
