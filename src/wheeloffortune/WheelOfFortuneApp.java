/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Nelson Rodriguez
* ID: nir5113
*/
package wheeloffortune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;




public class WheelOfFortuneApp {
private static Map<String,String> selectedOptions; //Arraylist for selected options
private static List<String> wedgeOptions;          //Arraylist for  different wedge choices 
private static List<String> gameOptions;           //ArrayList for providing game option
private static Scanner  userInput;                 //
private static String letterGuess;
private static String currentWord;
private static boolean letterCheck;
private static int randomValue;
private static Random randGenerator;
private static List<String> vocabList;
private static String wordGuessDisplay=""; 
    
  public static void main(String[] args) {
      
      
      gameOptions = new ArrayList<>();
      //created two methods which add the game options which are included in an
      // arraylist
      addVocabList();
      addGameOptions();
      addwedgeOptions();
      
      //Test Code
      System.out.println(wedgeOptions.size());
      System.out.println(gameOptions.size());
      getVocabWord();
      System.out.println(currentWord.length());
      
      displayMenuTitle();
      displayWordSpaces();
      displayGameOptions();
      
      //Ask for option selection
      userInput = new Scanner(System.in);
      int selection = Integer.parseInt(userInput.next()) ;
      
      switch (selection){
      case 1:
      System.out.print("You Landed on: "+wedgeOptions.get(getWedge())+"\n");
      System.out.print("Enter a letter to guess: ");
      letterGuess  =(userInput.next());
        while(!Character.isLetter(letterGuess.charAt(0))){
            System.out.println("Invalid!\n Please guess a letter from A-Z");
            letterGuess  =(userInput.next());
      }
      //include method for checking and comparing here
      break;
      case 2:
      System.out.print(selectedOptions.get(1));
      break;
      case 3:
      System.out.print(selectedOptions.get(2));
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
    private static int getWedge(){
      randGenerator = new Random(); //what if you instantiating it everytime? Is that safe?
      randomValue = randGenerator.nextInt(wedgeOptions.size()-1)+0;
      System.out.print("Random value:" +randomValue);
      return randomValue;
    }
  
    private static  void addSelectedGameOptions(){
        selectedOptions = new HashMap<>();
        selectedOptions.put("Buy a vowel","You have selected to buy a vowel:");
        selectedOptions.put("Spin the Wheel","You have selected to Spin the Wheel");
        selectedOptions.put("solvePuzzle", "You have selected to solve the puzzle");
    }
    private static void displayMenuTitle(){
        System.out.println("                         ======================\n" +
                           "                         =  Wheel Of Fortune  = \n" +
                           "                         ======================\n\n");
      
  }  
    private static void addGameOptions(){
        gameOptions.add("1.Spin the wheel");
        gameOptions.add("2.Buy a vowel");
        gameOptions.add("3.Solve the puzzle");
        gameOptions.add("4.Quit");
        gameOptions.add("9.Test letter input");
        gameOptions.add("Enter choice:");
    }
    private static void displayGameOptions(){
        for(int i = 0; i < gameOptions.size(); i++){
        System.out.println(gameOptions.get(i));
      }
    }
  
    private static void addwedgeOptions(){
        wedgeOptions = new ArrayList<>();
        wedgeOptions.add("5000");
        wedgeOptions.add("600");
        wedgeOptions.add("500");
        wedgeOptions.add("300");
        wedgeOptions.add("500");
        wedgeOptions.add("800");
        wedgeOptions.add("550");
        wedgeOptions.add("400");
        wedgeOptions.add("300");
        wedgeOptions.add("900");
        wedgeOptions.add("500");
        wedgeOptions.add("300");
        wedgeOptions.add("900");
        wedgeOptions.add("Bankrupt");
        wedgeOptions.add("600");
        wedgeOptions.add("400");
        wedgeOptions.add("$300");
        wedgeOptions.add("Lose a Turn");
        wedgeOptions.add("800");
        wedgeOptions.add("350");
        wedgeOptions.add("450");
        wedgeOptions.add("700");
        wedgeOptions.add("300");
        wedgeOptions.add("600");
    }       
    private static void addVocabList(){
        vocabList = new ArrayList<>();
        vocabList.add("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
}
    private static void getVocabWord(){
        currentWord = vocabList.get(0);
    
}

/*The code runs a for loop which runs as many times as the codes legnth and for 
  each iteration checks if there is a blank space. If there is a blank space(" ") 
  then a " " (blank space) is added.*/

    private static void displayWordSpaces(){
        for (int i = 0 ; i < currentWord.length(); i++){
            // char currentChar =currentWord.charAt(i); // makes the current character being checked in current word equal to current char
            if(currentWord.charAt(i) == ' '){ // IF current char equal
                //System.out.print(" ");
                wordGuessDisplay = wordGuessDisplay + " ";
        }
            else
                //System.out.print("-");
                wordGuessDisplay = wordGuessDisplay + "_";
            }
            System.out.println(wordGuessDisplay);
            System.out.print('\n');
}
    private static void checkWordGuess(){
        if(letterGuess.contains(currentWord)){
            
        }
        
    }
}

