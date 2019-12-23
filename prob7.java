// We are given a dictionary of words and a large input string.
// We have to find out whether the input string can be completely segmented into the words of a given dictionary.
// The following two examples elaborate on the problem further.

import java.util.HashSet;
import java.util.Set;

public class prob7 {
  public static void main(String[] args) {
    System.out.println("String sementation");
    testCase1();
    testCase2();
  }

  private static void testCase1(){
    Set<String> dict = new HashSet<String>();
    String s = new String();
    s = "applepie";
    dict.add("pie");
    dict.add("pear");
    dict.add("apple");
    dict.add("peach");
    System.out.println(segment(s, dict));
  }

  private static void testCase2(){
    Set<String> dict = new HashSet<String>();
    String s = new String();
    s = "applepiee";
    dict.add("pie");
    dict.add("pear");
    dict.add("apple");
    dict.add("peach");
    System.out.println(segment(s, dict));
  }

  public static boolean segment(String str, Set<String> dict){
    if (dict.contains(str))
      return true;
    return recSegment(str, dict, 0);
  }

  private static boolean recSegment(String str, Set<String> dict, int start){
    if (start == str.length())
      return true;
    int end = start + 1;
    while(end < str.length()){
      if (dict.contains(str.substring(start, end))){
        // not end + 1, because substring does not include the char at index end
        if (recSegment(str, dict, end)){
            return true;
        }
      }
      end++;
    }
    return dict.contains(str.substring(start, end));
  }
}
