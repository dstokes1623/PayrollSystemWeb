/*
 * Class contains the main method for the application and will initialize the DAs as well as print out the information in the DAs
 */
package domain;

import DataAccess.PayrollSystemDA;
import java.util.ArrayList;
import java.util.Date;


public class PayrollSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        PayrollSystemDA.initialize();
        
        
    }
}
