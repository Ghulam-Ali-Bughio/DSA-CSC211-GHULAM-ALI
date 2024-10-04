/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort;

/**
 *
 * @author ga408
 */

public class Bubble_sort {
    
    public void bubblesort(int[] arr){
     
     
     int count=1;
     System.out.println("Before Bubble Sort");
               for(int i=0; i<arr.length; i++){
                   System.out.print(arr[i]+" "); 
               }
        System.out.println("");
    for (int i=arr.length; i>0; i--){
            for(int j=0; j<i-1; j++){
                
                System.out.println(++count +" ");
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    
                    
                }}}
    System.out.println("\nAfter Bubble Sort");
    for(int i=0; i<arr.length; i++){
                   System.out.print(arr[i]+" ");                    
               }
    
    
    }
    public static void main(String[] args) {
        int[] arr={5,1,3,4,6,2};
        Bubble_sort s1= new Bubble_sort();
        s1.bubblesort(arr);
    }
    
}
