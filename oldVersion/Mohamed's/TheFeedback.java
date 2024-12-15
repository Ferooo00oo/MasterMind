package com.mycompany.project;

import java.util.List;
import java.util.ArrayList;

public class TheFeedback {
    protected static int[] Feedback(String SC , String trys){
        int blackPegs = 0;
        int whitePegs = 0;
        List<Character> secretList = new ArrayList<>();
        List<Character> trysList = new ArrayList<>();
        
        //Black pegs
        for (int i = 0; i < att.getCODE_LENGTH(); i++) {
            if (SC.charAt(i) == trys.charAt(i)) {
                blackPegs++;
            }
            else {
                secretList.add(SC.charAt(i));
                trysList.add(trys.charAt(i));
            }
        }
        
        //White pegs
        for (int i = 0; i < trysList.size(); i++) {
            if (secretList.contains(trysList.get(i))) {
                whitePegs++;
                secretList.remove(trysList.get(i));
            }
        }
        
        return new int[] {blackPegs , whitePegs}; 
    }
}
