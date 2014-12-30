package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tmahmood
 * @see <a href="https://oj.leetcode.com/problems/climbing-stairs/">https://oj.leetcode.com/problems/climbing-stairs/</a>
 */
public class ClimbingStairs {
   private Map<String, Integer> memo = new HashMap<>();

   public int climbStairs(int n) {
      if (n == 0)
         return 1;

      int num2 = 0;
      int num1 = 0;
      if (n - 2 >= 0) {
         if (memo.containsKey("num2_" + n)) {
            num2 = memo.get("num2_" + n);
         } else {
            num2 = climbStairs(n - 2);
            memo.put("num2_" + n, num2);
         }
      }
      if (memo.containsKey("num1_" + n)) {
         num1 = memo.get("num1_" + n);
      } else {
         num1 = climbStairs(n - 1);
         memo.put("num1_" + n, num1);
      }

      return num1 + num2;
   }

   public static void main(String args[]) {
      ClimbingStairs c = new ClimbingStairs();
      System.out.println(c.climbStairs(0));
      System.out.println(c.climbStairs(1));
      System.out.println(c.climbStairs(2));
      System.out.println(c.climbStairs(3));
   }
}
