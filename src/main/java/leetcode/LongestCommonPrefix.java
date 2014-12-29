package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author tabiul<tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/longest-common-prefix/">https://oj.leetcode.com/problems/longest-common-prefix/</a>
 */
public class LongestCommonPrefix {

   public static String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) {
         return "";
      }
      if (strs.length == 1) {
         return strs[0];
      }
      List<char[]> listOfStrings = new ArrayList<>();
      for (String s : strs) {
         listOfStrings.add(s.toCharArray());
      }
      int index = 0;
      String prefix = "";
      boolean mismatch = false;
      boolean end = false;
      while (true) {
         Character c = null;
         for (int i = 0; i < listOfStrings.size(); i++) {
            if (index < listOfStrings.get(i).length) {
               if (c == null) {
                  c = listOfStrings.get(i)[index];
               } else {
                  if (listOfStrings.get(i)[index] != c) {
                     mismatch = true;
                     break;

                  }
               }
            }else{
               end = true;
               break;
            }
         }
         
         if (mismatch) break;
         if (end) break;
         index++;
         prefix += c;
      }
      return prefix;
   }
   
   public static void main(String args[]){
      System.out.println(longestCommonPrefix(new String[]{"a"}));
      System.out.println(longestCommonPrefix(new String[]{"a","b"}));
      System.out.println(longestCommonPrefix(new String[]{"a","a"}));
      System.out.println(longestCommonPrefix(new String[]{"a","b","c"}));
      System.out.println(longestCommonPrefix(new String[]{"aa","ab","ac"}));
      System.out.println(longestCommonPrefix(new String[]{"aa","b","ac"}));
      System.out.println(longestCommonPrefix(new String[]{"aaa","aaab","aaac"}));
   }
}
