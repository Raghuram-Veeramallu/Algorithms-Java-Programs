/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap_sort;

import java.util.Arrays;

/**
 *
 * @author rockstar
 */
public class HeapSort {
    
    public boolean insert(int[] a, int n){
        int i = n;
        int item = a[n-1];
        while ((i>1) && (a[i/2-1] < item)){
            a[i-1] = a[i/2-1];
            i = i/2;
        }
        a[i-1] = item;
        return true;
    }
    
    public void adjust(int[] a, int i, int n){
        int j = 2*i;
        int item = a[i-1];
        while(j<=n){
            if ((j<n) && (a[j-1] < a[j])){
                j= j+1;
            }
            if (item >= a[j-1]){
                break;
            }
            a[j/2-1] = a[j-1];
            j = 2*j;
        }
        a[j/2-1] = item;
    }
    
    
    public void heapify(int[] a, int n){
        for (int i=(n/2); i>1; i--){
            adjust(a, i, n);
        }
    }
    
    public void heapSort(int a[], int n){
        heapify(a,n);
        for (int i=n; i>2; i--){
            int t = a[i-1];
            a[i-1] = a[0];
            a[0] = t;
            adjust(a,1,i-1);
        }
        System.out.println(Arrays.toString(a));
    }
    
    
    public void exec_main(){
        int[] a = {100,119,171,112,118,151,132};
        heapSort(a, a.length);
    }
    
    
}
