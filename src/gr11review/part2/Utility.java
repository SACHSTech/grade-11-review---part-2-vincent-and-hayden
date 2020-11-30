package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility{
  public static int sumNumbers(String str){
    int intLength;
    intLength = str.length();
    int intCount;
    int intSum = 0;
    String strWord = "";
    for(intCount = 0; intCount < intLength; intCount++){
      if(Character.isDigit(str.charAt(intCount))) {
        if (intCount < intLength-1 && Character.isDigit(str.charAt(intCount+1))){
          strWord += str.charAt(intCount);
        }else{
          strWord += str.charAt(intCount);
          intSum += Integer.parseInt(strWord);
          strWord = "";
        }
      }
    }
    return intSum;
  }

  public static String alphaWord(String filenametxt)throws IOException{
    BufferedReader FileText = new BufferedReader(new FileReader(filenametxt));
    String strWord;
    String strFinalWord;
    int intCompare;
    strWord = FileText.readLine();
    strFinalWord = FileText.readLine();
    while(strWord != null){
      intCompare = strFinalWord.compareToIgnoreCase(strWord);
      if(intCompare > 0){
        strFinalWord = strWord;
      }
      strWord = FileText.readLine();
      }
    FileText.close();
    return strFinalWord;
  }
  public static int[] notAlone(int[] nums, int value)throws IOException{
    int intCount = 0;
    while(intCount < nums.length){
      intCount++;
      if(intCount > 0 && intCount < nums.length - 1 && nums[intCount] == value){
      if(nums[intCount] != nums[intCount-1] && nums[intCount] !=nums[intCount+1])
        nums[intCount] = Math.max(nums[intCount-1], nums[intCount+1]);
      }
    }
    return nums;
  }
  public static boolean canBalance(int[] nums)throws IOException{
    
  }
}
