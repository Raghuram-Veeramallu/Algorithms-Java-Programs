/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_string_ops;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author rockstar
 */
public class StringOperations {
    
    static String mainString = "I stay at Shiv Nadar University in room 232, and I am a BTech student at Shiv Nadar University. I am from Idapadi, Tamil Nadu.";
    
    public void execute_main(){
        StringOperations so = new StringOperations();
        System.out.println(mainString);
        System.out.println(mainString.toUpperCase());
        String lowerString = mainString.toLowerCase();
        long count = lowerString.chars().filter(ch -> ch == 'u').count();
        System.out.println("Number of occurances of u in String are "+count);
        System.out.println(lowerString.replace("i", "$"));
        HashMap<String,Integer> hm=new HashMap<String,Integer>(so.wordCount(lowerString.split(" ")));
        for (String wrd: hm.keySet()){
            System.out.println(wrd.toString()+" : "+hm.get(wrd).toString());
        }
        System.out.println(mainString.trim());
        System.out.println("Length of string is "+mainString.length());
        System.out.println(mainString.charAt(2)+"  "+mainString.charAt(4)+"  "+mainString.charAt(5)+"  "+mainString.charAt(7)+"  "+mainString.charAt(14));
        System.out.println(new StringBuilder(mainString).reverse().toString());
        System.out.println("Palindromes:");
        String[] words_new = lowerString.replace(".", "").replace(",","").split(" ");
        Set<String> palindromes = new HashSet<>();
        for (String wrd: words_new) {
            if (so.isPalindrome(wrd)){
                System.out.println(wrd);
            }
        }
        
    }
    
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        for (String s:strings) {
          if (map.containsKey(s)) {
            count = map.get(s);
            map.put(s, count + 1);
          } else {
              map.put(s, 1);
          }
        }
        return map;
    }  
    
    public boolean isPalindrome(String input) {
        StringBuilder reverse = new StringBuilder(input).reverse();
        return (reverse.toString()).equals(input);
    }
    
}
