package hw3java;
/**
 *
 * @author Abu Khan
 * Project: HW 3 (testing for the project(Calculate product of two integers)
 */
public class TestCalculate {
    
    public static void main (String[] args){
        Calculate tcal = new Calculate();
        int i =  Integer.parseInt(args[0]) ;
        int j = Integer.parseInt(args[1]) ;
        //int j = -50;
        int presult = tcal.getProduct(i, j);
        if (presult < 0){
            System.out.println("The product of " + i + " and " + j +
                    " is (" +  -presult + ")");
              }
        else
        {
            System.out.println("The product of " + i + " and " + j +
                    " is " +  presult );
        }
}
}
