/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Nelson Rodriguez
* ID: nir5113
*/
package wheeloffortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class WheelOfFortuneApp {
    
    
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      
      List<String> Options = new ArrayList<>();
    String letterGuess;
    boolean letterCheck;
      
      
    String buyVowel = "You have select to buy a vowel";
    String spinWheel = "You have selected to Spin the wheel";
    String solvePuzzle = "You have selected to Solve the pizzle";
    
    Options.add(buyVowel);
    Options.add(spinWheel);
    Options.add(solvePuzzle);
    
  System.out.println("Please select from the following options:");
  System.out.println("Press 1 to Buy a vowel");
  System.out.println("Press 2 to Spin the wheel");
  System.out.println("Press 3 to Solve the puzzle");
  System.out.println("Press 4 to Guess Letter");
  System.out.println("Press 5 to Quit the game");
  System.out.println("Press 6 to Test letter input");
 
  
  
  Scanner userInput = new Scanner(System.in);
  int selection = Integer.parseInt(userInput.next()) ;
  
  
  
  switch (selection){
      case 1:
          System.out.print(Options.get(0));
          break;
      case 2:
          System.out.print(Options.get(1));
          break;
      case 3:
          System.out.print(Options.get(2));
          break;
      case 4:
          System.out.println("Please guess a letter from A-Z");
          letterGuess  =(userInput.next());
          
          while(!Character.isLetter(letterGuess.charAt(0))){     
              System.out.println("Invalid!\n Please guess a letter from A-Z");
              letterGuess  =(userInput.next());
              
          }
          System.out.println("You guessed letter " + letterGuess);
          break;
      case 5:
          System.exit(0);
          break;
      case 6:
          System.out.println("Please guess a letter from A-Z");
          letterGuess  =(userInput.next());
          
          while(!Character.isLetter(letterGuess.charAt(0))){     
              System.out.println("Invalid!\n Please guess a letter from A-Z");
              letterGuess  =(userInput.next());
              
          }
          System.out.println("You Entered " + letterGuess);
          break;
  
  } 
}
}
