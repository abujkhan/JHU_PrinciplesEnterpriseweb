/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package learn;

import java.util.*;
import java.text.*;
public class Test {
   public static void main(String[] args) {
      GregorianCalendar worldTour = new GregorianCalendar(2015, 0, 1);
       Date beforeadd = worldTour.getTime();
      worldTour.add(GregorianCalendar.DATE, 3);
      Date d = worldTour.getTime();
      DateFormat df = DateFormat.getDateInstance();
      String s = df.format(d);
      String befs = df.format(beforeadd);
      System.out.println(befs + " --3 day trip will end " + s);
   }
}
