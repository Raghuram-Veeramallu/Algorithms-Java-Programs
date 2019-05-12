/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_time_calc;

/**
 *
 * @author rockstar
 */
public class checkTime {
    public void runLoop(){
        int spaces = 0;
        int counter = 0;
        for(int i = 1; i <= 7; i++){
            for (int j = 1; j<spaces; j++){
                System.out.println("Counter :"+ counter++);
                //counter++;
            }
            for (int j = spaces; j<=7; j++){
                System.out.println("Counter :"+ counter++);
                //System.out.print("*");
                //counter++;
            }
            //System.out.println();
            //counter++;
            System.out.println("Counter :"+ counter++);
            System.out.println("Spaces :"+ spaces++);
            System.out.println("Counter :"+ counter++);
            //spaces++;
            //counter++;
        }
        System.out.println("Counter :"+counter);
    }
    
    public static void main(String args[]){
        checkTime ct = new checkTime();
        ct.runLoop();
    }
    
}
