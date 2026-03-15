package udayId1.Day4Project;

import java.util.Scanner;

public class DemoArrays {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int sum=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        System.out.println("Sum: "+sum);
        System.out.println("Even Numbers:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i]);
            }
        }
        

        sc.close();
    }
}