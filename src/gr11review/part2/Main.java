package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;
import java.util.*;
import java.util.Arrays;

/**
* Grade 11 Review Part 2 Assignment
* @author: Hayden Chung
*
*/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    // Variables
    String filenametxt = "src/gr11review/part2/words.txt";
    System.out.println("Which Program do you want to run");
    String strOption = keyboard.readLine();
    // Method 2 by Hayden Chung
    if (strOption.equals("Method 2")) {
      String str;
      int intInput;
      System.out.println("Enter any sentence");
      str = keyboard.readLine();
      intInput = Utility.sumNumbers(str);
      System.out.println(intInput);
    // File IO 2 by Hayden Chung
    } else if(strOption.equals("File IO 2")) {
      String strFinalName = Utility.alphaWord(filenametxt);
      System.out.println("First word based on alphabetical order: "+strFinalName);
    // Array 2 by Hayden Chung
    } else if(strOption.equals("Array 2")) {
      // Getting the number of numbers within Array
      System.out.println("Amount of numbers in Array");
      int intOption2 = Integer.parseInt(keyboard.readLine());
      int[] nums = new int[intOption2];
      int intCount = 0;
      while (intCount < intOption2) {
        System.out.println("Enter the number: ");
        nums[intCount] = Integer.parseInt(keyboard.readLine());
        intCount++;
      }
      System.out.println("Enter number to change");
      int Value = Integer.parseInt(keyboard.readLine());
      Utility.notAlone(nums, Value);
      System.out.println("The Changed Array is: " + Arrays.toString(nums));
    // Array 4 by Hayden Chung
    } else if(strOption.equals("Array 4")) {
      // Getting the number of numbers within Array
      System.out.println("Amount of numbers in Array");
      int intOption2 = Integer.parseInt(keyboard.readLine());
      int[] nums = new int[intOption2];
      int intCount = 0;
      while (intCount < intOption2) {
        System.out.println("Enter the number: ");
        nums[intCount] = Integer.parseInt(keyboard.readLine());
        intCount++;
      }
      boolean Condition = Utility.canBalance(nums);   
      System.out.println(Condition);  
    // Array 6 by Hayden Chung
    } else if(strOption.equals("Array 6")) {
      System.out.println("Pick a number");
      int n = Integer.parseInt(keyboard.readLine());
      Utility.diagonal(n);
    }
    /**
    * Testing of methods
    * @author: Vincent Hung
    */  
    
    //Testing ZipZap
    String str;
    str = Utility.zipZap("zzipC:Dzop");
    System.out.println(str);
    //Testing longestWord
    System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));
    
    //Testing tenRun
    int[] nums = {2,10,3,4,20};
    int[] intanswers = (Utility.tenRun(nums));
    System.out.println(Arrays.toString(intanswers));

    //Testing linearIn
    boolean test;
    int[] outer = {1,2,4,6};
    int[] inner = {2,3,4};
    test = Utility.linearIn(outer, inner);
    System.out.println(test);
    
    //Testing pascalTri
    Utility.pascalTri(7, 7);
  }
}
