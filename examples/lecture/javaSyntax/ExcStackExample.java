package lecture.javaSyntax;

public class ExcStackExample {

	public int divide(int a, int b) {
		return a/b;
	}
	
	public int getValue(int a, int b) {
		return divide(a, b);
	}
	
	public static void main(String args[]) {
		int a = 1;
		int b = 0;
		ExcStackExample exc = new ExcStackExample();
		System.out.println(exc.divide(a, b));
	}
	
}
