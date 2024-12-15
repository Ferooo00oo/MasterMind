package MasterMind;

import java.util.List;
import java.util.ArrayList;

public class TheFeedback {
    protected static int[] Feedback(String SC , String trys){
        int blackPegs = 0;
        int whitePegs = 0;
        List<String> secretList = new ArrayList<>();
        List<String> trysList = new ArrayList<>();
        String[] secretColor = SC.split(" ");
        String[] guess = trys.split(" ");

        //Black pegs
        for (int i = 0; i < Att.getCODE_LENGTH(); i++) {
            if (secretColor[i].equalsIgnoreCase(guess[i])) {
                blackPegs++;
            }
            else {
                secretList.add(secretColor[i]);
                trysList.add(guess[i]);
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
