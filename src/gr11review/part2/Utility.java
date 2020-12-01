package gr11review.part2;

import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;


/** 
* Method 2: Add numbers together
* @author: H. Chung
*
*/
public class Utility {
  public static int sumNumbers(String str) {
    // Setting Variables
    int intLength;
    intLength = str.length();
    int intCount;
    int intSum = 0;
    String strWord = "";
    // Looping until every character is check through
    for (intCount = 0; intCount < intLength; intCount++) {
      // See if the value is a digit
      if (Character.isDigit(str.charAt(intCount))) {
        // Conditions to see if you can add a number in the string
        if (intCount < intLength-1 && Character.isDigit(str.charAt(intCount+1))) {
           // Finding a number within the sentence
          strWord += str.charAt(intCount);
        } else {
          // Adding the numbers together
          strWord += str.charAt(intCount);
          intSum += Integer.parseInt(strWord);
          strWord = "";
        }
      }
    }
    // return sum
    return intSum;
  }
  /** 
  * File IO 2: Reading words in file and picking the first alphabetically first word
  * @author: H. Chung
  *
  */
  public static String alphaWord (String filenametxt) throws IOException {
    BufferedReader FileText = new BufferedReader(new FileReader(filenametxt));
    // Setting Variables and Reading File
    String strWord;
    String strFinalWord;
    int intCompare;
    strWord = FileText.readLine();
    strFinalWord = FileText.readLine();
    // As long as it is not in the end of the file, continue reading it. 
    while (strWord != null) {
      // Compares the words in the text file
      intCompare = strFinalWord.compareToIgnoreCase(strWord);
      if (intCompare > 0) {
        strFinalWord = strWord;
      }
      strWord = FileText.readLine();
      }
    // Closes file and returns the word that is alphabetically first
    FileText.close();
    return strFinalWord;
  }
  /** 
  * Array 2: Print out numbers in array
  * @author: H. Chung
  *
  */
  public static int[] notAlone(int[] nums, int value) throws IOException {
    // Setting Variables
    int intCount = 0;
    // As long as intCount is less than length of the array, it continues.
    while (intCount < nums.length) {
      intCount++;
      // Condition to make it change the selected number to the highest amount on its left or right
      if (intCount > 0 && intCount < nums.length - 1 && nums[intCount] == value) { 
        if (nums[intCount] != nums[intCount - 1] && nums[intCount] != nums[intCount + 1]) {
          nums[intCount] = Math.max(nums[intCount-1], nums[intCount+1]);
        }
      }
    }
    // return new array
    return nums;
  }
  /** 
  * Array 4: Whether or not the numbers are balanced, print true or false
  * @author: H. Chung
  *
  */
  public static boolean canBalance(int[] nums) throws IOException {
    // Setting Variables
    int intLeftSum = 0;
    int intCount = 0;
    // Looping as long as intCount is less than the length of number
    while (intCount < nums.length) {
      intLeftSum += nums[intCount];
      intCount++;
      int intRightSum = 0;
      int intCount2 = nums.length-1;
      // Conditions to check if it is balanced
      while (intCount2 > intCount) {
        intCount2--;
        intRightSum += nums[intCount2];
      }
      // Returning true or false depending if it is balanced
      if (intRightSum == intLeftSum) {
        return false;
      }
    }
    return true;
  }
  /** 
  * Array 6: Printing out numbers in a diagonal line
  * @author: H. Chung
  *
  */
  public static void diagonal(int n) throws IOException {
    // Setting variables and arrays
    int intCount = 0;
    int intCount1 = 0;
    int[][] intArray;
    intArray = new int[n][n];
    // Exception handling
    try {
    // Opens a file to write on
    PrintWriter theWriter = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt"));
    // Looping until the column reaches the end
    for (intCount = 0; intCount < n; intCount++) {
      // Looping until the row reaches the end
      for (intCount1 = 0; intCount1 < n; intCount1++) {
        // Prints a 0 if intCount1 is less than equation
        if (intCount1 < (n - intCount - 1)) {
          intArray[intCount][intCount1] = 0;
        // Prints a 1 if intCount1 is equal to equation
        } else if(intCount1 == (n - intCount - 1)) {
          intArray[intCount][intCount1] = 1;
        // Prints a 2 if intCount1 is greater than equation
        } else if(intCount1 > n - intCount - 1) {
          intArray[intCount][intCount1] = 2;
        }
      }
    }
    // Printing out the numbers given the value of the number from previous loop
    for (intCount = 0; intCount < n; intCount++) {
      for (intCount1 = 0; intCount1 < n; intCount1++) {
        theWriter.print(intArray[intCount][intCount1]);
      }
      theWriter.println("");
    }
    theWriter.close();
    } catch(IOException Hayden) {
      System.out.println("Message");
    }
  }
/**
* ZipZap method 
* remove inner character for any Z''P
* @author: Vincent Hung
*/ 
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
      PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/pascal.txt"));
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
