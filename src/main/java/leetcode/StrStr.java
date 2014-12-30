package leetcode;

/**
 * 
 * @author tabiul<tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/implement-strstr/">https://oj.leetcode.com/problems/implement-strstr/</a>
 */
public class StrStr {
   public int strStr(String haystack, String needle) {
      if (haystack.isEmpty() && needle.isEmpty())
         return 0;
      if (haystack.isEmpty() && !needle.isEmpty())
         return -1;
      if (!haystack.isEmpty() && needle.isEmpty())
         return 0;

      int index = 0;
      char[] hayStackchars = haystack.toCharArray();
      char[] needleChars = needle.toCharArray();
      int needleLen = needle.length();
      while (true) {
         int lastPos = index + (needleLen - 1);
         if (lastPos <= haystack.length() - 1) {
            boolean found = true;
            for (int i = index, j = 0; i <= lastPos; i++, j++) {
               if(hayStackchars[i] != needleChars[j]) {
                  found = false;
                  break;
               }
            }
            if (found) {
               return index;
            }
            index++;
         } else {
            break;
         }
      }

      return -1;
   }

   public static void main(String args[]) {
      StrStr s = new StrStr();
       System.out.println(s.strStr("a", "a"));
       System.out.println(s.strStr("a", ""));
       System.out.println(s.strStr("aabbaaabbaaaa", "aaa"));
       System.out.println(s.strStr("aaa", "aaaa"));
      System.out.println(s.strStr("mississippi", "pi"));
   }
}
