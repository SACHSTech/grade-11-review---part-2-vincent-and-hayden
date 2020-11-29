package gr11review.part2;

import java.io.*;
import java.util.Arrays;

public class Utility {
  public static String zipZap(String str) {
    int intlength;
    intlength = str.length();
    int intcounter;
    String stranswer;
    stranswer = "";
    for (intcounter = 0; intcounter < intlength; intcounter++) {
      stranswer = stranswer + str.substring(intcounter, intcounter + 1);
      if (intcounter > 0) {
        if (str.charAt(intcounter - 1) == 'z' && str.charAt(intcounter + 1) == 'p')
          stranswer = stranswer.substring(0, stranswer.length() - 1);
      }
    }
    return stranswer;
  }

  public static int sumNumbers(String str) {
    // Variable Declaration
    int intlength;
    intlength = str.length();
    int intcounter;
    int intanswer;
    String stranswer;
    stranswer = "";
    // String Scanner
    for (intcounter = 0; intcounter < intlength; intcounter++) {
      if (Character.isDigit(str.charAt(intcounter))) {
        stranswer = stranswer + str.charAt(intcounter);
      }
    }
    // System.out.println(stranswer);
    // Convert and Return Answer
    intanswer = Integer.parseInt(stranswer);
    return intanswer;
  }

  public static String longestWord(String filenametxt) {
    String strreader = "";
    int intlength = 0;
    int intlongest = 0;
    String stranswer = "";
    try {
      BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));
      while ((strreader = thefile.readLine()) != null) {
        // System.out.println(strreader);
        intlength = strreader.length();
        if (intlength > intlongest) {
          intlongest = intlength;
          stranswer = strreader;
        }
      }
      thefile.close();
    } catch (IOException e) {

      System.out.println("error");

    }
    return stranswer;
  }
  public static int[] tenRun(int[] nums) {
  int intcounter;
  int intlength;
  int intprinter = 0;
  intlength = nums.length;
  for (intcounter = 0 ; intcounter < intlength ; intcounter++) {
    if ((nums[intcounter] % 10) == 0) {
      intprinter = nums[intcounter];
    } else {
      nums[intcounter] = intprinter;
    }
  }
  return nums;
  }
}
