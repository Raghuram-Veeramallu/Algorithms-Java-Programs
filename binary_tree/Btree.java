/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

/**
 *
 * @author rockstar
 */
public class Btree {
    private Node root;
    // Root node pointer. Empty initially
    
    private static class Node{
        Node left;
        Node right;
        int data;
        
        Node(int newData){
            left = null;
            right = null;
            data = newData;
        }
    }
    
    public void Btree(){
        root = null;
    }
    
    public Node insertRecursive(Node tree, int data){
        if (tree == null){
            tree = new Node(data);
        }else{
            if (data <= tree.data){
                tree.left = insertRecursive(tree.left, data);
            }else{
                tree.right = insertRecursive(tree.right, data);
            }
        }
        return tree;
    }
    
    public Node insertIterative(Node tree, int data){
        Node n = new Node(data);
        Node temp = tree;  
        Node y = null;  
        while (temp != null) {  
            y = temp;  
            if (data < temp.data)  
                temp = temp.left;  
            else
                temp = temp.right;  
        }  
        if (y == null){
            y = n; 
        }  
        else if (data < y.data){
            y.left = n;
        }
        else{
            y.right = n;  
        }

        return y;  
    }
    public void printInorder(Node tree){
        if (tree == null){
            return;
        }
        printInorder(tree.left);
        System.out.print(tree.data+", ");
        printInorder(tree.right);
    }
    public void printPreorder(Node tree){
        if (tree == null){
            return;
        }
        System.out.print(tree.data+", ");
        printPreorder(tree.left);
        printPreorder(tree.right);
    }
    public void printPostorder(Node tree){
        if (tree == null){
            return;
        }
        printPostorder(tree.left);
        printPostorder(tree.right);
        System.out.print(tree.data+", ");
    }
    public Boolean searchRecursive(Node tree, int data){
        if (tree == null){ 
            return false;
        }
        if (tree.data == data){
            return true;
        }
        if (tree.data > data) {
            return searchRecursive(tree.left, data);
        }else if (tree.data < data){
            return searchRecursive(tree.right, data);
        }
        return false;
    }
    
    public boolean searchIterative(Node tree, int data){
        Node n = new Node(data);
        Node temp = tree;  
        Boolean b = false;
        while (temp != null) {  
            if (temp.data == data){
                b = true;
                break;
            }
            else if (data < temp.data)  
                temp = temp.left;  
            else
                temp = temp.right;  
        }
        return b;
    }
    
    public void executeMain(){
        root = insertRecursive(root, 6);
        insertRecursive(root, 3);
        insertRecursive(root, 9);
        insertRecursive(root, 2);
        insertRecursive(root, 7);
        insertIterative(root, 1);
        insertIterative(root, 11);
        insertIterative(root, 8);
        printInorder(root);
        System.out.println();
        printPreorder(root);
        System.out.println();
        printPostorder(root);
        System.out.println();
        System.out.println(searchIterative(root, 9));
        System.out.println(searchRecursive(root, 4));
        
    }
    
    
}
