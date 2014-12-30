package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
* @author tabiul<tabiul@gmail.com>
* @see <a href="https://oj.leetcode.com/problems/largest-rectangle-in-histogram/">https://oj.leetcode.com/problems/largest-rectangle-in-histogram/</a>
*/

public class LargestRectangle {
   public int largestRectangleArea(int[] height) {
      List<Integer> list = new ArrayList<>();
      int[] sorted = Arrays.copyOf(height, height.length);
      Arrays.sort(sorted);

      if (isAlreadySorted(height)) {
         for (int i = 0; i < sorted.length; i++) {
            int sum = sorted[i] * (sorted.length - i);
            list.add(sum);
         }

      } else {

         int prev = 0;
         for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != prev) {
               prev = sorted[i];
               list.add(getLargestRectangleforSpecificHeight(sorted[i], height));
            }
         }
      }
      return list.isEmpty() ? 0 : Collections.max(list);
   }

   private int getLargestRectangleforSpecificHeight(int height, int[] allBars) {
      List<Integer> list = new ArrayList<>();
      int sum = 0;
      for (int i = 0; i < allBars.length; i++) {
         if (allBars[i] >= height) {
            sum += height;
         } else {
            list.add(sum);
            sum = 0;
         }
      }
      list.add(sum);
      return Collections.max(list);
   }

   private boolean isAlreadySorted(int[] height) {
      boolean ascending = true;
      boolean descending = true;
      for (int i = 0; i < height.length - 1; i++) {
         if (height[i] < height[i + 1]) {
            ascending = false;
            break;
         }
      }

      for (int i = 0; i < height.length - 1; i++) {
         if (height[i] > height[i + 1]) {
            descending = false;
            break;
         }
      }

      return ascending || descending;
   }

   public static void main(String args[]) {
      LargestRectangle r = new LargestRectangle();
      System.out
            .println(r.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
      System.out
            .println(r.largestRectangleArea(new int[] { 2, 2, 5, 6, 2, 3 }));
      System.out
            .println(r.largestRectangleArea(new int[] { 1, 2, 3, 4, 5, 6 }));
      System.out
            .println(r.largestRectangleArea(new int[] { 6, 5, 4, 3, 2, 1 }));
   }
}
