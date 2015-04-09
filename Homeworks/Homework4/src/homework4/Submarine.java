/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * Submarine Class
 */
package homework4;

public class Submarine extends Ship {
    private int numberTorpedos;
    @Override
    public String toString()
   {
      return "Name: " + getName() + ", Type: " + getType() + ", Speed: " + getSpeed() + ", Number Torpedos:" + getNumberTorpedos();
   }
    public int getNumberTorpedos(){
          return this.numberTorpedos;
    }
    public void setNumberTorpedos(int newNumber) throws IllegalArgumentException{
        if (newNumber<0)
            throw new IllegalArgumentException("Number of torpedos can not be negetive");
        else
        numberTorpedos = newNumber;
    }
    public void setNumberTorpedos(String newNumber) throws IllegalArgumentException {
        try {
            Integer number = Integer.parseInt(newNumber);
            if (number<0)
                    throw new IllegalArgumentException("Number of torpedos can not be negetive");
            else
            numberTorpedos = number;
        }catch (NumberFormatException e){
                numberTorpedos = 2;
        }
    }
    
}
