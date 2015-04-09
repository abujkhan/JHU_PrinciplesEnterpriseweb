package lecture.javaSyntax;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Simple example illustrating the use of JColorChooser. 
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted.
 */

public class JColorChooserTest extends JFrame
                               implements ActionListener {
  public static void main(String[] args) {
    new JColorChooserTest();
  }

  public JColorChooserTest() {
    super("Using JColorChooser");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = getContentPane();
    content.setBackground(Color.white);
    content.setLayout(new FlowLayout());
    JButton colorButton
      = new JButton("Choose Background Color");
    colorButton.addActionListener(this);
    content.add(colorButton);
    setSize(300, 100);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Args are parent component, title, initial color.
    Color bgColor
      = JColorChooser.showDialog(this,
                                 "Choose Background Color",
                                 getBackground());
    if (bgColor != null)
      getContentPane().setBackground(bgColor);
  }
}