/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * Destroyer Class
 */
package homework4;

public class Destroyer extends Ship {
    private int numberMissile;
    
    @Override
    public String toString()
   {
      return "Name: " + getName() + ", Type: " + getType() + ", Speed: " + getSpeed() + ", Number Missile:" + getNumberMissiles();
   }
    public int getNumberMissiles(){
          return this.numberMissile;
    }
    public void setNumberMissiles(int newNumber) throws IllegalArgumentException{
        if (newNumber<0)
            throw new IllegalArgumentException("Number of missile can not be negetive");
        else
             numberMissile = newNumber; 
    }
    public void setNumberMissiles(String newNumber) throws IllegalArgumentException {
        try {
                Integer number = Integer.parseInt(newNumber);
                if (number<0)
                    throw new IllegalArgumentException("Number of missile can not be negetive");
              else
                numberMissile = number;
                
        }catch (NumberFormatException e){
                numberMissile = 2;
        }
    }
}
