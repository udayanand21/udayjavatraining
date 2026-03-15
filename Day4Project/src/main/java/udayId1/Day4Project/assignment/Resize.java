package udayId1.Day4Project.assignment;

import java.util.Scanner;

public class Resize {

    
    public static int[] doubleCapacity(int[] arr) {
        int oldLen = arr.length;
        int newLen = (oldLen == 0) ? 2 : oldLen * 2; 
        int[] newArr = new int[newLen];

        for (int i = 0; i < oldLen; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter initial array size (capacity): ");
        int capacity = sc.nextInt();
        if (capacity < 0) {
            System.out.println("Size cannot be negative.");
            sc.close();
            return;
        }

       
        int[] arr = new int[capacity];
        System.out.print("Enter how many elements you want to fill (0-" + capacity + "): ");
        int size = sc.nextInt();

        if (size < 0 || size > capacity) {
            System.out.println("Invalid size. Must be between 0 and " + capacity);
            sc.close();
            return;
        }

    
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

       
        System.out.print("\nBEFORE (size/capacity = " + size + "/" + arr.length + "): [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");

      
        arr = doubleCapacity(arr);

        
        System.out.print("AFTER  (size/capacity = " + size + "/" + arr.length + "): [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");

        sc.close();
    }
}