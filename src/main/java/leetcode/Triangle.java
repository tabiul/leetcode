package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @see <a href="https://oj.leetcode.com/problems/triangle/">https://oj.leetcode.com/problems/triangle/</a>
 * @author tabiul<tabiul@gmail.com>
 *
 */
public class Triangle {
   Map<String, Integer> memo = new HashMap<>();

   public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle.size() == 0)
         return 0;
      if (triangle.size() == 1)
         return Collections.min(triangle.get(0));

      return minimum(triangle, 0, 0);
   }

   private int minimum(List<List<Integer>> triangle, int row, int index) {
      // base case
      if (row == triangle.size() - 1) {
         if (index >= 0 && index < triangle.get(row).size()) {
            return triangle.get(row).get(index);
         } else {
            return 0;
         }
      }
      List<Integer> list = new ArrayList<>();
      int currentSum = triangle.get(row).get(index);
      int min = 0;
      String key = (row + 1) + "_" + index;
      if (!memo.containsKey(key)) {
         min = minimum(triangle, row + 1, index);
         memo.put(key, min);
         min = currentSum + min;
         list.add(min);
      } else {
         list.add(currentSum + memo.get(key));
      }

      key = (row + 1) + "_" + (index + 1);
      if (!memo.containsKey(key)) {
         min = minimum(triangle, row + 1, index + 1);
         memo.put(key, min);
         min = currentSum + min;
         list.add(min);
      } else {
         list.add(currentSum + memo.get(key));
      }
      min = Collections.min(list);
      key = (row) + "_" + (index);
      memo.put(key, min);
      return min;
   }

   public static void main(String args[]) {
      // [2],
      // [3,4],
      // [6,5,7],
      // [4,1,8,3]
      Triangle t = new Triangle();
      List<List<Integer>> L = new ArrayList<>();
      List<Integer> l1 = new ArrayList<>();
      l1.add(-1);
      L.add(l1);
      List<Integer> l2 = new ArrayList<>();
      l2.add(3);
      l2.add(2);
      L.add(l2);
      List<Integer> l3 = new ArrayList<>();
      l3.add(-3);
      l3.add(1);
      l3.add(-1);
      L.add(l3);
      // List<Integer> l4 = new ArrayList<>();
      // l4.add(4);
      // l4.add(1);
      // l4.add(8);
      // l4.add(3);
      // L.add(l4);
      System.out.println(t.minimumTotal(L));
   }
}
