package leetcode;

import java.util.Arrays;

/**
 * @author tmahmood
 * @see <a href="https://oj.leetcode.com/problems/remove-element/">https://oj.leetcode.com/problems/remove-element/</a>
 */
public class RemoveElement {
   public int removeElement(int[] A, int elem) {
      Arrays.sort(A);
      boolean found = false;
      int startIndex = 0;
      int endIndex = 0;
      for (int i = 0; i < A.length; i++) {
         if (A[i] == elem) {
            if (!found) {
               found = true;
               startIndex = i;
               endIndex = i;
            } else {
               endIndex = i;
            }
         }
      }
      if (found) {
         // shift
         int i, j = 0;
         for (i = startIndex, j = endIndex + 1; i < A.length && j < A.length; i++, j++) {
            A[i] = A[j];
         }

         return i;
      } else {
         return A.length;
      }
   }

   public static void main(String args[]) {
      RemoveElement r = new RemoveElement();
      int[] arr = new int[] { 0, 1, 0, 0, 0, 2, 3, 4, 0, 0, 0, 5, 6, 7, 0, 8 };
      System.out.println(r.removeElement(arr, 0));
      System.out.println(Arrays.toString(arr));
   }
}
