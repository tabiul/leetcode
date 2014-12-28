package leetcode;

import java.util.Arrays;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/plus-one/">https://oj.leetcode.com/problems/plus-one/</a>
 */
public class PlusOne {

   public static int[] plusOne(int[] digits) {

      int[] sum = new int[digits.length + 1]; // just in case it need to
                                              // overflow
      int carryOver = 0;
      for (int i = digits.length - 1; i >= 0; i--) {
         int add = 0;
         if (i == digits.length - 1) {
            add = digits[i] + 1;
         }
         else {
            add = digits[i] + carryOver;
         }
         if (add > 9) {
            carryOver = add / 10;
            sum[i + 1] = add % 10;
         }
         else {
            carryOver = 0;
            sum[i + 1] = add;
         }
      }

      if (carryOver != 0) {
         sum[0] = carryOver;
         return sum;
      }
      else {
         return Arrays.copyOfRange(sum, 1, sum.length);
      }
   }

   public static void main(String args[]) {

      System.out.println(Arrays.toString((plusOne(new int[] { 0 }))));
      System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
      System.out.println(Arrays.toString(plusOne(new int[] { 1, 9 })));
      System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 5 })));
      System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 9 })));
      System.out.println(Arrays.toString(plusOne(new int[] { 1, 9, 9 })));
      System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9 })));
   }
}
