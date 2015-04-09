package lecture.javaSyntax;
public class TestArray {

    public static void main(String[] args) {
        int [][] irArray = {{ 1 },
                            { 2, 3, 4 },
                            { 5 },
                            { 6, 7 }};
        // get array dimensions
        System.out.println("Rows = " + irArray.length);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < irArray[i].length; j++) {
                System.out.println("array[" + i + ", " + j + "] = " +
                                   irArray[i][j]);
            }
        }
    }
}
