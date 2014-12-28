package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/zigzag-conversion/">https://oj.leetcode.com/problems/zigzag-conversion/</a>
 */
public class Zizag {

   public static String convert(String s, int nRows) {

      List<List<Character>> l = new ArrayList<List<Character>>();
      for (int i = 0; i < nRows; i++) {
         l.add(new ArrayList<Character>());
      }
      int i = 0;
      boolean down = true;
      for (Character c : s.toCharArray()) {
         l.get(i).add(c);
         if (down) {
            i++;
         }
         if (!down) {
            i--;
         }
         if (i == -1) {
            down = true;
            if (i + 2 < nRows) {
               i += 2;
            }
            else {
               i = nRows - 1;
            }
         }
         if (i == nRows) {
            down = false;
            if (i - 2 >= 0) {
               i -= 2;
            }
            else {
               i = 0;
            }
         }

      }

      StringBuilder builder = new StringBuilder();
      for (List<Character> lc : l) {
         for (Character c : lc) {
            builder.append(c);
         }
      }

      return builder.toString();
   }

   public static void main(String args[]) {
      System.out.println(convert("AB", 1));
   }
}
