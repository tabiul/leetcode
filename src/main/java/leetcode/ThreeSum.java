package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

   private class Pair {
      public int num1;
      public int num2;
      public int num1Index;
      public int num2Index;

      @Override
      public String toString() {
         return "{" + num1 + "," + num2 + "}";
      }

      @Override
      public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + num1;
         result = prime * result + num2;
         return result;
      }

      @Override
      public boolean equals(Object obj) {
         if (this == obj)
            return true;
         if (obj == null)
            return false;
         if (getClass() != obj.getClass())
            return false;
         Pair other = (Pair) obj;
         if (this.num1 == other.num1 && this.num2 == other.num2)
            return true;
         return false;
      }

   }

   public List<List<Integer>> threeSum(int[] num) {
      // create sets of pair
      Set<Pair> pairSet = new HashSet<>();
      Arrays.sort(num);
      List<List<Integer>> l = new ArrayList<>();
      for (int i = 0; i < num.length; i++) {
         for (int j = i + 1; j < num.length; j++) {
            Pair p = new Pair();
            p.num1 = num[i];
            p.num2 = num[j];
            p.num1Index = i;
            p.num2Index = j;
            if (!pairSet.contains(p)) {
               pairSet.add(p);
            }
         }
      }

      for (Pair p : pairSet) {
         int sum = p.num1 + p.num2;
         if (sum < 0) {
            if (p.num2 <= Math.abs(sum) && find(p.num1Index, p.num2Index, Math.abs(sum), num)) {
               List<Integer> n = new ArrayList<>();
               n.add(p.num1);
               n.add(p.num2);
               n.add(Math.abs(sum));
               l.add(n);
            }
         } else if (sum > 0) {
            if (p.num2 <= -sum && find(p.num1Index, p.num2Index, -sum, num)) {
               List<Integer> n = new ArrayList<>();
               n.add(p.num1);
               n.add(p.num2);
               n.add(0);
               l.add(n);
            }

         } else { // sum is already 0 as such I need to find a 0
            if (p.num2 <= 0 && find(p.num1Index, p.num2Index, 0, num)) {
               List<Integer> n = new ArrayList<>();
               n.add(p.num1);
               n.add(p.num2);
               n.add(0);
               l.add(n);
            }
         }
      }

      return l;
   }

   private boolean find(int start, int end, int num, int[] nums) {
      int result = -1;
      try {
         result = Arrays.binarySearch(nums, 0, start, num);
      } catch (Exception e) {
         // do nothing
      }
      if (result < 0) {
         try {
            result = Arrays.binarySearch(nums, start + 1, end, num);
         } catch (Exception e) {
            // do nothing
         }
      }
      if (result < 0) {
         try {
            result = Arrays.binarySearch(nums, end + 1, nums.length, num);
         } catch (Exception e) {
            // do nothing
         }
      }
      return result < 0  ? false : true;
   }

   public static void main(String args[]) {
      ThreeSum sum = new ThreeSum();
      System.out.println(sum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

   }
}
