/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author stoke
 */
public class PayrollSystemDA {
    
    public static void initialize() {
        EmployeeDA.initialize();
        TimecardDA.initialize();
        WithholdingTypeDA.initialize();
        PayrollDA.initialize();
    }
}
