/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_nos;

import java.lang.Math;
import java.math.BigInteger;

/**
 *
 * @author rockstar
 */
public class primeNos {
    
    public void execute_main(){
        long n = 73L;
        System.out.println("The time taken to find it is: "+isPrimeFull(n));
    }
    
    public double isPrimeSqrt(long n){
        double maxNo = Math.sqrt(n);
        double beginTime = System.nanoTime();
        boolean check = checkPrime(n,maxNo);
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        if (check){
            System.out.println("The number is prime");
        }else{
            System.out.println("The number is not prime");
        }
        return timeTaken;
    }
    
    public double isPrimeHalf(long n){
        double maxNo = n/2;
        double beginTime = System.nanoTime();
        boolean check = checkPrime(n,maxNo);
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        if (check){
            System.out.println("The number is prime");
        }else{
            System.out.println("The number is not prime");
        }
        return timeTaken;
    }
    
    public double isPrimeFull(long n){
        double maxNo = n-1;
        double beginTime = System.nanoTime();
        boolean check = checkPrime(n,maxNo);
        double endTime = System.nanoTime();
        double timeTaken = endTime - beginTime;
        if (check){
            System.out.println("The number is prime");
        }else{
            System.out.println("The number is not prime");
        }
        return timeTaken;
    }
    
    
    public boolean checkPrime(long n, double maxNo){
        for (long i=2L; i<=maxNo; i++){
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }
}
