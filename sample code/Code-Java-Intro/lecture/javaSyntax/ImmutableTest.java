package lecture.javaSyntax;

public class ImmutableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String builder = new String("X");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++)
			builder += "X";
		long time = System.currentTimeMillis() - start;
		System.out.println("String built in " + time + " msec");
		
		StringBuffer build = new StringBuffer("X");
		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++)
			build.append("X");
		time = System.currentTimeMillis() - start;
		System.out.println("StringBuffer built in " + time + " msec");
	}

}
