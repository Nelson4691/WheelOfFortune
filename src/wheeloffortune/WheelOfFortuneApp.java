/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Nelson Rodriguez
* ID: nir5113
*/
package wheeloffortune;

import java.util.Scanner;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class WheelOfFortuneApp {
    
    String buyVowel = "You have select to buy a vowel";
    String spinWheel = "You have selected to spin the wheel";
    String solvePuzzle = "You have selected to solve the pizzle";
    
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      
      
  System.out.println("Please select from the following options:");
  System.out.println("Press 1 Spin the wheel");
  System.out.println("Press 2 Buy a vowel");
  System.out.println("Press 3 Solve the puzzle");
  System.out.println("Press 4 Quit the game");
  
  Scanner reader = new Scanner(System.in);
  String selection = reader.next();
  
  
  
  System.out.println("You have selected to:" + selection);
  
  
  
    /*
    JFrame GameFrame = new JFrame ();
    GameFrame.setVisible(true);
    GameFrame.setSize(640,480);
    GameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);*/
  }
  
  public boolean validateInput(String selection){
      return selection.matches(selection);
  }
  
  
  
}
