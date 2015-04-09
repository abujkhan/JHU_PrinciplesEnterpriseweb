package lecture.javaSyntax;

import java.util.ArrayList;
import java.util.Iterator;

public class Generics {

	private static String[] darray = {"1.0asdf", "2.0sdf", "3.0asdf", "4.0asf"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList holder = new ArrayList();
		
		for (int i = 0; i < darray.length; i++) 
			holder.add(darray[i]);
		
		for (Iterator i = holder.iterator(); i.hasNext();) {
			String x = (String)i.next();
			System.out.println("Casting -- Have new double = " + x);
		}
		
		for (Iterator<String> i = holder.iterator(); i.hasNext();) {
			String y = i.next();
			System.out.println("Generic -- Have new double = " + y);
		}
		

	}

}
