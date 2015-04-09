package lecture.javaSyntax;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a = new ArrayList();
		for (int i = 0; i < 20; i++)
			a.add(new Integer(i));
		
		for (Iterator i = a.iterator(); i.hasNext();) {
			Integer o = (Integer)i.next();
			int x = 10 * o;
			System.out.println(x);
		}
		
	}

}
