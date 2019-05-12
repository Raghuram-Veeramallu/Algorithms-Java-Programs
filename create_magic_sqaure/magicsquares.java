/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_magic_sqaure;

/**
 *
 * @author rockstar
 */
public class magicsquares {
    
    
    public int[][] insertNos(int m, int[][] arr, int i, int j, int n){
        
        if (m > (n*n)){
            return arr;
        }
        
        if (arr[i][j] != 0){
            i = (i+1)%n;
        }
        
        arr[i][j] = m;
        return insertNos(m+1, arr, (i-1+n)%n, (j-1+n)%n, n);
        
    }
    
    
    public void magic(int n, int[][] arr, int m){
        int[][] arr1 = insertNos(1, arr, 0, n/2, n);
        print(arr1, n);
    }
    
    public void print(int arr[][], int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.printf("%3d ",(arr[i][j]));
            }
            System.out.println();
        }
    }
    
    public void exec_main(){
        int n = 3;
        int m = 0;
        int[][] arr = new int[n][n];
        magic(n, arr, m);
    }
    
}
