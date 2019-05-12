/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rockstar
 */
public class unweighted {
    
    JFrame frame;
    
    public String[] takeInput(){
        frame = new JFrame("Unweighted Graph");
        String input = JOptionPane.showInputDialog(frame, "Enter the nodes between whih you want to find the distances:");
        String[] inp = input.split(" ");
        return inp;
    }
    
    public void displayOutput(String[] ip, int[] op){
        frame = new JFrame("Unweighted Graph");
        JOptionPane.showMessageDialog(frame, "The shortest path from "+ip[0]+" -> "+ip[1]+" is "+op[0]+" \n "+"The longest path from "+ip[0]+" -> "+ip[1]+" is "+op[1]);
        System.exit(0);
    }
    
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
    
    public int[][] computeAddition(int[][] adj1, int[][] adj2, int n){
        int[][] adj = new int[n][n];
        for (int a=0; a<n; a++){
            for (int b=0; b<n; b++){
                adj[a][b]= (adj1[a][b] | adj2[a][b]);
            }
        }
        return adj;
    }
    
    public int[] computeFinalAdj(int adj[][], int n, int n1, int n2){
        int temp[][] = new int[n][n];
        int[] dis = new int[2];
        temp = adj;
        if (temp[n1][n2] == 1){
            dis[0] = 1;
            dis[1] = 1;
        }
        for (int l = 1; l<n; l++){
            temp = computeBinaryMul(temp, adj, n);
            if (temp[n1][n2] == 1){
                if (dis[0] == 0){
                    dis[0] = (l+1);
                }
                if (dis[1] < (l+1)){
                    dis[1] = (l+1);
                }
            }
        }
        return dis;
    }
    
//    public void printFinalMatrix(int[][] adj, int n){
//        
//        System.out.println();
//        
//        for (int i=0; i<n; i++){
//            for (int j=0; j<n; j++){
//                System.out.print(adj[i][j]+"    ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
    
    
    
    public void exec_main(){
        int n = 5;
        HashMap<String, Integer> valuesCorr = new HashMap<String, Integer>();
        valuesCorr.put("A", 0);
        valuesCorr.put("B", 1);
        valuesCorr.put("C", 2);
        valuesCorr.put("D", 3);
        valuesCorr.put("E", 4);
        int[][] adj = {{0,0,1,1,0},{0,0,1,0,0},{0,0,0,1,1},{0,0,0,0,1},{0,0,0,1,0}};
        String[] inp = takeInput();
        int[] result = computeFinalAdj(adj, n, valuesCorr.get(inp[0]), valuesCorr.get(inp[1]));
        displayOutput(inp, result);
    }
    
    
}
