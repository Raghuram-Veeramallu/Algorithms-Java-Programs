/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_vertex_splitting;

import static java.lang.Integer.max;

/**
 *
 * @author rockstar
 */
public class greedyAlgo {
    
    int N = 13;
    
    int[] tree = {1,2,3,0,4,5,6,0,0,7,8,0,0,9,10};
    int[] weight = {0,4,2,0,2,1,3,0,0,1,4,0,0,2,3};
    int[] delay = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    int tol = 5;
    

    public void tvs(int i, int tol){
        if (tree[i-1] != 0 ){
            if ((2*i) > N){
                delay[i-1] = 0;
            }else{
                tvs(2*i, tol);
                delay[i-1] = max(delay[i-1], (delay[(2*i)-1]+weight[(2*i)-1]));
                if ((2*i)+1 <= N){
                    tvs((2*i)+1, tol);
                    delay[i-1] = max(delay[i-1], (delay[((2*i))]+weight[((2*i))]));
                }
            }
            if ((tree[i-1] != 1) && (delay[i-1] + weight[i-1] > tol)){
                System.out.println(tree[i-1]);
                delay[i-1] = 0;
            }
        }
    }
    
    public void exec_main(){
        tvs(1,tol);
    }
    
    
}
