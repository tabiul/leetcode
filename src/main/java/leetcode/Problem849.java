package leetcode;

import java.util.TreeSet;

public class Problem849 {
    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                treeSet.add(i);
            }
        }

        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                Integer lower = treeSet.lower(i);
                Integer higher = treeSet.higher(i);
                int smallest = 0;
                if (lower == null && higher != null) {
                    smallest = Math.abs(i - higher);
                } else if (lower != null && higher == null) {
                    smallest = Math.abs(i - lower);
                } else if (lower != null) {
                    smallest = Math.min(Math.abs(i - higher), Math.abs(i - lower));
                }
                max = Math.max(max, smallest);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem849 problem849 = new Problem849();
        System.out.println(problem849.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(problem849.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }
}
