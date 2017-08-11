import java.util.Scanner;
import java.util.Random;

public class Hangman {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // We are gettting user inputs
		Random random = new Random(); // We are generating random numbers and words
		String[] guesses = {"moringa", "phones", "cars", "house", "peace", "lake", "mountain", "forest", "love", "happiness", "programming"};
		
		boolean letsPlay = true;
		while(letsPlay) {
		System.out.println("Welcome to my game of Hangman");
		
		char[] randomWords = guesses[random.nextInt(guesses.length)].toCharArray();
		int amountOfGuesses = randomWords.length;
		char[] playerGuesses = new char[amountOfGuesses];
		
		for(int i = 0; i < playerGuesses.length; i++) {
			playerGuesses[i] = '_';
		}
		boolean wordIsGuessed = false;
		int tries = 0;
		
		while(!wordIsGuessed && tries != amountOfGuesses) {
			System.out.println("Current Guesses: ");
			printArray(playerGuesses);
			System.out.printf("You have %d tries left.\n", amountOfGuesses - tries);
			System.out.println("Enter your single character");
			char input = scanner.nextLine().charAt(0);
			tries ++;
			
			if(input == '-') {
				letsPlay = false;
				wordIsGuessed = true;
			} else {
		for(int i = 0; i < randomWords.length; i++) {
			if(randomWords[i] == input) {
				playerGuesses[i] = input;
			}
		}
		
		if(isTheWordGuessed(playerGuesses)) {
			wordIsGuessed = true;
			System.out.println("Congratulations you have won!");
			
		       }
			}
		 }
		 
		 if(!wordIsGuessed) System.out.println("You ran out of guesses :/");
		 System.out.println("Do you want to play another game? (yes/no)");
		 String anotherGame = scanner.nextLine();
			
			if(anotherGame.equals("no")) letsPlay = false;
		}
		
		System.out.println("Game Over.....");
	}
	
	public static void printArray(char[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isTheWordGuessed(char[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == '_') return false;
		}
		return true;
	}
}