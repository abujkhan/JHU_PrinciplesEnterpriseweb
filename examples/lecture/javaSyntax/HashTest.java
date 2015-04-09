package lecture.javaSyntax;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = {"Rich", "Tom", "Jody", "Erika"};
		String[] indexes = {"0", "1", "2", "3"};

		Hashtable ht = new Hashtable();
		HashMap hm = new HashMap();
		
		for (int i = 0; i < names.length; i++) {
			ht.put(indexes[i], names[i]);
			hm.put(indexes[i], names[i]);
		}
		
		
		System.out.println("***** MAP *****");
		Collection a = (Collection)hm.values();
		for (Iterator iter = a.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}

}
