package gr11review.part2;

import java.io.*;
import java.util.Arrays;

//@author Vincent Hung
public class Utility {
  public static String zipZap(String str) {
    //Variable Declaration
    int intlength;
    intlength = str.length();
    int intcounter;
    String stranswer;
    stranswer = "";
    //Z'x'P detection loop
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
    //Variable Declartion
    String strreader = "";
    int intlength = 0;
    int intlongest = 0;
    String stranswer = "";
    //Exception Handling 
    try {
      //File Reader Creation
      BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));
      //Run as long as EOF is not reached
      //Also reads line at same time
      while ((strreader = thefile.readLine()) != null) {
        // System.out.println(strreader);
        //Check current word length
        intlength = strreader.length();
        //Compare and switch if longer
        if (intlength >= intlongest) {
          intlongest = intlength;
          stranswer = strreader;
        }
      }
    thefile.close();
    //If Exception print error
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

  public static boolean linearIn(int[] outer, int[] inner) {
    //Variable Declaration
    int intinnercounter;
    int intoutercounter;
    intoutercounter = 0;
    int intinnerlength;
    int intconfirmation = 0;
    intinnerlength = inner.length;
    int intouterlength;
    intouterlength = outer.length;
    //System.out.println(intouterlength);
    //For loop until entire inner array has been checked
    for (intinnercounter = 0 ; intinnercounter < intinnerlength ; intoutercounter++) {
      //System.out.println(intoutercounter);
      //System.out.println(intinnercounter);
      //If outercounter still inside outer array
      if (intoutercounter <= intouterlength) {
        //If inner array number is smaller than outer
        //set innercounter to innerlength to skip everything else
        if (outer[intoutercounter] > inner[intinnercounter]) {
          intinnercounter = intinnerlength;
        //if match found add to confirmation and mover to next inner
        } else if (outer[intoutercounter] == inner[intinnercounter]) {
          intconfirmation++;
          intinnercounter++;
        }
      }
    }
    //if all inner array numbers have a match
    if (intconfirmation == intinnerlength) {
      return true;
    } else { 
      //System.out.println(intoutercounter);
      return false;
    }
  }

  public static void pascalTri(int i, int j){
    int[][] intanswerarray = new int[i][j];
    int introwcounter;
    int intcoloumncounter;

    for (introwcounter = 0 ; introwcounter < i ; introwcounter++) {
      intanswerarray[introwcounter][0] = 1;
    }
    for (intcoloumncounter = 0 ; intcoloumncounter < j ; incoloumncounter++) {
      intanswerarray[0][intcoloumncounter] = 1;
    }

    for (introwcounter = 1 ; introwcounter < i ; introwcounter++) {
      for (intcoloumncounter = 1 ; intcoloumncounter < j ; intcoloumncounter++) {
        intanswerarray[introwcounter][intcoloumncounter] = intanswerarray[introwcounter - 1][intcoloumncounter] + intanswerarray[introwcounter]
      }
    }
  }
}
