package lecture.javaSyntax;
import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Java 1.1 Vector
		Vector v1 = new Vector();
		for(int i = 0; i < 10; i++) {
			v1.addElement(new Integer(i));
		}
		
		// Java 1.5 with Generics
		Vector<Integer> v2 = new Vector<Integer>();
		for(int i = 0; i < 10; i++) {
			v2.addElement(new Integer(i));
		}
		
		// Java 1.1 Vector
		int total = 0;
		for (int i = 0; i < v1.size(); i++) {
			total = total + ((Integer)v1.get(i)).intValue();
		}
		System.out.println("Total0 = " + total);
		
		// Java 1.5 with Generics and Autoboxing
		total = 0;
		for (int i = 0; i < v2.size(); i++) {
			total = total + v2.get(i);
		}
		System.out.println("Total1 = " + total);
		
		// Java 1.1 Vector
		total = 0;
		for (Enumeration e = v1.elements(); e.hasMoreElements();) {
			total += ((Integer)e.nextElement()).intValue();
		}
		System.out.println("Total2 = " + total);
		
		// Java 1.5 with Generics 
		total = 0;
		for (Enumeration<Integer> e = v2.elements(); e.hasMoreElements();) {
			total += (e.nextElement()).intValue();
		}
		System.out.println("Total3 = " + total);
		
		// Java 1.1 Vector
		total = 0;
		for (Object i : v1) {
			total = total + ((Integer)i).intValue();
		}
		System.out.println("Total4 = " + total);
		
		// Java 1.5 with Generics and Autoboxing
		total = 0;
		for (int i : v2) {
			total = total + i;
		}
		System.out.println("Total5 = " + total);	
	}
}
