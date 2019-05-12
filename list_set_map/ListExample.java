/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list_set_map;

import java.util.*;

/**
 *
 * @author rockstar
 */
public class ListExample {
    public static void main(String args[]){
        List list = new ArrayList();
        list.add("Bernadine");
        list.add("Elizabeth");
        list.add("Gene");
        list.add("Elizabeth");
        list.add("Clara");
        System.out.println(list);
        LinkedList queue = new LinkedList();
        queue.addFirst("Bernadine");
        queue.addFirst("Elizabeth");
        queue.addFirst("Gene");
        queue.addFirst("Elizabeth");
        queue.addFirst("Clara");
        System.out.println(queue);
        
    }
}
