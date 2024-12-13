public class Main {

   public static void main(String[] args) {
      
      Att.secretCode[0] = Att.SC.next().toLowerCase();
      Att.secretCode[1] = Att.SC.next().toLowerCase();
      Att.secretCode[2] = Att.SC.next().toLowerCase();
      Att.secretCode[3] = Att.SC.next().toLowerCase();

      if(!Check.isValidCode()) System.out.println("Teezak");
      System.out.println(Att.secretCode[1]);
   }
}