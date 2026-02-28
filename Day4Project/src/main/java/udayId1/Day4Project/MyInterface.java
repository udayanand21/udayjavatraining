package udayId1.Day4Project;

public interface MyInterface {
	public void display();
	public default void  printDetails() {
		System.out.println("default method of myinterface");
	}
	public static void useparking(String CompName) {
		System.out.println(CompName+ " is using parking");
	}
	
}
