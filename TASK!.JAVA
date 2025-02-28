import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfTries = 0;
            boolean correctGuess = false;

            System.out.println("Round " + (++rounds));
            System.out.println("Guess a number between 1 and 100.");

            while (!correctGuess && numberOfTries < 10) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < numberToGuess) {
                    System.out.println("Too low. Try again!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again!");
                } else {
                    correctGuess = true;
                    System.out.println("Congratulations! You found the number in " + numberOfTries + " tries.");
                    score += 10 - numberOfTries;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess + ".");
            }

            System.out.println("Your current score is " + score + ".");
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over. Your final score is " + score + ".");
        scanner.close();
    }
}
