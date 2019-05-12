/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_adj;

/**
 *
 * @author rockstar
 */
public class graph {
    
    public int[][] computeBinaryMul(int[][] adj1, int[][] adj2, int n){
        int[][] adj = new int[5][5];
        for (int i=0; i<n; i++){
            for (int j=0 ; j<n ; j++){
                adj[i][j] = 0;
                for (int k=0; k<n; k++){
                    adj[i][j] = (adj[i][j] | (adj1[i][k] & adj2[k][j]));
                }
            }
        }
        return adj;
    }
    
//    public int multiplyMatrics(int[] ar1, int[] ar2, int n){
//        int ans = 0;
//        for (int k=0; k<n; k++){
//            ans = (ans | (ar1[k] & ar2[k]));
//        }
//        return ans;
//    }
    
    public int[][] computeAddition(int[][] adj1, int[][] adj2, int n){
        int[][] adj = new int[n][n];
        for (int a=0; a<n; a++){
            for (int b=0; b<n; b++){
                adj[a][b]= (adj1[a][b] | adj2[a][b]);
            }
        }
        return adj;
    }
    
    public void computeFinalAdj(int adj[][], int n){
        int final_adj[][] = new int[n][n];
        final_adj = adj;
        System.out.println("Initial Matrix");
        printFinalMatrix(final_adj, n);
        for (int l = 1; l<n; l++){
            final_adj = computeAddition(final_adj, computeBinaryMul(final_adj, adj, n), n);
            printFinalMatrix(computeBinaryMul(final_adj, adj, n), n);
        }
        printFinalMatrix(final_adj, n);
    }
    
    public void printFinalMatrix(int[][] adj, int n){
        
        System.out.println();
        
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(adj[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    public void exec_main(){
        int n = 5;
        int[][] adj = {{0,0,1,1,0},{0,0,1,0,0},{0,0,0,1,1},{0,0,0,0,1},{0,0,0,1,0}};
        computeFinalAdj(adj, n);
    }
    
}
