package leetcode;

import java.util.Arrays;

public class Problem961 {

    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return A[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem961 problem961 = new Problem961();
        System.out.println(problem961.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(problem961.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(problem961.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
