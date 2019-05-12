/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursive_sorting;

/**
 *
 * @author rockstar
 */
public class selection {
    
    // Return minimum index 
    public int getMinIndex(int a[], int i, int j) { 
        if (i == j) 
            return i; 
       
        // Find minimum of remaining elements 
        int k = getMinIndex(a, i + 1, j); 
       
        // Return minimum of current and remaining. 
        return (a[i] < a[k])? i : k; 
    } 
       
    // Recursive selection sort. n is size of a[] and index 
    // is index of starting element. 
    public void selection(int a[], int n, int index) { 
           
        // Return when starting and size are same 
        if (index == n) 
           return; 
       
        // calling minimum index function for minimum index 
        int k = getMinIndex(a, index, n-1); 
       
        // Swapping when index nd minimum index are not same 
        if (k != index){ 
           // swap 
           int temp = a[k]; 
           a[k] = a[index]; 
           a[index] = temp; 
        } 
        // Recursively calling selection sort function 
        selection(a, n, index + 1); 
    } 
       
      
    public void exec_main(){ 
        int arr[] = {3, 1, 5, 2, 7, 0}; 
       
        // Calling function 
        selection(arr, arr.length, 0); 
       
        //printing sorted array 
        for (int i = 0; i< arr.length; i++) 
            System.out.print(arr[i] + " "); 
    } 
    
    
    
}
