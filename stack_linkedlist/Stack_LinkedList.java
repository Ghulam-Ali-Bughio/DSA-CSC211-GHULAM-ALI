/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack_linkedlist;

/**
 *
 * @author ga408
 */
public class Stack_LinkedList {

    public class Node{
    
    int data;
    Node next;
    public Node (int data){
            this.data=data;
            this.next=null;
                    }
    }
    private Node top;
    public Stack_LinkedList(){
this.top=null;

}
public void push(int data){
Node newNode =new Node(data);
if (top == null){
top=newNode;
return;
}
newNode.next=top;
top=newNode;
}
    public int peek(){
    return top.data;
    
    }
    public int  pop(){
    int temp =top.data;
    top=top.next;
    return temp;
    }
        public Node isEmpty(){
       return top=null;
}
        
        public void Display(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else {
        Node current =top;
        while(current!=null){
            System.out.println(current.data);
        current = current.next;
        }
        
        }
        }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  Stack_LinkedList S1 =new Stack_LinkedList();
        S1.push(10);
        S1.push(20);
        S1.push(30);
        System.out.println(S1.peek());
        System.out.println(S1.peek());
        System.out.println(S1.pop());  
        System.out.println(S1.peek());
        System.out.println(S1.isEmpty());
        
    }
    
}
