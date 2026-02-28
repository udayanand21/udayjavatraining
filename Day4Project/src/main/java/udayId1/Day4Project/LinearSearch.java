package udayId1.Day4Project;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {22, 33, 43, 21, 43, 65};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int pos = -1; // -1 means not found
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                pos = i;
                break; // stop at first occurrence
            }
        }

        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + pos);
        }

        sc.close();
    }
}
