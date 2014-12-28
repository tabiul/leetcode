package leetcode;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/">https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/</a>
 */
public class RemoveDuplicates {

   public static int removeDuplicates(int[] A) {

      if (A.length == 0) {
         return 0;
      }
      int count = 1;
      int current = A[0];
      int currentIndex = 0;
      for (int i = 1; i < A.length; i++) {
         if (A[i] != current) {
            current = A[i];
            A[++currentIndex] = current;
            count++;
         }
      }
      return count;

   }

   public static void main(String args[]) {
      System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7 }));
   }
}
