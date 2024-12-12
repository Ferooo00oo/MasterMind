import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterMind {
    private static final String[] COLORS = {"R", "G", "B", "Y", "O", "P"}; // Red, Green, Blue, Yellow, Orange, Purple
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Mastermind!");
        System.out.println("Available colors: R, G, B, Y, O, P");
        
        // Code Maker creates the secret code
        System.out.print("Code Maker, enter your secret code (4 colors, e.g., RGBY): ");
        String secretCode = scanner.nextLine().toUpperCase();
        
        if (!isValidCode(secretCode)) {
            System.out.println("Invalid code. Please enter a valid code.");
            return;
        }

        System.out.println("\nCode Maker has set the secret code. Code Breaker, start guessing!");

        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            System.out.printf("Attempt %d/%d: Enter your guess (4 colors): ", attempts + 1, MAX_ATTEMPTS);
            String guess = scanner.nextLine().toUpperCase();
            
            if (!isValidCode(guess)) {
                System.out.println("Invalid guess. Please enter a valid guess.");
                continue;
            }

            int[] feedback = getFeedback(secretCode, guess);
            int blackPegs = feedback[0];
            int whitePegs = feedback[1];
            System.out.printf("Feedback: %d Black Peg(s), %d White Peg(s)\n", blackPegs, whitePegs);

            if (blackPegs == CODE_LENGTH) {
                System.out.println("Congratulations! You've guessed the secret code!");
                break;
            }

            attempts++;
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.printf("Sorry, you've run out of attempts! The secret code was: %s\n", secretCode);
        }

        scanner.close();
    }

    private static boolean isValidCode(String code) {
        if (code.length() != CODE_LENGTH) {
            return false;
        }
        for (char c : code.toCharArray()) {
            if (!isColorValid(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColorValid(String color) {
        for (String validColor : COLORS) {
            if (validColor.equals(color)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getFeedback(String secretCode, String guess) {
        int blackPegs = 0;
        int whitePegs = 0;
        List<Character> secretList = new ArrayList<>();
        List<Character> guessList = new ArrayList<>();

        // Count black pegs and prepare lists for white peg calculation
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) {
                blackPegs++;
            } else {
                secretList.add(secretCode.charAt(i));
                guessList.add(guess.charAt(i));
            }
        }

        // Count white pegs
        for (char c : guessList) {
            if (secretList.contains(c)) {
                whitePegs++;
                secretList.remove((Character) c); // Remove to avoid double counting
            }
        }

        return new int[]{blackPegs, whitePegs};
    }
}
