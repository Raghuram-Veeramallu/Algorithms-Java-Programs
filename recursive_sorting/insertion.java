/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursive_sorting;

import java.util.Arrays;

/**
 *
 * @author rockstar
 */
public class insertion {
    
    public void insertion(int arr[], int n){ 
        if (n <= 1) 
            return; 
       
        // Sort first n-1 elements 
        insertion( arr, n-1 ); 
       
        // Insert last element at its correct position 
        // in sorted array. 
        int last = arr[n-1]; 
        int j = n-2; 
       
        /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j] > last) 
        { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = last; 
    } 
      
    public void exec_main(){ 
        int arr[] = {12, 11, 13, 5, 6}; 
        insertion(arr, arr.length); 
        System.out.println(Arrays.toString(arr)); 
    } 
}
