// Name: Huy Truong Ngo
// Class: CS 145
// Date: 09/26
// Lab 1: Guessing Game
// This will create a random number then make the player guess them
import java.util.Scanner;
import java.util.Random;
public class guessingGame {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        CountResult(input, rand);
        input.close();
    } // main method

    public static void CountResult(Scanner input, Random rand) {
        int totalGame = 0;
        int totalGuess = 0;
        int bestGame = Integer.MAX_VALUE;
        boolean playAgain = true;

        System.out.println("Do you want to play the game? y/n");

        while (true) {
            String firstGame = input.next();

            if (firstGame.equalsIgnoreCase("y")) {
                intro();

                while (playAgain) {
                    // Generating the number
                    int answer = rand.nextInt(100) + 1;
                    // Counting game played and how many guess
                    int tries = Game(input, answer);
                    totalGame++;
                    totalGuess += tries;

                    if (tries < bestGame) {
                        bestGame = tries;
                    }
                    // ask to play again
                    System.out.println("Do you want to play again? (y/n)");
                    String playAgainInput = input.next();

                    if (!playAgainInput.equalsIgnoreCase("y")) {
                        playAgain = false;
                        overallResult(totalGame, totalGuess, bestGame);
                        break;
                    }
                }
                break;
            } else if (firstGame.equalsIgnoreCase("n")) {
                System.out.println("Okay, next time then.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n' only.");
            }
        } // while (true)


    }
    public static int Game(Scanner input, int answer) {
        int tries = 0;
        System.out.println("\nI'm thinking of a number between 1 and 100...");
        while (true) {
            System.out.println("Your guess: ");
            int guess = input.nextInt();
            tries++;
            // Comparing tries with number generated
            if (guess < answer) {
                System.out.println("Too low");
            } else if (guess > answer) {
                System.out.println("Too high");
            } else {
                System.out.println("You get it right!!!");
                break;
            }
        }
        return tries;
    } //game method

    public static void intro() {
        System.out.println("I will think of a number between 1 and 100");
        System.out.println("and will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the");
        System.out.println("right answer is higher or lower than your guess.");
    }
    public static void overallResult(int totalGame, int totalGuess, int bestGame) {
        System.out.println("Well, GG");
        System.out.println("Overall result: ");
        System.out.println("\tTotal games: " + totalGame);
        System.out.println("\tTotal guesses: " + totalGuess);
        System.out.println("\tGuess/Games: " + (double) totalGuess / totalGame);
        System.out.println("\tBest game: " + bestGame + " guesses");
    }

} // end class
