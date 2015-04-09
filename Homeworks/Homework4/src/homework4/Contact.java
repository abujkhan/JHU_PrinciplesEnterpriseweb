/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * Contact interface
 */

package homework4;

public interface Contact {
    //getter and setter for length
    public int getLength();
    public void setLength(int newLegth) ;
    //getter and setter for speed
    public int getSpeed();
    public void setSpeed(int newSpeed);
    
    public void setSpeed(String newSpeed);
    //getter and setter for name
    public String getName();
    public void setName(String newName);
    //getter and setter for type
    public String getType();
    public void setType(String newType);
    
    
}
