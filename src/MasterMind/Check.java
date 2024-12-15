package MasterMind;

public class Check {
    
        protected static boolean IsValidCode(String code){
            String[] codeArray = code.split(" ");
            if (codeArray.length == Att.getCODE_LENGTH()) {
                for (String c : codeArray) {
                    if (Att.getColors()[0].equalsIgnoreCase(c) || Att.getColors()[1].equalsIgnoreCase(c) || Att.getColors()[2].equalsIgnoreCase(c) || Att.getColors()[3].equalsIgnoreCase(c) || Att.getColors()[4].equalsIgnoreCase(c) || Att.getColors()[5].equalsIgnoreCase(c)) {}
                    else return false ;
                }
            }
            else return false ; 
            return true ;
        }
    }