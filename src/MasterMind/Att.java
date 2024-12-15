package MasterMind;

public class Att {
    private static final String[] colors = {"Red" , "Green" , "Blue" , "Yellow" , "Orange" , "Purple"};
    private static final int CODE_LENGTH = 4 ;
    private static final int MAX_ATTEMPTS = 10 ;
    private static String secretCode;
    private static String guess;
    private static int attempts = 0;

    public static String getSecretCode() {
        return secretCode;
    }
    
    public static void setSecretCode(String secretCode) {
        Att.secretCode = secretCode;
    }

    public static String getGuess() {
        return guess;
    }

    public static void setGuess(String guess) {
        Att.guess = guess;
    }

    public static int getAttempts() {
        return attempts;
    }

    public static void setAttempts(int attempts) {
        Att.attempts = attempts;
    }
    
    public static String[] getColors() {
        return colors;
    }
    
    public static int getCODE_LENGTH() {
        return CODE_LENGTH;
    }

    public static int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }
    
    
    
}
