/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author rockstar
 */
public class knapsack {
    
    int[] weights = {18,15,10};
    int[] price = {25,24,15};
    int m = 25;
    
    public Map<Float, Integer> computeRatio(int[] w, int[] p){
        //float[] ratio = new float[w.length];
        Map<Float, Integer> ratios = new TreeMap<>(Collections.reverseOrder());
        if (w.length == p.length){
            for (int i=0; i<w.length; i++){
                ratios.put(((float)p[i]/(float)w[i]), i);
            }
        }
        return ratios;
    }
    
    public ArrayList<Integer> checkCapacity(Map<Float, Integer> ratio, int[] weights, int[] prices, int m){
        int i = 0;
        int new_m = m;
        int final_price = 0;
        ArrayList final_w = new ArrayList<Integer>();
        for (Float r: ratio.keySet()){
            i = ratio.get(r);
            if (weights[i] <= new_m){
                final_w.add(weights[i]);
                new_m = m - weights[i];
                final_price = final_price + prices[i];
            }
        }
        return final_w;
    }
    
    public void exec_main(){
        int n = weights.length;
        Map<Float, Integer> ratio = computeRatio(weights, price);
//        for (Float r: ratio.keySet()){
//            String key =r.toString();
//            String value = ratio.get(r).toString();  
//            System.out.println(key + " " + value);  
//        } 
        ArrayList<Integer> final_w = checkCapacity(ratio, weights, price, m);
        System.out.println("Final Weights: "+final_w);
        
    } 
    
}
