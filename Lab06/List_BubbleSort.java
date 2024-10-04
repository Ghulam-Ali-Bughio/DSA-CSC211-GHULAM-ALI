/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort;

/**
 *
 * @author ga408
 */
public class List_BubbleSort {
    
    public void bubblesort(String[] arr){
     
    
     System.out.println("Before Bubble Sort");
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+", "); 
    }
    for (int i=0; i<arr.length-1; i++){
        for(int j=0; j<arr.length-1; j++){
                
//                System.out.println(++count +" ");
            if(arr[j].length()-1>arr[j+1].length()-1){
                String temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;  
            }
        }
    }
        System.out.println("\nAfter bubble sort by length of Strings");
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+", "); 
    }
    }
    public static void main(String[] args) {
        List_BubbleSort sort=new List_BubbleSort();
        
        String arr[]={"apple","pie","banana","cat"};
        
        sort.bubblesort(arr);
    }
    
}
