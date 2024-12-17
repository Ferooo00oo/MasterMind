package MasterMind;

public class Att {
    private static final String[] colors = {"Red" , "Green" , "Blue" , "Yellow" , "Orange" , "Purple"};
    private static String secretCode;
    private static String guess;
    private static int attempts = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int codeLength; // Default length
    private static int maxAttempts; // Default attempts

    public static int getCodeLength() {
        return codeLength;
    }

    public static void setCodeLength(int length) {
        codeLength = length;
    }

    public static int getMaxAttempts() {
        return maxAttempts;
    }

    public static void setMaxAttempts(int attempts) {
        maxAttempts = attempts;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
}
