/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection_sort;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rockstar
 */
public class sorted {
    
    ArrayList arr = new ArrayList();
    ArrayList sortedArr = new ArrayList();
    
    public void generateRandoms(int n){
        Random rand = new Random();
        for (int i=0;i<n;i++){
            arr.add(rand.nextInt(100));
        }
    }
    
    public void execute_main(int n){
        generateRandoms(n);
        System.out.print("Original Array: ");
        System.out.println(arr);
        ArrayList a = selectionSort(n, arr);
        System.out.print("Sorted Array: ");
        System.out.println(a);
    }
    
    public ArrayList selectionSort(int n, ArrayList array){
        if (n == 1){
            return array;
        }
        int max = (int) array.get(0);
        int pos = 0;
        for (int i=1; i<n;i++){
            if ((int)array.get(i) > max){
                max = (int)array.get(i);
                pos = i;
            }
        }
        array.remove(pos);
        array.add(n-1,max);
        
        return selectionSort(n-1, array);
        
    }
}
