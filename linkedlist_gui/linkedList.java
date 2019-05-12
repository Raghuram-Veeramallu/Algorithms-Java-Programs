package linkedlist_gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Rockstar
 */


public class linkedList {

    LinkedList list = new LinkedList();
    Random random = new Random();
    
    public linkedList() {
        addRandomNos();
        setText();
        Boolean run = true;
        while(run){
            create_joptions_pane();
            setText();
        }
    }
    
    public void create_joptions_pane(){
        String command;
        command = JOptionPane.showInputDialog("Please enter the command:");
        check_command(command);
    }
    
    public Boolean check_command(String command){
        switch(command){
            case "Push":{
                int a = random.nextInt(50);
                push(a);
                return true;
            }
            case "Pop":{
                pop();
                return true;
            }
            case "Add":{
                int a = random.nextInt(50);
                add(a);
                return true;
            }
            case "Delete":{
                delete();
                return true;
            }
            case "Quit":{
                System.exit(0);
                return false;
            }
        }
        return true;
    }
    
    
    public void addRandomNos() {
        int n;
        for (int i=0; i<10; i++){
            n = random.nextInt(100);
            list.add(n);
        }
    }
    
    public void push(int n){
        list.addFirst(n);
    }
    
    public int pop(){
        int n = (Integer) list.removeFirst();
        return n;
    }
    
    public void add(int n){
        list.addFirst(n);
    }
    
    public int delete(){
        int n = (Integer) list.removeLast();
        return n;
    }                                       

    private void setText(){
        System.out.println(list.toString());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new linkedList();
            }
        });
    }
                         
}


