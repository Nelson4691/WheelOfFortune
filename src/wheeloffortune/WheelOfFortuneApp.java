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
private static int optionSelection;                //Sotores selection                
private static int randomValue;                    //Stores the random value
private static Random randGenerator;
private static List<String> vocabList;             //Stores the vocab words
private static String currentpuzzleDisplayed="";   //Dipslays and stores current puzzle and user correct guess       
private static boolean gameActive = true;          //used to check if game is active    
private static boolean booleanToggleValue = true;  //Used to check guess value 
private static String temporaryCurrentWordHolder;  //Used to temporary hold word 
private static String currentWedge;                //Will be used to include the wedges 
private static int currentPlayerScore = 0;         //Used to keep track of player score
private static List <String> letterGuessedList = new ArrayList<>();     //Keeps track of all the letter guessed
private final static List <String> vowelList = new ArrayList<>();
private static String test = "A";
private static boolean vowelAcceptance = false;                   // used to check if vowel is acceptable (starts at false to assure user can guess vowel
private static List<String> PlayerWordGuess;

  public static void main(String[] args) {
      //created two methods which add the game options which are included in an
      // arraylist
      addVocabList();   //Adds vocab List
      addGameOptions(); //Adds the game options
      addwedgeOptions(); //Adds the different wege options
      getVocabWord();   //gets a vocab word from the vocab List
      addSelectedGameOptions();
      addVowels();
      System.out.println(checkForVowels(test));
      /*Test Code
      //System.out.println(wedgeOptions.size()); //Checks for 
      //System.out.println(gameOptions.size());
      //System.out.println(currentWord.length());
      */
      displayMenuTitle();
      createPuzzleSpaces(); //printes out required word space
      while(gameActive){
      displayCurrentPuzzle(); 
      displayPlayerScore();
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
    private static void addPlayerScore(){
    if(numericValidator(currentWedge) == true)
        currentPlayerScore = currentPlayerScore + Integer.parseInt(currentWedge);    
    }
    /*Used to test if value is not numberic*/
    public static boolean numericValidator(String str)  
    {  
        try{
            int value = Integer.parseInt(str);  
        }  
        catch(NumberFormatException error){
            return false;
        }  
        return true;  
    }
    private static void displayPlayerScore(){
        System.out.println("Your current Score: " + currentPlayerScore + "\n");
    }
    private static void updateLetterGuessList(String letterGuess){
       
        letterGuessedList.add(letterGuess);
        //Used to test if letters are updating
        /*letterGuessedList.stream().forEach((GuessedLetters) ->
        {
            System.out.println(GuessedLetters);
        });
        */
   
    }
    
    //Adds selected options to hashmap
    private static  void addSelectedGameOptions(){
        selectedOptions = new HashMap<>();
        selectedOptions.put("Buy a vowel","You have selected to buy a vowel:");
        selectedOptions.put("Spin the Wheel","You have selected to Spin the Wheel");
        selectedOptions.put("Solve the Puzzle", "You have selected to solve the puzzle");
    }
    private static void addVowels(){
        vowelList.add("A");
        vowelList.add("E");
        vowelList.add("I");
        vowelList.add("O");
        vowelList.add("U");
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
        gameOptions.stream().forEach((Options) ->
        {
            System.out.println(Options);
        });
    }
    //adds and stores wedge options
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
        wedgeOptions.add("300");
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
        vocabList.add("T H E  Q U I C K  B R O W N  F O X  J U M P S  O V E R  T H E  L A Z Y  D O G");
        vocabList.add("C O D E I N G  I S  F U N");
        vocabList.add("Y O U  W I L L  N E V E R  W I N");
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
                currentpuzzleDisplayed = currentpuzzleDisplayed + " "; //Updates the hint to includes a blank space
        }
            else
                //System.out.print("-");
                currentpuzzleDisplayed = currentpuzzleDisplayed + "_"; //if it doesn't have a blank space then it includes an Underscore
            }
    }
    private static void displayCurrentPuzzle(){
        System.out.println("\n"+currentpuzzleDisplayed);
        System.out.print('\n');
    }
    private static void getUserOptionSelection(){
        
       userInput = new Scanner(System.in);
       String optionValidator = userInput.next();               //variable checks for option selection
        while(numericValidator(optionValidator) == false){           
            System.out.println("Please enter a valid option");
            optionValidator = userInput.next();
         
        }
        optionSelection = Integer.parseInt(optionValidator) ;
    }
    private static void checkLetterGuess(){
        for (int i = 0 ; i < currentWord.length(); i++){                     //Loop runs as many times as current word
            if(currentWord.charAt(i) ==  letterGuess.charAt(0)){             // checks if the current word matches the letter guessed
                addPlayerScore();
                StringBuilder myName = new StringBuilder(currentpuzzleDisplayed);  //if matches bulder is instaniated out of currentworddisplay Ex.(__ _ _)
                myName.setCharAt(i,letterGuess.charAt(0) );                  //since the characters in myname are mutuable ill change it using setchar(string posiition, character)
                currentpuzzleDisplayed = myName.toString();                        // currentpuzzleDisplayed will then be updated = myName
              }
            
        }    
    }
    private static void checkForLetterReEntry(){
        //Loop checks to see if user has already entered the same letter
        for(int i = 0 ; i<letterGuessedList.size(); i++){
                if( letterGuessedList.get(i).charAt(0) == letterGuess.charAt(0)){
                    askUserForLetterGuess();
                }
            }
    }
    private static void askUserForLetterGuess(){
        System.out.print("Enter a letter to guess: ");
        letterGuess  =(userInput.next().toUpperCase());
        while(!Character.isLetter(letterGuess.charAt(0))){
            System.out.println("Invalid!\n Please guess a letter from A-Z");
            letterGuess  =(userInput.next().toUpperCase());
        }
        while(checkForVowels(letterGuess) == true){                    //add a method that checks returns true if you can guess a vowel and false if you cant
            System.out.println("Please enter a letter not a vowel!");
            letterGuess  =(userInput.next().toUpperCase());
        }
        checkForLetterReEntry();
    }
    private static void askUserForVowelGuess(){
         System.out.print("Enter a vowel to guess: ");
        letterGuess  =(userInput.next().toUpperCase());
        while(checkForVowels(letterGuess) == false){
            System.out.println("Invalid!\n Please enter a vowel ex. A,E,I,O,U");
            letterGuess  =(userInput.next().toUpperCase());
        }
        checkForLetterReEntry();
    }
    private static void displayCurrentWedgeLand(){
        System.out.print("You Landed on: "+currentWedge+"\n");
    }
    private static void checkForBankrupcy(){
        //currentWedge = "Bankrupt";                    //Tester for banrupty
        if(currentWedge == "Bankrupt"){
            currentPlayerScore = 0;
            // System.out.println("You are bankrupt");  //used to test for bankruptcy
        }
    }
    private static void updateWedgeLanding(){
        currentWedge = wedgeOptions.get(getWedge());
    }
    //should it be bool or void?
    private static boolean checkForVowels(String letter){
        for(int i = 0; i < vowelList.size();i++){
            if (letter.charAt(0) == vowelList.get(i).charAt(0)){
            return true;
            }
        }
            return false;
    }
    
    //will check if user score is less then cost for vowel 
    // return bool
    private static boolean validateVowelPurchase(){
        if (currentPlayerScore < 250){                                  //test to see if vowel cna be puchase
           return false;
        }
        return true;
    }
    private static void purchaseVowel(){
        if(validateVowelPurchase() == true){
            currentPlayerScore = currentPlayerScore -250;               //update playerScore if puchase is accepted
            askUserForVowelGuess();
            
        }
        else{
            System.out.print(" You do not have sufficient Funds to purchase a vowel!");
             vowelAcceptance = false;
        }
    }
    private static void guessWord(){
        PlayerWordGuess = new ArrayList<>(currentWord.length());    //Why can variable be fully instantiated here
       int playerCorrectWordGuessCount = 0;
        for(int i =0; i < currentWord.length(); i++){
             System.out.println("Please enter letter");
             PlayerWordGuess.add(userInput.next().toUpperCase());
             
        }
        for(int i = 0; i < currentWord.length(); i++){
            if(PlayerWordGuess.get(i).charAt(0) == currentWord.charAt(i)){
                playerCorrectWordGuessCount = playerCorrectWordGuessCount +1;
            }
        }
        if(playerCorrectWordGuessCount == currentWord.length()){
           System.out.print("You have won the game congrats");
           System.out.print("Your Scored :" +currentPlayerScore);
        }
    }
    
    private static void checkUserSelection(){
        switch (optionSelection){
            case 1:
                updateWedgeLanding();
                displayCurrentWedgeLand();
                checkForBankrupcy();
                askUserForLetterGuess();
                checkForLetterReEntry();
                checkLetterGuess();                                                    //Checks word guess if guess is correct it updates the display
                updateLetterGuessList(letterGuess);                                  //updates the guess list
                
                break;
                
            case 2:
                purchaseVowel();
                checkForLetterReEntry();
                checkLetterGuess();
                updateLetterGuessList(letterGuess);
                break;
            case 3:
                guessWord();
                break;
            case 4:
                System.exit(0);
                gameActive = false;
                break;
            case 8:
                
                if(booleanToggleValue){                                  /* The if statement allows user to see the word if 8 is pressed.*/
                   temporaryCurrentWordHolder = currentpuzzleDisplayed;  // putes your guesses in temporary holder 
                   currentpuzzleDisplayed = currentWord;                 // makes the puzzle displayed equal to the actual word guess. So user can see the full word
                   booleanToggleValue = false;                           // makes the value false so that next time user presses 8 the else if statment runs
               }
                else if(!booleanToggleValue){                            // If the variable is not true then means the user doesn't want to see word guess
                    currentpuzzleDisplayed = temporaryCurrentWordHolder; // The temporary variable holder sends the word back to the variable that is displayed to user   
                    booleanToggleValue = true;                           // toggle is now set to true so that user can select to see the word next time presses 8
                
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

