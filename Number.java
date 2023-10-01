import java.util.Random;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Set the lower bound for the random number
        int upperBound = 100; // Set the upper bound for the random number
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxTries = 10; // Set the maximum number of tries

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

        for (int tries = 1; tries <= maxTries; tries++) {
            System.out.print("Enter your guess (Try " + tries + "/" + maxTries + "): ");
            int playerGuess = scanner.nextInt();

            if (playerGuess < lowerBound || playerGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }

            if (playerGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("Try a lower number.");
            } else {
                System.out.println("Congratulations! You've guessed the number (" + numberToGuess + ") in " + tries + " tries.");
                break;
            }

            if (tries == maxTries) {
                System.out.println("Sorry, you've run out of tries. The number was " + numberToGuess + ".");
            }
        }

        scanner.close();
    }
}
