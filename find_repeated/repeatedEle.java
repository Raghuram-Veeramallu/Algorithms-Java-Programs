/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find_repeated;

import java.util.Random;

/**
 *
 * @author rockstar
 */
public class repeatedEle {
    
    public int repeat(int[] arr, int n){
        
        int count = 0;
        
        Random rand = new Random();
        
        while(true){
            count = count + 1;
            int i = rand.nextInt(n+1);
            int j = rand.nextInt(n+1);
            if ((i != j) && arr[i] == arr[j]){
                System.out.println(count);
                return i;
            }
        }
        
    }
    
    public void exec_main(){
        Random rand = new Random();
        int n = 100;
        int[] arr = new int[100];
        for (int i=0; i<(n/2); i++){
            arr[i] = (i+1);
        }
        int nextEle = arr[rand.nextInt(n/2)];
        for (int i=(n/2 + 1); i<n; i++){
            arr[i] = nextEle;
        }
        repeat(arr,n);
    }
    
}
