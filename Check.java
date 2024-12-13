public class Check {
    

    protected static boolean isValidCode(){   ///Green, Green, Red, Blue

        if(Att.secretCode.length > Att.getCodeLength()){
            return false;
        }
        else return true;

    }

}