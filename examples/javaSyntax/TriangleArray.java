package lecture.javaSyntax;
public class TriangleArray {
  public static void main(String[] args) {
  
    int[][] triangle = new int[10][];
    
    for(int i=0; i<triangle.length; i++) {
      triangle[i] = new int[i+1];
    }
    
    for (int i=0; i<triangle.length; i++) {
      for(int j=0; j < 5;/* triangle[i].length;*/  j++) {
        System.out.print(triangle[i][j]);
      }
      System.out.println();
    }
  }
}
