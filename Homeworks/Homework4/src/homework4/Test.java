/*
 * HomeWork 4
 * @author Abu Khan
 * Date: 9/27/2014
 * Test Class
 */

package homework4;

import java.util.ArrayList;

public class Test {
     public static void main(String[] args) {
         Destroyer destroyerReagan = new Destroyer();
         destroyerReagan.setLength(1000);
         destroyerReagan.setName("Des_Missicippi");
         destroyerReagan.setType("Destroyer");
         destroyerReagan.setNumberMissiles(5);
         //destroyerReagan.setNumberMissiles("foo");
         destroyerReagan.setSpeed("100");
         //System.out.println("----------Destroyer Missicippi-----------");
         //System.out.println(destroyerReagan.toString());
         Destroyer destroyerBush = new Destroyer();
         destroyerBush.setLength(800);
         destroyerBush.setName("Des_Florida");
         destroyerBush.setType("Destroyer");
         destroyerBush.setNumberMissiles(10);
         destroyerBush.setNumberMissiles("15");
         destroyerBush.setSpeed(200);
         //System.out.println("---------Destroyer Florida-----------");
         //System.out.println(destroyerBush.toString());
         
         Submarine submarineAtlantic = new Submarine();
         submarineAtlantic.setLength(300);
         submarineAtlantic.setName("Sub_Atlantic");
         submarineAtlantic.setType("Submarine");
         submarineAtlantic.setNumberTorpedos("foo");
         submarineAtlantic.setSpeed(200);
         //System.out.println("---------Submarine Atlantic-----------");
         //System.out.println(submarineAtlantic.toString());
         Submarine submarinePacific = new Submarine();
         submarinePacific.setLength(200);
         submarinePacific.setName("Sub_Pacific");
         submarinePacific.setType("Submarine");
         submarinePacific.setNumberTorpedos(7);
         submarinePacific.setSpeed(600);
         
         P3 p3Fighter = new P3();
         p3Fighter.setAltitude(10000);
         p3Fighter.setLength(100);
         p3Fighter.setName("Fighter3");
         p3Fighter.setSpeed(1500);
         p3Fighter.setType("Fighter Aircraft");
         p3Fighter.setNumberEngines(4);
         //System.out.println("---------Aircraft P3 Fighter-----------");
         //System.out.println(p3Fighter.toString());
         
         P3 p3Stealth = new P3();
         p3Stealth.setAltitude(20000);
         p3Stealth.setLength(200);
         p3Stealth.setName("Stealth3");
         p3Stealth.setSpeed(2000);
         p3Stealth.setType("Stealth Aircraft");
         p3Stealth.setNumberEngines(8);
         //System.out.println("---------Aircraft P3 Stealth-----------");
         //System.out.println(p3Stealth.toString());
         
         //collection of destroyer
         ArrayList <Destroyer> arrayListDestroyer = new ArrayList<Destroyer>();
         arrayListDestroyer.add(destroyerReagan);
         arrayListDestroyer.add(destroyerBush);
         //collection of submarines
         ArrayList <Submarine> arrayListSubmarine = new ArrayList<Submarine>();
         arrayListSubmarine.add(submarineAtlantic);
         arrayListSubmarine.add(submarinePacific);
         
         //collection of all ship
         ArrayList<Ship> arrayListShip = new ArrayList();
         arrayListShip.add(destroyerReagan);
         arrayListShip.add(destroyerBush);
         arrayListShip.add(submarineAtlantic);
         arrayListShip.add(submarinePacific);
         
         //collection of all contact
         ArrayList<Contact> arrayListContact = new ArrayList();
         arrayListContact.add(destroyerReagan);
         arrayListContact.add(destroyerBush);
         arrayListContact.add(submarineAtlantic);
         arrayListContact.add(submarinePacific);
         arrayListContact.add(p3Fighter);
         arrayListContact.add(p3Stealth);
         System.out.println("List of Contacts" +   "("+ arrayListContact.size() + "):");
         for (int i=0; i<arrayListContact.size(); i++)
         {
             Contact contact = arrayListContact.get(i);
             System.out.println("    " + contact.toString() + "  ");
         }
          
         
     }
    
}
