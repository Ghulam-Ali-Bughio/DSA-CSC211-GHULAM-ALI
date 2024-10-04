/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort;

/**
 *
 * @author ga408
 */
public class Opt_Bubble {
    public static void early_Stop_Bubble_Sort(int[] arr) {
        
        boolean swapped;
        int count=1;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false; 
            
            for (int j = 0; j < arr.length - 1 - i; j++) { 
                if (arr[j] > arr[j + 1]) {
                    System.out.println(++count +" ");
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; 
                    
                }
            }
            if (!swapped) {
                break; 
            }
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(arr);
        
        early_Stop_Bubble_Sort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
    
}
