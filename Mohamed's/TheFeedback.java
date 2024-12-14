package com.mycompany.project;

import java.util.List;
import java.util.ArrayList;
public class TheFeedback {
    protected static int []Feedback (String SC , String trys){
        int blackPegs = 0;
        int whitePegs = 0;
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
        
        //Black pegs
        for (int i = 0; i < att.getCODE_LENGTH(); i++) {
            if (SC.charAt(i) == trys.charAt(i)) {
                blackPegs++;
            }
            else {
                sList.add(SC.charAt(i));
                tList.add(trys.charAt(i));
            }
        }
        
        //White pegs
        for (int i = 0; i < tList.size(); i++) {
            if (sList.contains(tList.get(i))) {
                whitePegs++;
                sList.remove(tList.get(i));
            }
        }
        
        return new int[] {blackPegs , whitePegs}; 
    }
}
