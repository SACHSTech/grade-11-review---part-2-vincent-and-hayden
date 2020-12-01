package gr11review.part2;

import gr11review.part2.Utility.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    //@author Vincent Hung
    //Testing ZipZap
    String str;
    str = Utility.zipZap("zzipC:Dzop");
    System.out.println(str);
    //Testing longestWord
    System.out.println(Utility.longestWord("/home/runner/grade-11-review-part-2-vincent-and-hayden/src/gr11review/part2/words.txt"));
    
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
