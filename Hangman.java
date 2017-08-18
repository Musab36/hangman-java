import java.util.Scanner;
import java.util.Random;

public class Hangman {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // We are gettting user inputs
		Random random = new Random(); // We are generating random numbers and words
		String[] guesses = {"moringa", "phones", "cars", "house", "peace", "lake", "mountain", "forest", "love", "happiness", "programming"};
		
		boolean letsPlay = true;
		while(letsPlay) { // While letsPlay is true, the code in the while loop is run
		System.out.println("Welcome to my game of Hangman"); // A welcome message
		
		// We then get random words from the array guesses for the player to guess
		// .nexInt returns an int from 0 
		char[] randomWords = guesses[random.nextInt(guesses.length)].toCharArray(); // .toCharArray converts the random word into single characters h,o,u,s,e
		int amountOfGuesses = randomWords.length; // How many times the player can guess and is set to how long the word is
		char[] playerGuesses = new char[amountOfGuesses]; // An empty char array that saves the user's input
		
		// A for loop initialising the user's char array
		for(int i = 0; i < playerGuesses.length; i++) {
			playerGuesses[i] = '_'; // We are setting each field with '_'
		}
		
		// The beginning of the game
		boolean wordIsGuessed = false; // We set it to false because at the start the word is not guessed
		int tries = 0; // Amount of tries
		
		while(!wordIsGuessed && tries != amountOfGuesses) { // While the word is not guessed and tries are not equal to amount of guesses
			System.out.println("Current Guesses: "); // We are printing the current user guesses
			printArray(playerGuesses); // A function
			System.out.printf("You have %d tries left.\n", amountOfGuesses - tries); // We give the user their amount of tries
			System.out.println("Enter your single character"); // Then we prompt the user to enter single characters at a time
			char input = scanner.nextLine().charAt(0); // This will take only the first character even if the user inputs many characters
			tries ++; // Then we incriment the user's tries
			
			if(input == '-') { // If the user inputs '-' we end the game
				letsPlay = false;
				wordIsGuessed = true;
			} else { 
		for(int i = 0; i < randomWords.length; i++) {
			if(randomWords[i] == input) { // If the player inputs other than '-' the input is collected
				playerGuesses[i] = input;
			}
		}
		
		if(isTheWordGuessed(playerGuesses)) { // If the input is equals to the word guessed
			wordIsGuessed = true; // The wordIsGuessed is set to true and the user wins
			System.out.println("Congratulations you have won!");
			
		       }
			}
		 }
		 
		 if(!wordIsGuessed) System.out.println("You ran out of guesses....."); // If the word is not gussed and the tries left are 0
		 System.out.println("Do you want to play another game? (yes/no)"); // We prompt the player is they want to retry again
		 String anotherGame = scanner.nextLine(); // Then we get the user input
			
			if(anotherGame.equals("no")) letsPlay = false; // If the user inputs no
		}
		
		System.out.println("Game Over....."); // The game is over
	}
	
	public static void printArray(char[] array) { // A function taking a char array
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isTheWordGuessed(char[] array) { // A function taking a char arry
		for(int i = 0; i < array.length; i++) {
			if(array[i] == '_') return false; // If we find '_' that means the word is not guessed
		}
		return true; // If we don't find '_' that means the word is guessed
	}
}