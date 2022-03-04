/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import domain.WithholdingType;
import java.util.ArrayList;

/**
 *
 * @author stoke
 */
public class WithholdingTypeDA {
    private static ArrayList<WithholdingType> withholdingTypes = new ArrayList<WithholdingType>();
     
      public static void initialize(){
        
        WithholdingType type1 = new WithholdingType();
        WithholdingType type2 = new WithholdingType();
        
        type1.setWithholdingID(123);
        type1.setDescription("Social Security");
        type1.setRate(0.03);
        
        type2.setWithholdingID(456);
        type2.setDescription("401k");
        type2.setAmount(20.00);
        
        withholdingTypes.add(type1);
        withholdingTypes.add(type2);
    }
    public static ArrayList<WithholdingType> getWithholdingTypes(){
        return withholdingTypes;
    }
    public static void addWithholdingType(WithholdingType withholdingType){
        withholdingTypes.add(withholdingType);
    }

    public static double calculateWithholding(double grossPay){
        double totalWithholding = 0;
        double amount;
        double rate;

        for(int i = 0; i < withholdingTypes.size(); i++){
            amount = withholdingTypes.get(i).getAmount();
            rate = withholdingTypes.get(i).getRate();
            if(amount > 0){
                totalWithholding += amount;
            } else if(rate > 0){
                totalWithholding += (grossPay * rate);
            }
        }
        return totalWithholding;
    }
}
