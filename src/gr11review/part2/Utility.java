package gr11review.part2;

import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

// Method 2: Add numbers together
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
// File IO 2: Reading words in file and picking the first alphabetically first word
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
  // Array 2: Print out numbers in array
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
  // Array 4: Whether or not the numbers are balanced, print true or false
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
  // Array 6: Printing out numbers in a diagonal line
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
}
