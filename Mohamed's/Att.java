package com.mycompany.project;

public class att {
    protected static final char[] colors = {'R' , 'G' , 'B' , 'Y' , 'O' , 'P'};
    private static final int CODE_LENGTH = 4 ;
    private static final int MAX_ATTEMPTS = 10 ;

    public static char[] getColors() {
        return colors;
    }

    public static int getCODE_LENGTH() {
        return CODE_LENGTH;
    }

    public static int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }
    
    
}
