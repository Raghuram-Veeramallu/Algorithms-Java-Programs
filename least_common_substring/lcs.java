/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package least_common_substring;

/**
 *
 * @author rockstar
 */
public class lcs {
    
    int counter = 0;
    
    public void findLCS(char[] x, char[] y){
        int n = x.length;
        int m = y.length;
        int[][] matrix = new int[(n+1)][(m+1)];
        
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (x[i-1] == y[j-1]){
                    matrix[i][j] = (matrix[i-1][j-1] + 1);
                }
                else{
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
                counter = counter + 1;
            }
        }
        
        printMatrix(matrix, n, m, x, y);
        
        System.out.println();
        System.out.println("Length of LCS = "+matrix[n][m]);
        System.out.println();
        
        findSubSeq(matrix, n, m, x, y);
        
    }
    
    public void findSubSeq(int[][] mat, int n, int m, char[] x, char[] y){
        
        int i = n;
        int j = m;
        char[] final_str = new char[mat[n][m]];
        int k = 0;
        
        while (j>=1 & i>=1){
            if (mat[i][j] == mat[i-1][j]){
                i = i-1;
            }else if (mat[i][j] == mat[i][j-1]){
                j = j-1;
            }else{
                i = i-1;
                j= j-1;
                final_str[k++] = x[i];
            }
            counter = counter + 1;
        }
        
        System.out.print("The longest substring possible is: ");
        System.out.println(new StringBuilder(new String(final_str)).reverse().toString());
        
        
    }
    
    
    public void printMatrix(int[][] mat, int n, int m, char[] x, char[] y){
        
        System.out.print("    Y   ");
        for (int k = 0; k<m; k++){
            System.out.print(y[k]+"   ");
        }
        System.out.println();
        
        for (int i=0; i<=n; i++){
            if (i != 0){
                System.out.print(x[i-1]+"   ");
            }else{
                System.out.print("X   ");
            }
            for (int j=0; j<=m; j++){
                System.out.print(mat[i][j]+"   ");
            }
            System.out.println();
        }
    }
    
    public void exec_main(){
        String x = "BAABCD";
        String y = "BACBAD";
        findLCS(x.toCharArray(), y.toCharArray());
        System.out.println("Complexity :"+counter+" "+" ");
    }
    
}
