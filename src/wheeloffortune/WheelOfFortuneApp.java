/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Nelson Rodriguez
* ID: nir5113
*/
package wheeloffortune;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class WheelOfFortuneApp {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    JFrame GameFrame = new JFrame ();
    GameFrame.setVisible(true);
    GameFrame.setSize(640,480);
    GameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
}