package MasterMind;

import java.util.List;
import java.util.ArrayList;

public class TheFeedback {
    protected static int[] Feedback(String SC , String trys){
        int blackPegs = 0;
        int whitePegs = 0;
        List<String> secretList = new ArrayList<>();
        List<String> trysList = new ArrayList<>();
        String[] secretColors = SC.split(" ");
        String[] guessedColors = trys.split(" ");

        //Black pegs
        for (int i = 0; i < Att.getCODE_LENGTH(); i++) {
            if (secretColors[i].equalsIgnoreCase(guessedColors[i])) {
                blackPegs++;
            }
            else {
                secretList.add(secretColors[i]);
                trysList.add(guessedColors[i]);
            }
        }
        
        //White pegs
        for (String c : trysList) {
            if (secretList.contains(c)) {
                whitePegs++;
                secretList.remove(c);
            }
        }
        
        return new int[]{blackPegs, whitePegs}; 
    }
}
