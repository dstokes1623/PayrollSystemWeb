/*
 * Serves as the data access class for timecards will later be accessing database instead of arraylists
 */
package DataAccess;

import domain.Timecard;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dante Stokes
 */
public class TimecardDA {
     private static ArrayList<Timecard> timecards = new ArrayList<Timecard>();
     
      public static void initialize(){
        //Salary employees
        Timecard timecard1 = new Timecard(new Date(2022, 0, 25), 103, 10.5);
        
        Timecard timecard2 = new Timecard(new Date(2022, 0, 25), 104, 8.5);
        
        timecards.add(timecard1);
        timecards.add(timecard2);
    }
    public static ArrayList<Timecard> getTimecards(){
        return timecards;
    }
    public static void addTimecard(Timecard timecard){
        timecards.add(timecard);
    }
    public static ArrayList<Timecard> getTimecardsByID(int empID){
        ArrayList<Timecard> empTimecards = new ArrayList<Timecard>();

        for(Timecard timecard : timecards){
            if(timecard.getEmployeeID() == empID){
                empTimecards.add(timecard);
            }
        }
        return empTimecards;
    }
}
