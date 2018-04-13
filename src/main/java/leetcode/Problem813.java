package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem813 {
    private HashMap<String, Double> memo = new HashMap<>();

    public double largestSumOfAverages(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }
        return calculate(list, K, 0);
    }

    private double calculate(List<Integer> list, int k, int start) {
        if (start >= list.size()) return 0;
        if (start == list.size() - 1) return list.get(start);
        String key = start + "#" + k;
        if (memo.containsKey(key)) return memo.get(key);
        List<Double> avg = new ArrayList<>();
        int sum = 0;
        int count = 0;
        int len = list.size();
        for (int i = start; i < len; i++) {
            sum += list.get(i);
            count++;
            if (k > 1) {
                avg.add((sum / (double)count) + calculate(list, k - 1, i + 1));
            }
        }
        avg.add(sum / (double) count);
        double max = Collections.max(avg);
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem813 problem813 = new Problem813();
        System.out.println(problem813.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3) == 20);
        System.out.println(problem813.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4) == 20.5);
        System.out.println(((1 + 2 + 3 + 4)/4.0) +(5 + 6 + 7));
    }
}
