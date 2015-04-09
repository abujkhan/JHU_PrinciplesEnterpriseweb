/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * Aircraft Class
 */

package homework4;

public abstract class Aircraft implements Contact {
     private int length;
     private int speed;
     private String name;
     private String type;
     private int altitude;
     public int getLength(){
         return this.length;
     }
     
     public void setLength(int newLength)throws IllegalArgumentException {
         if (newLength<0)
            throw new IllegalArgumentException("Length can not be negetive");
         else
         length = newLength;
     }
      //getter and setter for speed
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int newSpeed)throws IllegalArgumentException{
        if (newSpeed<0)
            throw new IllegalArgumentException("Speed can not be negetive");
        else
        speed = newSpeed;
    }
     public void setSpeed(String newSpeed) throws IllegalArgumentException{
          try {
                Integer intSpeed = Integer.parseInt(newSpeed);
                if (intSpeed<0)
                    throw new IllegalArgumentException("Speed can not be negetive");
                else
                speed = intSpeed;
          }catch (NumberFormatException e){
                System.err.println("Ilegal input: Speed of " + getName() + ", "+ newSpeed + " is not an integer...Default value  " + speed);
          }
     }
    //getter and setter for name
     
    public String getName(){
        return this.name;
    }
    public void setName(String nm){
        name = nm;
    }
     public String getType(){
         return this.type;
     }
    public void setType(String tp){
        type = tp;
    }
    public int getAltitude(){
        return this.altitude;
    }
    public void setAltitude(int newAltitude) throws IllegalArgumentException{
        if (newAltitude<0)
            throw new IllegalArgumentException("Altitude can not be negetive");
        else
        altitude = newAltitude;
    }
    
    
}
