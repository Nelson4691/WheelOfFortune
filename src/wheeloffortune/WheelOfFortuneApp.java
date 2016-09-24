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
private static Scanner  userInput;                 //Scanner for user input
private static String letterGuess;                 //Used to store users guess
private static String currentWord;                 //Stores the current word user is guessing
private static int optionSelection;
private static boolean letterCheck;
private static int randomValue;
private static Random randGenerator;
private static List<String> vocabList;
private static String wordGuessDisplay=""; 
private static boolean gameActive = true;
private static boolean booleanToggleValue = true;
private static String temporaryCurrentWordHolder;
    
  public static void main(String[] args) {
      //created two methods which add the game options which are included in an
      // arraylist
      addVocabList();   //Adds vocab List
      addGameOptions(); //Adds the game options
      addwedgeOptions(); //Adds the different wege options
      getVocabWord();   //gets a vocab word from the vocab List
      addSelectedGameOptions();
      /*Test Code
      //System.out.println(wedgeOptions.size()); //Checks for 
      //System.out.println(gameOptions.size());
      //System.out.println(currentWord.length());
      */
      displayMenuTitle();
      createPuzzleSpaces(); //printes out required word space
      while(gameActive){
      displayCurrentPuzzle(); 
      displayGameOptions();
      getUserOptionSelection(); //prompts user for option selection
      checkUserSelection();
      }
     
  }
    //Provides user with a randomly selected wedge
    private static int getWedge(){
      randGenerator = new Random(); //what if you instantiating it everytime? Is that safe?
      randomValue = randGenerator.nextInt(wedgeOptions.size()-1)+0;
      return randomValue;
    }
    //Adds selected options to hashmap
    private static  void addSelectedGameOptions(){
        selectedOptions = new HashMap<>();
        selectedOptions.put("Buy a vowel","You have selected to buy a vowel:");
        selectedOptions.put("Spin the Wheel","You have selected to Spin the Wheel");
        selectedOptions.put("Solve the Puzzle", "You have selected to solve the puzzle");
    }
    private static void displayMenuTitle(){
        System.out.println("                         ======================\n" +
                           "                         =  Wheel Of Fortune  = \n" +
                           "                         ======================\n\n");
      
  }  
    private static void addGameOptions(){
        gameOptions = new ArrayList<>();
        gameOptions.add("1.Spin the wheel");
        gameOptions.add("2.Buy a vowel");
        gameOptions.add("3.Solve the puzzle");
        gameOptions.add("4.Quit");
        gameOptions.add("8.Toggle reveal");
        gameOptions.add("9.Test letter input");
        gameOptions.add("Enter choice:");
    }
    private static void displayGameOptions(){
        for(int i = 0; i < gameOptions.size(); i++){
        System.out.println(gameOptions.get(i));
      }
    }
    //adds and stores wedge options
    private static void addwedgeOptions(){
        wedgeOptions = new ArrayList<>();
        wedgeOptions.add("$5000");
        wedgeOptions.add("$600");
        wedgeOptions.add("$500");
        wedgeOptions.add("$300");
        wedgeOptions.add("$500");
        wedgeOptions.add("$800");
        wedgeOptions.add("$550");
        wedgeOptions.add("$400");
        wedgeOptions.add("$300");
        wedgeOptions.add("$900");
        wedgeOptions.add("$500");
        wedgeOptions.add("$300");
        wedgeOptions.add("$900");
        wedgeOptions.add("Bankrupt");
        wedgeOptions.add("$600");
        wedgeOptions.add("$400");
        wedgeOptions.add("$300");
        wedgeOptions.add("Lose a Turn");
        wedgeOptions.add("$800");
        wedgeOptions.add("$350");
        wedgeOptions.add("$450");
        wedgeOptions.add("$700");
        wedgeOptions.add("$300");
        wedgeOptions.add("$600");
    }       
    private static void addVocabList(){
        vocabList = new ArrayList<>();
        vocabList.add("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
}
    private static void getVocabWord(){
        randGenerator = new Random(); //what if you instantiating it everytime? Is that safe?
        randomValue = randGenerator.nextInt(vocabList.size())+0; 
        currentWord = vocabList.get(randomValue);
    
}

/*The code runs a for loop which runs as many times as the codes legnth and for 
  each iteration checks if there is a blank space. If there is a blank space(" ") 
  then a " " (blank space) is added.*/

    /*Generates Spaces for the word that is being guessed
    The codes runs a for loop that repeats as the current words character legth.
    Each time the loop runs it checks to see if there is a blank space in the
    current character it is looking at and checks to see if there is a space.
    */
    private static void createPuzzleSpaces(){
        for (int i = 0 ; i < currentWord.length(); i++){   //Loop runs as many times as current word
            if(currentWord.charAt(i) == ' '){ //           //Checks if character at certain persition has an empty space
                //System.out.print(" ");
                wordGuessDisplay = wordGuessDisplay + " "; //Updates the hint to includes a blank space
        }
            else
                //System.out.print("-");
                wordGuessDisplay = wordGuessDisplay + "-"; //if it doesn't have a blank space then it includes an Underscore
            }
    }
    private static void displayCurrentPuzzle(){
        System.out.println("\n"+wordGuessDisplay);
        System.out.print('\n');
    }
    private static void getUserOptionSelection(){
        userInput = new Scanner(System.in);
        optionSelection = Integer.parseInt(userInput.next()) ;
    }
    private static void checkWordGuess(){
        for (int i = 0 ; i < currentWord.length(); i++){                     //Loop runs as many times as current word
            if(currentWord.charAt(i) ==  letterGuess.charAt(0)){             // checks if the current word matches the letter guessed
                StringBuilder myName = new StringBuilder(wordGuessDisplay);  //if matches bulder is instaniated out of currentworddisplay Ex.(__ _ _)
                myName.setCharAt(i,letterGuess.charAt(0) );                  //since the characters in myname are mutuable ill change it using setchar(string posiition, character)
                wordGuessDisplay = myName.toString();                        // wordGuessDisplay will then be updated = myName
              }
       
        }
        
    }
    private static void checkUserSelection(){
        switch (optionSelection){
            case 1:
                System.out.print("You Landed on: "+wedgeOptions.get(getWedge())+"\n");
                System.out.print("Enter a letter to guess: ");
                letterGuess  =(userInput.next());
                while(!Character.isLetter(letterGuess.charAt(0))){
                    System.out.println("Invalid!\n Please guess a letter from A-Z");
                    letterGuess  =(userInput.next());
                }
                checkWordGuess();       //Checks word guess if guess is correct it updates the display
                break;
                
            case 2:
                System.out.print(selectedOptions.get("Buy a vowel"));
                break;
            case 3:
                System.out.print(selectedOptions.get("Solve the Puzzle"));
                break;
            case 4:
                System.exit(0);
                gameActive = false;
                break;
            case 8:
                if(booleanToggleValue){
                   temporaryCurrentWordHolder = wordGuessDisplay;  // putes your guesses in temporary holder 
                   wordGuessDisplay = currentWord;                 // makes orginally guess holder display full word
                   booleanToggleValue = false;
               }
                else if(!booleanToggleValue){
                    wordGuessDisplay = temporaryCurrentWordHolder;
                    booleanToggleValue = true;
                
                }
            break;
            
            case 9:
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

