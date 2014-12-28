package leetcode;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/length-of-last-word/">https://oj.leetcode.com/problems/length-of-last-word/</a>
 */
public class LastWord {

   public int lengthOfLastWord(String s) {
      if (s.length() == 0 || s.trim().length() == 0) {
         return 0;
      }
      String words[] = s.split(" ");
      return words[words.length - 1].length();
   }
}
