/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compute_complexity;

/**
 *
 * @author rockstar
 */
public class checkNotations {
    public int linearOps(int n){
        int counter = 0;
        double beginTime = System.nanoTime();
        for (int i=0; i<n; i++){
            counter++;
        }
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("Linear:"+timeTaken);
        return counter;
    }
    public int constantOps(){
        int counter = 0;
        double beginTime = System.nanoTime();
        counter++;
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("Constant:"+timeTaken);
        return counter;
    }
    public int logOps(int n){
        int counter = 0;
        double beginTime = System.nanoTime();
        for (int i=0; i<Math.log10(n); i++){
            counter++;
        }
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("Logarithmic:"+timeTaken);
        return counter;
    }
    public int nlogOps(int n){
        int counter = 0;
        double beginTime = System.nanoTime();
        for (int i=0; i<n; i++){
            for (int j=0; j<Math.log10(n); j++){
                counter++;
            }
        }
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("nLog:"+timeTaken);
        return counter;
    }
    public int polyOps(int n){
        int counter = 0;
        double beginTime = System.nanoTime();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                counter++;
            }
        }
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("Polynomial:"+timeTaken);
        return counter;
    }
    public int expOps(int n){
        int counter = 0;
        double beginTime = System.nanoTime();
        for (int i =0; i<Math.exp(n); i++){
            counter++;
        }
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        System.out.println("Exponential:"+timeTaken);
        return counter;
    }
    
    
    public static void main(String[] args){
        checkNotations c = new checkNotations();
        int n = 250;
        System.out.println("Linear Operations: "+c.linearOps(n));
        System.out.println("Log Operations: "+c.logOps(n));
        System.out.println("nLogn Operations: "+c.nlogOps(n));
        System.out.println("Polynomial Operations: "+c.polyOps(n));
        //System.out.println("Exponential Operations: "+c.expOps(n));
        System.out.println("Constant Operations: "+c.constantOps());
    }
}
