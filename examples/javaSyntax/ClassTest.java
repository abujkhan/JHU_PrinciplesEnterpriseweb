package lecture.javaSyntax;

public class ClassTest {
	
	public int divide(int a, int b) 
		throws DivideByZeroException { 
		if (b == 0) {
			throw new DivideByZeroException("divide by 0 error");
		}
		else return a/b;
	}
	
	public static void main(String args[]) {
		
		ClassTest object = new ClassTest();
		int a = 10;
		int b = 0;
		try {
			  int y = a/b;
			  int x = object.divide(a, b);
			}
			catch (DivideByZeroException d) {
			  System.out.println("Exception caught " + d.getMessage());
			}

	}


}
