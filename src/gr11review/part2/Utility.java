package gr11review.part2;

public class Utility{
    public static String zipZap(String str) {
      int intlength;
      intlength = str.length();
      int intcounter;
      String stranswer;
      stranswer = "";
      for (intcounter = 0 ; intcounter < intlength ; intcounter++) {
        stranswer = stranswer + str.substring(intcounter, intcounter + 1);
        if (str.charAt(intcounter) == 'z' && str.charAt(intcounter + 2) == 'p')
          stranswer = stranswer.substring(0 , stranswer.length()-1);
      }
      return stranswer;
    }
}

