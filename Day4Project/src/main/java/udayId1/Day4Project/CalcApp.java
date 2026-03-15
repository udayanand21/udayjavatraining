package udayId1.Day4Project;

public class CalcApp {

	public CalcApp() {
		super();
	}
//	@Override
//	public void add(int a, int b) {
//		System.out.println("Sum:"+ (a+b));
//		
//	}
	public static void main(String[]args) {
		CalcInterface ca = (a,b)->System.out.print("Sum: "+(a+b));
		ca.add(67,54);
		
	}

}
