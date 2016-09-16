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

  /**
   * @param args the command line arguments
   */
    
    
  public static void main(String[] args) {
      
    String spinWheel = "Spin the wheel";
    String buyVowel = "Buy a vowel";
    String solvePuzzle = "Solve the puzzle";    
      
  System.out.println("Please select from the following options:");
  System.out.println("Press 1 to Spin the wheel");
  System.out.println("Press 2 to Buy a vowel");
  System.out.println("Press 3 Solve the puzzle");
  System.out.println("Press 4 Quit the game");
  
  Scanner sc = new Scanner(System.in);
  int Selection = sc.nextInt();
  
  switch (Selection){
      case 1:
          System.out.println("You have chosen to "+spinWheel);
          break;
      case 2:
          System.out.print("You have chosen to "+ buyVowel);
          break;
      case 3:
          System.out.println("You have chosen to "+ solvePuzzle);
          break;
      case 4:
          System.exit(0);
  }
  
  
  
  
  
  
  
    /*
    JFrame GameFrame = new JFrame ();
    GameFrame.setVisible(true);
    GameFrame.setSize(640,480);
    GameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);*/
  }
  
}
