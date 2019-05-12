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
public class bubble {
    
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public int[] bubblesort(int arr[], int n){
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
	}
        
        if (n - 1 > 1) {
            bubblesort(arr, n - 1);
	}
        return arr;
    }
    
    public void exec_main(){
        int arr[] = {3, 5, 8, 4, 1, 9, -2};
        System.out.println(Arrays.toString(arr));
        int arr2[] = bubblesort(arr, arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}
