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
public class weighted {
    JFrame frame;
    final static int INF = 999999;
    int V = 5;
    
    public String[] takeInput(){
        frame = new JFrame("Unweighted Graph");
        String input = JOptionPane.showInputDialog(frame, "Enter the nodes between whih you want to find the distances:");
        String[] inp = input.split(" ");
        return inp;
    }
    
    public void displayOutput(String[] ip, int op){
        frame = new JFrame("Unweighted Graph");
        JOptionPane.showMessageDialog(frame, "The shortest path from "+ip[0]+" -> "+ip[1]+" is "+op);
        System.exit(0);
    }
    
    public int floydWarshall(int graph[][], int n1, int n2) 
    { 
        int shortest = 0;
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
  
        for (k = 0; k < V; k++) 
        { 
            for (i = 0; i < V; i++) 
            { 
                for (j = 0; j < V; j++) 
                { 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            }             
        } 
        if (dist[n1][n2] != INF && dist[n1][n2] > 0){
                shortest = dist[n1][n2];
        }
  
        //printSolution(dist);
        return shortest;
    }  
    
//    public void printSolution(int dist[][]) 
//    { 
//        System.out.println("The following matrix shows the shortest "+ 
//                         "distances between every pair of vertices"); 
//        for (int i=0; i<V; ++i) 
//        { 
//            for (int j=0; j<V; ++j) 
//            { 
//                if (dist[i][j]==INF) 
//                    System.out.print("INF "); 
//                else
//                    System.out.print(dist[i][j]+"   "); 
//            } 
//            System.out.println(); 
//        } 
//    } 
    
    
    public void exec_main(){
        int n = 5;
        HashMap<String, Integer> valuesCorr = new HashMap<String, Integer>();
        valuesCorr.put("A", 0);
        valuesCorr.put("B", 1);
        valuesCorr.put("C", 2);
        valuesCorr.put("D", 3);
        valuesCorr.put("E", 4);

        int graph[][] = {{0, INF, 2, 1, INF}, {INF, 0, 4, INF, INF}, {INF, INF, 0, 6, 7}, {INF, INF, INF, 0, 9}, {INF, INF, INF, 2, 0}};
        String[] inp = takeInput();
        int result = floydWarshall(graph, valuesCorr.get(inp[0].toUpperCase()) ,valuesCorr.get(inp[1].toUpperCase()));
        displayOutput(inp, result);
    }
}
