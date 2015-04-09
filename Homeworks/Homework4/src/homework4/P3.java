/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * P3 Class
 */

package homework4;

public class P3 extends Aircraft {
   private int numberEngines;
    @Override
    public String toString()
   {
      return "Name: " + getName() + ", Type: " + getType() + ", Speed: " + getSpeed() + ", Altitude: "+ getAltitude() + ", Number Engine:" + getNumberEngines();
   }
    public int getNumberEngines(){
          return this.numberEngines;
    }
    public void setNumberEngines(int newNumber) throws IllegalArgumentException {
        if (newNumber<0)
            throw new IllegalArgumentException("Number of engines can not be negetive");
        else
        numberEngines = newNumber;
        
    }
}
