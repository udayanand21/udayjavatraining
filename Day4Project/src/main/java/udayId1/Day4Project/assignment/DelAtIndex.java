package udayId1.Day4Project.assignment;

import java.util.Scanner;

public class DelAtIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length; 

        System.out.print("BEFORE: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index to delete (0-" + (size - 1) + "): ");
        int index = sc.nextInt();

     
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            sc.close();
            return;
        }

       
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

      
        size--;

       
        arr[size] = 0;

        System.out.print("AFTER DELETE at index " + index + ": ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nCapacity remains: " + arr.length + ", Size now: " + size);

        sc.close();
    }
}