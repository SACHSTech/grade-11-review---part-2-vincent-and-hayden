package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;
import java.util.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    String filenametxt = "src/gr11review/part2/words.txt";
    System.out.println("Which Program do you want to run");
    String strOption = keyboard.readLine();
    if (strOption.equals("Method 2")) {
      String str;
      int intInput;
      System.out.println("Enter any sentence");
      str = keyboard.readLine();
      intInput = Utility.sumNumbers(str);
      System.out.println(intInput);
    } else if(strOption.equals("File IO 2")) {
      String strFinalName = Utility.alphaWord(filenametxt);
      System.out.println("First word based on alphabetical order: "+strFinalName);
    } else if(strOption.equals("Array 2")) {
      System.out.println("Amount of numbers in Array");
      int intOption2 = Integer.parseInt(keyboard.readLine());
      int[] nums = new int[intOption2];
      int intCount = 0;
      while(intCount < intOption2){
        System.out.println("Enter the number: ");
        nums[intCount] = Integer.parseInt(keyboard.readLine());
        intCount++;
      }
      System.out.println("Enter number to change");
      int Value = Integer.parseInt(keyboard.readLine());
      Utility.notAlone(nums, Value);
      System.out.println("The Changed Array is: " + Arrays.toString(nums));
    } else if(strOption.equals("Array 4")) {
      
      int[] nums = {10, 10};
      boolean Condition = Utility.canBalance(nums);   
      System.out.println(Condition);  
    } else if(strOption.equals("Array 6")) {
      System.out.println("Pick a number");
      int n = Integer.parseInt(keyboard.readLine());
      Utility.diagonal(n);
    }
  }
}