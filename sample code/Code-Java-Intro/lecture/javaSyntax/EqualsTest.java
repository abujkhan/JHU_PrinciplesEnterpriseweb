package lecture.javaSyntax;
public class EqualsTest {
	public static void main(String[] args) {
		String match = "Test";
		if (args.length == 0) {
			System.out.println("No args");
		} else if (args[0] == match) {
                    System.out.println("argument == match");
		} else if (args[0].equals(match)){
			System.out.println("arguemnt.equals(Match)");
		} else {
			System.out.println("No match");
		}
	}
}
