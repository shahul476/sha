import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int lowerRange = 1;
            int upperRange = 100;
            int secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int maxAttempts = 7;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + lowerRange + " and " + upperRange);

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                try {
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else if (userGuess > secretNumber) {
                        System.out.println("Too high! Try a lower number.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + secretNumber +
                                " in " + attempts + " attempts.");
                        correctGuess = true;
                        roundsWon++;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            totalAttempts += attempts;
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.startsWith("y");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Average Attempts per Round: " +
                (roundsWon > 0 ? (double) totalAttempts / roundsWon : 0));

        scanner.close();
    }
}
