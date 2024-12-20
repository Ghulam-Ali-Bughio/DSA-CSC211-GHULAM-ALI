/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ga408
 */
class Node{
 int data;
 Node left;
 Node right;
 Node(int data){
 this.data=data;
 this.left=this.right=null;
 }
         
    
}
public class BST {
    
    Node root;
    BST(){
        this.root=null;
    }
    void Insertion(int val){
        if(root==null){
        this.root=new Node(val);
            System.out.println("Inserted at root ");    
             return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            
            if (val < current.data) {
                current = current.left;
                if (parent.left == null) {
                    parent.left = new Node(val);
                    System.out.println(val + " inserted at left");
                    return;
                }
               
            } else {
                current = current.right;
                if (parent.right == null) {
                    parent.right = new Node(val);
                    System.out.println(val+ " inserted at right");
                    return;
                }

        
    }
        }
    }
    void In_Order(Node root){
        if(root==null){
            return;
        }
        In_Order(root.left);
        System.out.print(" "+root.data);
        In_Order(root.right);
        
    }
    Node deletion(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deletion(root.left, key);
        } else if (key > root.data) {
            root.right = deletion(root.right, key); 
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.data= temp.data;
            root.right = deletion(root.right, temp.data);
        }

        return root;
    }
    
    public static void main(String[] args) {
         BST n1=new BST();
        System.out.println("");
        n1.Insertion(9);
        n1.Insertion(25);
         n1.Insertion(8);
        n1.Insertion(78);
         n1.Insertion(66);
        n1.Insertion(2);
         n1.Insertion(70);
        n1.Insertion(5);
        n1.In_Order(n1.root);
        System.out.println(" ");
        n1.deletion(n1.root,70);
        n1.In_Order(n1.root);
        System.out.println("");
    }
    
}
