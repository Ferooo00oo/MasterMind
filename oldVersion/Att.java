import java.util.Scanner;

public class Att {
    private static final String[] COLORS = {"blue", "red", "green", "yellow", "orange", "purple"}; //Main Colors[]
    private static final int CODE_LENGTH = 4;                                                      //------|
    private static final int MAX_ATTEMPTS = 10;                                                    //------|

    protected static String[] secretCode = new String[4];
    protected static Scanner SC = new Scanner(System.in);


    
    public static int getCodeLength() {
        return CODE_LENGTH;
    }
    public static String[] getColors() {
        return COLORS;
    }
    public static int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

}
