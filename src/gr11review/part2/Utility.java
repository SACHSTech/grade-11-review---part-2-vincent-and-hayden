package gr11review.part2;

import java.io.*;
import java.util.Arrays;

/**
* ZipZap method 
* remove inner character for any Z''P
* @author: Vincent Hung
*/ 
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
        if (str.charAt(intcounter - 1) == 'z' && str.charAt(intcounter + 1) == 'p') stranswer = stranswer.substring(0, stranswer.length() - 1);
      }
    }
    return stranswer;
  }
  /**
  * longestword method 
  * scans text file for longest word and returns word
  * @author: Vincent Hung
  */ 
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
    } catch(IOException e) {

      System.out.println("error");

    }
    return stranswer;
  }
  /**
  * tenRun method
  * For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10
  * @author: Vincent Hung
  */ 
  public static int[] tenRun(int[] nums) {
    //Variable Declaration
    int intcounter;
    int intlength;
    int intprinter = 0;
    intlength = nums.length;
    //loop to scan and change array
    for (intcounter = 0; intcounter < intlength; intcounter++) {
      //Check if number is divisible by 10
      if ((nums[intcounter] % 10) == 0) {
        //set printer variable to current number
        intprinter = nums[intcounter];
      } else if (intprinter == 0) {
        //Do nothing if no multiples of 10 has been found yet
      } else {
        //if number is not variable of 10 print using printer variable
        nums[intcounter] = intprinter;
      }
    }
    return nums;
  }
  /**
  * linearIn method
  * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer
  * @author: Vincent Hung
  */ 
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
    for (intinnercounter = 0; intinnercounter < intinnerlength; intoutercounter++) {
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
  /**
  * pascalTri method
  * Based on given dimension of array print out numbers of pascal triangle 
  * top left is the top of the pyramid
  * @author: Vincent Hung
  */ 
  public static void pascalTri(int i, int j) {
    //Variable Declartion
    int[][] intanswerarray = new int[i][j];
    int introwcounter;
    int intcoloumncounter;
    //Exception Handling
    try {
      PrintWriter theout = new PrintWriter(new FileWriter("/home/runner/grade-11-review-part-2-vincent-and-hayden/src/gr11review/part2/pascal.txt"));
      //Printing 1 along left and top side to array(they are independant from variables)
      for (introwcounter = 0; introwcounter < i; introwcounter++) {
        intanswerarray[introwcounter][0] = 1;
      }
      for (intcoloumncounter = 0; intcoloumncounter < j; intcoloumncounter++) {
        intanswerarray[0][intcoloumncounter] = 1;
      }
      //applying pascal pattern to other spaces in array
      //directly left and directly above the number are the two numbers to add to create new numbers
      //start at 1 for both row and coloumn in array since 0 row and coloumn already filled
      for (introwcounter = 1; introwcounter < i; introwcounter++) {
        for (intcoloumncounter = 1; intcoloumncounter < j; intcoloumncounter++) {
          intanswerarray[introwcounter][intcoloumncounter] = intanswerarray[introwcounter - 1][intcoloumncounter] + intanswerarray[introwcounter][intcoloumncounter - 1];
        }
      }
      //Printing to text file
      for (introwcounter = 0; introwcounter < i; introwcounter++) {
        for (intcoloumncounter = 0; intcoloumncounter < j; intcoloumncounter++) {
          theout.print(intanswerarray[introwcounter][intcoloumncounter] + ",");
        }
        theout.println("");
      }
      //closing text file
      theout.close();
      //If exception caught print out "error"
    } catch(IOException e) {

      System.out.println("error");

    }
  }
}
