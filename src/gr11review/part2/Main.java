package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Which Program do you want to run");
    String strOption = keyboard.readLine();
    if(strOption.equals("Method 2")){
      String str;
      int intInput;
      System.out.println("Enter any sentence");
      str = keyboard.readLine();
      intInput = Utility.sumNumbers(str);
      System.out.println(intInput);
    }else if(strOption.equals("File IO 2")){
      String filenametxt;
      filenametxt = keyboard.readLine();
      System.out.println(filenametxt);
    }
  }
}