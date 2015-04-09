package lecture.javaSyntax;

public class DivByZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int t = Integer.parseInt(args[0]);
			System.out.println(10/t);
			System.out.println("Program Completed");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException - " + e);
			System.out.println(10/1);
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("ArrayIndexOutOfBounds - " + e1);
		} catch (NumberFormatException n) {
			System.out.println("NumberFormat - " + n);
		} finally{
			System.out.println("DONE");
		}
	}
}
