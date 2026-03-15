package udayId1.Day4Project.assignment;
import java.util.Scanner;
public class Insertion {
	public static void main(String[]args) {
		int arr[]= {1,2,3,4,5,6};
		for(int num:arr) {
			System.out.print(num+"");
		}
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter value to be inserted");
		int value = sc.nextInt();
		System.out.println("Enter the index for value  to be inserted at");
		int i = sc.nextInt();
		arr[i]=value;
		System.out.println("AFTER INSERTION");
		for(int num:arr) {
			System.out.print(num+"");
		}
	}

}
